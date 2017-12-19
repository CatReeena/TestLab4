package dao;


import entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Arrays;
import java.util.List;

/**
 * Created by Shera on 19.12.2017.
 */
@Controller
@ContextConfiguration(classes = AppConfig.class)
public class MyController {

    @Autowired
    MovieDAO movieDAO;

    @GetMapping("/test")
    public String index(Model m) {

        List<String> supplierNames = Arrays.asList("sup1", "sup2", "sup3");
        MovieDAOHibernate movieDAOHibernate = new MovieDAOHibernate();
        movieDAOHibernate.add(new Movie("Inc"));

        m.addAttribute("supplierNames", supplierNames);
        return "welcome";
    }

    @GetMapping("/testInjection")
    public String testInjection(Model m) {

        Movie movie = new Movie("Inception");
        List<Movie> movies = movieDAO.findAll();
        m.addAttribute("movies", movies);
        return "welcome";
    }
}

