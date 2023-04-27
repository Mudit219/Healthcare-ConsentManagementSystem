package com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryDbConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef = "KaveryEntityManagerFactory",
        transactionManagerRef = "KaveryTransactionManager",
        basePackages = {"com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryRepositoryAPI"}
)
public class KaveryDbConfig {

    @Autowired
    private Environment env;

    @Bean(name = "KaveryDataSource")
    public DataSource createDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("kavery.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("kavery.datasource.jdbc-url"));
        dataSource.setPassword(env.getProperty("kavery.datasource.password"));
        dataSource.setUsername(env.getProperty("kavery.datasource.username"));

        return dataSource;
    }

    @Bean(name = "KaveryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean createEntityManagerFactory(){

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(createDataSource());
        emf.setPackagesToScan("com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryEntity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        HashMap<String,String> hbConfig = new HashMap<>();
        hbConfig.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
        hbConfig.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
        hbConfig.put("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
        emf.setJpaPropertyMap(hbConfig);
        return emf;
    }

    @Bean("KaveryTransactionManager")
    public PlatformTransactionManager createPrimaryTransactionManager(){
        return new JpaTransactionManager(createEntityManagerFactory().getObject());
    }
}
