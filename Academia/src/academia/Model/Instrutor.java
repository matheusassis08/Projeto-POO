package academia.Model;

import academia.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * A classe Instrutor representa um instrutor que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */

public class Instrutor extends Pessoa {
    private String cref;
    private double salario;
    private int idInstrutor;
    private String login;
    private String senha;

    
    /**
     * @param nome O nome do instrutor
     * @param cpf O cpf do instrutor
     * @param endereco O endereço do instrutor
     * @param telefone O telefone para contato do instrutor
     * @param email O email do instrutor
     * @param cref O registro cref do instrutor
     * @param salario O salário do instrutor
     * @param idInstrutor O id do instrutor
     * @param login O login do instrutor
     * @param senha A senha do instrutor
     */
    public Instrutor(String nome, String cpf, String endereco, String telefone, String email, String cref, double salario, int idInstrutor, String login, String senha) {
        super(nome, cpf, endereco, telefone, email);
        this.cref = cref;
        this.salario = salario;
        this.idInstrutor = idInstrutor;
        this.login = login;
        this.senha = senha;
    }
    public Instrutor() {
        super("", "", "", "", "");
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(int idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Instrutor{" + "cref=" + cref + ", salario=" + salario + ", idInstrutor=" + idInstrutor + ", login=" + login + ", senha=" + senha + '}';
    }
}
