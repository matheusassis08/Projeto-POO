package academia;

import java.time.format.DateTimeFormatter;

/**
 * Classe para representar um relatório de venda dentro do sistema.
 */
public class RelatorioVenda extends Relatorios{
    
    private int numeroPedido;
    private double valorTotalPedido;
    private String nomeCliente;
    private String nomeProdutos;
    private double valorUnitarioItemsPedido;
    private int codigoProdutosPedido;
    
    private final String FILE_RELATORIOVENDA = "C:\\POO\\Projeto-POO\\Academia\\src\\relatorios\\relatoriosVenda.json";

    public RelatorioVenda(String nome, String dataDeRealizacao, String horarioDeRealizacao, int idRelatorio,int numeroPedido, double valorTotalPedido, String nomeCliente, String nomeProdutos, double valorUnitarioItemsPedido, int codigoProdutosPedido) {
        super(nome, dataDeRealizacao, horarioDeRealizacao, idRelatorio);
        this.numeroPedido = numeroPedido;
        this.valorTotalPedido = valorTotalPedido;
        this.nomeCliente = nomeCliente;
        this.nomeProdutos = nomeProdutos;
        this.valorUnitarioItemsPedido = valorUnitarioItemsPedido;
        this.codigoProdutosPedido = codigoProdutosPedido;
    }
    
    public void GerarRelatorio(){
        System.out.println("O relatorio foi gerado.");
    }
    
    public RelatorioVenda() {
        super("", "", "", 0);
    }
    
    @Override
    public String toString() {
        return "RelatorioVenda{" + "numeroPedido=" + numeroPedido + ", valorTotalPedido=" + valorTotalPedido + ", nomeCliente=" + nomeCliente + ", nomeProdutos=" + nomeProdutos + ", valorUnitarioItemsPedido=" + valorUnitarioItemsPedido + ", codigoProdutosPedido=" + codigoProdutosPedido + super.toString() + '}';
    }
}