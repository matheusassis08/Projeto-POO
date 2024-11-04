package academia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * Classe para o cadastro, alteração e remoção de algum funcionário dentro do sistema.
 */
public class GerenciarFuncionario implements Cadastro, PadraoObserver {
    private final String FILE_RECEPCIONISTAS = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\recepcionistas.json";
    private final String FILE_INSTRUTORES = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\instrutores.json";
    private final String FILE_VENDEDORES = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\vendedores.json";
    private final String FILE_GERENTES = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\gerentes.json";
    String estado;
    Scanner scanner = new Scanner(System.in);
    ObjectMapper mapper = new ObjectMapper();
    private static final Set<Integer> idsGerados = new HashSet<>();
    private static final Random random = new Random();
    private static final int LIMITE_SUPERIOR_ID = 100000;
    //todos 4
    
    /** 
      Cadastra um novo funcionário no sistema. As opções para cadastro são 1. Recepcionista, 2. Instrutor, 3. Vendedor, 4. Gerente.
    */
    @Override
    public void realizarCadastro() {
        System.out.println("Qual o tipo de funcionário deseja cadastrar?\n1. Recepcionista\n2. Instrutor\n3. Vendedor\n4. Gerente\n5. Voltar ao inicio");
        int num = scanner.nextInt();
        scanner.nextLine();

        switch (num) {
            case 1 -> cadastrarFuncionario(scanner, Recepcionista.class, FILE_RECEPCIONISTAS);
            case 2 -> cadastrarFuncionario(scanner, Instrutor.class, FILE_INSTRUTORES);
            case 3 -> cadastrarFuncionario(scanner, Vendedor.class, FILE_VENDEDORES);
            case 4 -> cadastrarFuncionario(scanner, Gerente.class, FILE_GERENTES);
            case 5 -> {
                
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    private <T> void cadastrarFuncionario(Scanner scanner, Class<T> funcionarioClass, String filePath) {
        List<T> funcionarios = carregarFuncionarios(filePath, funcionarioClass);
        String continuar;
        do {
            T funcionario = criarFuncionario(scanner, funcionarioClass);
            if (funcionario != null) {
                funcionarios.add(funcionario);
            }

            System.out.print("Deseja adicionar outro " + funcionarioClass.getSimpleName().toLowerCase() + "? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        salvarFuncionarios(funcionarios, filePath);
    }

    private <T> List<T> carregarFuncionarios(String filePath, Class<T> funcionarioClass) {
        File arquivo = new File(filePath);

        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(arquivo, mapper.getTypeFactory().constructCollectionType(List.class, funcionarioClass));
        } catch (IOException e) {
            System.out.println("Erro ao carregar funcionários: " + e.getMessage());
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    private <T> void salvarFuncionarios(List<T> funcionarios, String filePath) {
        File arquivo = new File(filePath);

        try {
            mapper.writeValue(arquivo, funcionarios);
            System.out.println("Funcionários salvos no arquivo: " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao salvar funcionários: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private <T> T criarFuncionario(Scanner scanner, Class<T> funcionarioClass) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

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
            scanner.nextLine();
            return (T) new Recepcionista(nome, cpf, endereco, telefone, email, turno, salario);

        } else if (funcionarioClass.equals(Instrutor.class)) {
            System.out.print("Digite o CREF: ");
            String cref = scanner.nextLine();

            System.out.print("Digite o salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();
            return (T) new Instrutor(nome, cpf, endereco, telefone, email, cref, salario, gerarIdFuncionario());

        } else if (funcionarioClass.equals(Vendedor.class)) {
            System.out.print("Digite a sala: ");
            String sala = scanner.nextLine();

            System.out.print("Digite o salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();
            return (T) new Vendedor(nome, cpf, endereco, telefone, email, sala, salario);

        } else if (funcionarioClass.equals(Gerente.class)) {
            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();

            System.out.print("Digite o salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();
            return (T) new Gerente(nome, cpf, endereco, telefone, email, senha, salario);
        }

        return null;
    }
    /** 
     Exibe todos os Funcionários e pergunta se deseja alterar algum dado.
     
     */
    @Override
    public void alterarCadastro(){
    System.out.println("Qual o tipo de funcionário deseja alterar?\n1. Recepcionista\n2. Instrutor\n3. Vendedor\n4. Gerente\n5. Voltar ao inicio");
    int num = scanner.nextInt();
    scanner.nextLine();
    
    List<? extends Pessoa> funcionarios = new ArrayList<>();
    File arquivo = null;

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
     Exibe a lista de possiveis funcionários e da a opção de apagar o cadastro de algum selecionado.
     
     */
    @Override
    public void apagarCadastro(){
        System.out.println("Qual o tipo de funcionário deseja apagar?\n1. Recepcionista\n2. Instrutor\n3. Vendedor\n4. Gerente\n5. Voltar ao inicio");
        int num = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        List<? extends Pessoa> funcionarios = new ArrayList<>();
        File arquivo = null;

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

        System.out.print("Digite o número do funcionário que deseja apagar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice < 0 || indice >= funcionarios.size()) {
            System.out.println("Funcionário inválido.");
            return;
        }

        Pessoa funcionario = funcionarios.get(indice);
        System.out.println("Tem certeza que deseja apagar o funcionário: " + funcionario.getNome() + " (s/n)?");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("s")) {
            funcionarios.remove(indice);

            try {
                mapper.writeValue(arquivo, funcionarios);
                System.out.println("Funcionário apagado com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Operação cancelada.");
        }
    }
    
    
    private static int gerarIdFuncionario() {
        int novoId;
        do {
            novoId = random.nextInt(LIMITE_SUPERIOR_ID);
        } while (idsGerados.contains(novoId)); // Gera um novo ID enquanto houver repetição
        
        idsGerados.add(novoId); // Adiciona o novo ID ao conjunto para evitar duplicatas
        return novoId;
    }
    
    private void alterarComissaoVenda(){
        System.out.println("\nA comissão de venda do funcionário foi atualizada.\n");
    }
    
    @Override
    public void update(PadraoObservable o, Object arg){
        Carrinho carrinho = (Carrinho)o;
        estado = String.valueOf(arg);
        if(estado.equals("Feita")){
            this.alterarComissaoVenda();
        }
     }
}