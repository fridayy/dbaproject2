package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Nation;

import java.util.List;

/**
 * bnjm (1410418084) -  19.11.2015.
 */
public interface NationDAO {
    Nation insert(Nation n);

    Nation update(Nation n);

    void delete(Nation n);

    Nation findById(long id);

    List<Nation> findAll();

    Nation createNation(long id, String name, String alphacode);

    void reset();
}
