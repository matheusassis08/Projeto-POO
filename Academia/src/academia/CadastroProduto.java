/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Classe para o cadastro, alteração e remoção de algum produto dentro do sistema.
 */
public class CadastroProduto implements Cadastro{
    private final String FILE_PRODUTOS = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\produtos.json";
    /** 
     Cadastra um novo produto no sistema
     */
    @Override
    public void realizarCadastro(){
        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        File arquivo = new File(FILE_PRODUTOS);
        ObjectMapper mapper = new ObjectMapper();

        if (arquivo.exists()) {
            try {
                produtos = mapper.readValue(arquivo, new TypeReference<List<Produto>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String continuar;
        do {
            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a quantidade de estoque do produto: ");
            int quantidadeEstoque = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o codigo do produto: ");
            String codigo = scanner.nextLine();

            System.out.print("Digite o prazo de validade do produto(dd/MM/yyyy): ");
            String prazoValidade = converterDataParaString(solicitarDataValida(scanner));

            System.out.print("Digite o tipo de produto(Alimentício, Suplementação, Acessório): ");
            String tipo = scanner.nextLine();

            Produto produto = new Produto(nome, quantidadeEstoque, codigo, prazoValidade, tipo);
            produtos.add(produto);

            System.out.print("Deseja adicionar outro produto? (s/n): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        try {
            mapper.writeValue(arquivo, produtos);
            System.out.println("Produtos salvos no arquivo: " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** 
     Altera os dados de algum produto cadastro
     
     */
    @Override
    public void alterarCadastro(){
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File(FILE_PRODUTOS);
        List<Produto> produtos;

        if (!arquivo.exists()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        try {
            produtos = mapper.readValue(arquivo, new TypeReference<List<Produto>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Selecione o produto que deseja alterar(0 caso não queria mais alterar nenhuma informação):");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". Nome: " + produtos.get(i).getNome());
        }
        
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice < 0 || indice >= produtos.size()) {
            System.out.println("Produto não encontrado.");
            return;
        }

        Produto produto = produtos.get(indice);

        boolean alterar = true;
        while (alterar) {
            System.out.println("O que você deseja alterar?");
            System.out.println("1. Nome");
            System.out.println("2. Estoque");
            System.out.println("3. Código");
            System.out.println("4. Prazo de Validade");
            System.out.println("5. Tipo");
            System.out.println("6. Finalizar alterações");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();
                    produto.setNome(novoNome);
                }
                case 2 -> {
                    System.out.println("Digite a nova quantidade em estoque:");
                    int novoEstoque = scanner.nextInt();
                    produto.setQuantidadeEstoque(novoEstoque);
                }
                case 3 -> {
                    System.out.println("Digite o novo codigo:");
                    String novoCodigo = scanner.nextLine();
                    produto.setCodigo(novoCodigo);
                }
                case 4 -> {
                    LocalDate data = null;
                    String novoPrazoValidade = null;
                    while (data == null) {
                        System.out.println("Digite o novo prazo de validade(dd/MM/yyyy):");
                        novoPrazoValidade = scanner.nextLine();
                        data = parseData(novoPrazoValidade);
                    }
                    produto.setPrazoValidade(novoPrazoValidade);
                }
                case 5 -> {
                    System.out.println("Digite o novo tipo do produto:");
                    String novoTipo = scanner.nextLine();
                    produto.setTipo(novoTipo);
                }
                case 6 -> {
                    alterar = false;
                    System.out.println("Alterações finalizadas.");
                }
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }

        try {
            mapper.writeValue(arquivo, produtos);
            System.out.println("Cadastro do produto alterado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** 
     Apagar cadastro do Produto
     
     */
    @Override
    public void apagarCadastro(){
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        List<Produto> produtos = new ArrayList<>();
        
        File arquivo = new File(FILE_PRODUTOS);
        
        if (arquivo.exists()) {
            try {
                produtos = mapper.readValue(arquivo, new TypeReference<List<Produto>>() {});
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        
        System.out.print("Digite o código do produto que deseja remover: ");
        String codigo = scanner.nextLine();
        
        boolean clienteRemovido = false;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo().equals(codigo)) {
                produtos.remove(i);
                clienteRemovido = true;
                break;
            }
        }
        
        if (clienteRemovido) {
            try {
                mapper.writeValue(arquivo, produtos);
                System.out.println("Cliente removido com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Produto com o código " + codigo + " não encontrado.");
        }
    }
    
    /**
     * Verifica o estoque de algum produto a partir do seu codigo fornecido.
     * @param codigo
     */
    public void verificarEstoque(String codigo){
        ObjectMapper mapper = new ObjectMapper();
        List<Produto> produtos = new ArrayList<>();
        
        File arquivo = new File(FILE_PRODUTOS);
        
        if (arquivo.exists()) {
            try {
                produtos = mapper.readValue(arquivo, new TypeReference<List<Produto>>() {});
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                System.out.println("Produto: " + produto.getNome() + ", Estoque: " + produto.getQuantidadeEstoque());
                return;
            }
        }
        System.out.println("Produto com código " + codigo + " não encontrado.");
    }
    /**
     * Metodo para tratar exceções com relação a digitação incorreta do formato das data.
     * @param dataStr
     * @return 
     */
    private static LocalDate parseData(String dataStr) {
        try {
            return LocalDate.parse(dataStr, Academia.getDATE_FORMATTER());
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Use o formato dd/MM/yyyy.");
            return null; // Retorna null para sinalizar erro
        }
    }
    
    private static LocalDate solicitarDataValida(Scanner scanner) {
        LocalDate data = null;
        while (data == null) {
            System.out.print("Digite o prazo de validade do produto (dd/MM/yyyy): ");
            String inputDate = scanner.nextLine();
            data = parseData(inputDate);
        }
        return data;
    }
    /**
     * Metodo apenas converter a data para String
     */
    private static String converterDataParaString(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}