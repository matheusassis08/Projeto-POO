/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

public class Cliente extends Pessoa {
    // Atributos específicos do Cliente podem ser adicionados aqui, se necessário.

    // Construtor que utiliza o construtor da classe Pessoa
    public Cliente(String nome, String cpf, String endereco, String telefone, String email) {
        super(nome, cpf, endereco, telefone, email);
    }

    // Implementação do método abstrato
    @Override
    public String obterTipo() {
        return "Cliente"; // Retorna o tipo como "Cliente"
    }

    // Sobrescrita do método toString() para incluir mais detalhes se necessário
    @Override
    public String toString() {
        return "Cliente -> " + super.toString();
    }
}

