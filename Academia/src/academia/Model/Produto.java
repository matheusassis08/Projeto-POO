package academia;
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
    private int filaEspera;
    private static int instanciasProdutos = 0;
    
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
     * @param filaEspera Exibe quantos clientes estão na fila de espera por esse produto.
     */
    public Produto(String nome, int quantidadeEstoque, double valor, int codigo, String prazoValidade, String tipo, int filaEspera) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valor = valor;
        this.codigo = codigo;
        this.prazoValidade = prazoValidade;
        this.tipo = tipo;
        this.filaEspera = filaEspera;
        instanciasProdutos++;
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

    public int getFilaEspera() {
        return filaEspera;
    }

    public void setFilaEspera(int filaEspera) {
        this.filaEspera = filaEspera;
    }
    
    public static int getInstanciasProdutos() {
        return instanciasProdutos;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", quantidadeEstoque=" + quantidadeEstoque + ", valor=" + valor + ", codigo=" + codigo + ", prazoValidade=" + prazoValidade + ", tipo=" + tipo + ", filaEspera=" + filaEspera + '}';
    }
    
    
}
