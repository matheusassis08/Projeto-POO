package academia;
/**
 * A classe Vendedor representa um vendedor que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */
public class Vendedor extends Pessoa {

    private double salario;
    private String sala;
    private String login;
    private String senha;

    /**
     * Construtor da classe Vendedor.
     * 
     * @param nome      O nome completo do vendedor.
     * @param cpf       O CPF do vendedor.
     * @param endereco  O endereço residencial do vendedor.
     * @param telefone  O número de telefone do vendedor.
     * @param email     O endereço de email do vendedor.
     * @param sala     O sala onde o vendedor atua.
     * @param salario O salario do vendedor
     * @param login O login do vendedor
     * @param senha A senha do vendedor
     */
    public Vendedor(String nome, String cpf, String endereco, String telefone, String email, String sala, double salario, String login, String senha) {
        super(nome, cpf, endereco, telefone, email);
        this.sala = sala;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }
    
    public Vendedor(){
        super("", "", "", "", "");
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "salario=" + salario + ", sala=" + sala + ", login=" + login + ", senha=" + senha + '}';
    }
}
