/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 *
 * Classe para representar um relatorio dentro do sistema.
 */
public abstract class Relatorios {
    private String nome;
    private String dataDeRealizacao;
    private String horarioDeRealizacao;
    private String idRelatorio;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeRealizacao() {
        return dataDeRealizacao;
    }

    public void setDataDeRealizacao(String dataDeRealizacao) {
        this.dataDeRealizacao = dataDeRealizacao;
    }

    public String getHorarioDeRealizacao() {
        return horarioDeRealizacao;
    }

    public void setHorarioDeRealizacao(String horarioDeRealizacao) {
        this.horarioDeRealizacao = horarioDeRealizacao;
    }

    public String getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(String idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    @Override
    public String toString() {
        return "Relatorios{" + "nome=" + nome + ", dataDeRealizacao=" + dataDeRealizacao + ", horarioDeRealizacao=" + horarioDeRealizacao + ", idRelatorio=" + idRelatorio + '}';
    }
    
}