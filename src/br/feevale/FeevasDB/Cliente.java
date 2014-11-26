package br.feevale.FeevasDB;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cliente implements Serializable {

    private static final long serialVersionUID = -4901833542804431318L;
    private Integer idCliente;
    private String dsNomeCliente;
    private String dsEmail;
    private Timestamp dtNascimento;
    private Double vlCredito;
    private String tpPessoa;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getDsNomeCliente() {
        return dsNomeCliente;
    }

    public void setDsNomeCliente(String dsNome) {
        this.dsNomeCliente = dsNome;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getTpPessoa() {
        return tpPessoa;
    }

    public void setTpPessoa(String tpPessoa) {
        this.tpPessoa = tpPessoa;
    }

    public Timestamp getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Timestamp dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Double getVlCredito() {
        return vlCredito;
    }

    public void setVlCredito(Double vlLimiteCredito) {
        this.vlCredito = vlLimiteCredito;
    }
}