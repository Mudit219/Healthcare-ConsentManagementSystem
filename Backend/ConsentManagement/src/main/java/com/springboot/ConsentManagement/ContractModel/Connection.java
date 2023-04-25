package com.springboot.ConsentManagement.ContractModel;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class Connection extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516080806104e8833981018060405261002f919081019061009d565b60008054600160a060020a0319908116600160a060020a039687161790915560018054821694861694909417909355600280548416928516929092179091556003805460a060020a60ff02199316919093161716905561011b565b6000610096825161010a565b9392505050565b600080600080608085870312156100b357600080fd5b60006100bf878761008a565b94505060206100d08782880161008a565b93505060406100e18782880161008a565b92505060606100f28782880161008a565b91505092959194509250565b600160a060020a031690565b6000610115826100fe565b92915050565b6103be8061012a6000396000f3fe608060405234801561001057600080fd5b5060043610610073577c010000000000000000000000000000000000000000000000000000000060003504632e49d78b81146100785780633aaa59201461008d5780634e69d560146100ab5780637b0f9a36146100c0578063ea8a1af0146100c8575b600080fd5b61008b6100863660046102e3565b6100d0565b005b610095610146565b6040516100a29190610321565b60405180910390f35b6100b36101b1565b6040516100a29190610335565b61009561022e565b61008b610299565b600054600160a060020a03163214806100f35750600154600160a060020a031632145b15156100fe57600080fd5b6003805482919074ff0000000000000000000000000000000000000000191674010000000000000000000000000000000000000000838381111561013e57fe5b021790555050565b600254600090600160a060020a031633148061016c5750600354600160a060020a031633145b806101815750600054600160a060020a031632145b806101965750600154600160a060020a031632145b15156101a157600080fd5b50600054600160a060020a031690565b600254600090600160a060020a03163314806101d75750600354600160a060020a031633145b806101ec5750600054600160a060020a031632145b806102015750600154600160a060020a031632145b151561020c57600080fd5b5060035474010000000000000000000000000000000000000000900460ff1690565b600254600090600160a060020a03163314806102545750600354600160a060020a031633145b806102695750600054600160a060020a031632145b8061027e5750600154600160a060020a031632145b151561028957600080fd5b50600154600160a060020a031690565b6003805474ff0000000000000000000000000000000000000000191674030000000000000000000000000000000000000000179055565b60006102dc823561036a565b9392505050565b6000602082840312156102f557600080fd5b600061030184846102d0565b949350505050565b61031281610343565b82525050565b61031281610379565b6020810161032f8284610309565b92915050565b6020810161032f8284610318565b600061032f8261035e565b60006004821061035a57fe5b5090565b600160a060020a031690565b60006004821061035a57600080fd5b600061032f8261034e56fea265627a7a72305820d26b6c3212508e6166474610d1755e66f078b5ebbf95ebddd41ad0cdffa0c65a6c6578706572696d656e74616cf50037";

    public static final String FUNC_SETSTATUS = "setStatus";

    public static final String FUNC_GETDOCTOR = "getDoctor";

    public static final String FUNC_GETSTATUS = "getStatus";

    public static final String FUNC_GETPATIENT = "getPatient";

    public static final String FUNC_CANCEL = "cancel";

    @Deprecated
    protected Connection(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Connection(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Connection(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Connection(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> setStatus(BigInteger state) {
        final Function function = new Function(
                FUNC_SETSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(state)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getDoctor() {
        final Function function = new Function(FUNC_GETDOCTOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getStatus() {
        final Function function = new Function(FUNC_GETSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getPatient() {
        final Function function = new Function(FUNC_GETPATIENT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> cancel() {
        final Function function = new Function(
                FUNC_CANCEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Connection load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Connection(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Connection load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Connection(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Connection load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Connection(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Connection load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Connection(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Connection> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _doctor, String _patient, String _DocConnectionFile, String _PatConnectionFile) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _DocConnectionFile), 
                new org.web3j.abi.datatypes.Address(160, _PatConnectionFile)));
        return deployRemoteCall(Connection.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Connection> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _doctor, String _patient, String _DocConnectionFile, String _PatConnectionFile) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _DocConnectionFile), 
                new org.web3j.abi.datatypes.Address(160, _PatConnectionFile)));
        return deployRemoteCall(Connection.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Connection> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _doctor, String _patient, String _DocConnectionFile, String _PatConnectionFile) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _DocConnectionFile), 
                new org.web3j.abi.datatypes.Address(160, _PatConnectionFile)));
        return deployRemoteCall(Connection.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Connection> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _doctor, String _patient, String _DocConnectionFile, String _PatConnectionFile) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _DocConnectionFile), 
                new org.web3j.abi.datatypes.Address(160, _PatConnectionFile)));
        return deployRemoteCall(Connection.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
