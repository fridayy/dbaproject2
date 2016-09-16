package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Nation;
import at.fhj.swd.DTO.Player;
import at.fhj.swd.DTO.Position;
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
public class PlayerDAOTest {
    private static final PersistenceService ps = new PersistenceService("dbjpa");
    private static EntityManager em = ps.getEntityManager();
    private static PlayerDAO dao;
    private static Player player;
    private static Nation nation;
    private static Position position;
    private static long id = 1;

    @BeforeClass
    public static void setUp() {
        dao = new PlayerDAOImpl(em);
        nation = new Nation(id, "Austria", "AUT");
        assertNotNull(dao);
    }

    @AfterClass
    public static void tearDown() {
        ps.txBegin();
        em.createQuery("DELETE FROM Nation").executeUpdate(); //TODO: better way to do this
        em.createQuery("DELETE FROM Position").executeUpdate(); //TODO: better way to do this
        ps.txCommit();
        ps.closeEntityManager();
    }

    @Before
    public void beforeSetup() {
        ps.txBegin();
        player = new Player(id, "test", "test", LocalDate.now(), 'm', "test", "test", "test", 1, 180, 70, nation);
        em.persist(player);
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
        player.setJerseynumber(66);
        dao.update(player);
        ps.txCommit();
        Player p = dao.findById(id);
        assertEquals(66, p.getJerseynumber());
    }

    @Test
    public void testDelete() {
        ps.txBegin();
        dao.delete(player);
        ps.txCommit();
        assertNull(dao.findById(id));
    }

    @Test
    public void testFindById() {
        Player p = dao.findById(id);
        assertEquals("test", p.getFirstname());
    }

    @Test
    public void testFindAll() {
        List<Player> allPlayers = dao.findAll();
        assertEquals(1, allPlayers.size());
        assertEquals(player, allPlayers.get(0));
    }

    @Test
    public void testPosition() {
        position = new Position(id, "Striker", "ST");
        ps.txBegin();
        player.addPosition(position);
        dao.update(player);
        ps.txCommit();

        Player p = dao.findById(id);
        assertEquals(p.getPositions().get(0), position);
    }
}
