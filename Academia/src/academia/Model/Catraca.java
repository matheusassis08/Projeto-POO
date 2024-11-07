package academia.Model;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Representa uma entrada e saída de clientes em uma academia, registrando os horários de entrada e saída,
 * e calculando o tempo de permanência do cliente.
 */

public class Catraca {
    private String data;
    private String horarioEntrada;
    private String horarioSaida;
    private int idCliente;
    private String tempoPermanencia;

    /**
     * Constrói uma nova instância de Catraca com data, horário de entrada e ID do cliente especificados.
     *
     * @param data           a data da entrada do cliente no formato "yyyy-MM-dd"
     * @param horarioEntrada o horário de entrada do cliente no formato "HH:mm:ss"
     * @param idCliente      o identificador único do cliente
     */
    public Catraca(String data, String horarioEntrada, int idCliente) {
        this.data = data;
        this.horarioEntrada = horarioEntrada;
        this.idCliente = idCliente;
    }

    public Catraca() {
    
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

    /**
     * Obtém o tempo de permanência do cliente na academia.
     * <p>
     * Este valor é calculado com base nos horários de entrada e saída do cliente.
     * </p>
     *
     * @return o tempo de permanência do cliente como uma String no formato "HH:mm:ss",
     *         ou null se o cálculo não foi realizado
     */
    
    public String getTempoPermanencia() {
        return tempoPermanencia;
    }

    /**
     * Define o horário de saída do cliente.
     *
     * @param horarioSaida o horário de saída do cliente no formato "HH:mm:ss"
     */
    
    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    /**
     * Calcula o tempo de permanência do cliente na academia com base nos horários de entrada e saída.
     * <p>
     * A duração calculada é formatada como "HH:mm:ss". Se ocorrer um erro ao passar os horários, 
     * uma mensagem de erro será exibida.
     * </p>
     */
    
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
