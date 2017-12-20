package company.entities;

import company.entities.Hall;
import company.entities.Movie;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Shera on 19.12.2017.
 */
@Entity
public class Session {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)", length = 16)
    private UUID id;

    private LocalDateTime sessionStart;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Hall hall;

    public Session(LocalDateTime sessionStart) {
        this.sessionStart = sessionStart;
}

    public Session() {
    }

    public LocalDateTime getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(LocalDateTime sessionStart) {
        this.sessionStart = sessionStart;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
