package at.fhj.swd.DTO;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
public class Position extends IdEntity {
    private String name;
    private String abbreviation;

    @ManyToMany(mappedBy = "positions")
    private List<Player> players;


    protected Position() {
    }

    public Position(long id, String name, String abbreviation) {
        super(id);
        this.name = name;
        this.abbreviation = abbreviation;
        this.players = new ArrayList<>();
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

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
