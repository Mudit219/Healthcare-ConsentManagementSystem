package com.springboot.ConsentManagement;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.web3j.protocol.Web3j;

import com.springboot.ConsentManagement.ContractService.ContractService;
import org.web3j.protocol.http.HttpService;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class ConsentManagementApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsentManagementApplication.class);

	@Value("${ClientAddr:''}")
	private String clientAddress;

	Web3j web3j;
    public static void main(String[] args) {
		SpringApplication.run(ConsentManagementApplication.class, args);
	}
    
    @PostConstruct
    public void listen() {
		LOGGER.info("Client Address: {}", clientAddress);
		this.web3j = Web3j.build(new HttpService(clientAddress));

		web3j.transactionFlowable().subscribe(tx -> {
    		if (tx.getTo() != null && tx.getTo().equals("")) {
//    			service.getOwnerAccount()
    			LOGGER.info("New tx: id={}, block={}, from={}, to={}, value={}", tx.getHash(), tx.getBlockHash(), tx.getFrom(), tx.getTo(), tx.getValue().intValue());
//    			service.processContracts(tx.getValue().longValue());
    		} else {
    			LOGGER.info("Not matched: id={}, to={}", tx.getHash(), tx.getTo());
    		}
    	});
    }
}
