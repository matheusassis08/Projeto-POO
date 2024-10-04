/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 * A classe Cliente representa um cliente da academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */

public class Cliente extends Pessoa {

    public Cliente(String nome, String cpf, String endereco, String telefone, String email) {
        super(nome, cpf, endereco, telefone, email);
    }

    @Override
    public String toString() {
        return "Cliente -> " + super.toString();
    }
}

