package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Coach;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * bnjm (1410418084) -  07.01.2016.
 */
public class CoachDAOImpl implements CoachDAO {
    private final EntityManager em;

    public CoachDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Coach insert(Coach c) {
        em.persist(c);
        return c;
    }

    @Override
    public Coach update(Coach c) {
        return em.merge(c);
    }

    @Override
    public void delete(Coach c) {
        em.remove(c);
    }

    @Override
    public Coach findById(long id) {
        return em.find(Coach.class, id);
    }

    @Override
    public List findAll() {
        return em.createQuery("SELECT c FROM Coach AS c").getResultList();
    }

    @Override
    public Coach createCoach() {
        return null;
    }

    @Override
    public void reset() {
        em.createQuery("DELETE FROM Coach").executeUpdate();
    }
}
