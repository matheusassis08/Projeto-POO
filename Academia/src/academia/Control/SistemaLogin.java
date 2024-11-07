package academia.Control;

import academia.Model.Gerente;
import academia.Model.Instrutor;
import academia.Model.Pessoa;
import academia.Model.Recepcionista;
import academia.Model.Vendedor;
import java.util.List;

public class SistemaLogin {
    
    private List<Gerente> gerentes;
    private List<Instrutor> instrutores;
    private List<Vendedor> vendedores;
    private List<Recepcionista> recepcionistas;
    private String tipoFuncionario;
    
    /**
     * Construtor para inicializar as listas de funcionários
     * @param gerentes
     * @param instrutores
     * @param vendedores
     * @param recepcionistas
     */
    public SistemaLogin(List<Gerente> gerentes, List<Instrutor> instrutores, List<Vendedor> vendedores, List<Recepcionista> recepcionistas) {
        this.gerentes = gerentes;
        this.instrutores = instrutores;
        this.vendedores = vendedores;
        this.recepcionistas = recepcionistas;
    }

    // Método para verificar o login e senha fornecidos
    public boolean verificarLogin(String login, String senha) {
        if (verificarLoginParaTipo(login, senha, gerentes, "Gerente")) return true;
        if (verificarLoginParaTipo(login, senha, instrutores, "Instrutor")) return true;
        if (verificarLoginParaTipo(login, senha, vendedores, "Vendedor")) return true;
        if (verificarLoginParaTipo(login, senha, recepcionistas, "Recepcionista")) return true;

        System.out.println("Login ou senha incorretos.");
        return false;
    }

    // Método genérico para verificar login em uma lista de funcionários
    private boolean verificarLoginParaTipo(String login, String senha, List<? extends Pessoa> listaFuncionarios, String tipo) {
        for (Pessoa funcionario : listaFuncionarios) {
            switch (funcionario) {
                case Gerente gerente -> {
                    if (gerente.getLogin().equals(login) && gerente.getSenha().equals(senha)) {
                        tipoFuncionario = "Gerente";
                        return true;
                    }
                }
                case Instrutor instrutor -> {
                    if (instrutor.getLogin().equals(login) && instrutor.getSenha().equals(senha)) {
                        tipoFuncionario = "Instrutor";
                        return true;
                    }
                }
                case Vendedor vendedor -> {
                    if (vendedor.getLogin().equals(login) && vendedor.getSenha().equals(senha)) {
                        tipoFuncionario = "Vendedor";
                        return true;
                    }
                }
                case Recepcionista recepcionista -> {
                    if (recepcionista.getLogin().equals(login) && recepcionista.getSenha().equals(senha)) {
                        tipoFuncionario = "Recepcionista";
                        return true;
                    }
                }
                default -> {
                }
            }
        }
        return false;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }
}