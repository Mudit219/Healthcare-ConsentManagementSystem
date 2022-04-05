pragma solidity >=0.4.21 <=0.8.11;


contract Decentralized {
    string public name;
    address public owner;
    uint public patientCount;
    uint public doctorCount;
    uint public nomineeCount;
    constructor() public {
        name = "Consent Management System";
        owner = msg.sender;
        patientCount = 0;
        doctorCount = 0;
        nomineeCount = 0;
    }

    mapping(uint => Patient) public patientMap;
    mapping(address => uint) public inversePatientMap;
    mapping(uint => Doctor) public doctorMap;
    mapping(address => uint) public inverseDoctorMap;

    //1->Consent Given       0->Consent Not Given
    mapping(uint=>mapping(uint=>uint)) public patientToDoc;
    mapping(uint=>mapping(uint=>uint)) public docToPatient;
    //Exists -> 1   Doesn't exist -> 0
    mapping(uint=>mapping(uint=>uint)) public patientToNominee;
    mapping(uint=>mapping(uint=>uint)) public nomineeToPatient;

    struct Patient{
        uint patientId;
        string patientPassword;
        address patientAddress;
    }

    struct Nominee{
        uint nomineeId;
        string nomineePassword;
        address nomineeAddress;
    }
    
    struct Doctor{
        uint doctorId;
        string doctorPassword;
        address doctorAddress;
        uint hospitalId;
        string hospitalName;
    }


    event createPatientTest(
        uint patientId,
        string patientPassword,
        address patientAddress
    );
    function createPatient(string memory password) public {
        require(inversePatientMap[msg.sender] == 0,"Patient already exists");
        patientCount++;
        inversePatientMap[msg.sender] = patientCount;
        patientMap[patientCount] = Patient(patientCount,password,msg.sender);
        emit createPatientTest(patientCount,password,msg.sender);
    }


    event createNomineeTest(
        uint nomineeId,
        string nomineePassword,
        address nomineeAddress,
        uint val
    );
    function createNominee(uint patientId,uint nomineeId) public {
        require(patientId >= 1 && patientId <= patientCount,"Not a valid Patient");
        require(nomineeId >= 1 && nomineeId <= patientCount,"Not a valid Nominee");
        require(patientToNominee[patientId][nomineeId] == 0,"No record in DB");
        require(nomineeToPatient[nomineeId][patientId] == 0,"No record in DB");
        patientToNominee[patientId][nomineeId] = 1;
        nomineeToPatient[nomineeId][patientId] = 1;
        Patient memory n1 = patientMap[nomineeId];
        emit createNomineeTest(n1.patientId,n1.patientPassword,n1.patientAddress,1);
    }
    event removeNomineeTest(
        uint nomineeId,
        string nomineePassword,
        address nomineeAddress,
        uint val
    );
    function removeNominee(uint patientId,uint nomineeId) public {
        require(patientId >= 1 && patientId <= patientCount,"Not a valid Patient");
        require(nomineeId >= 1 && nomineeId <= patientCount,"Not a valid Nominee");
        require(patientToNominee[patientId][nomineeId] == 1,"Record in DB");
        require(nomineeToPatient[nomineeId][patientId] == 1,"Record in DB");
        patientToNominee[patientId][nomineeId] = 0;
        nomineeToPatient[nomineeId][patientId] = 0;
        Patient memory n1 = patientMap[nomineeId];
        emit removeNomineeTest(n1.patientId,n1.patientPassword,n1.patientAddress,0);
    }

    struct 

    event createDoctorTest(
        uint doctorId,
        string doctorPassword,
        address doctorAddress,
        uint hospitalId,
        string hospitalName
    );
    function createDoctor(string memory password) public {
        require(inverseDoctorMap[msg.sender] == 0,"Doctor already exists");
        doctorCount++;
        inverseDoctorMap[msg.sender] = doctorCount;
        doctorMap[doctorCount] = Doctor(doctorCount,password,msg.sender,1,"VSGH");
        emit createDoctorTest(doctorCount,password,msg.sender,1,"VSGH");
    }


    event createConsentTest(
        uint patientId,
        uint doctorId,
        uint finalState,
        address start,
        address end
    );
    function createConsent(uint patientId,uint doctorId) public {
        require(patientId >= 1 && patientId <= patientCount,"Not a valid patient");
        require(doctorId >= 1 && doctorId <= doctorCount,"Not a valid doctor");
        require(patientToDoc[patientId][doctorId] == 2,"Consent Request Sent by the Doctor");
        require(docToPatient[doctorId][patientId] == 2,"Consent Request Sent by the Doctor");

        Doctor memory d1 = doctorMap[doctorId];
        patientToDoc[patientId][doctorId] = 1;
        docToPatient[doctorId][patientId] = 1;
        emit createConsentTest(patientId,doctorId,1,msg.sender,d1.doctorAddress);
    }

    event revokeConsentTest(
        uint patientId,
        uint doctorId,
        uint finalState,
        address start,
        address end
    );
    function revokeConsent(uint patientId,uint doctorId) public {
        require(patientId >= 1 && patientId <= patientCount,"Not a valid patient");
        require(doctorId >= 1 && doctorId <= doctorCount,"Not a valid doctor");
        require(patientToDoc[patientId][doctorId] == 1,"Consent Not Given");
        require(docToPatient[doctorId][patientId] == 1,"Consent Not Given");

        Doctor memory d1 = doctorMap[doctorId];
        patientToDoc[patientId][doctorId] = 0;
        docToPatient[doctorId][patientId] = 0;
        emit revokeConsentTest(patientId,doctorId,0,msg.sender,d1.doctorAddress);
    }

    event requestConsentTest(
        uint patientId,
        uint doctorId,
        uint finalState,
        address start,
        address end
    );
    function requestConsent(uint patientId,uint doctorId) public {
        require(patientId >= 1 && patientId <= patientCount,"Not a valid patient");
        require(doctorId >= 1 && doctorId <= doctorCount,"Not a valid doctor");
        require(patientToDoc[patientId][doctorId] == 0,"Consent Not Given");
        require(docToPatient[doctorId][patientId] == 0,"Consent Not Given");

        Doctor memory d1 = doctorMap[doctorId];
        patientToDoc[patientId][doctorId] = 2;
        docToPatient[doctorId][patientId] = 2;
        emit requestConsentTest(patientId,doctorId,2,msg.sender,d1.doctorAddress);
    }
}