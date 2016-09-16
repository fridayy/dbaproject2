package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Person;
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
public class PersonDAOTest {
    private static final PersistenceService ps = new PersistenceService("dbjpa");
    private static EntityManager em = ps.getEntityManager();
    private static PersonDAO dao;
    private static Person person;
    private static long id = 1;
    private static final String EXPECTEDSTRING = "TEST";

    @BeforeClass
    public static void setUp() {
        dao = new PersonDAOImpl(em);
        assertNotNull(dao);
    }

    @AfterClass
    public static void tearDown() {
        ps.closeEntityManager();
    }

    @Before
    public void beforeSetup() {
        ps.txBegin();
        person = new Person(id, "test", "test", LocalDate.now(), 'w', "test", "test", "123");
        em.persist(person);
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
        person.setFirstname(EXPECTEDSTRING);
        ps.txBegin();
        dao.update(person);
        ps.txCommit();
        Person p = dao.findById(id);
        assertEquals(person, p);
        assertEquals(EXPECTEDSTRING, p.getFirstname());
    }

    @Test
    public void testDelete() {
        ps.txBegin();
        dao.delete(person);
        ps.txCommit();
        assertNull(dao.findById(id));
    }

    @Test
    public void testFindById() {
        Person p = dao.findById(id);
        assertNotNull(p);
        assertEquals(1, p.getId());
        assertEquals("test", p.getFirstname());
    }

    @Test
    public void testFindAll() {
        List<Person> allPersons = dao.findAll();
        assertNotNull(allPersons);
        assertEquals(1, allPersons.size());
        assertEquals(person, allPersons.get(0));
    }

}
