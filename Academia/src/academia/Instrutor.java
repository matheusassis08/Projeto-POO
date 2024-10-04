/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 * A classe Instrutor representa um instrutor que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */

public class Instrutor extends Pessoa {
    private String cargo;

    public Instrutor(String nome, String cpf, String endereco, String telefone, String email, String cargo, double salario) {
        super(nome, cpf, endereco, telefone, email);
        this.cargo = cargo;

    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Instrutor -> " + super.toString() + ", Cargo: " + cargo;
    }
}
