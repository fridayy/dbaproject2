package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Position;
import at.fhj.swd.persistence.PersistenceService;
import org.junit.*;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * bnjm (1410418084) -  13.01.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PositionDAOTest {
    private static final PersistenceService ps = new PersistenceService("dbjpa");
    private static EntityManager em = ps.getEntityManager();
    private static PositionDAO dao;
    private static Position position;
    private static long id = 1;

    @BeforeClass
    public static void setUp() {
        dao = new PositionDAOImpl(em);
        assertNotNull(dao);
    }

    @AfterClass
    public static void tearDown() {
        ps.closeEntityManager();
    }

    @Before
    public void beforeSetup() {
        ps.txBegin();
        position = new Position(id, "Striker", "ST");
        em.persist(position);
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
        position.setAbbreviation("STR");
        dao.update(position);
        ps.txCommit();
        Position np = dao.findById(id);
        assertEquals("STR", np.getAbbreviation());
    }

    @Test
    public void testDelete() {
        ps.txBegin();
        dao.delete(position);
        ps.txCommit();
        Position p = dao.findById(id);
        assertNull(p);
    }

    @Test
    public void testFindById() {
        Position p = dao.findById(id);
        assertEquals(p, position);
    }

    @Test
    public void testFindAll() {
        List<Position> allPositions = dao.findAll();
        assertEquals(1, allPositions.size());
        assertEquals(position, allPositions.get(0));
    }

}
