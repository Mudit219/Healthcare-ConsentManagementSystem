package com.springboot.ConsentManagement.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.ConsentManagement.ContractService.ContractService;

@Configuration
public class AppConfiguration {

    @Bean
    @Qualifier("contractServiceConfiguration")
    public ContractService contractServiceConfiguration(){
        return new ContractService();
    }
}