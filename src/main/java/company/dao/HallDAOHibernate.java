package company.dao;

import company.entities.Hall;

/**
 * Created by Shera on 19.12.2017.
 */
public class HallDAOHibernate extends AbstractDAOHibernate<Hall> implements HallDAO {

    @Override
    public Class<Hall> getEntityClass() {
        return Hall.class;
    }

    @Override
    public String getEntityName() {
        return "Hall";
    }
}

