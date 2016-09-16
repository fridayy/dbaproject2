package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Coach;

import java.util.List;

/**
 * bnjm (1410418084) -  07.01.2016.
 */
public interface CoachDAO {
    Coach insert(Coach c);

    Coach update(Coach c);

    void delete(Coach c);

    Coach findById(long id);

    List findAll();

    Coach createCoach(); //TODO: create a Factory

    void reset();
}
