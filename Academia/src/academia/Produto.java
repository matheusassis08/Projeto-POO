/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 * A classe Produto representa um produto para ser vendido na loja.
 */
public class Produto {

    private String nome;

    private int quantidade;

    private String codigo;

    private String prazoValidade;

    private String tipo;

    /**
     * Construtor da classe Produto.
     * 
     * @param nome          O nome do produto.
     * @param quantidade     A quantidade do produto.
     * @param codigo        O código do produto.
     * @param prazoValidade O prazo de validade do produto.
     * @param tipo          O tipo do produto.
     */
    public Produto(String nome, int quantidade, String codigo, String prazoValidade, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.prazoValidade = prazoValidade;
        this.tipo = tipo;
    }


    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
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
        return "Produto [Nome: " + nome + 
               ", Quantidade: " + quantidade + 
               ", Código: " + codigo + 
               ", Prazo de Validade: " + prazoValidade + 
               ", Tipo: " + tipo + "]";
    }
}
