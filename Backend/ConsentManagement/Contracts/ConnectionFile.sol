pragma solidity ^0.5.2;
pragma experimental ABIEncoderV2;
import "./Connection.sol";


contract ConnectionFile {

  address CMS;
  address validator;
  uint256 max_conn = 200;


  /* The owner of the file */
  address payable user;

  enum Role {
    doctor,
    patient,
    nominee
  }


  Role private role;

  /* The list of all consents */
  Connection[] listOfConnections;

  /* Events that are sent when things happen */
  event ConnectionAdded(address indexed file,address indexed user, Role role, address indexed connection);

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

  function GetNumTypeConnections(Connection.Status state) CMSorUser() private view returns(uint256) {
    uint256 cnt = 0;
    for(uint i=0;i<listOfConnections.length;i++) {
      if(listOfConnections[i].getStatus() == state) {
        cnt += 1;
      }
    }
    return cnt;
  }

  function GetTypeConnections(Connection.Status state) CMSorUser() public view returns(address[] memory) {
    uint256 TypeCnt = GetNumTypeConnections(state);
    address[] memory ReqConnections = new address[](TypeCnt);

    uint256 cnt = 0;
    for(uint i=0;i<listOfConnections.length;i++) {
        // listOfConnections[i].getStatus();
        if(listOfConnections[i].getStatus() == state) {
            if(role == Role.doctor) {
                ReqConnections[cnt] = listOfConnections[i].getPatient();
                cnt += 1;
            }
            if(role == Role.patient) {
                ReqConnections[cnt] = listOfConnections[i].getDoctor();
                cnt += 1;
            }
        }
    }
    return ReqConnections;
  }

    function getAssociatedConnection(address _otherUser,ConnectionFile _otherUserConnFile) CMSorUser() public returns(bool,Connection) {
    if(role == Role.doctor) {
      for(uint i=0;i < listOfConnections.length;i++) {
        if(listOfConnections[i].getPatient() == _otherUser) {
          return (true,listOfConnections[i]);
        }
      }
      Connection nc = new Connection(user,_otherUser,address(this),address(_otherUserConnFile));
      return (false,nc);
    }
    else {
      for(uint i=0;i < listOfConnections.length;i++) {
        if(listOfConnections[i].getDoctor() == _otherUser) {
          return (true,listOfConnections[i]);
        }
      }
      Connection nc = new Connection(_otherUser,user,address(_otherUserConnFile),address(this));
      return (false,nc);
    }
  }

  /* Adds a new consent to the file */
  function AddConnection(Connection _connect) CMSorUser() public
  {
    listOfConnections.push(_connect);
    emit ConnectionAdded(address(this), user, role, address(_connect));
  }

  /* Retrieve a list of all consents in the file */
  function getListOfConnections () onlyByUser() public view returns (Connection[] memory)
  {
    return listOfConnections;
  }

  /* Retrieves the owner */
  function getOwner () public view returns (address)
  {
    return user;
  }

}
