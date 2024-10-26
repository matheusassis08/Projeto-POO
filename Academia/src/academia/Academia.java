/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academia;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Academia {
    
    /**
     Atributo para definir a formatação das datas(dd/MM/yyyy).
     */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    
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
            System.out.println("7. Funcionários");
            System.out.println("8. Sair");
            
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
                    scanner.nextLine();
                    switch (n) {
                        case 1 -> {
                            CadastroProduto cadastroProduto = new CadastroProduto();
                            cadastroProduto.realizarCadastro();
                        }
                        case 2 -> {
                            CadastroProduto cadastroProduto = new CadastroProduto();
                            cadastroProduto.alterarCadastro();
                        }
                        case 3 -> {
                            CadastroProduto cadastroProduto = new CadastroProduto();
                            cadastroProduto.apagarCadastro();
                        }
                        case 4 -> {
                            CadastroProduto cadastroProduto = new CadastroProduto();
                            System.out.println("Informe o codigo do produto que deseja saber a quantidade em estoque: ");
                            int j;
                            do{
                            String c = scanner.nextLine();
                            cadastroProduto.verificarEstoque(c);
                            System.out.println("Pressione 0 para voltar.");
                            j = scanner.nextInt();
                            } while(j!=0);
                        }
                        case 5 -> {
                            
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 3 -> {
                    
                }
                case 4 -> {
                    System.out.println("1. Agendar Horário\n2. Verificar Horários\n3. Cancelar Agendamento\n4. Voltar ao menu principal");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            Agendamentos agendamentos = new Agendamentos();
                            agendamentos.realizarAgendamento();
                        }
                        case 2 -> {
                            
                        }
                        case 3 -> {
                            
                        }
                        case 4 -> {
                            
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 5 -> {
                    System.out.println("1. Verificar Relatórios\n2. Balanços\n3. Voltar ao menu principal");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            
                        }
                        case 2 -> {
                            
                        }
                        case 3 -> {
                            
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 6 -> {
                    System.out.println("1. Gerar Ficha\n2. Alterar Ficha\n3. Excluir Ficha\n4. Voltar ao menu principal");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            
                        }
                        case 2 -> {
                            
                        }
                        case 3 -> {
                            
                        }
                        case 4 -> {
                            
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 7 -> {
                    System.out.println("1. Cadastrar Funcionário\n2. Alterar cadastro de Funcionário\n3. Excluir cadastro de Funcionário\n4. Voltar ao menu principal");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
                            cadastroFuncionario.realizarCadastro();
                        }
                        case 2 -> {
                            CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
                            cadastroFuncionario.alterarCadastro();
                        }
                        case 3 -> {
                            CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
                            cadastroFuncionario.apagarCadastro();
                        }
                        case 4 -> {
                            
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 8 -> {
                    System.out.println("Encerrando o sistema...");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    public static DateTimeFormatter getDATE_FORMATTER() {
        return DATE_FORMATTER;
    }

    public static DateTimeFormatter getTIME_FORMATTER() {
        return TIME_FORMATTER;
    }
    
    
}