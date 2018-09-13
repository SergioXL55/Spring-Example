package my.database.implement;

import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 11.09.2018.
 */

public interface SqlTable {

    Session getSession();

    List<Object> getAll();

    Object getById();

    Object getByKey(String column, Object value);

    Boolean add(HashMap attr);
}
