package Repo;

import Domain.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class repoTask implements iTask {
    private JdbcUtils jdbc;

    public repoTask(Properties props) {
        this.jdbc = new JdbcUtils(props);
    }

    @Override
    public Task save(Task e) throws SQLException {
        Connection c = jdbc.getConnection();
        try(PreparedStatement ps =  c.prepareStatement("insert into Tasks(employeeId,descriere,dificultate,durata) values(?,?,?,?)")){
            ps.setInt(1,e.getEmployeeId());
            ps.setString(2,e.getDescription());
            ps.setInt(3,e.getRating());
            ps.setInt(4,e.getDuration());
            ps.execute();
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return e;
    }

    @Override
    public Task delete(Task e) {
        return null;
    }

    @Override
    public Task find_one(Integer id) {
        return null;
    }

    @Override
    public List<Task> find_all() {
        return null;
    }

    @Override
    public List<Task> findOnesTasks(Integer id) throws SQLException {
        Connection c = jdbc.getConnection();
        List<Task> rez = new ArrayList<>();
        try(PreparedStatement ps = c.prepareStatement("select * from Tasks where employeeId=?")){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    rez.add(new Task(
                            rs.getInt("id"),
                            rs.getInt("employeeId"),
                            rs.getString("descriere"),
                            rs.getInt("dificultate"),
                            rs.getInt("durata")
                    ));
                }
            }
        }
        return rez;
    }
}
