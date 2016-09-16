package at.fhj.swd.DTO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * bnjm (1410418084) -  20.11.2015.
 */
public class NationTest {

    final static String name = "Austria";
    final static String alphacode = "AUT";
    static Nation nation;

    @Before
    public void setUp() throws Exception {

        nation = new Nation(1, name, alphacode);
        assertNotNull(nation);
    }

    @After
    public void tearDown() throws Exception {
        nation = null;
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(name, nation.getName());
    }

    @Test
    public void testSetName() throws Exception {
        final String EXPECTED = "Germany";
        nation.setName(EXPECTED);
        assertEquals(EXPECTED, nation.getName());
    }

    @Test
    public void testGetAlphacode() throws Exception {
        assertEquals("AUT", nation.getAlphacode());
    }

    @Test
    public void testSetAlphacode() throws Exception {
        final String EXPECTED = "GER";
        nation.setAlphacode(EXPECTED);
        assertEquals(EXPECTED, nation.getAlphacode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameException() {
        nation.setName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAlphacodeException() {
        nation.setAlphacode(null);
    }

    @Test
    public void testGetId() {
        assertEquals(1, nation.getId());
    }

}