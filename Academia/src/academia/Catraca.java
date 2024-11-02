package academia;

/**
 *
 * Classe catraca
 */
public class Catraca {
    private String data;
    private String horario;
    private int idCliente;

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Catraca(String data, String horario, int idCliente) {
        this.data = data;
        this.horario = horario;
        this.idCliente = idCliente;
    }

    public Catraca() {
        
    }
    
    @Override
    public String toString() {
        return "Catraca{" + "data=" + data + ", horario=" + horario + ", idCliente=" + idCliente + '}';
    }
    
    
    
    
}
