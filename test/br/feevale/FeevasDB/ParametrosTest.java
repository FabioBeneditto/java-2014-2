package br.feevale.FeevasDB;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParametrosTest {
    private Parametros param;

    @Before
    public void setUp() {
        this.param = Parametros.getInstance();
    }

    @Test
    public void testClassType() {
        assertTrue(this.param instanceof Parametros);
    }
}