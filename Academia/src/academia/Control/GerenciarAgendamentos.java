package academia.Control;

import academia.Academia;
import academia.Model.Agendamento;
import academia.Model.Cliente;
import academia.Model.Mensalidade;
import academia.Model.RegistroDespesas;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Classe para administrar os agendamentos das aulas
 */
public class GerenciarAgendamentos{
    private static final String FILE_AGENDAMENTOS = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\agendamentos.json";
    private static final String FILE_MENSALIDADES = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\mensalidades.json";
    
    private final Scanner scanner = new Scanner(System.in);
    private final ObjectMapper mapper = new ObjectMapper();
    
    /** 
     * Para agendar um horário para um aluno ter aula
     */
    public void realizarAgendamentoPrevio() {
        System.out.println("Informe o e-mail do cliente para o agendamento: ");
        String email = scanner.nextLine();
        GerenciarCliente gerenciarCliente = new GerenciarCliente();
        List<Cliente> clientes = new ArrayList<>();
        clientes = gerenciarCliente.carregarJSONClientes(clientes);
        
        Optional<Cliente> cliente = gerenciarCliente.buscarClientePorEmail(clientes, email);
        if (cliente == null) {
            System.out.println("Cliente com e-mail " + email + " não encontrado.");
            return;
        }
        LocalDate dataIn = solicitarData();
        String data = dataIn.format(Academia.getDATE_FORMATTER());
        
        LocalTime horarioIn = solicitarHorario();
        String horario = horarioIn.format(Academia.getTIME_FORMATTER());
        
        List<Agendamento> agendamentos = carregarJSONAgendamentos();
        
        System.out.println("Qual o tipo de aula desejada?");
        String tipoDeAulaIn = scanner.nextLine();
        
        System.out.println("Qual o nome do instrutor designado para a aula?");
        String nomeInstrutorIn = scanner.nextLine();
        
        System.out.println("Qual o id do instrutor designado para a aula?");
        int idInstrutorIn = scanner.nextInt();
        
        System.out.println("Qual o valor do agendamento da aula?");
        double valorAgendamentoIn = scanner.nextDouble();
        GerenciarPagamentos gerenciarPagamentos = new GerenciarPagamentos();
        GerenciarRelatorios gerenciarRelatorios = new GerenciarRelatorios();
        
        Agendamento agendamento = new Agendamento(data, horario, cliente.get().getNome(), cliente.get().getEmail(), cliente.get().getIdCliente(), nomeInstrutorIn, idInstrutorIn, tipoDeAulaIn, valorAgendamentoIn, false);
        agendamentos.add(gerenciarPagamentos.solicitarPagamentoAgendamento(agendamento));
        LocalTime horaAtual = LocalTime.now();
       //hora formatada para hora:minuto:segundo
        String horarioDeRealizacao = horaAtual.format(Academia.getTIME_FORMATTER());
                            
        LocalDate dataAtual = LocalDate.now();
        //Formata a data para (dia/mes/ano)
        String dataDeRealizacao = dataAtual.format(Academia.getDATE_FORMATTER());
        
        //Gerando relatorio para receita de pagamento de agendamento
        gerenciarRelatorios.gerarRelatorioPagamentoAgendamento(cliente.get().getNome(), cliente.get().getIdCliente(), nomeInstrutorIn, idInstrutorIn, tipoDeAulaIn, valorAgendamentoIn, "Relátorio Agendamento de Aula", dataDeRealizacao, horarioDeRealizacao, gerenciarRelatorios.gerarIdRelatorio());
        
        salvarJSONAgendamentos(agendamentos);
    }
    /**
     * Para confirmar um agendamento prévio mundando o confirmado para True.
     */
    public void confimarAgendamentoPrevio(){
        List<Agendamento> agendamentos = carregarJSONAgendamentos();
        
        
        System.out.println("Qual o email do cliente que deseja confirmar seu agendamento?");
        String emailIn = scanner.nextLine();
        
        Agendamento agendamento = buscarAgendamentoPorEmail(agendamentos, emailIn);
        if(agendamento==null){
            System.out.println("Agendamento não encontrado");
        }
        agendamento.setConfirmado(true);
        salvarJSONAgendamentos(agendamentos);
    }
    
    /**
     * Para cancelar o agendamento de um aula, devolvendo o valor pago caso seja antecipado a 3 dias.
     */
    public void cancelarAgendamento(){
        List<Agendamento> agendamentos = new ArrayList<>();
        agendamentos = carregarJSONAgendamentos();
        System.out.println("Qual o email do cliente para cancelar agendamento?");
        String emailCliente = scanner.nextLine();
        Agendamento agendamento = buscarAgendamentoPorEmail(agendamentos, emailCliente);
        
        LocalDate dataAgendamento = LocalDate.parse(agendamento.getData(), Academia.getDATE_FORMATTER());
        LocalDate dataAtual = LocalDate.now();
        //Formata a data para (dia/mes/ano)
        String dataDeRealizacao = dataAtual.format(Academia.getDATE_FORMATTER());
        //Para caso ser cancelado 5 dias anterior 
        if (dataAtual.isBefore(dataAgendamento.minusDays(5)) || dataAtual.equals(dataAgendamento.minusDays(3))) {
            System.out.println("Como o cancelamento de agendamento está sendo feito 5 dias anteriormente a data agendada a devolução de 50% do valor será feita.");
            LocalTime horaAtual = LocalTime.now();
            //hora formatada para hora:minuto:segundo
            String horarioDeRealizacao = horaAtual.format(Academia.getTIME_FORMATTER());

            //gerando despesa de gasto com a devolução de metade do valor do agendamento caso seja 3 dias anterior a data marcada
            GerenciarDespesas gerenciarDespesas = new GerenciarDespesas();
            List<RegistroDespesas> despesas = new ArrayList<>();
            RegistroDespesas novaDespesa = new RegistroDespesas("Devolução de metade do valor do agendamento de aula", "Cancelamento de Aula", agendamento.getValorAgendamento()/2, dataDeRealizacao, horarioDeRealizacao, gerenciarDespesas.gerarIdDespesa());

            //salvando a nova despesa de devolver metade do valor do agendamento.
            gerenciarDespesas.carregarJSONRegistroDespesas(despesas);
            despesas.add(novaDespesa);
            gerenciarDespesas.salvarJSONRegistroDespesas(despesas);
        }
        
        agendamentos.remove(agendamento);
        salvarJSONAgendamentos(agendamentos);
    }
            
    /**
     * Solicita as horas no formato (hh:mm:ss) e retorna no formato LocalTime.
     * @return LocalTime
     */
    private LocalTime solicitarHorario(){
        LocalTime horario = null;
        while (horario == null) {
            System.out.println("Digite o horário (HH:mm:ss): ");
            try {
                horario = LocalTime.parse(scanner.nextLine(), Academia.getTIME_FORMATTER());
            } catch (Exception e) {
                System.out.println("Horário inválido. Tente novamente no formato HH:mm:ss.");
            }
        }
        return horario;
    }
    
    /**
     * Solicita a data no formato (dd/mm/yyyy) e retorna no formato LocalDate.
     * @return LocalDate
     */
    public LocalDate solicitarData(){
        LocalDate data = null;
        while (data == null) {
            System.out.println("Digite o dia (dd/MM/yyyy): ");
            try {
                data = LocalDate.parse(scanner.nextLine(), Academia.getDATE_FORMATTER());
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente no formato dd/MM/yyyy.");
            }
        }
        return data;
    }
    
    /**
     * Busca um agendamento feito a partir do email informando, e a lista de clientes já carregada.
     * @param agendamentos
     * @param emailCliente
     * @return Agendamento
     */
    public Agendamento buscarAgendamentoPorEmail(List<Agendamento> agendamentos, String emailCliente) {
       for (Agendamento agendamento : agendamentos) {
           if (agendamento.getEmailCliente().equalsIgnoreCase(emailCliente)) {
               return agendamento; // Retorna o agendamento se encontrar o email correspondente
            }
        }
        return null; // Retorna null se não encontrar o email
    }
    
    /**
     * Carrega o arquivo com todos os agendamentos.
     * @return ArrayList
     */
    public List<Agendamento> carregarJSONAgendamentos() {
        File arquivo = new File(FILE_AGENDAMENTOS);
        try {
            if (arquivo.exists() && arquivo.length() > 0) {
                return mapper.readValue(arquivo, new TypeReference<List<Agendamento>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    /**
     * Carrega toda a lista de Mensalidades salvar em JSON.
     * @return List Mensalidade
     */
    public List<Mensalidade> carregarJSONMensalidades() {
        File arquivo = new File(FILE_MENSALIDADES);
        try {
            if (arquivo.exists() && arquivo.length() > 0) {
                return mapper.readValue(arquivo, new TypeReference<List<Mensalidade>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    /**
     * Salva a lista de agendamentos realizados.
     * @param agendamentos
     */
    public void salvarJSONAgendamentos(List<Agendamento> agendamentos) {
        File arquivo = new File(FILE_AGENDAMENTOS);
        try {
            mapper.writeValue(arquivo, agendamentos);
            System.out.println("Agendamentos salvos com sucesso em: " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Salva o JSON de mensalidades em um arquivo.
     * @param mensalidades
     */
    public void salvarJSONMensalidades(List<Mensalidade> mensalidades) {
        File arquivo = new File(FILE_MENSALIDADES);
        try {
            mapper.writeValue(arquivo, mensalidades);
            System.out.println("Mensalidades salvas com sucesso em: " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Verifica e imprime no terminal todas as datas que já estão marcadas;
     * @param dataSolicitada
     */
    public void verificarVagasAgenda(LocalDate dataSolicitada) {
    List<Agendamento> agendamentos = carregarJSONAgendamentos();

    // Filtra e imprime os agendamentos do dia solicitado
    agendamentos.stream()
            .filter(agendamento -> {
                LocalDate dataAgendamento = LocalDate.parse(agendamento.getData(), Academia.getDATE_FORMATTER());
                return dataAgendamento.equals(dataSolicitada);
            })
            .forEach(agendamento -> {
                System.out.println("Cliente: " + agendamento.getNomeCliente());
                System.out.println("Horário agendado: " + agendamento.getHorario());
            });
    }
    
    /**
     * Comparator para comparar os agendamentos por valor
     * @return Comparator Agendamento
     */
    public Comparator<Agendamento> compararPorValor() {
        return new Comparator<Agendamento>() {
            @Override
            public int comparar(Agendamento a1, Agendamento a2) {
                int t = 0;
                if(a1.getValorAgendamento()>a2.getValorAgendamento()){
                    t = 1;
                }
                if(a1.getValorAgendamento()<a2.getValorAgendamento()){
                    t = -1;
                }
                if(a1.getValorAgendamento()==a2.getValorAgendamento()){
                    t = 0;
                }
                return t;
            }
        };
    }
    
    /**
     * Cadastra um novo mensalista no sistema salvando em JSON o registro da mensalidade
     */
    public void cadastarMensalista() {
        System.out.println("Informe o e-mail do cliente para cadastra sua mensalidade: ");
        String email = scanner.nextLine();
        GerenciarCliente gerenciarCliente = new GerenciarCliente();
        List<Cliente> clientes = new ArrayList<>();
        clientes = gerenciarCliente.carregarJSONClientes(clientes);
        
        Optional<Cliente> cliente = gerenciarCliente.buscarClientePorEmail(clientes, email);
        if (cliente == null) {
            System.out.println("Cliente com e-mail " + email + " não encontrado.");
            return;
        }
        
        System.out.println("Qual o tipo de plano de mensalidade:\n1. Mensal(1 mes) \n2.Semestral(6 Meses) \n3. Anual(12 Meses)");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        String plano = "";
        int mesesEmAberto = 1;
        switch(escolha){
            case(1) -> {plano = "Mensal" ;mesesEmAberto = 1;}
            case(2) -> {plano = "Semestral" ;mesesEmAberto = 6;}
            case(3) -> {plano = "Anual" ;mesesEmAberto = 12;}
            default -> System.out.println("Opção Inválida!");
        }
        
        System.out.println("A partir de que mes a mensalidade será cobrada?");
        int mes = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Qual o valor de cada mensalidade?");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        
        List<Mensalidade> mensalidades = carregarJSONMensalidades();
        Mensalidade mensalistaNovo = new Mensalidade(valor, mes, cliente.get().getNome(), cliente.get().getIdCliente(), plano, mesesEmAberto);
        mensalidades.add(mensalistaNovo);
        salvarJSONMensalidades(mensalidades);
    }
    
    /**
     * Construtor padrão da classe Agendamentos.
     */
    public GerenciarAgendamentos() {
        
    }
}