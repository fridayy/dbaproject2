package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Team;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bnjm on 11/20/15.
 */
public class TeamDAOImpl implements TeamDAO {

    private final EntityManager em;

    public TeamDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Team insert(Team t) {
        em.persist(t);
        return t;
    }

    @Override
    public Team update(Team t) {
        return em.merge(t);
    }

    @Override
    public void delete(Team t) {
        em.remove(t);
    }

    @Override
    public Team findById(long id) {
        return em.find(Team.class, id);
    }

    @Override
    public List<Team> findAll() {
        return em.createQuery("SELECT t FROM Team as t").getResultList();
    }

    @Override
    public void reset() {
        em.createQuery("DELETE FROM Team").executeUpdate();
    }

    /*
        Factoy Method
     */
    @Override
    public Team createTeam(long id, String name, String abbreviation) {
        Team t = new Team();
        t.setId(id);
        t.setName(name);
        t.setAbbreviation(abbreviation);
        insert(t);
        return t;
    }
}
