package at.fhj.swd.DTO;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team extends IdEntity {
    private String name;
    private String abbreviation;

    @ManyToMany(mappedBy = "teams")
    private List<Player> players;

    @ManyToMany(mappedBy = "teams")
    private List<Coach> coaches;

    public Team() {
    }

    public Team(long id, String name, String abbreviation) {
        super(id);
        this.name = name;
        this.abbreviation = abbreviation;
        this.players = new ArrayList<>();
        this.coaches = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void addCoach(Coach c) {
        coaches.add(c);
        c.addTeam(this);
    }
}
