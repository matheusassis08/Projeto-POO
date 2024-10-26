/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * Classe para gerenciar todos os relátorios, balanços, e notas do sistema.
 */
    public class Relatorios implements Observer{
    void gerarRelatorioVenda(){
        System.out.println("\nRelatório feito.");
    }

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