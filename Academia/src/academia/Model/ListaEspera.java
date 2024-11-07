package academia.Model;

/**
 *
 * Classe para representar uma fila de espera para alterção de estoque de um produto.
 */
public class ListaEspera {
    String emailCliente;
    int codigoProduto;

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    
    public ListaEspera() {
        
    }
    
    public ListaEspera(String emailCliente, int codigoProduto) {
        this.emailCliente = emailCliente;
        this.codigoProduto = codigoProduto;
    }

    @Override
    public String toString() {
        return "ListaEspera{" + "emailCliente=" + emailCliente + ", codigoProduto=" + codigoProduto + '}';
    }
}
