package company;

import company.dao.MovieDAO;
import company.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shera on 20.12.2017.
 */
public class Recommendation {

    @Autowired
    MovieDAO movieDAO;

    public Set<Movie> getRecommendation(final Genre genre)
    {
        Set<Movie> recommendedMovies = new HashSet<>();
       switch (genre)
       {
           case SCIFI:
               recommendedMovies = getSpecificMovie(genre);
               break;
           case COMEDY:
               recommendedMovies = new HashSet<Movie>();
               recommendedMovies.add(new Movie("movie0",Genre.COMEDY));
               recommendedMovies.add(new Movie("movie1",Genre.COMEDY));
               recommendedMovies.add(new Movie("movie2",Genre.COMEDY));
               break;
           case FANTASY:
               recommendedMovies = getSpecificMovie(genre);
           case HISTORY:
               recommendedMovies = getSpecificMovie(genre);
               break;
           case DETECTIVE:
               recommendedMovies = loadFromFile("file.txt");
           break;
       }
       return recommendedMovies;
    }

    public Set<Movie> getSpecificMovie(Genre genre)
    {
        Set<Movie> selectedMovies = new HashSet<>();
        for (Movie movie:
             movieDAO.findAll()) {
            if(movie.getGenre().equals(genre))
                selectedMovies.add(movie);
        }
        return selectedMovies;
    }

    public Set<Movie> loadFromFile(String fileName)
    {
        Set<Movie> selectedMovies = new HashSet<>();
        selectedMovies.add(new Movie("fromFile",Genre.DETECTIVE));
        return selectedMovies;
    }

}
