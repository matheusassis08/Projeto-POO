package academia;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * Classe para o cadastro, alteração e remoção de algum cliente dentro do sistema.
 */
public class GerenciarCliente implements Cadastro{
    private static final String FILE_CLIENTES = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\clientes.json";
    private final File arquivoCliente = new File(FILE_CLIENTES);
    Scanner scanner = new Scanner(System.in);
    ObjectMapper mapper = new ObjectMapper();
    
        /** 
     Cadastra um novo cliente no sistema
     */
    @Override
    public void realizarCadastro() {
        List<Cliente> clientes = new ArrayList<>();

        clientes = carregarJSONClientes(clientes);

        String continuar;
        do {
            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o CPF do cliente: ");
            String cpf = scanner.nextLine();

            System.out.print("Digite o endereço do cliente: ");
            String endereco = scanner.nextLine();

            System.out.print("Digite o telefone do cliente: ");
            String telefone = scanner.nextLine();

            System.out.print("Digite o e-mail do cliente: ");
            String email = scanner.nextLine();

            Cliente cliente = new Cliente(nome, cpf, endereco, telefone, email);
            clientes.add(cliente);

            System.out.print("Deseja adicionar outro cliente? (s/n): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        salvarJSONRelatorioVenda(clientes);
    }
    /** 
     * Altera os dados de algum cliente
     */
    @Override
    public void alterarCadastro(){
        List<Cliente> clientes = new ArrayList<>();

        clientes = carregarJSONClientes(clientes);

        System.out.println("Selecione o cliente que deseja alterar:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". Nome: " + clientes.get(i).getNome() + " | Telefone: " + clientes.get(i).getTelefone());
        }
        
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice < 0 || indice >= clientes.size()) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Cliente cliente = clientes.get(indice);

        boolean alterar = true;
        while (alterar) {
            System.out.println("O que você deseja alterar?");
            System.out.println("1. Nome");
            System.out.println("2. CPF");
            System.out.println("3. Endereço");
            System.out.println("4. Telefone");
            System.out.println("5. Email");
            System.out.println("6. Finalizar alterações");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();
                    cliente.setNome(novoNome);
                }
                case 2 -> {
                    System.out.println("Digite o novo CPF:");
                    String novoCpf = scanner.nextLine();
                    cliente.setCpf(novoCpf);
                }
                case 3 -> {
                    System.out.println("Digite o novo endereço:");
                    String novoEndereco = scanner.nextLine();
                    cliente.setEndereco(novoEndereco);
                }
                case 4 -> {
                    System.out.println("Digite o novo telefone:");
                    String novoTelefone = scanner.nextLine();
                    cliente.setTelefone(novoTelefone);
                }
                case 5 -> {
                    System.out.println("Digite o novo email:");
                    String novoEmail = scanner.nextLine();
                    cliente.setEmail(novoEmail);
                }
                case 6 -> {
                    alterar = false;
                    System.out.println("Alterações finalizadas.");
                }
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }
        salvarJSONRelatorioVenda(clientes);
    }
    /** 
     Apagar cadastro de um cliente por meio do seu cpf cadastrado
     
     */
    @Override
    public void apagarCadastro(){
        List<Cliente> clientes = new ArrayList<>();
        clientes = carregarJSONClientes(clientes);
        
        System.out.print("Digite o CPF do cliente que deseja remover: ");
        String cpf = scanner.nextLine();
        
        boolean clienteRemovido = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                clientes.remove(i);
                clienteRemovido = true;
                break;
            }
        }
        
        if (clienteRemovido) {
            salvarJSONRelatorioVenda(clientes);
        } else {
            System.out.println("Cliente com o CPF " + cpf + " não encontrado.");
        }
    }
    /**
     * Método para carregar todos os clientes salvos em JSON.
     * 
     * @param clientes
     * @return clientes;
     */
    public List<Cliente> carregarJSONClientes(List<Cliente> clientes){
        if (arquivoCliente.exists()) {
            try {
                clientes = mapper.readValue(arquivoCliente, new TypeReference<List<Cliente>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return clientes;
    }
    
    /**
     * 
     * Método para salvar um novo JSON com todos os relatorios de venda.
     * @param clientes
     */
    public void salvarJSONRelatorioVenda(List<Cliente> clientes){
        try {
            mapper.writeValue(arquivoCliente, clientes);
            System.out.println("Produtos salvos no arquivo: " + arquivoCliente.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Optional<Cliente> buscarClientePorEmail(List<Cliente> clientes, String email) {
        return clientes.stream()
                .filter(cliente -> cliente.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
    
    public GerenciarCliente() {
    }
    
    static public String getFILE_CLIENTES() {
        return FILE_CLIENTES;
    }
}