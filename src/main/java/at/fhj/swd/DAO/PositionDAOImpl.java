package at.fhj.swd.DAO;


import at.fhj.swd.DTO.Position;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * bnjm (1410418084) -  07.01.2016.
 */
public class PositionDAOImpl implements PositionDAO {
    private final EntityManager em;

    public PositionDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Position insert(Position p) {
        em.persist(p);
        return p;
    }

    @Override
    public Position update(Position p) {
        return em.merge(p);
    }

    @Override
    public void delete(Position p) {
        em.remove(p);
    }

    @Override
    public Position findById(long id) {
        return em.find(Position.class, id);
    }

    @Override
    public List findAll() {
        return em.createQuery("SELECT p FROM Position AS p").getResultList();
    }

    @Override
    public Position createPosition() {
        return null;
    }

    @Override
    public void reset() {
        em.createQuery("DELETE FROM Position").executeUpdate();
    }
}
