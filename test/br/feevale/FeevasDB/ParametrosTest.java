package br.feevale.FeevasDB;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParametrosTest {
    private Parametros param;

    @Before
    public void setUp() {
        param = Parametros.getInstance();
    }

    @Test
    public void testClassType() {
        assertTrue(param instanceof Parametros);
    }

    @Test
    public void testClassProperties() {
        assertEquals(param.getJDBCDriver(), null);
        assertEquals(param.getServer(), null);
        assertEquals(param.getPort(), null);
        assertEquals(param.getUsername(), null);
        assertEquals(param.getPassword(), null);
        assertEquals(param.getDatabase(), null);
    }
}