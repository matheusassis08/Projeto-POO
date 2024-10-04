/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academia;
import java.util.Scanner;

public class Academia {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Clientes\n2.Produtos\n3.Realizar Venda\n4.Agendamentos\n5.Relatorios\n6.Instrutor");
        int n = scanner.nextInt();

        switch(n){
            case 1 -> System.out.println("1.Adicionar Cliente\n2.Alterar Cliente\n3.Apagar Cliente");
            case 2 -> System.out.println("1.Adicionar Produto\n2.Alterar Produto\n3.Apagar Produto\n4.Verificar Estoque\n");
            case 3 -> System.out.println();
            case 4 -> System.out.println("1.Agendar Horário\n2.Verificar Horários\n3.Cancelar Agendamento");
            case 5 -> System.out.println("1.Verificar Relatórios\n2.Balanços");
            case 6 -> System.out.println("1.Gerar Ficha\n2.Alterar Ficha\n3.Exlcuir Ficha");
            default -> System.out.println("Não existe essa opção");
        }

    }
}