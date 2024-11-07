package academia.Control;

import academia.Academia;
import academia.Model.Agendamento;
import academia.Model.Cliente;
import academia.Model.Mensalidade;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Classe para realizar ou gerenciar pagamentos.
 */
public class GerenciarPagamentos{
    
    private final Scanner scanner = new Scanner(System.in);
    
    /**
     * Autentica o pagamento
     * @param valor
     * @param tipo
     */
    public void autenticarPagamento(Double valor, String tipo){
        System.out.println("Pagamento em "+ tipo +" no valor de " + valor + " confirmado.");
    }
    
    /**
     * Para autenticar o pagamento de cartão
     * @param numeroCartao
     * @param valor
     */
    public void autenticarPagamentoCartao(int numeroCartao, double valor){
        System.out.println("Pagamento no cartão confirmado.");
    }
    
    /**
     * Verifica e confirma se o pagamento foi feito
     */
    public void confirmarPagamento(){
        System.out.println("Pagamento confirmado com sucesso.");
    }
    
    
    /**
     * Solicita o pagamento
     * @param valor
     * @param tipo
     */
    public void solicitarPagamento(double valor, String tipo){
        confirmarPagamento();
    }
    
    /**
     * Para solicitar o pagamento de agendamento
     * @param agendamento
     * @return Agendamento
     */
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
    
    /**
     * Para confimar um agendamento de alguma mensalidade de um cliente especificado
     */
    public void confirmarPagamentoMensalidade() {
        System.out.println("Informe o e-mail do cliente para cadastrar sua mensalidade: ");
        String email = scanner.nextLine();
        GerenciarCliente gerenciarCliente = new GerenciarCliente();
        GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
        GerenciarRelatorios gerenciarRelatorios = new GerenciarRelatorios();
        List<Cliente> clientes = gerenciarCliente.carregarJSONClientes(new ArrayList<>());
        Optional<Cliente> cliente = gerenciarCliente.buscarClientePorEmail(clientes, email);
        if (cliente.isEmpty()) {
            System.out.println("Cliente com e-mail " + email + " não encontrado.");
            return;
        }
        int idCliente = cliente.get().getIdCliente();

        
        List<Mensalidade> mensalidades = gerenciarAgendamentos.carregarJSONMensalidades();
        List<Mensalidade> mensalidadesCliente = mensalidades.stream()
            .filter(mensalidade -> mensalidade.getIdCliente() == idCliente)
            .collect(Collectors.toList());

        if (mensalidadesCliente.isEmpty()) {
            System.out.println("Nenhuma mensalidade encontrada para o cliente com ID: " + idCliente);
        } else {
            System.out.println("Mensalidades do cliente " + cliente.get().getNome() + ":");
            mensalidadesCliente.forEach(mensalidade -> {
                if (mensalidade.getMesesEmAberto() > 0) {
                    mensalidade.setMesesEmAberto(mensalidade.getMesesEmAberto() - 1);
                    gerenciarAgendamentos.salvarJSONMensalidades(mensalidades);
                }
                System.out.println("Mensalidade atualizada: " + mensalidade);
            });
        }
        
        LocalTime horaAtual = LocalTime.now();
       //hora formatada para hora:minuto:segundo
        String horarioRealizacao = horaAtual.format(Academia.getTIME_FORMATTER());
                            
        LocalDate dataAtual = LocalDate.now();
        //Formata a data para (dia/mes/ano)
        String dataRealizacao = dataAtual.format(Academia.getDATE_FORMATTER());
        
        
        // gerando relatorio do pagamento de mensalidade
        GerenciarRelatorios gerenciarRelatorio = new GerenciarRelatorios();
        gerenciarRelatorio.gerarRelatorioPagamentoMensalidades(cliente.get().getNome(), idCliente, mensalidadesCliente.getFirst().getValor(), "Relátorio de Pagamento De Agendamento", dataRealizacao, horarioRealizacao, gerenciarRelatorio.gerarIdRelatorio());
    }
    
    public GerenciarPagamentos() {
    }
    
    @Override
    public String toString() {
        return "GerenciarPagamentos{" + '}';
    }
}