package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Operative;
import at.fhj.swd.persistence.PersistenceService;
import org.eclipse.persistence.internal.libraries.asm.commons.Method;
import org.junit.*;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * bnjm (1410418084) -  13.01.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OperativeDAOTest {
    private static final PersistenceService ps = new PersistenceService("dbjpa");
    private static EntityManager em = ps.getEntityManager();
    private static OperativeDAO dao;
    private static Operative op;
    private static long id = 1;

    @BeforeClass
    public static void setUp() {
        dao = new OperativeDAOImpl(em);
        assertNotNull(dao);
    }

    @AfterClass
    public static void tearDown() {
        ps.closeEntityManager();
    }

    @Before
    public void beforeSetup() {
        ps.txBegin();
        op = new Operative(id, "test", "test", LocalDate.now(), 'm', "test", "test", "test", "Office 1");
        em.persist(op);
        ps.txCommit();
    }

    @After
    public void afterSetup() {
        ps.txBegin();
        dao.reset();
        ps.txCommit();
    }

    @Test
    public void testUpdate() {
        ps.txBegin();
        op.setOffice("Office 1023");
        dao.update(op);
        ps.txCommit();
        Operative o = dao.findById(id);
        assertEquals("Office 1023", o.getOffice());
    }

    @Test
    public void testDelete() {
        ps.txBegin();
        dao.delete(op);
        ps.txCommit();
        assertNull(dao.findById(id));
    }

    @Test
    public void testFindById() {
        Operative o = dao.findById(id);
        assertNotNull(o);
        assertEquals(id, o.getId());
        assertEquals("Office 1", o.getOffice());
    }

    @Test
    public void testFindAll() {
        List<Operative> allOperatives = dao.findAll();
        assertEquals(1, allOperatives.size());
        assertEquals(op, allOperatives.get(0));
    }
}
