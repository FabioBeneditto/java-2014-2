package br.feevale.FeevasDB;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Calendar;

import static org.junit.Assert.*;

public class ConexaoTest {
    Conexao conn;
    Cliente cliente;

    @Before
    public void setUp() throws Exception {
        conn = new Conexao();

        Calendar nasc = Calendar.getInstance();
        nasc.set(2014, 11, 26);

        cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setDsNomeCliente("Test client");
        cliente.setDsEmail("client@example.com");
        cliente.setDtNascimento(new Timestamp(nasc.getTimeInMillis()));
        cliente.setVlCredito(0.0);
        cliente.setTpPessoa("fis");
    }

    @Test
    public void testConexao() throws Exception {
        assertTrue(conn instanceof Conexao);
    }

    @Test
    public void testGetConnection() throws Exception {
        Connection connection = conn.getConnection();
        assertTrue(connection instanceof Connection);
    }

    @Test
    public void testClose() throws Exception {
        Connection connection = conn.getConnection();
        conn.close();

        assertTrue(connection.isClosed());
    }

    @Test
    public void testExecutaSql() throws Exception {
        try {
            //testa o comando e já deleta todos os clientes, para teste
            conn.executaSql("DELETE FROM clientes;");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testPrepareStatement() throws Exception {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append ("insert into clientes ( idCliente, dsNomeCliente, dsEmail, dtNascimento, vlCredito, tpPessoa )");
            sql.append ("values ( ?, ?, ?, ?, ?, ? );");
            PreparedStatement ps = conn.prepareStatement(sql.toString());

            ps.setInt( 1, cliente.getIdCliente() );
            ps.setString( 2, cliente.getDsNomeCliente() );
            ps.setString( 3, cliente.getDsEmail() );
            ps.setTimestamp( 4, cliente.getDtNascimento() );
            ps.setDouble( 5, cliente.getVlCredito() );
            ps.setString( 6, cliente.getTpPessoa() );

            ps.execute();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testExecuteQuery() throws Exception {
        fail("Not implemented");
    }
}