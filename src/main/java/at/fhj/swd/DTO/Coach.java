package at.fhj.swd.DTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coach")
@PrimaryKeyJoinColumn(name = "person_id", referencedColumnName = "id")
public class Coach extends Person {
    private String role;

    @ManyToMany
    @JoinTable(
            name = "coach_team",
            joinColumns = @JoinColumn(name = "coach_person_id", referencedColumnName = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"))
    private List<Team> teams;

    protected Coach() {
    }

    public Coach(long id, String firstname, String lastname, LocalDate dateofbirth, char gender, String address, String email, String phonenumber, String role) {
        super(id, firstname, lastname, dateofbirth, gender, address, email, phonenumber);
        this.role = role;
        this.teams = new ArrayList<>();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team t) {
        teams.add(t);
    }
}
