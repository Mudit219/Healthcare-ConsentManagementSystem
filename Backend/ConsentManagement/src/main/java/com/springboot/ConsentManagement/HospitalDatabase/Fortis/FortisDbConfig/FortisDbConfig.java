package com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisDbConfig;

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

@Configuration("FortisDbConfig")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "FortisEntityManagerFactory",
        transactionManagerRef = "FortisTransactionManager",
        basePackages = {"com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisRepositoryAPI"}
)
public class FortisDbConfig {

    @Autowired
    private Environment env;

    @Bean(name = "FortisDataSource")
    public DataSource createDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("fortis.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("fortis.datasource.jdbc-url"));
        dataSource.setPassword(env.getProperty("fortis.datasource.password"));
        dataSource.setUsername(env.getProperty("fortis.datasource.username"));

        return dataSource;
    }

    @Bean(name = "FortisEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean createEntityManagerFactory(){

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(createDataSource());
        emf.setPackagesToScan("com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisEntity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        HashMap<String,String> hbConfig = new HashMap<>();
        hbConfig.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
        hbConfig.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
        hbConfig.put("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
        emf.setJpaPropertyMap(hbConfig);
        return emf;
    }

    @Bean("FortisTransactionManager")
    public PlatformTransactionManager createPrimaryTransactionManager(){
        return new JpaTransactionManager(createEntityManagerFactory().getObject());
    }
}
