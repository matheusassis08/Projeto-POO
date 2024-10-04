/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 * Classe para administrar os agendamentos das aulas
 * @author Leona
 */
public class Agendamentos {
    private String data;
    private String horario;
    private String nomeCliente;       
    private String emailCliente;       
    private String nomeInstrutor;
    /** Para agendar um horário para um aluno ter aula*/
    void realizarAgendamento(){
    
    }
    /** Altera algum agendamento feito*/
    void alterarAgendamento(){
    
    }
    /** Cancela algum agendamento*/
    void excluirAgendamento(){
    
    }
    /** Verifica os horários que já estão agendados*/
    void verificarAgendamento(){
    
    }

    public Agendamentos(String nomeCliente, String emailCliente, String nomeInstrutor) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.nomeInstrutor = nomeInstrutor;
    }

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

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    @Override
    public String toString() {
        return "Agendamentos{" + "data=" + data + ", horario=" + horario + ", nomeCliente=" + nomeCliente + ", emailCliente=" + emailCliente + ", nomeInstrutor=" + nomeInstrutor + '}';
    }
    
}
