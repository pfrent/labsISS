package Repo;

import Domain.Employee;
import Domain.Person;

import java.sql.SQLException;

public interface iPerson extends iRepo<Person> {
    public Person findByUsername(String username) throws SQLException;
}
