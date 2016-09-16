package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Person;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * bnjm (1410418084) -  07.01.2016.
 */
public class PersonDAOImpl implements PersonDAO {
    private final EntityManager em;

    public PersonDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Person insert(Person p) {
        em.persist(p);
        return p;
    }

    @Override
    public Person update(Person p) {
        return em.merge(p);
    }

    @Override
    public void delete(Person p) {
        em.remove(p);
    }

    @Override
    public Person findById(long id) {
        return em.find(Person.class, id);
    }

    @Override
    public List findAll() {
        return em.createQuery("SELECT p FROM Person AS p").getResultList();
    }

    @Override
    public Person createPerson() {
        return null;
    }

    @Override
    public void reset() {
        em.createQuery("DELETE FROM Person").executeUpdate();
    }
}
