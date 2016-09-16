package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Position;

import java.util.List;

/**
 * bnjm (1410418084) -  07.01.2016.
 */
public interface PositionDAO {
    Position insert(Position p);

    Position update(Position p);

    void delete(Position p);

    Position findById(long id);

    List findAll();

    Position createPosition(); //TODO: create factory

    void reset();
}
