package academia.Model;

/**
 *  Classe para representar um agendamento dentro do sistema
 */
public class Agendamento {
    private String data;
    private String horario;
    private String nomeCliente;
    private String emailCliente;
    private int idCliente;
    private String nomeInstrutor;
    private int idInstrutor;
    private String tipoDeAula;
    private double valorAgendamento;
    private boolean confirmado;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
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

    public String getTipoDeAula() {
        return tipoDeAula;
    }

    public void setTipoDeAula(String tipoDeAula) {
        this.tipoDeAula = tipoDeAula;
    }

    public double getValorAgendamento() {
        return valorAgendamento;
    }

    public void setValorAgendamento(double valorAgendamento) {
        this.valorAgendamento = valorAgendamento;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
    
    /**
     * Contrutor da classe Agendamento
     * 
     * @param data
     * @param horario
     * @param nomeCliente
     * @param emailCliente
     * @param idCliente
     * @param nomeInstrutor
     * @param idInstrutor
     * @param tipoDeAula
     * @param valorAgendamento
     */
    public Agendamento(String data, String horario, String nomeCliente, String emailCliente, int idCliente, String nomeInstrutor, int idInstrutor, String tipoDeAula, double valorAgendamento, boolean confirmado) {
        this.data = data;
        this.horario = horario;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.idCliente = idCliente;
        this.nomeInstrutor = nomeInstrutor;
        this.idInstrutor = idInstrutor;
        this.tipoDeAula = tipoDeAula;
        this.valorAgendamento = valorAgendamento;
        this.confirmado = confirmado;
    }
    /**
     * Construtor padrão da classe Agendamento
     */
    public Agendamento(){
        
    }

    @Override
    public String toString() {
        return "Agendamento{" + "data=" + data + ", horario=" + horario + ", nomeCliente=" + nomeCliente + ", emailCliente=" + emailCliente + ", idCliente=" + idCliente + ", nomeInstrutor=" + nomeInstrutor + ", idInstrutor=" + idInstrutor + ", tipoDeAula=" + tipoDeAula + ", valorAgendamento=" + valorAgendamento + '}';
    }
}
