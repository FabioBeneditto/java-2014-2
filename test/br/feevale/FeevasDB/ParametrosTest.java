package br.feevale.FeevasDB;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import static org.junit.Assert.*;

public class ParametrosTest {
    private Parametros param;

    @Before
    public void setUp() {
        this.createConfigFile();
        try {
            param = Parametros.getInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testClassType() {
        assertTrue(param instanceof Parametros);
    }

    @Test
    public void testClassProperties() {
        assertNotNull(param.getJDBCDriver());
        assertNotNull(param.getServer());
        assertNotNull(param.getPort());
        assertNotNull(param.getUsername());
        assertNotNull(param.getPassword());
        assertNotNull(param.getDatabase());
    }

    @Test
    public void testDriver() {
        assertEquals("org.postgresql.Driver", param.getJDBCDriver());
    }

    @Test
    public void testServer() {
        assertEquals("localhost", param.getServer());
    }

    @Test
    public void testPort() {
        assertEquals("5432", param.getPort());
    }

    @Test
    public void testUser() {
        assertEquals("postgres", param.getUsername());
    }

    @Test
    public void testPassword() {
        assertEquals("postgres", param.getPassword());
    }

    @Test
    public void testDatabase() {
        assertEquals("ProgIII", param.getDatabase());
    }


    /**
     * Cria um arquivo de configuração para os testes
     * @return
     */
    private void createConfigFile() {
        String tmpDir = "prmsFevasDB.xml";
        try {
            File xml = new File(tmpDir);
            PrintWriter writer = new PrintWriter(xml, "UTF-8");

            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            writer.println("<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">");
            writer.println("<properties>");
            writer.println("<comment>Parametros do Fevas DB</comment>");
            writer.println("<entry key=\"driverJDBC\">org.postgresql.Driver</entry>");
            writer.println("<entry key=\"endBanco\">localhost</entry>");
            writer.println("<entry key=\"nroPorta\">5432</entry>");
            writer.println("<entry key=\"nomeUsuario\">postgres</entry>");
            writer.println("<entry key=\"senha\">postgres</entry>");
            writer.println("<entry key=\"nomeDatabase\">ProgIII</entry>");
            writer.println("</properties>");

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}