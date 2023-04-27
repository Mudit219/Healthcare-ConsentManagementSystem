//package com.springboot.ConsentManagement.DatabaseConfiguration.HospitalDbConfig;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
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
//        entityManagerFactoryRef = "SacredOakEntityManagerFactory",
//        transactionManagerRef = "SacredOakTransactionManager",
//        basePackages = {"com.springboot.ConsentManagement.HospitalEHRRepository.SacredOak"}
//)
//public class SacredOakDbConfig {
//
//    @Bean(name = "SacredOakDataSource")
//    @ConfigurationProperties(prefix = "sacredoak.data-source")
//    public DataSource createDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "SacredOakEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean createEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("SacredOakDataSource") DataSource dataSource){
//        return builder.dataSource(dataSource).packages("com.springboot.ConsentManagement.HospitalEHREntity").build();
//    }
//
//    @Bean("SacredOakTransactionManager")
//    public PlatformTransactionManager createTransactionManager(@Qualifier("SacredOakEntityManagerFactory") EntityManagerFactory entityManagerFactory){
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}
