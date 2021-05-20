package Domain;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    public Employee(Integer id, String username, String pass, String realName) {
        super(id, username, pass, realName, "employee");
    }
}
