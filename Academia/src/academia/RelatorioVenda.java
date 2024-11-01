package academia;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para representar um relatório de venda dentro do sistema.
 */
public class RelatorioVenda extends Relatorios{
    
    private int numeroPedido;
    private double valorTotalPedido;
    private String nomeCliente;
    private String emailCliente;
    private List<String> nomeProdutos;
    private List<Double> valorUnitarioItemsPedido;
    private List<Integer> codigoProdutosPedido;
    
    private final String FILE_RELATORIOVENDA = "C:\\POO\\Projeto-POO\\Academia\\src\\relatorios\\relatoriosVenda.json";

    public RelatorioVenda(String nome, String dataDeRealizacao, String horarioDeRealizacao, int idRelatorio,int numeroPedido, double valorTotalPedido, String nomeCliente, String emailCliente, List<String> nomeProdutos, List<Double> valorUnitarioItemsPedido, List<Integer> codigoProdutosPedido) {
        super(nome, dataDeRealizacao, horarioDeRealizacao, idRelatorio);
        this.numeroPedido = numeroPedido;
        this.valorTotalPedido = valorTotalPedido;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.nomeProdutos = new ArrayList<>();
        this.nomeProdutos.addAll(nomeProdutos);
        this.valorUnitarioItemsPedido = new ArrayList<>();
        this.valorUnitarioItemsPedido.addAll(valorUnitarioItemsPedido);
        this.codigoProdutosPedido = new ArrayList<>();
        this.codigoProdutosPedido.addAll(codigoProdutosPedido);
    }
    
    public void GerarRelatorio(){
        System.out.println("O relatorio foi gerado.");
    }
    
    public RelatorioVenda() {
        super("", "", "", 0);
        nomeProdutos = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public double getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<String> getNomeProdutos() {
        return nomeProdutos;
    }

    public void setNomeProdutos(List<String> nomeProdutos) {
        this.nomeProdutos = nomeProdutos;
    }

    public List<Double> getValorUnitarioItemsPedido() {
        return valorUnitarioItemsPedido;
    }

    public void setValorUnitarioItemsPedido(List<Double> valorUnitarioItemsPedido) {
        this.valorUnitarioItemsPedido = valorUnitarioItemsPedido;
    }

    public List<Integer> getCodigoProdutosPedido() {
        return codigoProdutosPedido;
    }

    public void setCodigoProdutosPedido(List<Integer> codigoProdutosPedido) {
        this.codigoProdutosPedido = codigoProdutosPedido;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    
    
    @Override
    public String toString() {
        return "RelatorioVenda{" + "numeroPedido=" + numeroPedido + ", valorTotalPedido=" + valorTotalPedido + ", nomeCliente=" + nomeCliente + ", emailCliente=" + emailCliente + ", nomeProdutos=" + nomeProdutos + ", valorUnitarioItemsPedido=" + valorUnitarioItemsPedido + ", codigoProdutosPedido=" + codigoProdutosPedido + ", FILE_RELATORIOVENDA=" + FILE_RELATORIOVENDA + super.toString() + '}';
    }
    
    
}