/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 *
 * 
 */
public class RelatorioAgendamento extends Relatorios{
    private String nomeCliente;
    private String idCliente;
    
    public RelatorioAgendamento(String nome, String dataDeRealizacao, String horarioDeRealizacao, int idRelatorio) {
        super(nome, dataDeRealizacao, horarioDeRealizacao, idRelatorio);
    }
    
}