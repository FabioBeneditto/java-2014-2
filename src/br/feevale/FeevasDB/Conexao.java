package br.feevale.FeevasDB;

import br.feevale.FeevasDB.Exceptions.FevasDBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by diovani on 26/11/14.
 */
public class Conexao {
    public Connection getConnection() {
        return null;
    }

    public void close() {

    }

    public void executaSql(String comando) throws FevasDBException {

    }

    public PreparedStatement prepareStatement(String comando) throws FevasDBException {
        return null;
    }

    public ResultSet executeQuery(String query) throws FevasDBException {
        return null;
    }
}
