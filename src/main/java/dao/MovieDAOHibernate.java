package dao;

import entities.Movie;

/**
 * Created by Shera on 19.12.2017.
 */
public class MovieDAOHibernate extends AbstractDAOHibernate<Movie> implements MovieDAO {

    @Override
    public Class<Movie> getEntityClass() {
        return Movie.class;
    }

    @Override
    public String getEntityName() {
        return "Movie";
    }
}
