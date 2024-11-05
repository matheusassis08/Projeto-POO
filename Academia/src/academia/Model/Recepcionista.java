/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

/**
 * A classe Recepcionista representa um recepcionista que trabalha na academia.
 * Ela herda os atributos e comportamentos da classe abstrata Pessoa.
 */
public class Recepcionista extends Pessoa {
    private String turno;
    private double salario;

        /**
     * Construtor da classe Recepcionista.
     * 
     * @param nome      O nome completo do vendedor.
     * @param cpf       O CPF do vendedor.
     * @param endereco  O endereço residencial do vendedor.
     * @param telefone  O número de telefone do vendedor.
     * @param email     O endereço de email do vendedor.
     * @param turno     O turno do recepcionista.
     * @param salario   O salario do recepcionista.
     */
    public Recepcionista(String nome, String cpf, String endereco, String telefone, String email, String turno, double salario) {
        super(nome, cpf, endereco, telefone, email);
        this.turno = turno;
        this.salario = salario;
    }
    
        public Recepcionista() {
        super("", "", "", "", "");
    }
    
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return "Recepcionista{" + "turno=" + turno + ", salario=" + salario + '}';
    }
}