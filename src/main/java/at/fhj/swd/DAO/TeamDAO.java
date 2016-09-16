package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Team;

import java.util.List;

/**
 * Created by bnjm on 11/20/15.
 */
public interface TeamDAO {
    Team insert(Team t);

    Team update(Team t);

    void delete(Team t);

    Team findById(long id);

    List<Team> findAll();

    Team createTeam(long id, String name, String abbreviation);

    void reset();
}
