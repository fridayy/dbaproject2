package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Operative;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * bnjm (1410418084) -  07.01.2016.
 */
public class OperativeDAOImpl implements OperativeDAO {
    private final EntityManager em;

    public OperativeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Operative insert(Operative o) {
        em.persist(o);
        return o;
    }

    @Override
    public Operative update(Operative o) {
        return em.merge(o);
    }

    @Override
    public void delete(Operative o) {
        em.remove(o);
    }

    @Override
    public Operative findById(long id) {
        return em.find(Operative.class, id);
    }

    @Override
    public List<Operative> findAll() {
        return em.createQuery("SELECT o FROM Operative AS o").getResultList();
    }

    @Override
    public Operative createOperative() {
        return null;
    }

    @Override
    public void reset() {
        em.createQuery("DELETE FROM Operative").executeUpdate();
    }
}
