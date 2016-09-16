package at.fhj.swd.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * bnjm (1410418084) -  19.11.2015.
 */
public class PersistenceService {
    private String unitName;
    private EntityManager em;

    public PersistenceService(String unitName) {
        setUnitName(unitName);
    }


    public void setUnitName(String unitName) {
        if (unitName == null)
            throw new IllegalArgumentException();
        this.unitName = unitName;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        if (unitName == null)
            throw new IllegalStateException();
        return Persistence.createEntityManagerFactory(unitName);
    }

    public EntityManager getEntityManager() {
        if (em == null)
            em = getEntityManagerFactory().createEntityManager();
        return em;
    }

    public void closeEntityManager() {
        if (em != null)
            em.close();
    }

    public void txBegin() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
    }

    public void txCommit() {
        EntityTransaction tx = em.getTransaction();
        if (tx.getRollbackOnly()) {
            tx.rollback();
        } else {
            tx.commit();
        }
    }

    public void txRollback() {
        EntityTransaction tx = em.getTransaction();
        tx.rollback();
    }
}
