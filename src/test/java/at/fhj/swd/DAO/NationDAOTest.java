package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Nation;
import at.fhj.swd.persistence.PersistenceService;
import org.junit.*;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * bnjm (1410418084) -  19.11.2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NationDAOTest {
    private static final PersistenceService ps = new PersistenceService("dbjpa");
    private static EntityManager em = ps.getEntityManager();
    private static NationDAO dao;
    private static Nation austria;
    private static Nation germany;
    private static long id = 1;

    @BeforeClass
    public static void setUp() throws Exception {
        dao = new NationDAOImpl(em);
        assertNotNull(dao);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        ps.closeEntityManager();
    }

    @Before
    public void beforeSetUp() {
        ps.txBegin();
        austria = new Nation(id, "Austria", "AUT");
        em.persist(austria);
        ps.txCommit();
    }

    @After
    public void afterSetUp() {
        ps.txBegin();
        dao.reset();
        ps.txCommit();
    }


    @Test
    public void testUpdate() throws Exception {
        ps.txBegin();
        austria.setAlphacode("AUS");
        dao.update(austria);
        ps.txCommit();
        Nation n = dao.findById(id);
        assertEquals("AUS", n.getAlphacode());
    }

    @Test
    public void testDelete() throws Exception {
        ps.txBegin();
        dao.delete(austria);
        ps.txCommit();
        assertNull(dao.findById(id));
    }

    @Test
    public void testFindById() throws Exception {
        Nation n = dao.findById(id);
        assertEquals(1, n.getId());
        assertEquals("Austria", n.getName());
        assertEquals("AUT", n.getAlphacode());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Nation> allNations = dao.findAll();
        assertEquals(1, allNations.size());
        assertEquals(austria, allNations.get(0));
    }

    @Test
    public void testCreateNation() throws Exception {
        ps.txBegin();
        germany = dao.createNation(2L, "Germany", "GER");
        assertNotNull(germany);
        ps.txCommit();
    }
}