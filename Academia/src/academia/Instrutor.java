package academia;

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

    
    /**
     * @param nome O nome do instrutor
     * @param cpf O cpf do instrutor
     * @param endereco O endereço do instrutor
     * @param telefone O telefone para contato do instrutor
     * @param email O email do instrutor
     * @param cref O registro cref do instrutor
     * @param salario O salário do instrutor
     * @param idInstrutor O id do instrutor
     */
    public Instrutor(String nome, String cpf, String endereco, String telefone, String email, String cref, double salario, int idInstrutor) {
        super(nome, cpf, endereco, telefone, email);
        this.cref = cref;
        this.salario = salario;
        this.idInstrutor = idInstrutor;
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

    @Override
    public String toString() {
        return "Instrutor{" + "cref=" + cref + ", salario=" + salario + ", idInstrutor=" + idInstrutor + super.toString();
    }
    
}
