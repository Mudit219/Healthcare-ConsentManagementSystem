pragma solidity ^0.5.2;
pragma experimental ABIEncoderV2;
import "./ConsentTemplate.sol";
/*
 * This is the contract that handles consents for a specific purpouse given by a
 * user (giver) to another user (owner).
 *
 * It basically provides a textual description  that is either accepted or denied by a user.
 *
 */
contract Consent {

    /* Enumeration for the state of the consent */
  enum Status {created,
          denied,    /* The giver has denied the consent */
	       accepted,  /* The giver has accepted the consent */ 
	       requested, /* The company has requested a consent, user has not yet responded */
	       cancelled  /* The company has cancelled the consent because he no longer needs it */
  }

   address DocConsentFile;
  address PatConsentFile;

  /* State variables for the contract */
  // address payable private owner;  /* Who issues to consent form */
  address private patient; /* Who created this object */
  address private doctor;  /* Who gives the consent, address to the account. */

  Status  private status; /* The status of the consent */
  ConsentTemplate consentTemplate; /* The template this consent is based on */

  /* Event to signal that the status has changed */
  event ConsentStatusChanged(address indexed consent, Status status);

  /* A modifier */
  modifier onlyByPatient()
  {
    require(tx.origin == patient);
    _;
  }

  modifier onlyByDoctor()
  {
    require(tx.origin == doctor);
    _;
  }

  modifier onlyByBoth()
  {
    require ((tx.origin == patient) || (tx.origin == doctor));
    _;
  }

  modifier onlyByBothAndConsentFile()
  {
    require ((msg.sender == PatConsentFile) || (msg.sender == DocConsentFile) || (tx.origin == patient) || (tx.origin == doctor));
    _;
  }


  /* This function is executed at initialization and sets the owner and the giver of the consent */
  /* as well as what it contains */
  constructor (address _patient,address payable _doctor, address _PatConsentFile,address _DocConsentFile) public
  {
    patient = _patient;
    doctor = _doctor;
    DocConsentFile = _DocConsentFile;
    PatConsentFile = _PatConsentFile;

    consentTemplate = new ConsentTemplate(_patient,_doctor,address(this));
    status = Status.created;
  }

  function setRequestStatus(string memory requestdesc) onlyByDoctor() public {
    status = Status.requested;
    consentTemplate.SettingRequestedDesc(requestdesc);
    emit ConsentStatusChanged(address(this),status);
  }
  /* Sets the status of the consent, this can only be done by the giver. */
  function setPatientSideStatus(Status _status) onlyByPatient () public
  {
    if (_status == Status.denied || _status == Status.accepted) {
      status = _status;
      emit ConsentStatusChanged (address(this), status);
    }
  }

  function setConsentedRecords(string[] memory consentedRecords) onlyByPatient () public {
    status = Status.accepted;
    consentTemplate.setConsentedRecords(consentedRecords);
    emit ConsentStatusChanged(address(this),status);
  }

  /* Cancels a consent, this can only be done by the company who created the consent. */
  function cancel () onlyByPatient() public
  {
    status = Status.cancelled;
    consentTemplate.setConsentedRecords(new string[](0));
    emit ConsentStatusChanged (address(this), Status.cancelled);
  }

  /* Returns the status of the consent */
  function getStatus() onlyByBothAndConsentFile() public view returns (Status)
  {
    return status;
  }

  function GetConsents() onlyByBothAndConsentFile() public view returns(string[] memory) {
    return consentTemplate.GetConsentedRecords();
  }

  /* Returns the consent template that this consent is based on */
  function getTemplate() onlyByBothAndConsentFile()  public view returns (address)
  {
    return address(consentTemplate);
  }

  /* Returns with the giver */
  function getPatient() onlyByBothAndConsentFile() public view returns (address)
  {
    return patient;
  }

  function GetAssociatedDocConsentFile() public view returns (address) {
    return DocConsentFile;
  }

  function GetAssociatedPatConsentFile() public view returns (address) {
    return PatConsentFile;
  }

  /* Returns with teh giver */
  function getDoctor() onlyByBothAndConsentFile() public view returns (address)
  {
    return doctor;
  }
  
  /* Function to recover the funds on the contract */
  // function kill() public { if (tx.origin == owner) selfdestruct(owner); }
}
