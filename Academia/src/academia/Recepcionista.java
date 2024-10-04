/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 * A classe Recepcionista representa um recepcionista que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */

public class Recepcionista extends Pessoa {
    private String turno;

    public Recepcionista(String nome, String cpf, String endereco, String telefone, String email, String turno, double salario) {
        super(nome, cpf, endereco, telefone, email);
        this.turno = turno;
    }

    @Override
    public String obterTipo() {
        return "Recepcionista";
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Recepcionista -> " + super.toString() + ", Turno: " + turno;
    }
}
