package company.entities;

import company.Genre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Shera on 14.12.2017.
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)", length = 16)
    private UUID id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie", fetch = FetchType.EAGER)
    private Set<Session> sessions = new HashSet<>();

    public Movie(){}

    public Movie(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public UUID getId() {
        return id;
    }

    public void addSession(final Session session) {
        sessions.add(session);
        session.setMovie(this);
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString()
    {
        return name;
    }


}
