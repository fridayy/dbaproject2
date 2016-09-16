package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Person;

import java.util.List;

/**
 * bnjm (1410418084) -  07.01.2016.
 */
public interface PersonDAO {
    Person insert(Person p);

    Person update(Person p);

    void delete(Person p);

    Person findById(long id);

    List findAll();

    Person createPerson(); //TODO: create factory

    void reset();
}
