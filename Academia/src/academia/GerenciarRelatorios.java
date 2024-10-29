/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Classe para gerenciar todos os relátorios, balanços, e notas do sistema.
 */
    public class GerenciarRelatorios implements PadraoObserver{
        
    private final String FILE_RELATORIOSDIARIO = "C:\\POO\\Projeto-POO\\Academia\\src\\relatorios\\relatoriosDiarios.json";
    //só essa^
    
    
    private Scanner scanner = new Scanner(System.in);
    private File arquivo = new File(FILE_RELATORIOSDIARIO);
    private ObjectMapper mapper = new ObjectMapper();
    
    /*
    public void gerarRelatorioPedido(){
        if (arquivo.exists()) {
            try {
                clientes = mapper.readValue(arquivo, new TypeReference<List<Cliente>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    public GerenciarRelatorios() {
        
    }
    
    public void gerarRelotorioVenda(){
        System.out.println("Relatório de venda gerado.");
    }
    
    public void GerarRelatorioCancelamentoVenda(){
        System.out.println("Relatório de venda cancelada gerado.\n");
    }
    
    @Override
    public void update(PadraoObservable o, Object arg){
        Carrinho carrinho = (Carrinho)o;
        String venda = String.valueOf(arg);
        if(venda.equals("Feita")){
            this.gerarRelotorioVenda();
        }
        if(venda.equals("Cancelada")){
            this.GerarRelatorioCancelamentoVenda();
        }
     }
}