package company.dao;

import company.entities.Hall;
import company.entities.Movie;
import company.entities.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

/**
 * Created by Shera on 19.12.2017.
 */
public class DAOHibernateTest {


    @Autowired
    MovieDAO movieDAO;

    @Autowired
    SessionDAO sessionDAO;

    @Autowired
    HallDAO hallDAO;

    @org.junit.Test
    public void find() throws Exception {

        Movie movie = new Movie("Inception");
        Hall hall = new Hall("Black");
        Session session = new Session(LocalDateTime.now());

        movieDAO.add(movie);
        hallDAO.add(hall);
        sessionDAO.add(session);

        movie.addSession(session);
        hall.addSession(session);

        movieDAO.update(movie);
        hallDAO.update(hall);

    }

    @Autowired
    private EntityManager entityManager;

    @org.junit.Test
    public void findAll() throws Exception {

        entityManager.getTransaction().begin();
        entityManager.persist(new Movie("Помни2"));
        entityManager.getTransaction().commit();
        entityManager.close();



    }

    @org.junit.Test
    public void add() throws Exception {
    }

    @org.junit.Test
    public void update() throws Exception {
    }

    @org.junit.Test
    public void delete() throws Exception {
    }

}