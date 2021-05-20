import Domain.Person;
import Domain.Task;
import Repo.iPerson;
import Repo.iTask;
import Service.Observer;
import Service.iService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServerImp implements iService {

    private iTask rt;
    private iPerson rp;
    private Map<String, Observer> loggedClients = new ConcurrentHashMap<>();

    public ServerImp(iTask rt, iPerson rp) {
        this.rt = rt;
        this.rp = rp;
    }


    @Override
    public int login(Person p) {

        try {
            Person subject = rp.findByUsername(p.getUsername());
            if (subject != null) {
                if(subject.getRole().equals("employee")){
                    return 1;
                }
                else return 2;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        return 0;
    }

    @Override
    public void addObserver(String role, Observer obs) {
        loggedClients.put(role,obs);
    }

    @Override
    public List<Task> visualizeTasks(int id) {
        try{
        return rt.findOnesTasks(id);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Person findByUsername(String username) {

        try {
            return rp.findByUsername(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveTask(Task t) {
        try {
            rt.save(t);
            System.out.println("saved");
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Person> findAllEmployees() {

        try {
            return rp.find_all();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
