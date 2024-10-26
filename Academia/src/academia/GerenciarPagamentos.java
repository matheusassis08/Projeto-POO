package academia;

/**
 *
 * Classe para realizar ou gerenciar pagamentos.
 */
public class GerenciarPagamentos {
    
    public void autenticarPagamento(Double valor){
        System.out.println("Pagamento no valor de " + valor + " confirmado.");
    }
    
    public void confirmarPagamento(){
        System.out.println("Pagamento confirmado com sucesso.");
    }
    
    public void solicitarPagamento(double valor){
        autenticarPagamento(valor);
        confirmarPagamento();
    }

    public GerenciarPagamentos() {
    }

    @Override
    public String toString() {
        return "GerenciarPagamentos{" + '}';
    }
}