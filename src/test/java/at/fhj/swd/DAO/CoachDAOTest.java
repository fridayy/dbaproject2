package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Coach;
import at.fhj.swd.persistence.PersistenceService;
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
public class CoachDAOTest {
    private static final PersistenceService ps = new PersistenceService("dbjpa");
    private static EntityManager em = ps.getEntityManager();
    private static CoachDAO dao;
    private static Coach c;
    private static long id = 1;

    @BeforeClass
    public static void setUp() {
        dao = new CoachDAOImpl(em);
        assertNotNull(dao);
    }

    @AfterClass
    public static void tearDown() {
        ps.closeEntityManager();
    }

    @Before
    public void beforeSetup() {
        ps.txBegin();
        c = new Coach(id, "test", "test", LocalDate.now(), 'm', "test", "email", "123", "HeadCoach");
        em.persist(c);
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
        c.setRole("Assistant");
        dao.update(c);
        ps.txCommit();
        Coach carter = dao.findById(id);
        assertEquals("Assistant", carter.getRole());
    }

    @Test
    public void testDelete() {
        ps.txBegin();
        dao.delete(c);
        ps.txCommit();
        assertNull(dao.findById(id));
    }

    @Test
    public void testFindById() {
        Coach carter = dao.findById(id);
        assertEquals(c, carter);
        assertEquals(1, carter.getId());
    }

    @Test
    public void testFindAll() {
        List<Coach> allCoaches = dao.findAll();
        assertEquals(1, allCoaches.size());
        assertEquals(c, allCoaches.get(0));
    }
}
