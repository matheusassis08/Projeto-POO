/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia.Model;

import academia.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * A classe Gerente representa um gerente que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */
public class Gerente extends Pessoa {
    private double salario;
    private String login;
    private String senha;

    /**
     * Construtor da classe Gerente.
     * 
     * @param nome       O nome completo do gerente.
     * @param cpf        O CPF do gerente.
     * @param endereco   O endereço residencial do gerente.
     * @param telefone   O número de telefone do gerente.
     * @param email      O endereço de email do gerente.
     * @param salario O salario do gerente
     * @param login O login do gerente
     * @param senha A senha de acesso do gerente.
     */
    public Gerente(String nome, String cpf, String endereco, String telefone, String email, double salario, String login, String senha) {
        super(nome, cpf, endereco, telefone, email); // Chama o construtor da superclasse Pessoa
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }
    
    public Gerente() {
        super("", "", "", "", "");
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Gerente{" + "salario=" + salario + ", login=" + login + ", senha=" + senha + '}';
    }
    
    
    
    
}