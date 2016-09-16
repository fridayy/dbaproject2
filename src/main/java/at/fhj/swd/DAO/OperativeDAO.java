package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Operative;

import java.util.List;

/**
 * Created by bnjm on 11/20/15.
 */
public interface OperativeDAO {

    Operative insert(Operative o);

    Operative update(Operative o);

    void delete(Operative o);

    Operative findById(long id);

    List<Operative> findAll();

    Operative createOperative(); //TODO: consider a factory for Persons

    void reset();
}
