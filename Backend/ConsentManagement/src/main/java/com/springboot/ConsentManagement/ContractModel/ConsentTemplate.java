package com.springboot.ConsentManagement.ContractModel;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class ConsentTemplate extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051606080610980833981018060405261002f919081019061014a565b60018054600160a060020a03808616600160a060020a031992831617909255600280548584169083161790556000805492841692909116919091178155604080516020810191829052829052610088916005919061009c565b50506006805460ff19169055506101b49050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100dd57805160ff191683800117855561010a565b8280016001018555821561010a579182015b8281111561010a5782518255916020019190600101906100ef565b5061011692915061011a565b5090565b61013491905b808211156101165760008155600101610120565b90565b600061014382516101a3565b9392505050565b60008060006060848603121561015f57600080fd5b600061016b8686610137565b935050602061017c86828701610137565b925050604061018d86828701610137565b9150509250925092565b600160a060020a031690565b60006101ae82610197565b92915050565b6107bd806101c36000396000f3fe608060405234801561001057600080fd5b5060043610610073577c010000000000000000000000000000000000000000000000000000000060003504630f399a4181146100785780633f0622701461009657806340a4895c146100ab5780634ca334e2146100c05780636e81a8a3146100d3575b600080fd5b6100806100e8565b60405161008d9190610675565b60405180910390f35b6100a96100a4366004610595565b6100f8565b005b6100b3610126565b60405161008d91906106a1565b6100a96100ce366004610558565b6101fc565b6100db610226565b60405161008d9190610689565b600054600160a060020a03165b90565b600254600160a060020a0316321461010f57600080fd5b8051610122906005906020840190610342565b5050565b600054606090600160a060020a031633148061014c5750600254600160a060020a031632145b806101615750600154600160a060020a031632145b151561016c57600080fd5b6005805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156101f25780601f106101c7576101008083540402835291602001916101f2565b820191906000526020600020905b8154815290600101906020018083116101d557829003601f168201915b5050505050905090565b600154600160a060020a0316321461021357600080fd5b80516101229060049060208401906103c0565b600054606090600160a060020a031633148061024c5750600254600160a060020a031632145b806102615750600154600160a060020a031632145b151561026c57600080fd5b6004805480602002602001604051908101604052809291908181526020016000905b828210156103395760008481526020908190208301805460408051601f60026000196101006001871615020190941693909304928301859004850281018501909152818152928301828280156103255780601f106102fa57610100808354040283529160200191610325565b820191906000526020600020905b81548152906001019060200180831161030857829003601f168201915b50505050508152602001906001019061028e565b50505050905090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061038357805160ff19168380011785556103b0565b828001600101855582156103b0579182015b828111156103b0578251825591602001919060010190610395565b506103bc929150610419565b5090565b82805482825590600052602060002090810192821561040d579160200282015b8281111561040d57825180516103fd918491602090910190610342565b50916020019190600101906103e0565b506103bc929150610433565b6100f591905b808211156103bc576000815560010161041f565b6100f591905b808211156103bc57600061044d8282610456565b50600101610439565b50805460018160011615610100020316600290046000825580601f1061047c575061049a565b601f01602090049060005260206000209081019061049a9190610419565b50565b6000601f820183136104ae57600080fd5b81356104c16104bc826106d9565b6106b2565b81815260209384019390925082018360005b838110156104ff57813586016104e98882610509565b84525060209283019291909101906001016104d3565b5050505092915050565b6000601f8201831361051a57600080fd5b81356105286104bc826106fa565b9150808252602083016020830185838301111561054457600080fd5b61054f83828461073d565b50505092915050565b60006020828403121561056a57600080fd5b813567ffffffffffffffff81111561058157600080fd5b61058d8482850161049d565b949350505050565b6000602082840312156105a757600080fd5b813567ffffffffffffffff8111156105be57600080fd5b61058d84828501610509565b6105d38161072c565b82525050565b60006105e482610728565b808452602084019350836020820285016105fd85610722565b60005b84811015610634578383038852610618838351610640565b925061062382610722565b602098909801979150600101610600565b50909695505050505050565b600061064b82610728565b80845261065f816020860160208601610749565b61066881610779565b9093016020019392505050565b6020810161068382846105ca565b92915050565b6020808252810161069a81846105d9565b9392505050565b6020808252810161069a8184610640565b60405181810167ffffffffffffffff811182821017156106d157600080fd5b604052919050565b600067ffffffffffffffff8211156106f057600080fd5b5060209081020190565b600067ffffffffffffffff82111561071157600080fd5b506020601f91909101601f19160190565b60200190565b5190565b6000600160a060020a038216610683565b82818337506000910152565b60005b8381101561076457818101518382015260200161074c565b83811115610773576000848401525b50505050565b601f01601f19169056fea265627a7a72305820716606d9dac79b638b79eb64138e57bb76e3c48a613bfbad163dc12a0eccdc9b6c6578706572696d656e74616cf50037";

    public static final String FUNC_GETASSOCIATEDCONSENT = "GetAssociatedConsent";

    public static final String FUNC_SETTINGREQUESTEDDESC = "SettingRequestedDesc";

    public static final String FUNC_GETREQUESTEDDESC = "GetRequestedDesc";

    public static final String FUNC_SETCONSENTEDRECORDS = "setConsentedRecords";

    public static final String FUNC_GETCONSENTEDRECORDS = "GetConsentedRecords";

    @Deprecated
    protected ConsentTemplate(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ConsentTemplate(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ConsentTemplate(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ConsentTemplate(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> GetAssociatedConsent() {
        final Function function = new Function(FUNC_GETASSOCIATEDCONSENT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> SettingRequestedDesc(String desc) {
        final Function function = new Function(
                FUNC_SETTINGREQUESTEDDESC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(desc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> GetRequestedDesc() {
        final Function function = new Function(FUNC_GETREQUESTEDDESC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setConsentedRecords(List<String> _recordIds) {
        final Function function = new Function(
                FUNC_SETCONSENTEDRECORDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(_recordIds, org.web3j.abi.datatypes.Utf8String.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> GetConsentedRecords() {
        final Function function = new Function(FUNC_GETCONSENTEDRECORDS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Utf8String>>() {}));
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

    @Deprecated
    public static ConsentTemplate load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ConsentTemplate(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ConsentTemplate load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ConsentTemplate(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ConsentTemplate load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ConsentTemplate(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ConsentTemplate load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ConsentTemplate(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ConsentTemplate> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _patient, String _doctor, String _consent) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _consent)));
        return deployRemoteCall(ConsentTemplate.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ConsentTemplate> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _patient, String _doctor, String _consent) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _consent)));
        return deployRemoteCall(ConsentTemplate.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ConsentTemplate> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _patient, String _doctor, String _consent) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _consent)));
        return deployRemoteCall(ConsentTemplate.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ConsentTemplate> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _patient, String _doctor, String _consent) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _consent)));
        return deployRemoteCall(ConsentTemplate.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
