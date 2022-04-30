pragma solidity ^0.5.2;
pragma experimental ABIEncoderV2;
import "./Consent.sol";

contract ConsentFile {

  address CMS;

  /* The owner of the file */
  address payable user;

  enum Role {
    doctor,
    patient,
    nominee
  }


  Role private role;

  /* The list of all consents */
  address[] private listOfConsents;

  /* Events that are sent when things happen */
  event ConsentFileConsentAdded(address indexed file, address consent);

  /* A modifier */
  modifier onlyByUser()
  {
    require(tx.origin == user);
    _;
  }

  modifier CMSorUser()
  {
    require ((tx.origin == user) || (msg.sender == CMS));
    _;
  }


  /* The constructor of the file. Also attaches it to an owner */
  constructor (address payable _user,Role _role,address _CMS) public
  {
    CMS = _CMS;
    user = _user;
    role = _role;
  }

  function memcmp(bytes memory a, bytes memory b) internal pure returns(bool){
    return (a.length == b.length) && (keccak256(a) == keccak256(b));
  }
  function strcmp(string memory a, string memory b) internal pure returns(bool){
    return memcmp(bytes(a), bytes(b));
  }

  function CheckElementExist(string [] memory root, string memory elem) private view returns(bool) {
    for(uint i=0;i<root.length;i++) {
      if(strcmp(root[i],elem)) {
        return true;
      }
    }
    return false;
  }

  modifier EqualLengthArrays(string[] memory first,string[] memory second) {
    require(first.length == second.length);
    _;
  }
  function CompareStringArrays(string[] memory first,string[] memory second) EqualLengthArrays(first,second) private view returns(bool) {
    for(uint i=0;i<first.length;i++) {
      if(CheckElementExist(second,first[i])) {
        continue;
      }
      else {
        return false;
      }
    }
    return true;
  }


  function CheckSubset(string[] memory root,string[] memory check) private view returns(uint256) {
    uint256 cnt=0;
    for(uint i=0;i<check.length;i++) {
      if(CheckElementExist(root,check[i])) {
        cnt += 1;
        continue;
      }
    }
    return cnt;
  }


  function RecordsExists(string[] memory records) CMSorUser() public view returns(bool) {
    if(role == Role.doctor) {
      uint256 matchedRecords = 0;
      string[] memory records_corr;
      for(uint i=0;i < listOfConsents.length;i++) {
        records_corr = Consent(listOfConsents[i]).GetConsents();
        matchedRecords = matchedRecords + CheckSubset(records_corr,records);
        if(matchedRecords == records.length) {
          return true;
        }
      }
      return false;
    }
  }


  function getAssociatedConsent(address payable _otherUser,ConsentFile _otherUserFile) onlyByUser() public returns(bool,Consent ) {
    if(role == Role.doctor) {
      for(uint i=0;i < listOfConsents.length;i++) {
        if(Consent(listOfConsents[i]).getPatient() == _otherUser) {
          return (true,Consent(listOfConsents[i]));
        }
      }
      Consent nc = new Consent(_otherUser,user,address(_otherUserFile),address(this));
      return (false,nc);
    }
    else {
      for(uint i=0;i < listOfConsents.length;i++) {
        if(Consent(listOfConsents[i]).getDoctor() == _otherUser) {
          return (true,Consent(listOfConsents[i]));
        }
      }
      Consent nc = new Consent(user,_otherUser,address(this),address(_otherUserFile));
      return (false,nc);
    }
  }


  /* Adds a new consent to the file */
  function addConsent(Consent _consent) CMSorUser() public
  {
    listOfConsents.push(address(_consent));
    emit ConsentFileConsentAdded(address(this), address(_consent));
  }

  /* Retrieve a list of all consents in the file */
  function getListOfConsents () onlyByUser() public view returns (address[] memory)
  {
    return listOfConsents;
  }

  /* Retrieves the owner */
  function getOwner () public view returns (address)
  {
    return user;
  }
  
}
