package at.fhj.swd.DTO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * bnjm (1410418084) -  14.01.2016.
 */
public class PersonTest {
    private static Person p;
    private static String EXPECTEDSTRING;
    private static LocalDate EXPECTEDDATE;

    @Before
    public void setUp() throws Exception {
        EXPECTEDSTRING = "TEST";
        EXPECTEDDATE = LocalDate.now();
        p = new Person(1L, EXPECTEDSTRING, EXPECTEDSTRING, EXPECTEDDATE, 'm',
                EXPECTEDSTRING, EXPECTEDSTRING, EXPECTEDSTRING);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetFirstname() throws Exception {
        assertEquals(EXPECTEDSTRING, p.getFirstname());
    }

    @Test
    public void testSetFirstname() throws Exception {
        EXPECTEDSTRING = "Test";
        p.setFirstname(EXPECTEDSTRING);
        assertEquals(EXPECTEDSTRING, p.getFirstname());
    }

    @Test
    public void testGetLastname() throws Exception {
        assertEquals(EXPECTEDSTRING, p.getLastname());
    }

    @Test
    public void testSetLastname() throws Exception {
        EXPECTEDSTRING = "Test";
        p.setLastname(EXPECTEDSTRING);
        assertEquals(EXPECTEDSTRING, p.getLastname());
    }

    @Test
    public void testGetDateofbirth() throws Exception {
        assertEquals(EXPECTEDDATE, p.getDateofbirth());
    }

    @Test
    public void testSetDateofbirth() throws Exception {
        EXPECTEDDATE = LocalDate.of(2014, 10, 4);
        p.setDateofbirth(EXPECTEDDATE);
        assertEquals(EXPECTEDDATE, p.getDateofbirth());
    }

    @Test
    public void testGetGender() throws Exception {
        char g = 'm';
        assertEquals(g, p.getGender());
    }

    @Test
    public void testSetGender() throws Exception {
        p.setGender('w');
        assertEquals('w', p.getGender());
    }

    @Test
    public void testGetAddress() throws Exception {
        assertEquals(EXPECTEDSTRING, p.getAddress());
    }

    @Test
    public void testSetAddress() throws Exception {
        EXPECTEDSTRING = "newadd";
        p.setAddress(EXPECTEDSTRING);
        assertEquals(EXPECTEDSTRING, p.getAddress());
    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals(EXPECTEDSTRING, p.getEmail());
    }

    @Test
    public void testSetEmail() throws Exception {
        EXPECTEDSTRING = "test@test.at";
        p.setEmail(EXPECTEDSTRING);
        assertEquals(EXPECTEDSTRING, p.getEmail());
    }

    @Test
    public void testGetPhonenumber() throws Exception {
        assertEquals(EXPECTEDSTRING, p.getPhonenumber());
    }

    @Test
    public void testSetPhonenumber() throws Exception {
        EXPECTEDSTRING = "12334534";
        p.setPhonenumber(EXPECTEDSTRING);
        assertEquals(EXPECTEDSTRING, p.getPhonenumber());
    }
}