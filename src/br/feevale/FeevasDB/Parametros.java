package br.feevale.FeevasDB;

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
    public static synchronized Parametros getInstance() {
        if (instance == null) {
            instance = new Parametros();
        }

        return instance;
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
