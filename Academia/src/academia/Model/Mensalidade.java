/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import java.time.LocalDate;

/**
 * Classe para representar uma mensalidade dentro do sistema
 */
public class Mensalidade {
    private double valor;
    private int mesInicio;
    private String nomeCliente;
    private int idCliente;
    private String plano;
    private int mesesEmAberto;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(int mesInicio) {
        this.mesInicio = mesInicio;
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

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public int getMesesEmAberto() {
        return mesesEmAberto;
    }

    public void setMesesEmAberto(int mesesEmAberto) {
        this.mesesEmAberto = mesesEmAberto;
    }

    

    public Mensalidade(double valor, int mes, String nomeCliente, int idCliente, String plano, int mesesEmAberto) {
        this.valor = valor;
        this.mesInicio = mes;
        this.nomeCliente = nomeCliente;
        this.idCliente = idCliente;
        this.plano = plano;
        this.mesesEmAberto = mesesEmAberto;
    }
    
    public Mensalidade() {
        
    }

    @Override
    public String toString() {
        return "Mensalidade{" + "valor=" + valor + ", mes=" + mesInicio + ", nomeCliente=" + nomeCliente + ", idCliente=" + idCliente + ", plano=" + plano + ", mesesEmAberto=" + mesesEmAberto + '}';
    }

    
}