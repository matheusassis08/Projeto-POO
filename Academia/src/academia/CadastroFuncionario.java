/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Leona
 */
public class CadastroFuncionario implements Cadastro {
    private final String FILE_RECEPCIONISTAS = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\recepcionistas.json";
    private final String FILE_INSTRUTORES = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\instrutores.json";
    private final String FILE_VENDEDORES = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\vendedores.json";
    private final String FILE_GERENTES = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\gerentes.json";
        /** 
     Cadastra um novo funcionário no sistema
     * As opções para cadastro são 1. Recepcionista, 2. Instrutor, 3. Vendedor, 4. Gerente.
     */
    @Override
    public void realizarCadastro() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Qual o tipo de funcionário deseja cadastrar?\n1. Recepcionista\n2. Instrutor\n3. Vendedor\n4. Gerente\n5. Voltar ao inicio");
    int num = scanner.nextInt();

    switch (num) {
        case 1 -> cadastrarFuncionario(scanner, FILE_RECEPCIONISTAS, Recepcionista.class);
        case 2 -> cadastrarFuncionario(scanner, FILE_INSTRUTORES, Instrutor.class);
        case 3 -> cadastrarFuncionario(scanner, FILE_VENDEDORES, Vendedor.class);
        case 4 -> cadastrarFuncionario(scanner, FILE_GERENTES, Gerente.class);
        case 5 -> {
            // Voltar ao menu inicial
        }
        default -> System.out.println("Opção inválida.");
    }
}

    private <T> void cadastrarFuncionario(Scanner scanner, String filePath, Class<T> funcionarioClass) {
        List<T> funcionarios = carregarFuncionarios(filePath, funcionarioClass);

        String continuar;
        do {
            T funcionario = criarFuncionario(scanner, funcionarioClass);
            funcionarios.add(funcionario);

            System.out.print("Deseja adicionar outro " + funcionarioClass.getSimpleName().toLowerCase() + "? (s/n): ");
            continuar = scanner.nextLine();
            if (continuar.isEmpty()) continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        salvarFuncionarios(filePath, funcionarios);
    }

    private <T> List<T> carregarFuncionarios(String filePath, Class<T> funcionarioClass) {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File(filePath);

        if (arquivo.exists()) {
            try {
                return mapper.readValue(arquivo, new TypeReference<List<T>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    private <T> T criarFuncionario(Scanner scanner, Class<T> funcionarioClass) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        if (nome.isEmpty()) nome = scanner.nextLine();

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o e-mail: ");
        String email = scanner.nextLine();

        if (funcionarioClass.equals(Recepcionista.class)) {
            System.out.print("Digite o turno: ");
            String turno = scanner.nextLine();

            System.out.print("Digite o salário: ");
            double salario = scanner.nextDouble();
            return (T) new Recepcionista(nome, cpf, endereco, telefone, email, turno, salario);

        } else if (funcionarioClass.equals(Instrutor.class)) {
            System.out.print("Digite o CREF: ");
            String cref = scanner.nextLine();

            System.out.print("Digite o salário: ");
            double salario = scanner.nextDouble();
            return (T) new Instrutor(nome, cpf, endereco, telefone, email, cref, salario);

        } else if (funcionarioClass.equals(Vendedor.class)) {
            System.out.print("Digite a sala: ");
            String sala = scanner.nextLine();

            System.out.print("Digite o salário: ");
            double salario = scanner.nextDouble();
            return (T) new Vendedor(nome, cpf, endereco, telefone, email, sala, salario);

        } else if (funcionarioClass.equals(Gerente.class)) {
            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();

            System.out.print("Digite o salário: ");
            double salario = scanner.nextDouble();
            return (T) new Gerente(nome, cpf, endereco, telefone, email, senha, salario);
        }

        return null;
        
    }

    private <T> void salvarFuncionarios(String filePath, List<T> funcionarios) {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File(filePath);

        try {
            mapper.writeValue(arquivo, funcionarios);
            System.out.println("Funcionários salvos no arquivo: " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** 
     Altera os dados de algum funcionário cadastrado
     
     */
    @Override
    public void alterarCadastro(){
        
    }
    /** 
     Apagar cadastro de um funcionário
     
     */
    @Override
    public void apagarCadastro(){
        
    }
}
