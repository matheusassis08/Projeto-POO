/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * A classe Vendedor representa um vendedor que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */
public class Vendedor extends Pessoa {

    private double salario;
    private String sala;

    /**
     * Construtor da classe Vendedor.
     * 
     * @param nome      O nome completo do vendedor.
     * @param cpf       O CPF do vendedor.
     * @param endereco  O endereço residencial do vendedor.
     * @param telefone  O número de telefone do vendedor.
     * @param email     O endereço de email do vendedor.
     * @param sala     O sala onde o vendedor atua.
     * @param salario O salario do vendedor
     */
    public Vendedor(String nome, String cpf, String endereco, String telefone, String email, String sala, double salario) {
        super(nome, cpf, endereco, telefone, email);
        this.sala = sala;
        this.salario = salario;
    }
    
    public Vendedor(){
        super("", "", "", "", "");
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "salario=" + salario + ", sala=" + sala + '}';
    }
}
