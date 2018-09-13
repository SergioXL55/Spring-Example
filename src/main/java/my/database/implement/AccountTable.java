package my.database.implement;

import java.util.HashMap;

/**
 * Created by User on 13.09.2018.
 */
public interface AccountTable extends SqlTable {

    int DEFAULT_ROLE_NUM = 2;//==USER

    String AUTH_CODE_LENGHT = "Минимальная длина логина или пароля не менее 4 символов";
    String AUTH_CODE_FREE_LOGIN = "Имя пользоателя уже занято";
    String AUTH_CODE_OK = "Регистрация прошла успешно";
    String AUTH_CODE_FALSE = "Одно из полей не заполнено";

    byte STATUS_OK = 1;
    byte STATUS_FALSE = 0;

    boolean checkFreeLogin(String login);

    HashMap createAccount(String login, String password);

}
