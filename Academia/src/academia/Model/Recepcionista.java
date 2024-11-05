package academia;

/**
 * A classe Recepcionista representa um recepcionista que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */
public class Recepcionista extends Pessoa {
    private String turno;
    private double salario;
    private String login;
    private String senha;

        /**
     * Construtor da classe Recepcionista.
     * 
     * @param nome      O nome completo do vendedor.
     * @param cpf       O CPF do vendedor.
     * @param endereco  O endereço residencial do vendedor.
     * @param telefone  O número de telefone do vendedor.
     * @param email     O endereço de email do vendedor.
     * @param turno     O turno do recepcionista.
     * @param salario   O salario do recepcionista.
     */
    public Recepcionista(String nome, String cpf, String endereco, String telefone, String email, String turno, double salario, String login, String senha) {
        super(nome, cpf, endereco, telefone, email);
        this.turno = turno;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }
    
        public Recepcionista() {
        super("", "", "", "", "");
    }
    
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
        return "Recepcionista{" + "turno=" + turno + ", salario=" + salario + ", login=" + login + ", senha=" + senha + '}';
    }
}