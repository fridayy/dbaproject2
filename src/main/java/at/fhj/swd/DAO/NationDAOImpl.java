package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Nation;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * bnjm (1410418084) -  19.11.2015.
 */
public class NationDAOImpl implements NationDAO {

    private final EntityManager em;

    public NationDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Nation insert(Nation n) {
        em.persist(n);
        return n;
    }

    @Override
    public Nation update(Nation n) {
        return em.merge(n);
    }

    @Override
    public void delete(Nation n) {
        em.remove(n);
    }

    @Override
    public Nation findById(long id) {
        return em.find(Nation.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Nation> findAll() {
        return em.createQuery("SELECT n FROM Nation AS n").getResultList();
    }

    @Override
    public Nation createNation(long id, String name, String alphacode) {
        Nation n = new Nation();
        n.setId(id);
        n.setName(name);
        n.setAlphacode(alphacode);
        insert(n);
        return n;
    }

    @Override
    public void reset() {
        em.createQuery("DELETE FROM Nation").executeUpdate();
    }
}
