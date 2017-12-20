package company.dao;


import company.Genre;
import company.Recommendation;
import company.entities.Hall;
import company.entities.Movie;
import company.web.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Shera on 19.12.2017.
 */
@Controller
@ContextConfiguration(classes = AppConfig.class)
public class MyController {

    @Autowired
    HallDAO hallDAO;

    @Autowired
    MovieDAO movieDAO;


    @GetMapping("/recommendations")
    public String showRecommendations(Model m) {
        Recommendation recommendation = new Recommendation();
        Set<Movie> movies = recommendation.getRecommendation(Genre.COMEDY);
        m.addAttribute("RecommendedMovies", movies);
        return "movies_table";
    }

    @GetMapping("/showMovies")
    public String showMovies(Model m) {

        List<Movie> movies = movieDAO.findAll();
        m.addAttribute("movies", movies);
        return "movies_table";
    }

    @GetMapping("/showHalls")
    public String showHalls(Model m) {

        List<Hall> halls = hallDAO.findAll();
        m.addAttribute("halls", halls);
        return "halls_table";
    }
}

