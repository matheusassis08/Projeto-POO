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
    private String codigo;
    private LocalDate prazoValidade;
    private String tipo;
    
    
     public Produto() {
         
    }
    
    /**
     * Construtor da classe Produto.
     * 
     * @param nome          O nome do produto.
     * @param quantidadeEstoque    A quantidade do produto.
     * @param codigo        O código do produto.
     * @param prazoValidade O prazo de validade do produto.
     * @param tipo          O tipo do produto.
     */
    public Produto(String nome, int quantidadeEstoque, String codigo, String prazoValidade, String tipo) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.codigo = codigo;
        this.prazoValidade = LocalDate.parse(prazoValidade, Academia.getDATE_FORMATTER());
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrazoValidade() {
        return prazoValidade.format(Academia.getDATE_FORMATTER());
    }

    public void setPrazoValidade(String prazoValidade) {
        this.prazoValidade = LocalDate.parse(prazoValidade, Academia.getDATE_FORMATTER());
    }

    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

    @Override
    public String toString() {
        return "Produto [Nome: " + nome + 
               ", Quantidade: " + quantidadeEstoque + 
               ", Código: " + codigo + 
               ", Prazo de Validade: " + prazoValidade + 
               ", Tipo: " + tipo + "]";
    }
}
