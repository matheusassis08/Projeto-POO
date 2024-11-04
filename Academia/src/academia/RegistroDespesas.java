package academia;

/**
 *Classe para representar uma despesa registrada no sistema.
 */
public class RegistroDespesas {
    private String descricaoDaDespesa;
    private String tipoDeDespesa;
    private double valor;
    private String dataDespesa;
    private String horaDespesa;
    private int idDespesa;

    public String getDescricaoDaDespesa() {
        return descricaoDaDespesa;
    }

    public void setDescricaoDaDespesa(String descricaoDaDespesa) {
        this.descricaoDaDespesa = descricaoDaDespesa;
    }

    public String getTipoDeDespesa() {
        return tipoDeDespesa;
    }

    public void setTipoDeDespesa(String tipoDeDespesa) {
        this.tipoDeDespesa = tipoDeDespesa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valorDespesa) {
        this.valor = valorDespesa;
    }

    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    public String getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(String dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public String getHoraDespesa() {
        return horaDespesa;
    }

    public void setHoraDespesa(String horaDespesa) {
        this.horaDespesa = horaDespesa;
    }
    
    
    
    /**
     * Contrutor de RegistroDespesas
     * @param descricaoDaDespesa
     * @param tipoDeDespesa
     * @param valorDespesa
     * @param dataDespesa
     * @param horaDespesa
     * @param idDespesa
     */
    public RegistroDespesas(String descricaoDaDespesa, String tipoDeDespesa, double valorDespesa, String dataDespesa, String horaDespesa, int idDespesa) {
        this.descricaoDaDespesa = descricaoDaDespesa;
        this.tipoDeDespesa = tipoDeDespesa;
        this.valor = valorDespesa;
        this.dataDespesa = dataDespesa;
        this.horaDespesa = horaDespesa;
        this.idDespesa = idDespesa;
    }

    public RegistroDespesas() {
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegistroDespesas{");
        sb.append("descricaoDaDespesa=").append(descricaoDaDespesa);
        sb.append(", tipoDeDespesa=").append(tipoDeDespesa);
        sb.append(", valorDespesa=").append(valor);
        sb.append(", dataDespesa=").append(dataDespesa);
        sb.append(", horaDespesa=").append(horaDespesa);
        sb.append(", idDespesa=").append(idDespesa);
        sb.append('}');
        return sb.toString();
    }
}
