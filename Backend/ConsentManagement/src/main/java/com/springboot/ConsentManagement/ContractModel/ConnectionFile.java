package com.springboot.ConsentManagement.ContractModel;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.0.
 */
public class ConnectionFile extends Contract {
    private static final String BINARY = "608060405260c860025534801561001557600080fd5b5060405160608062001334833981018060405261003591908101906100c1565b60008054600160a060020a03808416600160a060020a03199283161790925560038054928616929091169190911780825583919060a060020a60ff0219167401000000000000000000000000000000000000000083600281111561009557fe5b021790555050505061013e565b60006100ae825161011a565b9392505050565b60006100ae825161012b565b6000806000606084860312156100d657600080fd5b60006100e286866100a2565b93505060206100f3868287016100b5565b9250506040610104868287016100a2565b9150509250925092565b600160a060020a031690565b60006101258261010e565b92915050565b60006003821061013a57600080fd5b5090565b6111e6806200014e6000396000f3fe608060405234801561001057600080fd5b5060043610610073577c01000000000000000000000000000000000000000000000000000000006000350463117334a48114610078578063122b2b5a146100a257806346bc6c88146100b75780635cd3d8da146100d7578063893d20e8146100ec575b600080fd5b61008b610086366004610a3b565b610101565b604051610099929190610c35565b60405180910390f35b6100aa6103d8565b6040516100999190610c24565b6100ca6100c5366004610a93565b610452565b6040516100999190610c13565b6100ea6100e5366004610a75565b6107b0565b005b6100f4610899565b6040516100999190610ba6565b6003546000908190600160a060020a03163214806101295750600054600160a060020a031633145b151561013457600080fd5b600060035474010000000000000000000000000000000000000000900460ff16600281111561015f57fe5b14156102c05760005b60045481101561026e5784600160a060020a031660048281548110151561018b57fe5b60009182526020918290200154604080517f7b0f9a360000000000000000000000000000000000000000000000000000000081529051600160a060020a0390921692637b0f9a3692600480840193829003018186803b1580156101ed57600080fd5b505afa158015610201573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506102259190810190610a15565b600160a060020a0316141561026657600160048281548110151561024557fe5b600091825260209091200154909350600160a060020a031691506103d19050565b600101610168565b50600354600090600160a060020a03168530866102896109c2565b6102969493929190610bba565b604051809103906000f0801580156102b2573d6000803e3d6000fd5b506000935091506103d19050565b60005b6004548110156103a85784600160a060020a03166004828154811015156102e657fe5b60009182526020918290200154604080517f3aaa59200000000000000000000000000000000000000000000000000000000081529051600160a060020a0390921692633aaa592092600480840193829003018186803b15801561034857600080fd5b505afa15801561035c573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506103809190810190610a15565b600160a060020a031614156103a057600160048281548110151561024557fe5b6001016102c3565b506003546000908590600160a060020a031685306103c46109c2565b6102969493929190610bf8565b9250929050565b600354606090600160a060020a031632146103f257600080fd5b600480548060200260200160405190810160405280929190818152602001828054801561044857602002820191906000526020600020905b8154600160a060020a0316815260019091019060200180831161042a575b5050505050905090565b600354606090600160a060020a03163214806104785750600054600160a060020a031633145b151561048357600080fd5b600061048e836108a8565b90506060816040519080825280602002602001820160405280156104bc578160200160208202803883390190505b5090506000805b6004548110156107a6578560038111156104d957fe5b60048054839081106104e757fe5b60009182526020918290200154604080517f4e69d5600000000000000000000000000000000000000000000000000000000081529051600160a060020a0390921692634e69d56092600480840193829003018186803b15801561054957600080fd5b505afa15801561055d573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506105819190810190610ab1565b600381111561058c57fe5b141561079e57600060035474010000000000000000000000000000000000000000900460ff1660028111156105bd57fe5b14156106985760048054829081106105d157fe5b60009182526020918290200154604080517f7b0f9a360000000000000000000000000000000000000000000000000000000081529051600160a060020a0390921692637b0f9a3692600480840193829003018186803b15801561063357600080fd5b505afa158015610647573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525061066b9190810190610a15565b838381518110151561067957fe5b600160a060020a03909216602092830290910190910152600191909101905b600160035474010000000000000000000000000000000000000000900460ff1660028111156106c357fe5b141561079e5760048054829081106106d757fe5b60009182526020918290200154604080517f3aaa59200000000000000000000000000000000000000000000000000000000081529051600160a060020a0390921692633aaa592092600480840193829003018186803b15801561073957600080fd5b505afa15801561074d573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506107719190810190610a15565b838381518110151561077f57fe5b600160a060020a03909216602092830290910190910152600191909101905b6001016104c3565b5090949350505050565b600354600160a060020a03163214806107d35750600054600160a060020a031633145b15156107de57600080fd5b600480546001810182556000919091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03838116918217909255600354604051919281169130917f8a9208f2779a24d352064589ab804c990968f6b7568525cadfe439d89b47d1d79161088e9174010000000000000000000000000000000000000000900460ff1690610c50565b60405180910390a450565b600354600160a060020a031690565b600354600090600160a060020a03163214806108ce5750600054600160a060020a031633145b15156108d957600080fd5b6000805b6004548110156109bb578360038111156108f357fe5b600480548390811061090157fe5b60009182526020918290200154604080517f4e69d5600000000000000000000000000000000000000000000000000000000081529051600160a060020a0390921692634e69d56092600480840193829003018186803b15801561096357600080fd5b505afa158015610977573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525061099b9190810190610ab1565b60038111156109a657fe5b14156109b3576001820191505b6001016108dd565b5092915050565b6040516104e880610cc583390190565b60006109de8235610c68565b9392505050565b60006109de8251610c68565b60006109de8235610c94565b60006109de8235610c9f565b60006109de8251610c9f565b600060208284031215610a2757600080fd5b6000610a3384846109e5565b949350505050565b60008060408385031215610a4e57600080fd5b6000610a5a85856109d2565b9250506020610a6b858286016109f1565b9150509250929050565b600060208284031215610a8757600080fd5b6000610a3384846109f1565b600060208284031215610aa557600080fd5b6000610a3384846109fd565b600060208284031215610ac357600080fd5b6000610a338484610a09565b610ad881610cae565b82525050565b610ad881610c68565b6000610af282610c64565b808452602084019350610b0483610c5e565b60005b82811015610b3457610b1a868351610ade565b610b2382610c5e565b602096909601959150600101610b07565b5093949350505050565b6000610b4982610c64565b808452602084019350610b5b83610c5e565b60005b82811015610b3457610b71868351610b94565b610b7a82610c5e565b602096909601959150600101610b5e565b610ad881610c73565b610ad881610c94565b610ad881610cb9565b60208101610bb48284610ade565b92915050565b60808101610bc88287610acf565b610bd56020830186610ade565b610be26040830185610ade565b610bef6060830184610ade565b95945050505050565b60808101610c068287610ade565b610bd56020830186610acf565b602080825281016109de8184610ae7565b602080825281016109de8184610b3e565b60408101610c438285610b8b565b6109de6020830184610b94565b60208101610bb48284610b9d565b60200190565b5190565b6000610bb482610c88565b151590565b600060038210610c8457fe5b5090565b600160a060020a031690565b6000610bb482610c68565b600060048210610c8457600080fd5b6000610bb482610c94565b6000610bb482610c7856fe608060405234801561001057600080fd5b506040516080806104e8833981018060405261002f919081019061009d565b60008054600160a060020a0319908116600160a060020a039687161790915560018054821694861694909417909355600280548416928516929092179091556003805460a060020a60ff02199316919093161716905561011b565b6000610096825161010a565b9392505050565b600080600080608085870312156100b357600080fd5b60006100bf878761008a565b94505060206100d08782880161008a565b93505060406100e18782880161008a565b92505060606100f28782880161008a565b91505092959194509250565b600160a060020a031690565b6000610115826100fe565b92915050565b6103be8061012a6000396000f3fe608060405234801561001057600080fd5b5060043610610073577c010000000000000000000000000000000000000000000000000000000060003504632e49d78b81146100785780633aaa59201461008d5780634e69d560146100ab5780637b0f9a36146100c0578063ea8a1af0146100c8575b600080fd5b61008b6100863660046102e3565b6100d0565b005b610095610146565b6040516100a29190610321565b60405180910390f35b6100b36101b1565b6040516100a29190610335565b61009561022e565b61008b610299565b600054600160a060020a03163214806100f35750600154600160a060020a031632145b15156100fe57600080fd5b6003805482919074ff0000000000000000000000000000000000000000191674010000000000000000000000000000000000000000838381111561013e57fe5b021790555050565b600254600090600160a060020a031633148061016c5750600354600160a060020a031633145b806101815750600054600160a060020a031632145b806101965750600154600160a060020a031632145b15156101a157600080fd5b50600054600160a060020a031690565b600254600090600160a060020a03163314806101d75750600354600160a060020a031633145b806101ec5750600054600160a060020a031632145b806102015750600154600160a060020a031632145b151561020c57600080fd5b5060035474010000000000000000000000000000000000000000900460ff1690565b600254600090600160a060020a03163314806102545750600354600160a060020a031633145b806102695750600054600160a060020a031632145b8061027e5750600154600160a060020a031632145b151561028957600080fd5b50600154600160a060020a031690565b6003805474ff0000000000000000000000000000000000000000191674030000000000000000000000000000000000000000179055565b60006102dc823561036a565b9392505050565b6000602082840312156102f557600080fd5b600061030184846102d0565b949350505050565b61031281610343565b82525050565b61031281610379565b6020810161032f8284610309565b92915050565b6020810161032f8284610318565b600061032f8261035e565b60006004821061035a57fe5b5090565b600160a060020a031690565b60006004821061035a57600080fd5b600061032f8261034e56fea265627a7a72305820d26b6c3212508e6166474610d1755e66f078b5ebbf95ebddd41ad0cdffa0c65a6c6578706572696d656e74616cf50037a265627a7a72305820dcad74c89dd4564cd3ffb7f5bfb74287aa78c8de749c29b0a0e3cbe75c04716e6c6578706572696d656e74616cf50037";

    public static final String FUNC_GETASSOCIATEDCONNECTION = "getAssociatedConnection";

    public static final String FUNC_GETLISTOFCONNECTIONS = "getListOfConnections";

    public static final String FUNC_GETTYPECONNECTIONS = "GetTypeConnections";

    public static final String FUNC_ADDCONNECTION = "AddConnection";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final Event CONNECTIONADDED_EVENT = new Event("ConnectionAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint8>() {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected ConnectionFile(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ConnectionFile(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ConnectionFile(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ConnectionFile(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> getAssociatedConnection(String _otherUser, String _otherUserConnFile) {
        final Function function = new Function(
                FUNC_GETASSOCIATEDCONNECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _otherUser), 
                new org.web3j.abi.datatypes.Address(160, _otherUserConnFile)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getListOfConnections() {
        final Function function = new Function(FUNC_GETLISTOFCONNECTIONS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<List> GetTypeConnections(BigInteger state) {
        final Function function = new Function(FUNC_GETTYPECONNECTIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(state)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> AddConnection(String _connect) {
        final Function function = new Function(
                FUNC_ADDCONNECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _connect)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public List<ConnectionAddedEventResponse> getConnectionAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CONNECTIONADDED_EVENT, transactionReceipt);
        ArrayList<ConnectionAddedEventResponse> responses = new ArrayList<ConnectionAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ConnectionAddedEventResponse typedResponse = new ConnectionAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.file = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.user = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.connection = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.role = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ConnectionAddedEventResponse> connectionAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ConnectionAddedEventResponse>() {
            @Override
            public ConnectionAddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONNECTIONADDED_EVENT, log);
                ConnectionAddedEventResponse typedResponse = new ConnectionAddedEventResponse();
                typedResponse.log = log;
                typedResponse.file = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.user = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.connection = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.role = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ConnectionAddedEventResponse> connectionAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONNECTIONADDED_EVENT));
        return connectionAddedEventFlowable(filter);
    }

    @Deprecated
    public static ConnectionFile load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ConnectionFile(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ConnectionFile load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ConnectionFile(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ConnectionFile load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ConnectionFile(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ConnectionFile load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ConnectionFile(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ConnectionFile> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _user, BigInteger _role, String _CMS) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user), 
                new org.web3j.abi.datatypes.generated.Uint8(_role), 
                new org.web3j.abi.datatypes.Address(160, _CMS)));
        return deployRemoteCall(ConnectionFile.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ConnectionFile> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _user, BigInteger _role, String _CMS) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user), 
                new org.web3j.abi.datatypes.generated.Uint8(_role), 
                new org.web3j.abi.datatypes.Address(160, _CMS)));
        return deployRemoteCall(ConnectionFile.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ConnectionFile> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _user, BigInteger _role, String _CMS) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user), 
                new org.web3j.abi.datatypes.generated.Uint8(_role), 
                new org.web3j.abi.datatypes.Address(160, _CMS)));
        return deployRemoteCall(ConnectionFile.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ConnectionFile> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _user, BigInteger _role, String _CMS) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user), 
                new org.web3j.abi.datatypes.generated.Uint8(_role), 
                new org.web3j.abi.datatypes.Address(160, _CMS)));
        return deployRemoteCall(ConnectionFile.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ConnectionAddedEventResponse extends BaseEventResponse {
        public String file;

        public String user;

        public String connection;

        public BigInteger role;
    }
}
