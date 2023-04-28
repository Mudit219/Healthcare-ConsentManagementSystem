package com.springboot.ConsentManagement.ContractService;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import com.springboot.ConsentManagement.ContractModel.ConsentManagementSystem;
import kotlin.Pair;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Bool;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.springboot.ConsentManagement.ContractModel.Contract;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;

@Service
public class ContractService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContractService.class);
	private static final String PASSWORD = "saksham";
	private static final BigInteger GAS_PRICE = BigInteger.valueOf(1L);
	private static final BigInteger GAS_LIMIT = BigInteger.valueOf(4713288);

	Web3j web3j;

	@Value("${OwnerAccount:NA}")
	private String PrivateKey;

	Credentials credentials;

	@Value("${ContractAddr:''}")
	private String contractAddr;

	@Value("${ClientAddr:''}")
	private String clientAddress;


	@PostConstruct
	public void init() throws Exception, IOException, CipherException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
		this.web3j = Web3j.build(new HttpService(clientAddress));
		//    	String file = WalletUtils.generateLightNewWalletFile(PASSWORD, null);
		//    	credentials = WalletUtils.loadCredentials(PASSWORD, file);
		System.out.println(PrivateKey);
		credentials = Credentials.create(PrivateKey);
		LOGGER.info("Credentials created: address={}", credentials.getAddress());
//    	EthCoinbase coinbase = web3j.ethCoinbase().send();
//    	System.out.println(coinbase.getAddress());
//    	EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
//    	Transaction transaction = Transaction.createEtherTransaction(credentials.getAddress(), transactionCount.getTransactionCount(), BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(21_000), credentials.getAddress(),BigInteger.valueOf(25_000_000_000_000_000L));
//    	web3j.ethSendTransaction(transaction).send();
//    	EthGetBalance balance = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameter.valueOf("LATEST")).sendAsync().get(10, TimeUnit.SECONDS);
//    	LOGGER.info("Balance: {}", balance.getBalance().longValue());
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


	public Pair<Boolean,String> AddNewUserToContract(String _user, String role) {
		ConsentManagementSystem contract = ConsentManagementSystem.load(contractAddr,
				web3j, credentials, GAS_PRICE, BigInteger.valueOf(4372188));

		try {
			TransactionReceipt tr = contract.AddNewUser(_user,role).sendAsync().get(1000,TimeUnit.SECONDS);
			System.out.println(tr);
			LOGGER.info("Transaction receipt: from={}, to={}, gas={}",
					tr.getFrom(), tr.getTo(), tr.getGasUsed().intValue());
			EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,
					DefaultBlockParameterName.LATEST, contract.getContractAddress());
			web3j.ethLogFlowable(filter).subscribe(log -> {
				LOGGER.info("Log: {}", log.getData());
			});
			return new Pair<Boolean, String>(Boolean.TRUE,"Success");
		} catch (Exception e) {
			LOGGER.error("Error during contract execution", e);

			return new Pair<Boolean, String>(Boolean.FALSE,"Failure");

		}
	}

	public Pair<Boolean,List> GetRequestedConnection(String _user) {
		System.out.print(contractAddr);
		System.out.print(_user);

		ConsentManagementSystem contract = ConsentManagementSystem.load(contractAddr,
				web3j, credentials, GAS_PRICE, BigInteger.valueOf(4372188));
		try {
			List ReqConnections = contract.GetReqestedConnections(_user).sendAsync().get(1000,TimeUnit.SECONDS);;

			LOGGER.info("List: ",ReqConnections);
			ReqConnections.forEach((conn) -> {
				System.out.print(conn);
			});

			return new Pair<Boolean, List>(Boolean.TRUE,ReqConnections);
		}
		catch (Exception e) {
			LOGGER.error("Error during contract execution", e);
			return new Pair<Boolean, List>(Boolean.FALSE,new ArrayList<>());
		}
	}

	public Pair<Boolean,List> GetAcceptedConnection(String _user) {
		System.out.print(contractAddr);
		System.out.print(_user);

		ConsentManagementSystem contract = ConsentManagementSystem.load(contractAddr, web3j, credentials, GAS_PRICE, BigInteger.valueOf(4372188));
		try {
			List AcceptedConnections = contract.GetAcceptedConnections(_user).sendAsync().get(1000,TimeUnit.SECONDS);;

			LOGGER.info("List: ",AcceptedConnections);
			AcceptedConnections.forEach((conn) -> {
				System.out.print(conn);
			});
			return new Pair<Boolean, List>(Boolean.TRUE,AcceptedConnections);
		}
		catch (Exception e) {
			LOGGER.error("Error during contract execution", e);
			return new Pair<Boolean, List>(Boolean.FALSE,new ArrayList<>());
		}
	}

	public Pair<Boolean,Boolean> CheckValidRecords(String doctor, List<String> records) {
		System.out.print(contractAddr);

		ConsentManagementSystem contract = ConsentManagementSystem.load(contractAddr,
				web3j, credentials, GAS_PRICE, BigInteger.valueOf(4372188));
		try {
			Boolean ret = contract.ValidateRecordRequest(doctor, records).sendAsync().get(1000,TimeUnit.SECONDS);;

			LOGGER.info("Ret value: ",ret);
			return new Pair<Boolean,Boolean>(Boolean.TRUE,ret);
		}
		catch (Exception e) {
			LOGGER.error("Error during contract execution", e);
			return new Pair<Boolean,Boolean>(Boolean.FALSE,Boolean.FALSE);
		}
	}

}