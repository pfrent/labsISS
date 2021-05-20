package Service;

import java.rmi.Remote;

public interface Observer extends Remote {
    public void refresh() throws Exception;
}
