package company.dao;

import java.util.List;
import java.util.UUID;

/**
 * Created by Shera on 19.12.2017.
 */
public interface DAO<T> {

    T find(UUID id);
    List<T> findAll();
    boolean add(T object);
    boolean update(T object);
    boolean delete(UUID id);
}
