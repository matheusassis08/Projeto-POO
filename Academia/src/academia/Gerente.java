/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;


/**
 * A classe Gerente representa um gerente que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */
public class Gerente extends Pessoa {

    private String departamento;

    /**
     * Construtor da classe Gerente.
     * 
     * @param nome       O nome completo do gerente.
     * @param cpf        O CPF do gerente.
     * @param endereco   O endereço residencial do gerente.
     * @param telefone   O número de telefone do gerente.
     * @param email      O endereço de email do gerente.
     * @param departamento O departamento onde o gerente atua.
     */
    public Gerente(String nome, String cpf, String endereco, String telefone, String email, String departamento) {
        super(nome, cpf, endereco, telefone, email); // Chama o construtor da superclasse Pessoa
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Gerente -> " + super.toString() + ", Departamento: " + departamento;
    }
}

