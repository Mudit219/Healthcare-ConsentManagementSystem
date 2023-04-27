package com.springboot.ConsentManagement.ConsentDatabase.ConsentDbConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager",
        basePackages = {"com.springboot.ConsentManagement.ConsentDatabase.ConsentDao"}
)
public class PrimaryDbConfig {

    @Autowired
    private Environment env;

    @Bean(name = "primaryDataSource")
    @Primary
    public DataSource createDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.jdbc-url"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        return dataSource;
    }

    @Bean(name = "primaryEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean createEntityManagerFactory(){

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(createDataSource());
        emf.setPackagesToScan("com.springboot.ConsentManagement.ConsentDatabase.ConsentTable");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        HashMap<String,String> hbConfig = new HashMap<>();
        hbConfig.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
        hbConfig.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
        hbConfig.put("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
        emf.setJpaPropertyMap(hbConfig);
        return emf;
    }

    @Bean("primaryTransactionManager")
    public PlatformTransactionManager createPrimaryTransactionManager(){
        return new JpaTransactionManager(createEntityManagerFactory().getObject());
    }

}
