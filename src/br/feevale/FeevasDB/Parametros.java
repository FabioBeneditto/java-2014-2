package br.feevale.FeevasDB;

import br.feevale.FeevasDB.Exceptions.FevasDBException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by diovani on 11/18/14.
 */
public class Parametros {
    private static Parametros instance;

    private String JDBCDriver;
    private String server;
    private String port;
    private String username;
    private String password;
    private String database;

    /**
     * Construtor privado para impedir novas instâncias
     */
    private Parametros() {}

    /**
     * Obtém a única instância da classe
     * @return Parametros
     */
    public static synchronized Parametros getInstance() throws FevasDBException {
        if (instance == null) {
            instance = new Parametros();
            instance.loadParameros();
        }

        return instance;
    }

    /**
     * Carrega as propriedades da classe a partir do
     * xml de configuração
     * @throws FevasDBException
     */
    private void loadParameros() throws FevasDBException {
        File arqParametros = new File( "prmsFevasDB.xml" );

        if( arqParametros.exists() ) {
            try {
                FileInputStream fsStream = new FileInputStream( arqParametros );

                try {
                    Properties prop = new Properties();
                    prop.loadFromXML(fsStream);

                    this.JDBCDriver = prop.getProperty("driverJDBC");
                    this.server = prop.getProperty("endBanco");
                    this.port = prop.getProperty("nroPorta");
                    this.username = prop.getProperty("nomeUsuario");
                    this.password = prop.getProperty("senha");
                    this.database = prop.getProperty("nomeDatabase");
                } finally {
                    fsStream.close();
                }
            } catch (Exception e) {
                throw new FevasDBException( "Erro ao carregar arquivo de parâmetros: '" + arqParametros.getAbsolutePath() + "'", e );
            }

        } else {
            throw new FevasDBException( "Não encontrei arquivo de parâmetros: '" + arqParametros.getAbsolutePath() + "'" );
        }


    }

    public String getJDBCDriver() {
        return this.JDBCDriver;
    }

    public String getServer() {
        return server;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }
}
