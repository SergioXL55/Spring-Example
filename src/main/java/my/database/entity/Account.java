package my.database.entity;

import javax.persistence.*;

/**
 * Created by User on 10.09.2018.
 */
@Entity
@Table(name = "account")
public class Account {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "login")
    public String login;

    @Column(name = "password")
    public String pass;

    @Column(name = "role")
    public int role;

    @Column(name = "enabled")
    private Boolean enabled;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", role=" + role +
                ", enabled=" + enabled +
                '}';
    }



}
