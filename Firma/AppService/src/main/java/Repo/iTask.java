package Repo;

import Domain.Task;

import java.sql.SQLException;
import java.util.List;

public interface iTask extends iRepo<Task>{
        public List<Task> findOnesTasks(Integer id) throws SQLException;

}
