package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Position;
import at.fhj.swd.DTO.Team;
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
public class TeamDAOTest {
    private static final PersistenceService ps = new PersistenceService("dbjpa");
    private static EntityManager em = ps.getEntityManager();
    private static TeamDAO dao;
    private static Team team;
    private static long id = 1;

    @BeforeClass
    public static void setUp() {
        dao = new TeamDAOImpl(em);
        assertNotNull(dao);
    }

    @AfterClass
    public static void tearDown() {
        ps.closeEntityManager();
    }

    @Before
    public void beforeSetup() {
        ps.txBegin();
        team = new Team(id, "First Team", "S1");
        em.persist(team);
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
        team.setAbbreviation("S2");
        ps.txBegin();
        dao.update(team);
        ps.txCommit();
        Team t = dao.findById(id);
        assertEquals("S2", t.getAbbreviation());
    }

    @Test
    public void testDelete() {
        ps.txBegin();
        dao.delete(team);
        ps.txCommit();
        assertNull(dao.findById(id));
    }

    @Test
    public void testFindById() {
        Team t = dao.findById(id);
        assertNotNull(t);
        assertEquals(id, t.getId());
        assertEquals("S1", t.getAbbreviation());

    }

    @Test
    public void testFindAll() {
        List<Team> allTeams = dao.findAll();
        assertNotNull(allTeams);
        assertEquals(1, allTeams.size());
        assertEquals(team, allTeams.get(0));
    }

}
