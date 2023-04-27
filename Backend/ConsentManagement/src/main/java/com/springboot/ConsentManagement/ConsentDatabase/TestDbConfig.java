//package com.springboot.ConsentManagement.DatabaseConfiguration;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "testEntityManagerFactory",
//        transactionManagerRef = "testTransactionManager",
//        basePackages = {"com.springboot.ConsentManagement.TestingDao"}
//)
//public class TestDbConfig {
//
//    @Bean(name = "testDataSource")
//    @ConfigurationProperties(prefix = "spring.second-data-source")
//    public DataSource testDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "testEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean createPrimaryEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("testDataSource") DataSource dataSource){
//        return builder.dataSource(dataSource).packages("com.springboot.ConsentManagement.testing").build();
//    }
//
//    @Bean("testTransactionManager")
//    public PlatformTransactionManager createPrimaryTransactionManager(@Qualifier("testEntityManagerFactory") EntityManagerFactory entityManagerFactory){
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}
