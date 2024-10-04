/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 * A classe Atendente representa um atendente que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */
public class Atendente extends Pessoa {

    private String turno;

    /**
     * Construtor da classe Atendente.
     * 
     * @param nome      O nome completo do vendedor.
     * @param cpf       O CPF do vendedor.
     * @param endereco  O endereço residencial do vendedor.
     * @param telefone  O número de telefone do vendedor.
     * @param email     O endereço de email do vendedor.
     * @param turno     O turno do atendente.
     */
    public Atendente(String nome, String cpf, String endereco, String telefone, String email, String horario) {
        super(nome, cpf, endereco, telefone, email);
        this.turno = turno;
    }


    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Atendente -> " + super.toString() + ", Turno: " + turno;
    }
}
