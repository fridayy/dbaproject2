package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Player;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bnjm on 1/12/16.
 */
public class PlayerDAOImpl implements PlayerDAO {

    private final EntityManager em;

    public PlayerDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Player insert(Player p) {
        em.persist(p);
        return p;
    }

    @Override
    public Player update(Player p) {
        return em.merge(p);
    }

    @Override
    public void delete(Player p) {
        em.remove(p);
    }

    @Override
    public Player findById(long id) {
        return em.find(Player.class, id);
    }

    @Override
    public List findAll() {
        return em.createQuery("SELECT p FROM Player AS p").getResultList();
    }

    @Override
    public Player createPlayer() {
        return null;
    }

    @Override
    public void reset() {
        em.createQuery("DELETE FROM Player").executeUpdate();
    }
}
