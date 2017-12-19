package dao;

import entities.Session;

/**
 * Created by Shera on 19.12.2017.
 */
public class SessionDAOHibernate extends AbstractDAOHibernate<Session> implements SessionDAO {

    @Override
    public Class<Session> getEntityClass() {
        return Session.class;
    }

    @Override
    public String getEntityName() {
        return "Session";
    }

}
