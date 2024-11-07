package academia.Model;
/**
 * A classe Cliente representa um cliente da academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */
public class Cliente extends Pessoa {
    private static int instanciasClientes = 0;
    protected static int instanciasClientesProtected = 0;
    private int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
    public Cliente() {
        super("", "", "", "", "");
    }
    /**
     * O construtor de um novo cliente.
     * @param nome     O nome de um cliente.
     * @param cpf      O numero de cpf de um cliente.
     * @param endereco O endereço de um cliente.
     * @param telefone O telefone do cliente.
     * @param email    O email do cliente.
     * @param idCliente O id do cliente.
     */
    public Cliente(String nome, String cpf, String endereco, String telefone, String email, int idCliente) {
        super(nome, cpf, endereco, telefone, email);
        this.idCliente = idCliente;
        instanciasClientes++;
        instanciasClientesProtected++;
    }
    
    public static int getInstanciasClientes() {
        return instanciasClientes;
    }

    public static int getInstanciasClientesProtected() {
        return instanciasClientesProtected;
    }

    public static void setInstanciasClientesProtected(int instanciasClientesProtected) {
        Cliente.instanciasClientesProtected = instanciasClientesProtected;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + super.toString();
    }
}

