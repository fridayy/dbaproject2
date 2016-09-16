package at.fhj.swd.DTO;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player")
@PrimaryKeyJoinColumn(name = "person_id", referencedColumnName = "id")
public class Player extends Person {
    private int jerseynumber;
    private int height;
    private int weight;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "nation_id", referencedColumnName = "id")
    private Nation nation;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "player_position",
            joinColumns = @JoinColumn(name = "player_person_id", referencedColumnName = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id", referencedColumnName = "id"))
    private List<Position> positions;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "player_team",
            joinColumns = @JoinColumn(name = "player_person_id", referencedColumnName = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"))
    private List<Team> teams;

    protected Player() {
    }

    public Player(long id, String firstname, String lastname, LocalDate dateofbirth, char gender, String address, String email, String phonenumber, int jerseynumber, int height, int weight, Nation nation) {
        super(id, firstname, lastname, dateofbirth, gender, address, email, phonenumber);
        this.jerseynumber = jerseynumber;
        this.height = height;
        this.weight = weight;
        this.nation = nation;
        this.positions = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public int getJerseynumber() {
        return jerseynumber;
    }

    public void setJerseynumber(int jerseynumber) {
        this.jerseynumber = jerseynumber;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void addPosition(Position p) {
        positions.add(p);
    }

    public void addTeam(Team t) {
        teams.add(t);
    }
}
