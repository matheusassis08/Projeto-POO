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
    
    public List<Agendamento> solicitarPagamentoAgendamento(List<Agendamento> agendamentos){
        GerenciarPagamentos gerenciarPagamentos = new GerenciarPagamentos();
        GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
        
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
                                    gerenciarPagamentos.autenticarPagamentoCartao(numCartaoIn,agendamentos.getLast().getValorAgendamento());
                                    gerenciarAgendamentos.salvarJSONAgendamentos(agendamentos);
                                    return agendamentos;
                                }
                                case 2 -> {
                                    scanner.nextLine();
                                    System.out.println("Qual o numero do cartão? ");
                                    int numCartaoIn = scanner.nextInt();
                                    gerenciarPagamentos.autenticarPagamentoCartao(numCartaoIn,agendamentos.getLast().getValorAgendamento());
                                    gerenciarAgendamentos.salvarJSONAgendamentos(agendamentos);
                                    return agendamentos;
                                }
                                case 3 -> {
                                    String tipo = "Pix";
                                    gerenciarPagamentos.solicitarPagamento(agendamentos.getLast().getValorAgendamento(), tipo);
                                    gerenciarAgendamentos.salvarJSONAgendamentos(agendamentos);
                                    return agendamentos;
                                }
                                case 4 -> {
                                    String tipo = "Dinheiro";
                                    gerenciarPagamentos.solicitarPagamento(agendamentos.getLast().getValorAgendamento(), tipo);
                                    gerenciarAgendamentos.salvarJSONAgendamentos(agendamentos);
                                    return agendamentos;
                                }
                                default -> {
                                    System.out.println("Opção inválida.");
                                    return agendamentos;
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