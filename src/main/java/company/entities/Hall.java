package company.entities;

    import javax.persistence.*;
    import java.util.HashSet;
    import java.util.Set;
    import java.util.UUID;

/**
 * Created by Shera on 14.12.2017.
 */
@Entity
public class Hall {

    @SuppressWarnings("checkstyle:MagicNumber")
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)", length = 16)
    private UUID id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hall")
    private Set<Session> sessions = new HashSet<>();

    public Hall(){}

    public Hall(String name){this.name = name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Session> getSessions() {return sessions;}

    public void addSession(final Session session) {
        sessions.add(session);
        session.setHall(this);
    }

    @Override
    public String toString()
    {
        return name;
    }
}
