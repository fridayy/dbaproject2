package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Function;
import at.fhj.swd.DTO.Operative;
import at.fhj.swd.persistence.PersistenceService;
import org.junit.*;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static org.junit.Assert.assertNull;

/**
 * bnjm (1410418084) -  13.01.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FunctionDAOTest {
    private static final PersistenceService ps = new PersistenceService("dbjpa");
    private static EntityManager em = ps.getEntityManager();
    private static FunctionDAO dao;
    private static Function cfo;
    private static Operative op;
    private static long id = 1;

    @BeforeClass
    public static void setUp() {
        dao = new FunctionDAOImpl(em);
    }

    @AfterClass
    public static void tearDown() {
        ps.closeEntityManager();
    }

    @Before
    public void beforeSetup() {
        ps.txBegin();
        op = new Operative(id, "test", "test", LocalDate.now(), 'm', "testaddress", "test@test.at", "1234", "Office 1");
        cfo = new Function(op, id, "CFO");
        em.persist(op);
        em.persist(cfo);
        ps.txCommit();
    }

    @Test
    public void testDelete() {
        ps.txBegin();
        dao.delete(cfo);
        ps.txCommit();
        assertNull(dao.findById(id));
    }

//    @After
//    public static void afterSetup() {
//        ps.txBegin();
//        dao.reset();
//        ps.txCommit();
//    }
}
