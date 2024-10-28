package academia;

/**
 * A classe Cliente representa um cliente da academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */

public class Cliente extends Pessoa {
    public Cliente() {
        super("", "", "", "", ""); // Chama o construtor da superclasse com valores vazios
    }
    /**
     * O construtor de um novo cliente.
     * @param nome     O nome de um cliente.
     * @param cpf      O numero de cpf de um cliente.
     * @param endereco O endereço de um cliente.
     * @param telefone O telefone do cliente.
     * @param email    O email do cliente.
     */
    public Cliente(String nome, String cpf, String endereco, String telefone, String email) {
        super(nome, cpf, endereco, telefone, email);
    }

    
    @Override
    public String toString() {
        return "Cliente -> " + super.toString();
    }
}

