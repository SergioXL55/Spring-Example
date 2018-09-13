package my.database.service;

import my.database.implement.RoleTable;
import my.database.implement.SqlTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 11.09.2018.
 */
@Service
@Transactional
public class RoleService implements RoleTable {

    private SessionFactory sessionFactory;

    @Autowired
    public RoleService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session getSession() {
        return null;
    }

    @Override
    public List<Object> getAll() {
       Session session=sessionFactory.getCurrentSession();
       Query query= session.createQuery("FROM Role");
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

}
