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
     Exibe todos os Funcionários e pergunta se deseja alterar algum dado.
     
     */
    @Override
    public void alterarCadastro(){
        Scanner scanner = new Scanner(System.in);
    System.out.println("Qual o tipo de funcionário deseja alterar?\n1. Recepcionista\n2. Instrutor\n3. Vendedor\n4. Gerente\n5. Voltar ao inicio");
    int num = scanner.nextInt();
    scanner.nextLine();
    
    List<? extends Pessoa> funcionarios = new ArrayList<>();
    File arquivo = null;
    ObjectMapper mapper = new ObjectMapper();

    switch (num) {
        case 1 -> {
            arquivo = new File(FILE_RECEPCIONISTAS);
            try {
                funcionarios = arquivo.exists() ? mapper.readValue(arquivo, new TypeReference<List<Recepcionista>>() {}) : new ArrayList<>();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        case 2 -> {
            arquivo = new File(FILE_INSTRUTORES);
            try {
                funcionarios = arquivo.exists() ? mapper.readValue(arquivo, new TypeReference<List<Instrutor>>() {}) : new ArrayList<>();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        case 3 -> {
            arquivo = new File(FILE_VENDEDORES);
            try {
                funcionarios = arquivo.exists() ? mapper.readValue(arquivo, new TypeReference<List<Vendedor>>() {}) : new ArrayList<>();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        case 4 -> {
            arquivo = new File(FILE_GERENTES);
            try {
                funcionarios = arquivo.exists() ? mapper.readValue(arquivo, new TypeReference<List<Gerente>>() {}) : new ArrayList<>();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        case 5 -> {
            System.out.println("Voltando ao menu inicial...");
            return;
        }
        default -> {
            System.out.println("Opção inválida.");
            return;
        }
    }

    if (funcionarios.isEmpty()) {
        System.out.println("Nenhum funcionário encontrado.");
        return;
    }
    
    System.out.println("Funcionários disponíveis:");
    for (int i = 0; i < funcionarios.size(); i++) {
        Pessoa funcionario = funcionarios.get(i);
        System.out.println((i + 1) + ". Nome: " + funcionario.getNome() + ", Email: " + funcionario.getEmail());
    }

    System.out.print("Digite o número do funcionário que deseja alterar: ");
    int indice = scanner.nextInt() - 1;
    scanner.nextLine(); // Consumir nova linha

    if (indice < 0 || indice >= funcionarios.size()) {
        System.out.println("Funcionário inválido.");
        return;
    }

    Pessoa funcionario = funcionarios.get(indice);
    
    System.out.println("O que deseja alterar?\n1. Nome\n2. CPF\n3. Endereço\n4. Telefone\n5. E-mail\n6. Voltar");
    int opcaoAlterar = scanner.nextInt();
    scanner.nextLine();

    switch (opcaoAlterar) {
        case 1 -> {
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            funcionario.setNome(novoNome);
        }
        case 2 -> {
            System.out.print("Digite o novo CPF: ");
            String novoCpf = scanner.nextLine();
            funcionario.setCpf(novoCpf);
        }
        case 3 -> {
            System.out.print("Digite o novo endereço: ");
            String novoEndereco = scanner.nextLine();
            funcionario.setEndereco(novoEndereco);
        }
        case 4 -> {
            System.out.print("Digite o novo telefone: ");
            String novoTelefone = scanner.nextLine();
            funcionario.setTelefone(novoTelefone);
        }
        case 5 -> {
            System.out.print("Digite o novo e-mail: ");
            String novoEmail = scanner.nextLine();
            funcionario.setEmail(novoEmail);
        }
        case 6 -> {
            System.out.println("Voltando ao menu anterior...");
            return;
        }
        default -> {
            System.out.println("Opção inválida.");
            return;
        }
    }

    try {
        mapper.writeValue(arquivo, funcionarios);
        System.out.println("Funcionário alterado com sucesso.");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    /** 
     Apagar cadastro de um funcionário
     
     */
    @Override
    public void apagarCadastro(){
        
    }
}
