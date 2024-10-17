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
public class CadastroCliente implements Cadastro {
    /**
     * Atributo estático para definir o caminho da pasta para salvar em json a lista de clientes.
     */
    private static final String ARQUIVO_CLIENTES = "H:\\Epic HD\\Projeto-POO\\Academia\\src\\arquivos\\clientes.json";
        /** 
     Cadastra um novo cliente no sistema
     */
    @Override
    public void realizarCadastro() {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        File arquivo = new File(ARQUIVO_CLIENTES);
        ObjectMapper mapper = new ObjectMapper();

        if (arquivo.exists()) {
            try {
                clientes = mapper.readValue(arquivo, new TypeReference<List<Cliente>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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

        try {
            mapper.writeValue(arquivo, clientes);
            System.out.println("Clientes salvos no arquivo: " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** 
     Altera os dados de algum cliente
     
     */
    @Override
    public void alterarCadastro(){
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File(ARQUIVO_CLIENTES);
        List<Cliente> clientes;

        // Verifica se o arquivo existe
        if (!arquivo.exists()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        try {
            // Lê os clientes do arquivo
            clientes = mapper.readValue(arquivo, new TypeReference<List<Cliente>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Exibe a lista de clientes com nome e telefone para o usuário escolher qual alterar
        System.out.println("Selecione o cliente que deseja alterar:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". Nome: " + clientes.get(i).getNome() + " | Telefone: " + clientes.get(i).getTelefone());
        }
        
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir a quebra de linha

        if (indice < 0 || indice >= clientes.size()) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Cliente cliente = clientes.get(indice);

        // Apresenta as opções de alteração sem mostrar os valores atuais
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
            scanner.nextLine(); // Consumir a quebra de linha

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

        // Salva a lista de clientes alterada no arquivo JSON
        try {
            mapper.writeValue(arquivo, clientes);
            System.out.println("Cadastro do cliente alterado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** 
     Apagar cadastro de um cliente por meio do seu cpf cadastrado
     
     */
    @Override
    public void apagarCadastro(){
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        List<Cliente> clientes = new ArrayList<>();

        File arquivo = new File(ARQUIVO_CLIENTES);

        // Carregar os clientes existentes, se houver
        if (arquivo.exists()) {
            try {
                clientes = mapper.readValue(arquivo, new TypeReference<List<Cliente>>() {});
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        // Solicitar o CPF do cliente a ser removido
        System.out.print("Digite o CPF do cliente que deseja remover: ");
        String cpf = scanner.nextLine();

        // Verificar se o cliente existe na lista
        boolean clienteRemovido = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                clientes.remove(i);
                clienteRemovido = true;
                break;
            }
        }

        if (clienteRemovido) {
            try {
                // Atualizar o arquivo com a lista de clientes sem o cliente removido
                mapper.writeValue(arquivo, clientes);
                System.out.println("Cliente removido com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Cliente com o CPF " + cpf + " não encontrado.");
        }
    }

    public CadastroCliente() {
    }
}
