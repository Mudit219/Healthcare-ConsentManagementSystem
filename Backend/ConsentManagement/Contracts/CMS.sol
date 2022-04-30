  pragma solidity ^0.5.2;
  pragma experimental ABIEncoderV2;
  import "./ConsentFile.sol";
  import "./ConnectionFile.sol";
  import "./Connection.sol";
  // /*
  //  * This is the consent factory contract that handles consents and version of
  //  * consents.
  //  *
  //  * It basically provides an interface to be able to create consents based on
  //  * a specific purpouse for a specific user. And always using the latest version
  //  * and always puts newly generated consents into a persons consent file.
  //  *
  //  */

  contract ConsentManagementSystem {

    /* The owner of this contract */
    address payable private owner;  /* Who owns this CMS*/
    address private creator; /* Who created this CMS */
    string  private company;  /* Company that created this CMS */

    enum Role {
      doctor,
      patient,
      nominee
    }

    mapping(address => address) Patients;
    mapping(address => address) Doctors;

    uint256 NumUsers = 0;

    mapping(address => ConsentFile) UserToConsentFile;
    mapping(address => ConnectionFile) UserToConnectionFile;


    /* Events generated when the consent has been created */
    event CMSConnectionStatusEvent(address conn,Connection.Status status);
    // event CMSConnectionStatusChangedEvent(address indexed factory, address indexed owner, address indexed user, Consent consent, Consent.Status status);

    event CMSConsentCreatedEvent(address consent,string[] Records);
    event CMSConsentRequestedEvent(address consent,string desc);
    // event CMSConsentStatusChangedEvent(address consent, Consent.Status oldStatus, Consent.Status newStatus);

    event CMSFileCreatedEvent(address indexed factory, address indexed owner, address indexed user, address file);
    // event CMSFailedEvent(address indexed factory, address indexed owner, address indexed user, Error error);


    /* A modifier */
    modifier onlyBy(address _account)
    {
      require(tx.origin == _account);
      _;
    }

    modifier AccountExists(address _account) {
      require((Patients[_account] == _account) || (Doctors[_account] == _account));
      _;
    }

    modifier PatientAccountExists(address _account)
    {
      require(Patients[_account] == _account);
      _;
    }

    modifier DoctorAccountExists(address _account)
    {
      require(Doctors[_account] == _account);
      _;
    }

    struct ConnDeets {
      bool exists;
      Connection Conn;
    }

    struct ConsentDeets {
      bool exists;
      Consent _consent;
    }

    modifier ConnectionStatusExists(address patient,address doctor,Connection.Status state) {
      ConnectionFile DoctorConnectionFile = UserToConnectionFile[doctor];
      ConnectionFile PatientConnectionFile = UserToConnectionFile[patient];

      ConnDeets memory DocConn;
      (DocConn.exists,DocConn.Conn) = DoctorConnectionFile.getAssociatedConnection(patient,PatientConnectionFile);

      ConnDeets memory PatConn;
      (PatConn.exists,PatConn.Conn) = PatientConnectionFile.getAssociatedConnection(doctor,DoctorConnectionFile);

      require ( (DocConn.exists && DocConn.Conn.getStatus() == state) ||
                (PatConn.exists && PatConn.Conn.getStatus() == state)
              );
      _;
    }


    /* Constructor for the consent factory */
    constructor (string memory _company) public
    {
      owner = tx.origin;
      creator = msg.sender;
      company = _company;
    }

    function memcmp(bytes memory a, bytes memory b) internal pure returns(bool){
      return (a.length == b.length) && (keccak256(a) == keccak256(b));
    }
    function strcmp(string memory a, string memory b) internal pure returns(bool){
      return memcmp(bytes(a), bytes(b));
    }

    function AddNewUser(address payable _user,string memory role) onlyBy(owner) public {
      if(strcmp(role,"doctor")) {
        Doctors[_user] = _user;
        createConsentFile(_user,ConsentFile.Role.doctor);
        createConnectionFile(_user,ConnectionFile.Role.doctor);
      }
      else {
        Patients[_user] = _user;
        createConsentFile(_user,ConsentFile.Role.patient);
        createConnectionFile(_user,ConnectionFile.Role.patient);
      }
      NumUsers += 1;
    }

    function NumOfUsers() public view returns(uint256) {
      return NumUsers;
    }

    function DoctorExists() DoctorAccountExists(tx.origin) public view returns(bool){
      return true;
    }

    function GetConsentFile() AccountExists(tx.origin) public view returns(ConsentFile) {
      return UserToConsentFile[tx.origin];
    }

    function GetConnectionFile() AccountExists(tx.origin) public view returns(ConnectionFile) {
      return UserToConnectionFile[tx.origin];
    }

    /* Create a file that holds a users all consents.
    *
    * This is the file that holds all consents regardless of their state. Should have a modifier for the company.
    */
    function createConsentFile(address payable _user,ConsentFile.Role role) onlyBy(owner) public
    {
      ConsentFile file = new ConsentFile(_user,role,address(this));
      UserToConsentFile[_user] = file;
      // emit CMSFileCreatedEvent(address(this), owner, _user, file);
    }

    function createConnectionFile(address payable _user,ConnectionFile.Role role) onlyBy(owner) public {
      ConnectionFile file = new ConnectionFile(_user,role,address(this));
      UserToConnectionFile[_user] = file;
    }




    /* Create a consent for a specific purpouse of the latest version, language and country.
    *
    * Country and Purpouse must exist otherwise it will fail, if language is not there it will
    * default to countrys default language if it exists otherwise it will fail. It adds
    * the consent to the users file as well. Should have a modifier for the company only.
    */

    //
    function requestConsent(string memory requestedDesc,address payable fromPatient) ConnectionStatusExists(fromPatient,tx.origin,Connection.Status.accepted) public{
      ConsentFile DoctorConsentFile = UserToConsentFile[tx.origin];
      ConsentFile PatientConsentFile = UserToConsentFile[fromPatient];

      ConsentDeets memory _deets;
      (_deets.exists,_deets._consent) = DoctorConsentFile.getAssociatedConsent(fromPatient,PatientConsentFile);

      if(!_deets.exists) {
        DoctorConsentFile.addConsent(_deets._consent);
        PatientConsentFile.addConsent(_deets._consent);
      }

      _deets._consent.setRequestStatus(requestedDesc);

      emit CMSConsentRequestedEvent(address(_deets._consent),requestedDesc);
    }

    function GetConsents() AccountExists(tx.origin) public view returns(address[] memory) {
      ConsentFile UserConsents = UserToConsentFile[tx.origin];
      address[] memory _consents = UserConsents.getListOfConsents();
      return _consents;
    }

    function createConsent(address payable _doctor, string[] memory records) ConnectionStatusExists(tx.origin,_doctor,Connection.Status.accepted) public
    {

      ConsentFile PatientConsentFile = UserToConsentFile[tx.origin];
      ConsentFile DoctorConsentFile = UserToConsentFile[_doctor];

      ConsentDeets memory _deets;
      (_deets.exists,_deets._consent) = PatientConsentFile.getAssociatedConsent(_doctor,DoctorConsentFile);

      if(!_deets.exists) {
        PatientConsentFile.addConsent(_deets._consent);
        DoctorConsentFile.addConsent(_deets._consent);
      }

      _deets._consent.setConsentedRecords(records);


      emit CMSConsentCreatedEvent(address(_deets._consent),records);

    }

    function ValidateRecordRequest(address doctor, string[] memory records) onlyBy(owner) public view returns(bool){
      ConsentFile doctorConsentFile = UserToConsentFile[doctor];
      return doctorConsentFile.RecordsExists(records);
    }

    function PatientCreateConnection(address doctor) PatientAccountExists(tx.origin) public {
      ConnectionFile DoctorConnectionFile = UserToConnectionFile[doctor];
      ConnectionFile PatientConnectionFile = UserToConnectionFile[tx.origin];

      ConnDeets memory _deets;

      (_deets.exists,_deets.Conn) = PatientConnectionFile.getAssociatedConnection(doctor,DoctorConnectionFile);

      if(_deets.exists) {
        return;
      }
      else {
        DoctorConnectionFile.AddConnection(_deets.Conn);
        PatientConnectionFile.AddConnection(_deets.Conn);

        _deets.Conn.setStatus(Connection.Status.requested);
      }
      emit CMSConnectionStatusEvent(address(_deets.Conn),Connection.Status.requested);
    }

    function DoctorAcceptConnection(address patient) ConnectionStatusExists(patient,tx.origin,Connection.Status.requested) public {
      ConnectionFile DoctorConnectionFile = UserToConnectionFile[tx.origin];
      ConnectionFile PatientConnectionFile = UserToConnectionFile[patient];

      ConnDeets memory _deets;

      (_deets.exists,_deets.Conn) = DoctorConnectionFile.getAssociatedConnection(patient,PatientConnectionFile);

      if(_deets.exists && _deets.Conn.getStatus() == Connection.Status.accepted) {
        return;
      }
      else {
        if(!_deets.exists) {
          DoctorConnectionFile.AddConnection(_deets.Conn);
          PatientConnectionFile.AddConnection(_deets.Conn);
        }

        _deets.Conn.setStatus(Connection.Status.accepted);
      }

      emit CMSConnectionStatusEvent(address(_deets.Conn),Connection.Status.accepted);
    }


    modifier AccountExistsOrValidator(address _account)
    {
      require((tx.origin == owner) || (Patients[_account] == _account) || (Doctors[_account] == _account));
      _;
    }

    function GetReqestedConnections(address _account) AccountExistsOrValidator(tx.origin) public view returns(address[] memory) {
      ConnectionFile file = UserToConnectionFile[_account];
      return file.GetTypeConnections(Connection.Status.requested);
    }

    function GetAcceptedConnections(address _account) AccountExistsOrValidator(tx.origin) public view returns(address[] memory) {
      ConnectionFile file = UserToConnectionFile[_account];
      return file.GetTypeConnections(Connection.Status.accepted);
    }

    function CheckSubset(address[2] memory array,address addr) private pure returns(bool) {
      for(uint i=0;i<array.length;i++) {
        if(array[i] == addr) {
          return true;
        }
      }
      return false;
    }

    modifier MultipleOnlyBy(address[2] memory accounts) {
      require(CheckSubset(accounts,tx.origin) == true);
      _;
    }

    function RevokeConnection(Connection _conn) MultipleOnlyBy([_conn.getPatient(),_conn.getDoctor()]) public {
      _conn.cancel();
      emit CMSConnectionStatusEvent(address(_conn),Connection.Status.cancelled);
    }

    // /* Cancel the consent */
    function cancelConsent(Consent _consent) onlyBy(_consent.getPatient()) public
    {
      _consent.cancel();
      // emit ConsentFactoryConsentStatusChangedEvent (address(this), _consent.getOwner(), _consent.getGiver(), _consent, Consent.Status.cancelled);
    }

    // /* The company who has this factory */
    function getCompany() public view returns (string memory)
    {
      return company;
    }

    // /* Returns the owner for the factory */
    function getOwner() public view returns (address)
    {
      return owner;
    }


  }

  /*
  * END
  */