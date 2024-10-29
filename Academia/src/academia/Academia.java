package academia;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("""
                               Qual opção você deseja acessar?
                               1. Clientes
                               2. Produtos
                               3. Realizar Venda
                               4. Agendamentos
                               5. Relatórios
                               6. Instrutor
                               7. Funcionários
                               8. Sair""");
            
            int n = scanner.nextInt();

            switch (n) {
                case 1 -> {
                    System.out.println("""
                                       1. Adicionar Cliente
                                       2. Alterar Cliente
                                       3. Apagar Cliente
                                       4. Voltar ao menu principal""");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            GerenciarCliente cadastroCliente = new GerenciarCliente();
                            cadastroCliente.realizarCadastro();
                        }
                        case 2 -> {
                            GerenciarCliente cadastroCliente = new GerenciarCliente();
                            cadastroCliente.alterarCadastro();
                        }
                        case 3 -> {
                            GerenciarCliente cadastroCliente = new GerenciarCliente();
                            cadastroCliente.apagarCadastro();
                        }
                        case 4 -> {
                            //Volta ao menu principal
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 2 -> {
                    System.out.println("""
                                        1. Adicionar Produto
                                        2. Alterar Produto
                                        3. Apagar Produto
                                        4. Verificar Estoque
                                        5. Adicionar Cliente a Fila de Espera de Produto
                                        6. Voltar ao menu principal""");
                    n = scanner.nextInt();
                    scanner.nextLine();
                    switch (n) {
                        case 1 -> {
                            /*GerenciarProduto cadastroProduto = new GerenciarProduto();
                            cadastroProduto.realizarCadastro();*/
                            
                        }
                        case 2 -> {
                            GerenciarProduto cadastroProduto = new GerenciarProduto();
                            cadastroProduto.alterarCadastro();
                        }
                        case 3 -> {
                            GerenciarProduto cadastroProduto = new GerenciarProduto();
                            cadastroProduto.apagarCadastro();
                        }
                        case 4 -> {
                            GerenciarProduto cadastroProduto = new GerenciarProduto();
                            System.out.println("Informe o codigo do produto que deseja saber a quantidade em estoque: ");
                            int j;
                            do{
                            int c = scanner.nextInt();
                            scanner.nextLine();
                            cadastroProduto.verificarEstoque(c);
                            System.out.println("Pressione 0 para voltar.");
                            j = scanner.nextInt();
                            } while(j!=0);
                        }
                        case 5 -> {
                            GerenciarProduto cadastroProduto = new GerenciarProduto();
                            cadastroProduto.adicionarClienteFila();
                        }
                        case 6 -> {
                            
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 3 -> {
                    boolean finalizar = true;
                    Carrinho carrinho = new Carrinho();
                    List<Carrinho> carrinhos = new ArrayList<>();
                    
                    do{
                    System.out.println("""
                                       1. Adicionar Produto ao Carrinho
                                       2. Remover Produto Do Carrinho
                                       3. Verificar Valor Total Do Pedido
                                       4. Verificar Produtos no Pedido
                                       5. Cancelar Pedido
                                       6. Finalizar Pedido""");
                    n = scanner.nextInt();
                    scanner.nextLine();
                    switch (n) {
                        case 1 -> {
                            carrinhos = carrinho.adicionarProduto(carrinhos);
                        }
                        case 2 -> {
                            System.out.println("Qual o código do produto deseja remover do carrinho? ");
                            int codigoRemover = scanner.nextInt();
                            scanner.nextLine();

                            carrinhos.removeIf(carrinhoItem -> carrinhoItem.getCodigoItem() == codigoRemover);
                            System.out.println("Produto removido do carrinho.");
                        }
                        case 3 -> {
                            System.out.println("O valor total dos produtos é de: " + carrinho.somarPedido(carrinhos));
                            scanner.nextLine();
                        }
                        case 4 -> {
                            System.out.println("Produtos no carrinho: " + carrinhos);
                        }
                        case 5 -> {
                            finalizar = false;
                        }
                        case 6 -> {
                            GerenciarPagamentos gerenciarPagamento = new GerenciarPagamentos();
                            gerenciarPagamento.solicitarPagamento(carrinho.somarPedido(carrinhos));
                            GerenciarProduto gerenciarProduto = new GerenciarProduto();
                            GerenciarRelatorios gerenciarRelatorios = new GerenciarRelatorios();
                            GerenciarFuncionario gerenciarFuncionario = new GerenciarFuncionario();
                            
                            carrinho.adicionarObserver(gerenciarProduto);
                            carrinho.adicionarObserver(gerenciarRelatorios);
                            carrinho.adicionarObserver(gerenciarFuncionario);
                            
                            carrinho.finalizarPedido();
                        }
                        default -> System.out.println("Opção inválida.");
                    }} while(finalizar==true);
                }
                case 4 -> {
                    System.out.println("""
                                       1. Agendar Horário
                                       2. Verificar Horários
                                       3. Cancelar Agendamento
                                       4. Voltar ao menu principal""");
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
                    System.out.println("""
                                       1. Verificar Relatórios
                                       2. Balanços
                                       3. Voltar ao menu principal""");
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
                    System.out.println("""
                                       1. Gerar Ficha
                                       2. Alterar Ficha
                                       3. Excluir Ficha
                                       4. Voltar ao menu principal""");
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
                    System.out.println("""
                                       1. Cadastrar Funcionário\n
                                       2. Alterar cadastro de Funcionário\n
                                       3. Excluir cadastro de Funcionário\n
                                       4. Voltar ao menu principal""");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            GerenciarFuncionario cadastroFuncionario = new GerenciarFuncionario();
                            cadastroFuncionario.realizarCadastro();
                        }
                        case 2 -> {
                            GerenciarFuncionario cadastroFuncionario = new GerenciarFuncionario();
                            cadastroFuncionario.alterarCadastro();
                        }
                        case 3 -> {
                            GerenciarFuncionario cadastroFuncionario = new GerenciarFuncionario();
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

    public Academia() {
    }

    public static DateTimeFormatter getDATE_FORMATTER() {
        return DATE_FORMATTER;
    }

    public static DateTimeFormatter getTIME_FORMATTER() {
        return TIME_FORMATTER;
    }
    
    
}