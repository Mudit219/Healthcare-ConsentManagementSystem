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
import org.web3j.abi.datatypes.Utf8String;
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
public class Consent extends Contract {
    private static final String BINARY = "60806040523480156200001157600080fd5b506040516080806200185c833981018060405262000033919081019062000117565b60028054600160a060020a03808716600160a060020a031992831617909255600380548684169083161790556000805484841690831617905560018054928516929091169190911790558383306200008a620000f1565b620000989392919062000192565b604051809103906000f080158015620000b5573d6000803e3d6000fd5b5060048054600160a060020a031916600160a060020a039290921691909117905550506003805460a060020a60ff021916905550620001e79050565b6040516109808062000edc83390190565b6000620001108251620001c8565b9392505050565b600080600080608085870312156200012e57600080fd5b60006200013c878762000102565b94505060206200014f8782880162000102565b9350506040620001628782880162000102565b9250506060620001758782880162000102565b91505092959194509250565b6200018c81620001c8565b82525050565b60608101620001a2828662000181565b620001b1602083018562000181565b620001c0604083018462000181565b949350505050565b6000620001d582620001db565b92915050565b600160a060020a031690565b610ce580620001f76000396000f3fe608060405234801561001057600080fd5b50600436106100c6576000357c0100000000000000000000000000000000000000000000000000000000900480634e69d5601161008e5780634e69d560146101235780637b0f9a3614610138578063aa43c93614610140578063bc307bb914610153578063ea8a1af01461015b578063f998292a14610163576100c6565b8063321c48f2146100cb578063370fcc20146100e95780633aaa5920146100f157806340ab301e146100f95780634ca334e21461010e575b600080fd5b6100d3610176565b6040516100e09190610b55565b60405180910390f35b6100d36101e1565b6100d36101f0565b61010161025b565b6040516100e09190610b7a565b61012161011c366004610981565b610352565b005b61012b610472565b6040516100e09190610b8b565b6100d36104ef565b61012161014e3660046109f3565b61055a565b6100d3610633565b610121610642565b610121610171366004610a11565b61077c565b600154600090600160a060020a031633148061019c5750600054600160a060020a031633145b806101b15750600254600160a060020a031632145b806101c65750600354600160a060020a031632145b15156101d157600080fd5b50600454600160a060020a031690565b600054600160a060020a031690565b600154600090600160a060020a03163314806102165750600054600160a060020a031633145b8061022b5750600254600160a060020a031632145b806102405750600354600160a060020a031632145b151561024b57600080fd5b50600354600160a060020a031690565b600154606090600160a060020a03163314806102815750600054600160a060020a031633145b806102965750600254600160a060020a031632145b806102ab5750600354600160a060020a031632145b15156102b657600080fd5b60048054604080517f6e81a8a30000000000000000000000000000000000000000000000000000000081529051600160a060020a0390921692636e81a8a3928282019260009290829003018186803b15801561031157600080fd5b505afa158015610325573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f1916820160405261034d91908101906109be565b905090565b600254600160a060020a0316321461036957600080fd5b6003805474ff0000000000000000000000000000000000000000191674020000000000000000000000000000000000000000179055600480546040517f4ca334e2000000000000000000000000000000000000000000000000000000008152600160a060020a0390911691634ca334e2916103e691859101610b7a565b600060405180830381600087803b15801561040057600080fd5b505af1158015610414573d6000803e3d6000fd5b50506003546040513093507f7004293283c83e944feedfe102d317947bdd62fdffaa93c44ab95e20b426befd92506104679174010000000000000000000000000000000000000000900460ff1690610b8b565b60405180910390a250565b600154600090600160a060020a03163314806104985750600054600160a060020a031633145b806104ad5750600254600160a060020a031632145b806104c25750600354600160a060020a031632145b15156104cd57600080fd5b5060035474010000000000000000000000000000000000000000900460ff1690565b600154600090600160a060020a03163314806105155750600054600160a060020a031633145b8061052a5750600254600160a060020a031632145b8061053f5750600354600160a060020a031632145b151561054a57600080fd5b50600254600160a060020a031690565b600254600160a060020a0316321461057157600080fd5b600181600481111561057f57fe5b14806105965750600281600481111561059457fe5b145b15610630576003805482919074ff00000000000000000000000000000000000000001916740100000000000000000000000000000000000000008360048111156105dc57fe5b021790555060035460405130917f7004293283c83e944feedfe102d317947bdd62fdffaa93c44ab95e20b426befd916104679174010000000000000000000000000000000000000000900460ff1690610b8b565b50565b600154600160a060020a031690565b600254600160a060020a0316321461065957600080fd5b6003805474ff000000000000000000000000000000000000000019167404000000000000000000000000000000000000000017905560045460408051600080825260208201909252600160a060020a0390921691634ca334e2916106cd565b60608152602001906001900390816106b85790505b506040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016107069190610b69565b600060405180830381600087803b15801561072057600080fd5b505af1158015610734573d6000803e3d6000fd5b5050505030600160a060020a03167f7004293283c83e944feedfe102d317947bdd62fdffaa93c44ab95e20b426befd60046040516107729190610b8b565b60405180910390a2565b600354600160a060020a0316321461079357600080fd5b6003805474ff0000000000000000000000000000000000000000191674030000000000000000000000000000000000000000179055600480546040517f3f062270000000000000000000000000000000000000000000000000000000008152600160a060020a0390911691633f062270916103e691859101610b99565b6000601f8201831361082157600080fd5b813561083461082f82610bd1565b610baa565b81815260209384019390925082018360005b83811015610872578135860161085c88826108ec565b8452506020928301929190910190600101610846565b5050505092915050565b6000601f8201831361088d57600080fd5b815161089b61082f82610bd1565b81815260209384019390925082018360005b8381101561087257815186016108c3888261093b565b84525060209283019291909101906001016108ad565b60006108e58235610c4b565b9392505050565b6000601f820183136108fd57600080fd5b813561090b61082f82610bf2565b9150808252602083016020830185838301111561092757600080fd5b610932838284610c65565b50505092915050565b6000601f8201831361094c57600080fd5b815161095a61082f82610bf2565b9150808252602083016020830185838301111561097657600080fd5b610932838284610c71565b60006020828403121561099357600080fd5b813567ffffffffffffffff8111156109aa57600080fd5b6109b684828501610810565b949350505050565b6000602082840312156109d057600080fd5b815167ffffffffffffffff8111156109e757600080fd5b6109b68482850161087c565b600060208284031215610a0557600080fd5b60006109b684846108d9565b600060208284031215610a2357600080fd5b813567ffffffffffffffff811115610a3a57600080fd5b6109b6848285016108ec565b610a4f81610c24565b82525050565b6000610a6082610c20565b80845260208401935083602082028501610a7985610c1a565b60005b84811015610ab0578383038852610a94838351610b20565b9250610a9f82610c1a565b602098909801979150600101610a7c565b50909695505050505050565b6000610ac782610c20565b80845260208401935083602082028501610ae085610c1a565b60005b84811015610ab0578383038852610afb838351610b20565b9250610b0682610c1a565b602098909801979150600101610ae3565b610a4f81610c5a565b6000610b2b82610c20565b808452610b3f816020860160208601610c71565b610b4881610ca1565b9093016020019392505050565b60208101610b638284610a46565b92915050565b602080825281016108e58184610abc565b602080825281016108e58184610a55565b60208101610b638284610b17565b602080825281016108e58184610b20565b60405181810167ffffffffffffffff81118282101715610bc957600080fd5b604052919050565b600067ffffffffffffffff821115610be857600080fd5b5060209081020190565b600067ffffffffffffffff821115610c0957600080fd5b506020601f91909101601f19160190565b60200190565b5190565b6000610b6382610c3f565b600060058210610c3b57fe5b5090565b600160a060020a031690565b600060058210610c3b57600080fd5b6000610b6382610c2f565b82818337506000910152565b60005b83811015610c8c578181015183820152602001610c74565b83811115610c9b576000848401525b50505050565b601f01601f19169056fea265627a7a723058204c721c2d22b91668037eddf25ae7d0595ee37a70cc802eab861e6fc948c43adc6c6578706572696d656e74616cf50037608060405234801561001057600080fd5b50604051606080610980833981018060405261002f919081019061014a565b60018054600160a060020a03808616600160a060020a031992831617909255600280548584169083161790556000805492841692909116919091178155604080516020810191829052829052610088916005919061009c565b50506006805460ff19169055506101b49050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100dd57805160ff191683800117855561010a565b8280016001018555821561010a579182015b8281111561010a5782518255916020019190600101906100ef565b5061011692915061011a565b5090565b61013491905b808211156101165760008155600101610120565b90565b600061014382516101a3565b9392505050565b60008060006060848603121561015f57600080fd5b600061016b8686610137565b935050602061017c86828701610137565b925050604061018d86828701610137565b9150509250925092565b600160a060020a031690565b60006101ae82610197565b92915050565b6107bd806101c36000396000f3fe608060405234801561001057600080fd5b5060043610610073577c010000000000000000000000000000000000000000000000000000000060003504630f399a4181146100785780633f0622701461009657806340a4895c146100ab5780634ca334e2146100c05780636e81a8a3146100d3575b600080fd5b6100806100e8565b60405161008d9190610675565b60405180910390f35b6100a96100a4366004610595565b6100f8565b005b6100b3610126565b60405161008d91906106a1565b6100a96100ce366004610558565b6101fc565b6100db610226565b60405161008d9190610689565b600054600160a060020a03165b90565b600254600160a060020a0316321461010f57600080fd5b8051610122906005906020840190610342565b5050565b600054606090600160a060020a031633148061014c5750600254600160a060020a031632145b806101615750600154600160a060020a031632145b151561016c57600080fd5b6005805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156101f25780601f106101c7576101008083540402835291602001916101f2565b820191906000526020600020905b8154815290600101906020018083116101d557829003601f168201915b5050505050905090565b600154600160a060020a0316321461021357600080fd5b80516101229060049060208401906103c0565b600054606090600160a060020a031633148061024c5750600254600160a060020a031632145b806102615750600154600160a060020a031632145b151561026c57600080fd5b6004805480602002602001604051908101604052809291908181526020016000905b828210156103395760008481526020908190208301805460408051601f60026000196101006001871615020190941693909304928301859004850281018501909152818152928301828280156103255780601f106102fa57610100808354040283529160200191610325565b820191906000526020600020905b81548152906001019060200180831161030857829003601f168201915b50505050508152602001906001019061028e565b50505050905090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061038357805160ff19168380011785556103b0565b828001600101855582156103b0579182015b828111156103b0578251825591602001919060010190610395565b506103bc929150610419565b5090565b82805482825590600052602060002090810192821561040d579160200282015b8281111561040d57825180516103fd918491602090910190610342565b50916020019190600101906103e0565b506103bc929150610433565b6100f591905b808211156103bc576000815560010161041f565b6100f591905b808211156103bc57600061044d8282610456565b50600101610439565b50805460018160011615610100020316600290046000825580601f1061047c575061049a565b601f01602090049060005260206000209081019061049a9190610419565b50565b6000601f820183136104ae57600080fd5b81356104c16104bc826106d9565b6106b2565b81815260209384019390925082018360005b838110156104ff57813586016104e98882610509565b84525060209283019291909101906001016104d3565b5050505092915050565b6000601f8201831361051a57600080fd5b81356105286104bc826106fa565b9150808252602083016020830185838301111561054457600080fd5b61054f83828461073d565b50505092915050565b60006020828403121561056a57600080fd5b813567ffffffffffffffff81111561058157600080fd5b61058d8482850161049d565b949350505050565b6000602082840312156105a757600080fd5b813567ffffffffffffffff8111156105be57600080fd5b61058d84828501610509565b6105d38161072c565b82525050565b60006105e482610728565b808452602084019350836020820285016105fd85610722565b60005b84811015610634578383038852610618838351610640565b925061062382610722565b602098909801979150600101610600565b50909695505050505050565b600061064b82610728565b80845261065f816020860160208601610749565b61066881610779565b9093016020019392505050565b6020810161068382846105ca565b92915050565b6020808252810161069a81846105d9565b9392505050565b6020808252810161069a8184610640565b60405181810167ffffffffffffffff811182821017156106d157600080fd5b604052919050565b600067ffffffffffffffff8211156106f057600080fd5b5060209081020190565b600067ffffffffffffffff82111561071157600080fd5b506020601f91909101601f19160190565b60200190565b5190565b6000600160a060020a038216610683565b82818337506000910152565b60005b8381101561076457818101518382015260200161074c565b83811115610773576000848401525b50505050565b601f01601f19169056fea265627a7a72305820716606d9dac79b638b79eb64138e57bb76e3c48a613bfbad163dc12a0eccdc9b6c6578706572696d656e74616cf50037";

    public static final String FUNC_GETTEMPLATE = "getTemplate";

    public static final String FUNC_GETASSOCIATEDDOCCONSENTFILE = "GetAssociatedDocConsentFile";

    public static final String FUNC_GETDOCTOR = "getDoctor";

    public static final String FUNC_GETCONSENTS = "GetConsents";

    public static final String FUNC_SETCONSENTEDRECORDS = "setConsentedRecords";

    public static final String FUNC_GETSTATUS = "getStatus";

    public static final String FUNC_GETPATIENT = "getPatient";

    public static final String FUNC_SETPATIENTSIDESTATUS = "setPatientSideStatus";

    public static final String FUNC_GETASSOCIATEDPATCONSENTFILE = "GetAssociatedPatConsentFile";

    public static final String FUNC_CANCEL = "cancel";

    public static final String FUNC_SETREQUESTSTATUS = "setRequestStatus";

    public static final Event CONSENTSTATUSCHANGED_EVENT = new Event("ConsentStatusChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint8>() {}));
    ;

    @Deprecated
    protected Consent(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Consent(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Consent(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Consent(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getTemplate() {
        final Function function = new Function(FUNC_GETTEMPLATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> GetAssociatedDocConsentFile() {
        final Function function = new Function(FUNC_GETASSOCIATEDDOCCONSENTFILE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getDoctor() {
        final Function function = new Function(FUNC_GETDOCTOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<List> GetConsents() {
        final Function function = new Function(FUNC_GETCONSENTS, 
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

    public RemoteFunctionCall<TransactionReceipt> setConsentedRecords(List<String> consentedRecords) {
        final Function function = new Function(
                FUNC_SETCONSENTEDRECORDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(consentedRecords, org.web3j.abi.datatypes.Utf8String.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteFunctionCall<TransactionReceipt> setPatientSideStatus(BigInteger _status) {
        final Function function = new Function(
                FUNC_SETPATIENTSIDESTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> GetAssociatedPatConsentFile() {
        final Function function = new Function(FUNC_GETASSOCIATEDPATCONSENTFILE, 
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

    public RemoteFunctionCall<TransactionReceipt> setRequestStatus(String requestdesc) {
        final Function function = new Function(
                FUNC_SETREQUESTSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(requestdesc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<ConsentStatusChangedEventResponse> getConsentStatusChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CONSENTSTATUSCHANGED_EVENT, transactionReceipt);
        ArrayList<ConsentStatusChangedEventResponse> responses = new ArrayList<ConsentStatusChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ConsentStatusChangedEventResponse typedResponse = new ConsentStatusChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.consent = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.status = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ConsentStatusChangedEventResponse> consentStatusChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ConsentStatusChangedEventResponse>() {
            @Override
            public ConsentStatusChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONSENTSTATUSCHANGED_EVENT, log);
                ConsentStatusChangedEventResponse typedResponse = new ConsentStatusChangedEventResponse();
                typedResponse.log = log;
                typedResponse.consent = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.status = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ConsentStatusChangedEventResponse> consentStatusChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONSENTSTATUSCHANGED_EVENT));
        return consentStatusChangedEventFlowable(filter);
    }

    @Deprecated
    public static Consent load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Consent(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Consent load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Consent(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Consent load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Consent(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Consent load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Consent(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Consent> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _patient, String _doctor, String _PatConsentFile, String _DocConsentFile) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _PatConsentFile), 
                new org.web3j.abi.datatypes.Address(160, _DocConsentFile)));
        return deployRemoteCall(Consent.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Consent> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _patient, String _doctor, String _PatConsentFile, String _DocConsentFile) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _PatConsentFile), 
                new org.web3j.abi.datatypes.Address(160, _DocConsentFile)));
        return deployRemoteCall(Consent.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Consent> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _patient, String _doctor, String _PatConsentFile, String _DocConsentFile) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _PatConsentFile), 
                new org.web3j.abi.datatypes.Address(160, _DocConsentFile)));
        return deployRemoteCall(Consent.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Consent> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _patient, String _doctor, String _PatConsentFile, String _DocConsentFile) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _patient), 
                new org.web3j.abi.datatypes.Address(160, _doctor), 
                new org.web3j.abi.datatypes.Address(160, _PatConsentFile), 
                new org.web3j.abi.datatypes.Address(160, _DocConsentFile)));
        return deployRemoteCall(Consent.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ConsentStatusChangedEventResponse extends BaseEventResponse {
        public String consent;

        public BigInteger status;
    }
}
