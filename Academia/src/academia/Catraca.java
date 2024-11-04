package academia;

import java.time.Duration;
import java.time.LocalTime;

public class Catraca {
    private String data;
    private String horarioEntrada;
    private String horarioSaida;
    private int idCliente;
    private String tempoPermanencia;

    public Catraca(String data, String horarioEntrada, int idCliente) {
        this.data = data;
        this.horarioEntrada = horarioEntrada;
        this.idCliente = idCliente;
    }
    
    public Catraca(){
    
    }

    public String getData() {
        return data;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getTempoPermanencia() {
        return tempoPermanencia;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public void calcularTempoPermanencia() {
        try {
            Duration duracao = Duration.between(LocalTime.parse(horarioEntrada), LocalTime.parse(horarioSaida));
            this.tempoPermanencia = String.format("%02d:%02d:%02d", duracao.toHoursPart(), duracao.toMinutesPart(), duracao.toSecondsPart());
        } catch (Exception e) {
            System.out.println("Erro ao calcular tempo de permanência.");
        }
    }

    @Override
    public String toString() {
        return "Catraca{" +
                "data='" + data + '\'' +
                ", horarioEntrada='" + horarioEntrada + '\'' +
                ", horarioSaida='" + horarioSaida + '\'' +
                ", idCliente=" + idCliente +
                ", tempoPermanencia='" + tempoPermanencia + '\'' +
                '}';
    }
}
