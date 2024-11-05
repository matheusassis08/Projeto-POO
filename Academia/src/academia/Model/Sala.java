package academia;

import java.util.List;

/**
 *
 * 
 */
public class Sala {
    private int capacidadeMaxima;
    private String tipoAula;
    private String funcionarioChefe;
    private double tamanho;
    private String localizacao;

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public String getFuncionarioChefe() {
        return funcionarioChefe;
    }

    public void setFuncionarioChefe(String funcionarioChefe) {
        this.funcionarioChefe = funcionarioChefe;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Sala(int capacidadeMaxima, String tipoAula, String funcionarioChefe, double tamanho, String localizacao) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.tipoAula = tipoAula;
        this.funcionarioChefe = funcionarioChefe;
        this.tamanho = tamanho;
        this.localizacao = localizacao;
    }
    
    public Sala() {
        
    }

    @Override
    public String toString() {
        return "Sala{" + "capacidadeMaxima=" + capacidadeMaxima + ", tipoAula=" + tipoAula + ", funcionarioChefe=" + funcionarioChefe + ", tamanho=" + tamanho + ", localizacao=" + localizacao + '}';
    }
    
    
}
