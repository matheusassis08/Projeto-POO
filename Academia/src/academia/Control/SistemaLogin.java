package academia.Control;

import academia.Model.Gerente;
import academia.Model.Instrutor;
import academia.Recepcionista;
import academia.Vendedor;
import java.util.List;

public class SistemaLogin {
    
    private List<Gerente> gerentes;
    private List<Instrutor> instrutores;
    private List<Vendedor> vendedores;
    private List<Recepcionista> recepcionistas;
    private String tipoFuncionario;
    
    // Construtor para inicializar as listas de funcionários
    public SistemaLogin(List<Gerente> gerentes, List<Instrutor> instrutores, List<Vendedor> vendedores, List<Recepcionista> recepcionistas, String tipoFuncionario) {
        this.gerentes = gerentes;
        this.instrutores = instrutores;
        this.vendedores = vendedores;
        this.recepcionistas = recepcionistas;
        this.tipoFuncionario = tipoFuncionario;
    }
    
    public SistemaLogin(){
        
    }

    // Método para verificar o login e senha fornecidos
    public boolean verificarLogin(String login, String senha) {
        for (Gerente gerente : gerentes) {
            if (gerente.getLogin().equals(login) && gerente.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido como Gerente.");
                tipoFuncionario = "Gerente";
                return true;
            }
        }
        
        for (Instrutor instrutor : instrutores) {
            if (instrutor.getLogin().equals(login) && instrutor.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido como Instrutor.");
                tipoFuncionario = "Instrutor";
                return true;
            }
        }
        
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getLogin().equals(login) && vendedor.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido como Vendedor.");
                tipoFuncionario = "Vendedor";
                return true;
            }
        }
        
        for (Recepcionista recepcionista : recepcionistas) {
            if (recepcionista.getLogin().equals(login) && recepcionista.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido como Recepcionista.");
                tipoFuncionario = "Recepcionista";
                return true;
            }
        }
        
        System.out.println("Login ou senha incorretos.");
        return false;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }
    
    
}