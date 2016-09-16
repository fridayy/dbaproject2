package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Function;
import at.fhj.swd.DTO.Operative;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bnjm on 11/20/15.
 */
public class FunctionDAOImpl implements FunctionDAO {

    private final EntityManager em;

    public FunctionDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Function insert(Function f) {
        em.persist(f);
        return f;
    }

    @Override
    public Function update(Function f) {
        return em.merge(f);
    }

    @Override
    public void delete(Function f) {
        em.remove(f);
    }

    @Override
    public Function findById(long id) {
        return em.find(Function.class, id);
    }

    @Override
    public List<Function> findAll() {
        return em.createQuery("SELECT f FROM Function AS f").getResultList();
    }

    @Override
    public Function createFunction(Operative o, long id, String title) {
        Function f = new Function();
        f.setOperative(o);
        f.setId(id);
        f.setTitle(title);
        insert(f);
        return f;
    }

    @Override
    public void reset() {
        em.createQuery("DELETE FROM Function").executeUpdate();
    }
}
