package academia;

import java.util.List;
import java.util.Scanner;

/**
 *
 * Classe para realizar ou gerenciar pagamentos.
 */
public class GerenciarPagamentos{
    private final Scanner scanner = new Scanner(System.in);
    
    
    public void autenticarPagamento(Double valor, String tipo){
        System.out.println("Pagamento em "+ tipo +" no valor de " + valor + " confirmado.");
    }
    
    public void autenticarPagamentoCartao(int numeroCartao, double valor){
        System.out.println("Pagamento no cartão confirmado.");
    }
    
    public void confirmarPagamento(){
        System.out.println("Pagamento confirmado com sucesso.");
    }
    
    public void solicitarPagamento(double valor, String tipo){
        confirmarPagamento();
    }
    
    public Agendamento solicitarPagamentoAgendamento(Agendamento agendamento){
        GerenciarPagamentos gerenciarPagamentos = new GerenciarPagamentos();
        
        System.out.println("""
                                               Qual forma de Pagamento?
                                               
                                               1. Cartão Debito
                                               2. Cartão Crédito
                                               3. Pix
                                               4. Dinheiro""");
                            int n = scanner.nextInt();
                            switch (n) {
                                case 1 -> {
                                    scanner.nextLine();
                                    System.out.println("Qual o numero do cartão? ");
                                    int numCartaoIn = scanner.nextInt();
                                    gerenciarPagamentos.autenticarPagamentoCartao(numCartaoIn,agendamento.getValorAgendamento());
                                    return agendamento;
                                }
                                case 2 -> {
                                    scanner.nextLine();
                                    System.out.println("Qual o numero do cartão? ");
                                    int numCartaoIn = scanner.nextInt();
                                    gerenciarPagamentos.autenticarPagamentoCartao(numCartaoIn,agendamento.getValorAgendamento());
                                    return agendamento;
                                }
                                case 3 -> {
                                    String tipo = "Pix";
                                    gerenciarPagamentos.solicitarPagamento(agendamento.getValorAgendamento(), tipo);
                                    return agendamento;
                                }
                                case 4 -> {
                                    String tipo = "Dinheiro";
                                    gerenciarPagamentos.solicitarPagamento(agendamento.getValorAgendamento(), tipo);
                                    return agendamento;
                                }
                                default -> {
                                    System.out.println("Opção inválida.");
                                    return agendamento;
                                }
                            }                
    }

    public GerenciarPagamentos() {
    }
    
    
    
    @Override
    public String toString() {
        return "GerenciarPagamentos{" + '}';
    }
}