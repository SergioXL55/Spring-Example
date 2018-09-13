package my.database.service;

import my.database.entity.Account;
import my.database.implement.AccountTable;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 10.09.2018.
 */
@Service
@Transactional
public class AccountService implements AccountTable {

    private SessionFactory sessionFactory;
    private final static Logger LOG = Logger.getLogger(AccountService.class);

    @Autowired
    public AccountService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Object> getAll() {
        Query query = getSession().createQuery("from Account");
        return query.list();
    }

    @Override
    public Object getById() {
        return null;
    }

    @Override
    public Object getByKey(String column, Object value) {
        return null;
    }

    @Override
    public Boolean add(HashMap attr) {
        return true;
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean checkFreeLogin(String login) {
        String sql = "from Account where login=:name";
        Query query = getSession().createQuery(sql).setParameter("name", login);
        return query.list().isEmpty();
    }

    @Override
    public HashMap createAccount(String login, String password) {
        byte status = STATUS_FALSE;
        String message = AUTH_CODE_FALSE;
        HashMap result = new HashMap();
        try {
            if (login.length() >= 4 & password.length() >= 4) {
                if (checkFreeLogin(login)) {
                    Account account = new Account();
                    account.setLogin(login);
                    account.setEnabled(true);
                    account.setPass(new BCryptPasswordEncoder().encode(password));
                    account.setRole(DEFAULT_ROLE_NUM);
                    getSession().save(account);
                    message = AUTH_CODE_OK;
                    status = STATUS_OK;
                } else message = AUTH_CODE_FREE_LOGIN;
            } else message = AUTH_CODE_LENGHT;
        } catch (Exception e) {
            LOG.error(e);
        }
        result.put("status", status);
        result.put("mess", message);
        return result;
    }
}
