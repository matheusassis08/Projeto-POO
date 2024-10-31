/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * Classe para gerenciar todos os relátorios, balanços, e notas do sistema.
 */
    public class GerenciarRelatorios implements PadraoObserver{
        
    private final String FILE_RELATORIOSVENDA = "C:\\POO\\Projeto-POO\\Academia\\src\\relatorios\\relatoriosVenda.json";
    String estado;
    //só essa^
    
    
    private Scanner scanner = new Scanner(System.in);
    private File arquivoRelatoriosVenda = new File(FILE_RELATORIOSVENDA);
    private ObjectMapper mapper = new ObjectMapper();
    
    /*
    public void gerarRelatorioPedido(){
        if (arquivoRelatoriosVenda.exists()) {
            try {
                clientes = mapper.readValue(arquivoRelatoriosVenda, new TypeReference<List<Cliente>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    public GerenciarRelatorios() {
        
    }
    
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
    
    public void gerarRelotorioVenda(String nome, String dataDeRealizacao, String horarioDeRealizacao, int idRelatorio,int numeroPedido, double valorTotalPedido, String nomeCliente, String emailCliente, List<String> nomeProdutos, List<Double> valorUnitarioItemsPedido, List<Integer> codigoProdutosPedido){
        List<RelatorioVenda> relatoriosVenda = new ArrayList<>();
        carregarJSONRelatorioVenda(relatoriosVenda);
        
        RelatorioVenda relatorioVenda = new RelatorioVenda(nome, dataDeRealizacao, horarioDeRealizacao, idRelatorio, numeroPedido, valorTotalPedido, nomeCliente, emailCliente, nomeProdutos, valorUnitarioItemsPedido, codigoProdutosPedido);
        relatoriosVenda.add(relatorioVenda);
        
        salvarJSONRelatorioVenda(relatoriosVenda);
    }
    
    public void GerarRelatorioCancelamentoVenda(){
        System.out.println("Relatório de venda cancelada gerado.\n");
    }
    
    
    
    @Override
    public void update(PadraoObservable o, Object arg){
        Carrinho carrinho = (Carrinho)o;
        estado = String.valueOf(arg);
        if(estado.equals("Feita")){
            
        }
        if(estado.equals("Cancelada")){
            this.GerarRelatorioCancelamentoVenda();
        }
     }
}