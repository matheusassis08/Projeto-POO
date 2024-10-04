/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

public class Instrutor extends Pessoa {
    private String cargo;

    // Construtor que utiliza o construtor da classe Pessoa e adiciona atributos específicos do instrutor
    public Instrutor(String nome, String cpf, String endereco, String telefone, String email, String cargo, double salario) {
        super(nome, cpf, endereco, telefone, email); // Chama o construtor da superclasse Pessoa
        this.cargo = cargo;

    }

    // Implementação do método abstrato
    @Override
    public String obterTipo() {
        return "Instrutor"; // Retorna o tipo como "Instrutor"
    }

    // Getters e Setters para os atributos específicos do Instrutor
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Sobrescrita do método toString() para incluir cargo e salário
    @Override
    public String toString() {
        return "Instrutor -> " + super.toString() + ", Cargo: " + cargo;
    }
}
