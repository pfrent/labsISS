package Domain;

import java.io.Serializable;

public class Supervisor extends Person implements Serializable {
    public Supervisor(Integer id, String username, String pass, String realName) {
        super(id, username, pass, realName, "supervisor");
    }
}
