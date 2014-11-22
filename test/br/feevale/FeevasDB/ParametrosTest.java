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
        param = Parametros.getInstance();
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
        assertEquals(param.getJDBCDriver(), "org.postgresql.Driver");
    }

    @Test
    public void testServer() {
        assertEquals(param.getServer(), "localhost");
    }

    @Test
    public void testPort() {
        assertEquals(param.getPort(), "5432");
    }

    @Test
    public void testUser() {
        assertEquals(param.getUsername(), "postgres");
    }

    @Test
    public void testPassword() {
        assertEquals(param.getPassword(), "postgres");
    }

    @Test
    public void testDatabase() {
        assertEquals(param.getDatabase(), "ProgIII");
    }


    /**
     * Cria um arquivo de configuração para os testes
     * @return
     */
    private void createConfigFile() {
        String tmpDir = "database.xml";
        try {
            File xml = new File(tmpDir);
            PrintWriter writer = new PrintWriter(xml, "UTF-8");

            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            writer.println("<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">");
            writer.println("<properties>");
            writer.println("<comment>Parametros do Fevas DB</comment>");
            writer.println("<entry key=\"driverJDBC\">org.postgresql.Driver</entry>");
            writer.println("<entry key=\"senha\">postgres</entry>");
            writer.println("<entry key=\"endBanco\">localhost</entry>");
            writer.println("<entry key=\"nomeDatabase\">ProgIII</entry>");
            writer.println("<entry key=\"nomeUsuario\">postgres</entry>");
            writer.println("<entry key=\"nroPorta\">5432</entry>");
            writer.println("</properties>");

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}