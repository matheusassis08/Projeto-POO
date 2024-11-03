package academia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * Classe para gerenciar todos os relátorios, balanços, e notas do sistema.
 */
    public class GerenciarRelatorios implements PadraoObserver{
        
    private final String FILE_RELATORIOSVENDA = "C:\\POO\\Projeto-POO\\Academia\\src\\relatorios\\relatoriosVenda.json";
    private final String FILE_RELATORIOSAGENDAMENTO = "C:\\POO\\Projeto-POO\\Academia\\src\\relatorios\\relatoriosAgendamento.json";
    String estado;
    //só essa^
    
    
    private final Scanner scanner = new Scanner(System.in);
    private final File arquivoRelatoriosVenda = new File(FILE_RELATORIOSVENDA);
    private final File arquivoRelatoriosAgendamento = new File(FILE_RELATORIOSAGENDAMENTO);
    private final ObjectMapper mapper = new ObjectMapper();
    

    public GerenciarRelatorios() {
        
    }
    /**
     * Metodo para carrega a lista de todos RelatorioVenda
     * @param relatoriosVenda
     * @return List RelatorioVenda
     */
    public List<RelatorioVenda> carregarJSONRelatorioVenda(List<RelatorioVenda> relatoriosVenda){
        if (arquivoRelatoriosVenda.exists()) {
            try {
                relatoriosVenda = mapper.readValue(arquivoRelatoriosVenda, new TypeReference<List<RelatorioVenda>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return relatoriosVenda;
    }
    
    /**
     * Método para salvar o JSON dos relatorios de venda.
     * @param relatoriosVenda
     */
    public void salvarJSONRelatorioVenda(List<RelatorioVenda> relatoriosVenda){
        try {
            mapper.writeValue(arquivoRelatoriosVenda, relatoriosVenda);
            System.out.println("Produtos salvos no arquivo: " + arquivoRelatoriosVenda.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método para gerar um id de relatorio unico para cada relatorio novo.
     * @return int idRelatorio
     */
    public int gerarIdRelatorio(){
        Random random = new Random();
        List<RelatorioVenda> relatoriosVenda = new ArrayList<>();
        GerenciarRelatorios gerenciarRelatorios = new GerenciarRelatorios();
        relatoriosVenda = gerenciarRelatorios.carregarJSONRelatorioVenda(relatoriosVenda);

        int idRelatorio;
        List<Integer> numerosPedidos = new ArrayList<>();
        
        for (RelatorioVenda relatorio : relatoriosVenda) {
            numerosPedidos.add(relatorio.getIdRelatorio());
        }

        do {
            idRelatorio = random.nextInt(100000);
        } while (numerosPedidos.contains(idRelatorio));

        return idRelatorio;
    }
    /**
     * Método que busca e retorna todos relátorios de determinada dia.
     * @param relatorios
     * @param data
     * @return List RelatorioVenda
     */
    public List<RelatorioVenda> buscarRelatoriosVendaPorDia(List<RelatorioVenda> relatorios, String data) {
        return relatorios.stream()
                .filter(relatorio -> relatorio.getDataDeRealizacao().equals(data))
                .collect(Collectors.toList());
    }
    
    public void gerarRelotorioVenda(String nome, String dataDeRealizacao, String horarioDeRealizacao, int idRelatorio,int numeroPedido, double valorTotalPedido, String nomeCliente, String emailCliente, List<String> nomeProdutos, List<Double> valorUnitarioItemsPedido, List<Integer> codigoProdutosPedido){
        List<RelatorioVenda> relatoriosVenda = new ArrayList<>();
        carregarJSONRelatorioVenda(relatoriosVenda);
        
        RelatorioVenda relatorioVenda = new RelatorioVenda(nome, dataDeRealizacao, horarioDeRealizacao, idRelatorio, numeroPedido, valorTotalPedido, nomeCliente, emailCliente, nomeProdutos, valorUnitarioItemsPedido, codigoProdutosPedido);
        relatoriosVenda.add(relatorioVenda);
        
        salvarJSONRelatorioVenda(relatoriosVenda);
    }
    
    /**
     * Método para buscar relatorio de Vendas Mensais a partir de determinado mês e ano.
     * @param relatorios
     * @param mes
     * @param ano
     * @return List RelatorioVenda
     */
    public List<RelatorioVenda> buscarRelatorioVendaMensal(List<RelatorioVenda> relatorios, int mes, int ano) {
        return relatorios.stream()
                .filter(relatorio -> {
                    String[] partesData = relatorio.getDataDeRealizacao().split("/");
                    int mesRelatorio = Integer.parseInt(partesData[1]);
                    int anoRelatorio = Integer.parseInt(partesData[2]);
                    return mesRelatorio == mes && anoRelatorio == ano;
                })
                .collect(Collectors.toList());
    }
    /**
     * Método para gerar o relatorio de Pagamento de Um Agendamento.
     * @param nomeCliente
     * @param idCliente
     * @param nomeInstrutor
     * @param idInstrutor
     * @param tipoAula
     * @param valor
     * @param nome
     * @param dataDeRealizacao
     * @param horarioDeRealizacao
     * @param idRelatorio
     * @return List RelatorioAgendamento
     */
    public List<RelatorioAgendamento> gerarRelatorioPagamentoAgendamento(String nomeCliente, int idCliente, String nomeInstrutor, int idInstrutor, String tipoAula, double valor, String nome, String dataDeRealizacao, String horarioDeRealizacao, int idRelatorio){
        List<RelatorioAgendamento> relatoriosAgendamentos = new ArrayList<>();
        relatoriosAgendamentos = carregarJSONRelatorioAgendamento(relatoriosAgendamentos);
        
        RelatorioAgendamento relatorioAgendamento = new RelatorioAgendamento(nomeCliente, idCliente, nomeInstrutor, idInstrutor, tipoAula, valor, nome, dataDeRealizacao, horarioDeRealizacao, idRelatorio);
        relatoriosAgendamentos.add(relatorioAgendamento);
        salvarJSONRelatorioAgendamento(relatoriosAgendamentos);
        
        return relatoriosAgendamentos;
    }
    /**
     * Método para carregar todos os JSONs de Relatorios de Agendamento
     * @param relatoriosAgendamentos
     * @return List RelatorioAgendamento
     */
    public List<RelatorioAgendamento> carregarJSONRelatorioAgendamento(List<RelatorioAgendamento> relatoriosAgendamentos){
        if (arquivoRelatoriosVenda.exists()) {
            try {
                relatoriosAgendamentos = mapper.readValue(arquivoRelatoriosAgendamento, new TypeReference<List<RelatorioAgendamento>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return relatoriosAgendamentos;
    }
    /**
     * Método para salvar os JSONs dos Relatorios de Agendamento.
     * @param relatoriosAgendamentos
     */
    public void salvarJSONRelatorioAgendamento(List<RelatorioAgendamento> relatoriosAgendamentos){
        try {
            mapper.writeValue(arquivoRelatoriosAgendamento, relatoriosAgendamentos);
            System.out.println("Produtos salvos no arquivo: " + arquivoRelatoriosAgendamento.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<RelatorioAgendamento> buscarRelatorioAgendamentoMensal(List<RelatorioAgendamento> relatorios, int mes, int ano) {
        return relatorios.stream()
                .filter(relatorio -> {
                    String[] partesData = relatorio.getDataDeRealizacao().split("/");
                    int mesRelatorio = Integer.parseInt(partesData[1]);
                    int anoRelatorio = Integer.parseInt(partesData[2]);
                    return mesRelatorio == mes && anoRelatorio == ano;
                })
                .collect(Collectors.toList());
    }
    
    /**
     * Calcula e retorna o balanço mensal de determinado mês informado.
     */
    public void geraBalançoMensal(){
        
        List<RelatorioAgendamento> relatoriosAgendamentos = new ArrayList<>();
        List<RelatorioVenda> relatoriosVendas = new ArrayList<>();
        List<RegistroDespesas> registrosDespesas = new ArrayList<>();
        GerenciarDespesas gerenciarDespesas = new GerenciarDespesas();
        relatoriosVendas = carregarJSONRelatorioVenda(relatoriosVendas);
        relatoriosAgendamentos = carregarJSONRelatorioAgendamento(relatoriosAgendamentos);
        registrosDespesas = gerenciarDespesas.carregarJSONRegistroDespesas(registrosDespesas);
        
        System.out.println("Qual o ano do balanço desejado: ");
        int mes = scanner.nextInt();
        System.out.println("Qual o mês do balanço desejado: ");
        int ano = scanner.nextInt();
        
        relatoriosVendas = carregarJSONRelatorioVenda(relatoriosVendas);
        relatoriosVendas = buscarRelatorioVendaMensal(relatoriosVendas, mes, ano);
        relatoriosAgendamentos = buscarRelatorioAgendamentoMensal(relatoriosAgendamentos, mes, ano);
        registrosDespesas = gerenciarDespesas.buscarDespesasMensais(registrosDespesas, mes, ano);
        
        double valorReceitas = somarValores(relatoriosVendas, RelatorioVenda::getValor) + somarValores(relatoriosAgendamentos, RelatorioAgendamento::getValor);
        double valorDespesas = somarValores(registrosDespesas, RegistroDespesas::getValor);
        
        double valorBalanço = valorReceitas - valorDespesas;
        System.out.println("O seu balanço mensal de "+ mes + "/" + ano + ". Foi de: " + valorBalanço + "R$.");
    }
    
    /**
     * Método para somar 
     * @param <T>
     * @param lista
     * @param valorExtractor
     * @return valor
     */
    public <T> double somarValores(List<T> lista, Function<T, Double> valorExtractor) {
        return lista.stream()
                    .mapToDouble(valorExtractor::apply) // usa a função para extrair o valor
                    .sum();
    }
    
    
    @Override
    public void update(PadraoObservable o, Object arg){
        Carrinho carrinho = (Carrinho)o;
        estado = String.valueOf(arg);
        if(estado.equals("Feita")){
            
        }
        if(estado.equals("Cancelada")){
            
        }
     }
}