package Domain;

import java.io.Serializable;

public class Person implements Serializable {
    private Integer id;
    private String username;
    private String pass;
    private String realName;
    private String role;

    public Person(Integer id, String username, String pass, String realName, String role) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.realName = realName;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getRealName() {
        return realName;
    }

    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
