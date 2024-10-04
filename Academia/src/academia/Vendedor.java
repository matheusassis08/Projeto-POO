/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 * A classe Vendedor representa um vendedor que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */
public class Vendedor extends Pessoa {

    private String setor;

    /**
     * Construtor da classe Vendedor.
     * 
     * @param nome      O nome completo do vendedor.
     * @param cpf       O CPF do vendedor.
     * @param endereco  O endereço residencial do vendedor.
     * @param telefone  O número de telefone do vendedor.
     * @param email     O endereço de email do vendedor.
     * @param setor     O setor onde o vendedor atua.
     */
    public Vendedor(String nome, String cpf, String endereco, String telefone, String email, String setor) {
        super(nome, cpf, endereco, telefone, email);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Vendedor -> " + super.toString() + ", Setor: " + setor;
    }
}
