package Repo;

import java.sql.SQLException;
import java.util.List;

public interface iRepo<T> {

    public T save(T e) throws SQLException;
    public T delete(T e);
    public T find_one(Integer id);
    public List<T> find_all() throws SQLException;

}
