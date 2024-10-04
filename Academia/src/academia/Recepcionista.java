/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

public class Recepcionista extends Pessoa {
    private String turno; // Turno de trabalho (manhã, tarde, noite)

    // Construtor que utiliza o construtor da classe Pessoa e adiciona atributos específicos do recepcionista
    public Recepcionista(String nome, String cpf, String endereco, String telefone, String email, String turno, double salario) {
        super(nome, cpf, endereco, telefone, email); // Chama o construtor da superclasse Pessoa
        this.turno = turno;
    }

    // Implementação do método abstrato
    @Override
    public String obterTipo() {
        return "Recepcionista"; // Retorna o tipo como "Recepcionista"
    }

    // Getters e Setters para os atributos específicos do Recepcionista
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    // Sobrescrita do método toString() para incluir turno e salário
    @Override
    public String toString() {
        return "Recepcionista -> " + super.toString() + ", Turno: " + turno;
    }
}
