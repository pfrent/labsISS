package Service;

import Domain.Person;
import Domain.Task;

import java.util.List;

public interface iService {
    public int login(Person p);
    public void addObserver(String role,Observer obs);
    public List<Task> visualizeTasks(int id);
    public Person findByUsername(String username);
    public void saveTask(Task t);
    public List<Person> findAllEmployees();

}
