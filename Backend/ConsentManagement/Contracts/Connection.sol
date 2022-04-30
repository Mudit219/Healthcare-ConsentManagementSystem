pragma solidity ^0.5.2;
pragma experimental ABIEncoderV2;

contract Connection {

    address doctor;
    address patient;

    address DocConnectionFile;
    address PatConnectionFile;

    enum Status {  /* The giver has denied the consent */
        created,
        accepted,  /* The giver has accepted the consent */
        requested, /* The company has requested a consent, user has not yet responded */
        cancelled  /* The company has cancelled the consent because he no longer needs it */
    }

    modifier onlyByBoth() {
        require((tx.origin == doctor) || (tx.origin == patient));
        _;
    }

    modifier onlyByBothOrConsentFile() {
        require((msg.sender == DocConnectionFile) || (msg.sender == PatConnectionFile) || (tx.origin == doctor) || (tx.origin == patient));
        _;
    }


    Status status;

    constructor(address _doctor,address _patient,address _DocConnectionFile, address _PatConnectionFile) public {
        doctor = _doctor;
        patient = _patient;
        DocConnectionFile = _DocConnectionFile;
        PatConnectionFile = _PatConnectionFile;

        status = Status.created;
    }

    function cancel() public
    {
        status = Status.cancelled;
    }

    function setStatus(Status state) onlyByBoth() public {
        status = state;
    }

    function getDoctor() onlyByBothOrConsentFile() public view returns(address) {
        return doctor;
    }

    function getPatient() onlyByBothOrConsentFile() public view returns(address) {
        return patient;
    }

    function getStatus() onlyByBothOrConsentFile() public view returns(Status) {
        return status;
    }

}
