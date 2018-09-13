package my.database.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by User on 10.09.2018.
 */

@Configuration
@EnableTransactionManagement
@ComponentScan("my.database")
@PropertySource(value = "classpath:property.properties")
public class DataBaseConfig {

    @Autowired
    Environment environment;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setCatalog(environment.getProperty("jdbc.catalog"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean localSession() {
        LocalSessionFactoryBean localession = new LocalSessionFactoryBean();
        localession.setPackagesToScan(environment.getProperty("hibernate.entity"));
        localession.setDataSource(dataSource());
        Properties prop = new Properties();
        prop.put("dialect", environment.getProperty("hibernate.dialect"));
        localession.setHibernateProperties(prop);
        return localession;
    }

    @Autowired
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory localSessionFactoryBean) {
        HibernateTransactionManager tx = new HibernateTransactionManager();
        tx.setSessionFactory(localSessionFactoryBean);
        return tx;
    }

}
