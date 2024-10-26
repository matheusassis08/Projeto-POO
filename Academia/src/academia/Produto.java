/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
/**
 * A classe Produto representa um produto para ser vendido na loja.
 */
public class Produto {

    private String nome;
    private int quantidadeEstoque;
    private double valor;
    private int codigo;
    private String prazoValidade;
    private String tipo;
    
    
     public Produto() {
         
    }
    
    /**
     * Construtor da classe Produto.
     * 
     * @param nome          O nome do produto.
     * @param quantidadeEstoque    A quantidade do produto.
     * @param valor         O valor do Produto
     * @param codigo        O código do produto.
     * @param prazoValidade O prazo de validade do produto.
     * @param tipo          O tipo do produto.
     */
    public Produto(String nome, int quantidadeEstoque, double valor, int codigo, String prazoValidade, String tipo) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valor = valor;
        this.codigo = codigo;
        this.prazoValidade = prazoValidade;
        this.tipo = tipo;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPrazoValidade() {
        return prazoValidade;
    }

    public void setPrazoValidade(String prazoValidade) {
        this.prazoValidade = prazoValidade;
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", quantidadeEstoque=" + quantidadeEstoque + ", valor=" + valor + ", codigo=" + codigo + ", prazoValidade=" + prazoValidade + ", tipo=" + tipo + '}';
    }

    
}
