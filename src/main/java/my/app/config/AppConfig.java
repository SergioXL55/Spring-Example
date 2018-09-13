package my.app.config;

import my.database.implement.AccountTable;
import my.database.implement.RoleTable;
import my.database.service.AccountService;
import my.database.service.RoleService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 11.09.2018.
 */
@Configuration
@ComponentScan("my")
public class AppConfig {

    @Autowired
    @Bean
    public AccountTable account(SessionFactory sessionFactory) {
        return new AccountService(sessionFactory);
    }

    @Autowired
    @Bean
    public RoleTable role(SessionFactory sessionFactory) {
        return new RoleService(sessionFactory);
    }

}
