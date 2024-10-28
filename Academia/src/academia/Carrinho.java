/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para armazenar os produtos para realizar as vendas.
 * @author Leona
 */
public class Carrinho extends PadraoObservable{
    private String nomeItem;
    private int codigoItem;
    private double valorItem;
    private double valorTotalPedido;
    private String nomeVendedor;
    private int numeroPedido;
    
    private final String FILE_CARRINHO = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\carrinho.json";
    
    private Scanner scanner = new Scanner(System.in);
    private ObjectMapper mapper = new ObjectMapper();
    private GerenciarProduto cadastroProduto = new GerenciarProduto();
    private String FILE_PRODUTOS = cadastroProduto.getFILE_PRODUTOS();
    private File arquivo = new File(FILE_PRODUTOS);
    private List<Produto> produtos;
    private List<Carrinho> produtosCarrinho = new ArrayList<>();
    
    public List<Carrinho> adicionarProduto(List<Carrinho> Carrinho){
        
        String continuar = "s";
        do{
        System.out.println("Qual o codigo do produto que voce deseja adicionar ao carrinho? ");
        int codigoProduto = scanner.nextInt();
        scanner.nextLine();

        if (!arquivo.exists()) {
            System.out.println("Nenhum produto cadastrado.");
        }

        try {
            produtos = mapper.readValue(arquivo, new TypeReference<List<Produto>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        Produto produtoAdicionado = null;
        for(Produto produto: produtos){
            if (produto.getCodigo()==codigoProduto) {
                produtoAdicionado = produto;
            }
        }
        System.out.println("Digite o numero do pedido.");
        int numeroPedidoAtual = scanner.nextInt();
        scanner.nextLine();
        produtosCarrinho.add(new Carrinho(produtoAdicionado.getNome(),produtoAdicionado.getCodigo(),produtoAdicionado.getValor(),0,"nomevendedor(vazio)",numeroPedidoAtual));
        System.out.println("Deseja continuar(s/n)?");
        continuar = scanner.nextLine().trim();
        } while(continuar.equalsIgnoreCase("s"));
        return produtosCarrinho;
    }
    
    public double somarPedido(List<Carrinho> somaProdutosCarrinho){
        double valorTotalSomado = 0;
        for (Carrinho carrinho : produtosCarrinho) {
            valorTotalSomado += carrinho.getValorItem();
        }
        return valorTotalSomado;
    }
    void cancelarPedido(){
        
    }
    String venda = "";
    public void finalizarPedido(){
        venda = "Feita";
        System.out.println("\nFoi concluida a venda.");
        this.mudaEstado();
    }
    
    public void mudaEstado(){
        foiAlterado();
        notificarObservers(venda);
    }
    
    /** Inicia o carrinho para realizar vend
     * @param numeroPedido*/
    public Carrinho(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    
    public Carrinho(){
        
    }

    public Carrinho(String nomeItem, int codigoItem, double valorItem, double valorTotalPedido, String nomeVendedor, int numeroPedido) {
        this.nomeItem = nomeItem;
        this.codigoItem = codigoItem;
        this.valorItem = valorItem;
        this.valorTotalPedido = valorTotalPedido;
        this.nomeVendedor = nomeVendedor;
        this.numeroPedido = numeroPedido;
    }
    
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public double getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    @Override
    public String toString() {
        return "Carrinho{" + "nomeItem=" + nomeItem + ", codigoItem=" + codigoItem + ", valorItem=" + valorItem + ", valorTotalPedido=" + valorTotalPedido + ", nomeVendedor=" + nomeVendedor + ", numeroPedido=" + numeroPedido + '}';
    }
}