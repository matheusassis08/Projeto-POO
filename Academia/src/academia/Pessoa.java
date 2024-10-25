/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;
/**
 * A classe abstrata Pessoa representa uma pessoa genérica que pode ser herdada por diferentes tipos de pessoas,
 * como Cliente, Instrutor, Gerente, Vendedor, e Recepcionista. Ela contém os atributos e métodos comuns a todas as pessoas.
 */
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;

    /**
     * Construtor da classe Pessoa.
     * 
     * @param nome      O nome completo da pessoa.
     * @param cpf       O CPF da pessoa.
     * @param endereco  O endereço residencial da pessoa.
     * @param telefone  O número de telefone da pessoa.
     * @param email     O endereço de email da pessoa.
     */
    
    public Pessoa(String nome, String cpf, String endereco, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + '}';
    }
}