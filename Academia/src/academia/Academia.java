/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academia;
import java.util.Scanner;

public class Academia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nQual opção você deseja acessar?");
            System.out.println("1. Clientes");
            System.out.println("2. Produtos");
            System.out.println("3. Realizar Venda");
            System.out.println("4. Agendamentos");
            System.out.println("5. Relatórios");
            System.out.println("6. Instrutor");
            System.out.println("7. Sair");
            
            int n = scanner.nextInt();

            switch (n) {
                case 1 -> {
                    System.out.println("1. Adicionar Cliente\n2. Alterar Cliente\n3. Apagar Cliente\n4. Voltar ao menu principal");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            CadastroCliente cadastroCliente = new CadastroCliente();
                            cadastroCliente.realizarCadastro();
                        }
                        case 2 -> {
                            CadastroCliente cadastroCliente = new CadastroCliente();
                            cadastroCliente.alterarCadastro();
                        }
                        case 3 -> {
                            CadastroCliente cadastroCliente = new CadastroCliente();
                            cadastroCliente.apagarCadastro();
                        }
                        case 4 -> {
                            //Volta ao menu principal
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 2 -> {
                    System.out.println("1. Adicionar Produto\n2. Alterar Produto\n3. Apagar Produto\n4. Verificar Estoque\n5. Voltar ao menu principal");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            // Lógica para adicionar produto
                        }
                        case 2 -> {
                            // Lógica para alterar produto
                        }
                        case 3 -> {
                            // Lógica para apagar produto
                        }
                        case 4 -> {
                            // Lógica para verificar estoque
                        }
                        case 5 -> {
                            // Volta ao menu principal
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 3 -> {
                    // Lógica para realizar venda
                }
                case 4 -> {
                    System.out.println("1. Agendar Horário\n2. Verificar Horários\n3. Cancelar Agendamento\n4. Voltar ao menu principal");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            // Lógica para agendar horário
                        }
                        case 2 -> {
                            // Lógica para verificar horários
                        }
                        case 3 -> {
                            // Lógica para cancelar agendamento
                        }
                        case 4 -> {
                            // Volta ao menu principal
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 5 -> {
                    System.out.println("1. Verificar Relatórios\n2. Balanços\n3. Voltar ao menu principal");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            // Lógica para verificar relatórios
                        }
                        case 2 -> {
                            // Lógica para balanços
                        }
                        case 3 -> {
                            // Volta ao menu principal
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 6 -> {
                    System.out.println("1. Gerar Ficha\n2. Alterar Ficha\n3. Excluir Ficha\n4. Voltar ao menu principal");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            // Lógica para gerar ficha
                        }
                        case 2 -> {
                            // Lógica para alterar ficha
                        }
                        case 3 -> {
                            // Lógica para excluir ficha
                        }
                        case 4 -> {
                            // Volta ao menu principal
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 7 -> {
                    System.out.println("Encerrando o sistema...");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}