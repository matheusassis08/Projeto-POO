package academia;
/**
 *  Classe para representar um relatorio de agendamento de aula dentro do sistema
 */
public class RelatorioAgendamento extends Relatorios{
    private String nomeCliente;
    private int idCliente;
    private String nomeInstrutor;
    private int idInstrutor;
    private String tipoAula;
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

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public int getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(int idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public RelatorioAgendamento(String nomeCliente, int idCliente, String nomeInstrutor, int idInstrutor, String tipoAula, double valor, String nome, String dataDeRealizacao, String horarioDeRealizacao, int idRelatorio) {
        super(nome, dataDeRealizacao, horarioDeRealizacao, idRelatorio);
        this.nomeCliente = nomeCliente;
        this.idCliente = idCliente;
        this.nomeInstrutor = nomeInstrutor;
        this.idInstrutor = idInstrutor;
        this.tipoAula = tipoAula;
        this.valor = valor;
    }
    
    public RelatorioAgendamento(){
        super("", "", "", 0);
    }

    @Override
    public String toString() {
        return "RelatorioAgendamento{" + "nomeCliente=" + nomeCliente + ", idCliente=" + idCliente + ", nomeInstrutor=" + nomeInstrutor + ", idInstrutor=" + idInstrutor + ", tipoAula=" + tipoAula + ", valor=" + valor + super.toString() + '}';
    }
}