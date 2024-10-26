/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
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
public class Carrinho extends Observable{
    private String nomeItem;
    private int codigoItem;
    private int valorItem;
    private int valorTotalPedido;
    private String nomeVendedor;
    private int numeroPedido;
    
    private final String FILE_CARRINHO = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\carrinho.json";
    
    private Scanner scanner = new Scanner(System.in);
    File arquivo2 = new File(FILE_CARRINHO);
    public void adicionarProduto(){
        System.out.println("Qual o codigo do produto que voce deseja adicionar ao carrinho? ");
        String codigoProduto = scanner.nextLine();
        CadastroProduto cadastroProduto = new CadastroProduto();
        String FILE_PRODUTOS = cadastroProduto.getFILE_PRODUTOS();
        File arquivo = new File(FILE_PRODUTOS);
        List<Produto> produtos;
        List<Carrinho> produtosCarrinho;
        ObjectMapper mapper = new ObjectMapper();

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
        Produto produtoAdicionado = null;
        for(Produto produto: produtos){
            if (produto.getCodigo().equalsIgnoreCase(codigoProduto)) {
                produtoAdicionado = produto;
            }
        }
        
        //produtosCarrinho.add(new Carrinho(produtoAdicionado.getNome(), produtoAdicionado.getCodigo(), produtoAdicionado.g));
    }
    void somarPedido(){
    
    }
    void cancelarPedido(){
    
    }
    String venda = "";
    void finalizarPedido(){
        venda = "Feita";
        System.out.println("Foi concluida a venda: ///" + venda);
        this.mudaEstado();
    }
    
    public void mudaEstado(){
        setChanged();
        notifyObservers(venda);
    }
    
    /** Inicia o carrinho para realizar vend
     * @param numeroPedido*/
    public Carrinho(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    
    public Carrinho(){
        
    }

    public Carrinho(String nomeItem, int codigoItem, int valorItem, int valorTotalPedido, String nomeVendedor, int numeroPedido) {
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

    public int getValorItem() {
        return valorItem;
    }

    public void setValorItem(int valorItem) {
        this.valorItem = valorItem;
    }

    public int getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(int valorTotalPedido) {
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