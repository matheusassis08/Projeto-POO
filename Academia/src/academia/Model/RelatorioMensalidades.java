package academia.Model;

/**
 * Classe para representar relatorios de mensalidades dentro do sistema
 */
public class RelatorioMensalidades extends Relatorios{
    private String nomeCliente;
    private int idCliente;
    private double valor;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public RelatorioMensalidades(String nomeCliente, int idCliente, double valor, String nome, String dataDeRealizacao, String horarioDeRealizacao, int idRelatorio) {
        super(nome, dataDeRealizacao, horarioDeRealizacao, idRelatorio);
        this.nomeCliente = nomeCliente;
        this.idCliente = idCliente;
        this.valor = valor;
    }

    
    
    public RelatorioMensalidades(){
        super("", "", "", 0);
    }

    @Override
    public String toString() {
        return "RelatorioMensalidades{" + "nomeCliente=" + nomeCliente + ", idCliente=" + idCliente + ", valor=" + valor + '}';
    }

    
}
