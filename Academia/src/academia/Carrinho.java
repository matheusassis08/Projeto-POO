/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 * Classe para armazenar os produtos para realizar as vendas.
 * @author Leona
 */
public class Carrinho {
    private String nomeItem;
    private int codigoItem;
    private int valorItem;
    private int valorTotalPedido;
    private String nomeVendedor;
    private int numeroPedido;
    
    void adicionarProduto(){
    
    }
    void somarPedido(){
    
    }
    void cancelarPedido(){
    
    }
    void finalizarPedido(){
    
    }
    /** Inicia o carrinho para realizar venda*/
    public Carrinho(int numeroPedido) {
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
