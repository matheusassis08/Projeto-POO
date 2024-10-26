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
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 *
 * Classe para gerenciar todos os relátorios, balanços, e notas do sistema.
 */
    public class Relatorios implements Observer{
    
    String nome;    
    String data;
    
    
    private String FILE_RELATORIOSDIARIO = "C:\\POO\\Projeto-POO\\Academia\\src\\relatorios\\relatoriosDiarios.json";
    private Scanner scanner = new Scanner(System.in);
    private File arquivo = new File(FILE_RELATORIOSDIARIO);
    private ObjectMapper mapper = new ObjectMapper();
    
    
    
    void gerarRelatorioVenda(){
        System.out.println("\nRelatório feito.");
    }
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

    public Relatorios() {
        
    }
    
    
    
    @Override
    public void update(Observable o, Object arg) {
        String venda = String.valueOf(arg);
        if(venda.equals("Feita")){
            this.gerarRelatorioVenda();
        }
    }
}