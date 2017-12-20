package company.dao;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.UUID;

/**
 * Created by Shera on 19.12.2017.
 */
@Component
public abstract class AbstractDAOHibernate<T> implements DAO<T> {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public T find(UUID id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        List<T> elementsList = entityManager.createQuery("from " + getEntityName(),
                getEntityClass()).getResultList();
        return elementsList;
    }

    @Override
    public boolean add(T object) {
        entityManager.persist(object);
        return true;
    }

    @Override
    public boolean update(T object) {
        entityManager.merge(object);
        return true;
    }

    @Override
    public boolean delete(UUID id) {
        boolean result = false;
        T object = entityManager.find(getEntityClass(), id);
        if (object != null) {
            result = true;
            entityManager.remove(object);
        }
        return result;
    }

    public abstract String getEntityName();

    public abstract Class<T> getEntityClass();

}
