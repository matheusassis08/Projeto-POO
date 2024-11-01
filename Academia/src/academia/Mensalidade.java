/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import java.time.LocalDate;

/**
 *
 * 
 */
public class Mensalidade {
    private double valor;
    private LocalDate mes;
    private String nomeCliente;
    private int idCliente;
    private boolean pagamento;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getMes() {
        return mes;
    }

    public void setMes(LocalDate mes) {
        this.mes = mes;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public Mensalidade(double valor, LocalDate mes, String nomeCliente, int idCliente, boolean pagamento) {
        this.valor = valor;
        this.mes = mes;
        this.nomeCliente = nomeCliente;
        this.idCliente = idCliente;
        this.pagamento = pagamento;
    }
    
    

    @Override
    public String toString() {
        return "Mensalidade{" + "valor=" + valor + ", mes=" + mes + ", nomeCliente=" + nomeCliente + ", idCliente=" + idCliente + ", pagamento=" + pagamento + '}';
    }
}