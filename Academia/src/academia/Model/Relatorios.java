package academia.Model;

/**
 *
 * Classe Abstrata para representar um relatorio dentro do sistema a ser especificado em outras subclasses.
 */
public abstract class Relatorios {
    private String nome;
    private String dataDeRealizacao;
    private String horarioDeRealizacao;
    private int idRelatorio;
    
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
    
    public int getIdRelatorio() {
        return idRelatorio;
    }
    
    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }
    
    
    
    public Relatorios(String nome, String dataDeRealizacao, String horarioDeRealizacao, int idRelatorio) {
        this.nome = nome;
        this.dataDeRealizacao = dataDeRealizacao;
        this.horarioDeRealizacao = horarioDeRealizacao;
        this.idRelatorio = idRelatorio;
    }
    
    @Override
    public String toString() {
        return "Relatorios{" + "nome=" + nome + ", dataDeRealizacao=" + dataDeRealizacao + ", horarioDeRealizacao=" + horarioDeRealizacao + ", idRelatorio=" + idRelatorio + '}';
    }
}