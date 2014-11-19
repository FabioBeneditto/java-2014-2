package br.feevale.FeevasDB;

/**
 * Created by diovani on 11/18/14.
 */
public class Parametros {
    private static Parametros instance;

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
}
