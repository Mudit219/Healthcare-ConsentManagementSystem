package com.springboot.ConsentManagement.ContractService;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.springboot.ConsentManagement.ContractModel.ConsentManagementSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Bool;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.springboot.ConsentManagement.ContractModel.Contract;

@Service
public class ContractService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContractService.class);
    private static final String PASSWORD = "saksham";
    private static final BigInteger GAS_PRICE = BigInteger.valueOf(1L);
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(4713288);
    
    @Autowired
    Web3j web3j;

	@Value("${OwnerAccount:NA}")
	private String PrivateKey;

    Credentials credentials;

	@Value("${ContractAddr:''}")
    private String contractAddr;
    
   
    @PostConstruct
    public void init() throws IOException, CipherException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
//    	String file = WalletUtils.generateLightNewWalletFile(PASSWORD, null);
//    	credentials = WalletUtils.loadCredentials(PASSWORD, file);
		System.out.println(PrivateKey);
		credentials = Credentials.create(PrivateKey);
		LOGGER.info("Credentials created: address={}", credentials.getAddress());
//    	EthCoinbase coinbase = web3j.ethCoinbase().send();
//    	System.out.println(coinbase.getAddress());
    	EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
    	Transaction transaction = Transaction.createEtherTransaction(credentials.getAddress(), transactionCount.getTransactionCount(), BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(21_000), credentials.getAddress(),BigInteger.valueOf(25_000_000_000_000_000L));
    	web3j.ethSendTransaction(transaction).send();
    	EthGetBalance balance = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
    	LOGGER.info("Balance: {}", balance.getBalance().longValue());
    }
    
    public String getOwnerAccount() {
    	return credentials.getAddress();
    }
    
    public Contract createContract(Contract newContract) throws Exception {
//    	String file = WalletUtils.generateLightNewWalletFile(PASSWORD, null);
//    	Credentials receiverCredentials = WalletUtils.loadCredentials(PASSWORD, file);
    	LOGGER.info("Credentials created: address={}", credentials.getAddress());

    	ConsentManagementSystem contract = ConsentManagementSystem.deploy(web3j, credentials, ConsentManagementSystem.GAS_PRICE,ConsentManagementSystem.GAS_LIMIT
				, "CMS Healthcare Company").send();
    	newContract.setReceiver(credentials.getAddress());
    	newContract.setAddress(contract.getContractAddress());
		contractAddr = contract.getContractAddress();
    	LOGGER.info("New contract deployed: address={}", contract.getContractAddress());
    	Optional<TransactionReceipt> tr = contract.getTransactionReceipt();
    	if (tr.isPresent()) {
    		LOGGER.info("Transaction receipt: from={}, to={}, gas={}", tr.get().getFrom(), tr.get().getTo(), tr.get().getGasUsed().intValue());
    	}
    	return newContract;
    }

    
    public void AddNewUserToContract(String _user,String role) {
		ConsentManagementSystem contract = ConsentManagementSystem.load(contractAddr, web3j, credentials, GAS_PRICE, GAS_LIMIT);
		try {
			TransactionReceipt tr = contract.AddNewUser(_user,role).send();
			LOGGER.info("Transaction receipt: from={}, to={}, gas={}", tr.getFrom(), tr.getTo(), tr.getGasUsed().intValue());
			LOGGER.info("Get receiver: {}", contract.DoctorExists().send());
			EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST, contract.getContractAddress());
			web3j.ethLogFlowable(filter).subscribe(log -> {
				LOGGER.info("Log: {}", log.getData());
			});
		} catch (Exception e) {
			LOGGER.error("Error during contract execution", e);
		}
    }

	public List GetRequestedConnection(String _user) {
		System.out.print(contractAddr);
		System.out.print(_user);

		ConsentManagementSystem contract = ConsentManagementSystem.load(contractAddr, web3j, credentials, GAS_PRICE, BigInteger.valueOf(4372188));
		try {
			List ReqConnections = contract.GetReqestedConnections(_user).send();
			LOGGER.info("List: ",ReqConnections);
			ReqConnections.forEach((conn) -> {
				System.out.print(conn);
			});
			return ReqConnections;
		}
		catch (Exception e) {
			LOGGER.error("Error during contract execution", e);
		}
		return null;
	}

	public List GetAcceptedConnection(String _user) {
		System.out.print(contractAddr);
		System.out.print(_user);

		ConsentManagementSystem contract = ConsentManagementSystem.load(contractAddr, web3j, credentials, GAS_PRICE, BigInteger.valueOf(4372188));
		try {
			List AcceptedConnections = contract.GetAcceptedConnections(_user).send();
			LOGGER.info("List: ",AcceptedConnections);
			AcceptedConnections.forEach((conn) -> {
				System.out.print(conn);
			});
			return AcceptedConnections;
		}
		catch (Exception e) {
			LOGGER.error("Error during contract execution", e);
		}
		return null;
	}

	public Boolean CheckValidRecords(String doctor, String[] records) {
		System.out.print(contractAddr);

		ConsentManagementSystem contract = ConsentManagementSystem.load(contractAddr, web3j, credentials, GAS_PRICE, BigInteger.valueOf(4372188));
		try {
			Boolean ret = contract.ValidateRecordRequest(doctor, List.of(records)).send();
			LOGGER.info("Ret value: ",ret);
			return ret;
		}
		catch (Exception e) {
			LOGGER.error("Error during contract execution", e);
		}
		return Boolean.FALSE;
	}

}