package Repo;

import Domain.Employee;
import Domain.Person;
import Domain.Supervisor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class repoPerson implements iPerson{
    private JdbcUtils jdbc;

    public repoPerson(Properties props) {
        this.jdbc = new JdbcUtils(props);
    }


    @Override
    public Person findByUsername(String username) throws SQLException {
        Connection c = jdbc.getConnection();

        try(PreparedStatement ps = c.prepareStatement("select * from Persons where username=?")){
            ps.setString(1,username);
            try(ResultSet rs = ps.executeQuery()){
                Integer i = rs.getInt("id");
                String user = rs.getString("username");
                String pass = rs.getString("pass");
                String name = rs.getString("realName");
                String role = rs.getString("role");

                return new Person(i,user,pass,name,role);
            }
        }
        catch(SQLException ex){
            return null;
        }
    }

    @Override
    public Person save(Person e) {
        return null;
    }

    @Override
    public Person delete(Person e) {
        return null;
    }

    @Override
    public Person find_one(Integer id) {
        return null;
    }

    @Override
    public List<Person> find_all() throws SQLException {
        Connection c = jdbc.getConnection();
        List<Person> rez=new ArrayList<>();

        try(PreparedStatement ps = c.prepareStatement("select * from Persons where role=?")){
            ps.setString(1,"employee");
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    rez.add(new Person(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("pass"),
                            rs.getString("realName"),
                            rs.getString("role")
                    ));
                }
            }

        }
        return rez;
    }
}
