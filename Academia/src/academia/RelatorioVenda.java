/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 *
 * @author Leona
 */
public class RelatorioVenda extends Relatorios{
    int numeroPedido;
    double valorTotalPedido;
    String nomeCliente;
    String nomeProdutos;
    double valorUnitarioItemsPedido;
    int codigoProdutosPedido;

    public RelatorioVenda(int numeroPedido, double valorTotalPedido, String nomeCliente, String nomeProdutos, double valorUnitarioItemsPedido, int codigoProdutosPedido) {
        this.numeroPedido = numeroPedido;
        this.valorTotalPedido = valorTotalPedido;
        this.nomeCliente = nomeCliente;
        this.nomeProdutos = nomeProdutos;
        this.valorUnitarioItemsPedido = valorUnitarioItemsPedido;
        this.codigoProdutosPedido = codigoProdutosPedido;
    }

    @Override
    public String toString() {
        return "RelatorioVenda{" + "numeroPedido=" + numeroPedido + ", valorTotalPedido=" + valorTotalPedido + ", nomeCliente=" + nomeCliente + ", nomeProdutos=" + nomeProdutos + ", valorUnitarioItemsPedido=" + valorUnitarioItemsPedido + ", codigoProdutosPedido=" + codigoProdutosPedido + '}';
    }
    
}
