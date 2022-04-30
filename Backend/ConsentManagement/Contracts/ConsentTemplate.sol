pragma solidity ^0.5.2;
pragma experimental ABIEncoderV2;

contract ConsentTemplate {

  address private consent;

  address private patient;      /* Creator of this template */
  address private doctor;      /* Creator of this template */
  address private validator;
  string[]  private recordIds;     /* What purpouse the template is for */
  string  private requestedRecordDesc;        /* The title of the consent */
  uint8 version;

  /* Creates the contract and set the values of the contract. */
  constructor (address _patient, address payable _doctor, address _consent) public
  {
    patient = _patient;
    doctor = _doctor;
    consent = _consent;

    // recordIds = [];
    requestedRecordDesc = "";
    version = 0;
  }

  /* A modifier */
  modifier onlyByDoctor()
  {
    require(tx.origin == doctor);
    _;
  }

   modifier onlyByBoth()
    {
      require((doctor == tx.origin) || (patient == tx.origin));
      _;
    }

    modifier ConsentOrBoth()
    {
      require((msg.sender == consent) || (doctor == tx.origin) || (patient == tx.origin));
      _;
    }

  modifier onlyByPatient()
  {
    require(tx.origin == patient);
    _;
  }

  function SettingRequestedDesc(string memory desc) onlyByDoctor() public{
    requestedRecordDesc = desc;
  }

  function setConsentedRecords(string[] memory _recordIds) onlyByPatient() public {
    recordIds = _recordIds;
  }

  /* Set of getters for the contract */
  function GetConsentedRecords()  ConsentOrBoth()  public view returns(string[] memory)
  {
    return recordIds;
  }

  function GetRequestedDesc() ConsentOrBoth() public view returns  (string memory)
  {
    return requestedRecordDesc;
  }

  function GetAssociatedConsent() public view returns(address) {
    return consent;
  }
}
