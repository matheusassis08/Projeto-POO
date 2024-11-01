package academia;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                               8. Despesas
                               9. Balanços
                               10. Sair""");
            
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
                            GerenciarProduto cadastroProduto = new GerenciarProduto();
                            cadastroProduto.realizarCadastro();
                            
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
                    List<String> nomeProdutos = new ArrayList<>();
                    List<Double> valorUnitarioItemsPedido = new ArrayList<>();
                    List<Integer> codigoProdutosPedido = new ArrayList<>();
                    List<Carrinho> carrinhos = new ArrayList<>();
                    GerenciarRelatorios gerenciarRelatorios = new GerenciarRelatorios();
                    GerenciarCliente gerenciarCliente = new GerenciarCliente();
                    
                    
                    System.out.println("Qual o email do cliente que está comprando.");
                    scanner.nextLine();
                    String emailCliente = scanner.nextLine();
                    List<Cliente> clientes = new ArrayList<>();
                    clientes = gerenciarCliente.carregarJSONClientes(clientes);
                    Optional<Cliente> cliente = gerenciarCliente.buscarClientePorEmail(clientes, emailCliente);
                    if (cliente.isPresent()) {
                        System.out.println("Cliente encontrado: " + cliente.get().getNome());
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    
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
                            for (Carrinho item : carrinhos) {
                                if (!nomeProdutos.contains(item.getNomeItem()) || !codigoProdutosPedido.contains(item.getCodigoItem())) {
                                    nomeProdutos.add(item.getNomeItem());
                                    valorUnitarioItemsPedido.add(item.getValorItem());
                                    codigoProdutosPedido.add(item.getCodigoItem());
                                }
                            }
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
                            gerenciarPagamento.solicitarPagamento(carrinho.somarPedido(carrinhos), "");
                            
                            
                            GerenciarProduto gerenciarProduto = new GerenciarProduto();
                            GerenciarFuncionario gerenciarFuncionario = new GerenciarFuncionario();
                            //padrao de projeto observer
                            carrinho.adicionarObserver(gerenciarProduto);
                            carrinho.adicionarObserver(gerenciarFuncionario);
                            
                            LocalTime horaAtual = LocalTime.now();
                            //hora formatada para hora:minuto:segundo
                            String horarioDeRealizacao = horaAtual.format(TIME_FORMATTER);
                            
                            LocalDate dataAtual = LocalDate.now();
                            //Formata a data para (dia/mes/ano)
                            String dataDeRealizacao = dataAtual.format(DATE_FORMATTER);
                            
                            int numeroPedido = carrinho.gerarNumeroPedido();
                            int idRelatorio = gerenciarRelatorios.gerarIdRelatorio();
                            gerenciarRelatorios.gerarRelotorioVenda("Relatório de Venda", dataDeRealizacao, horarioDeRealizacao, idRelatorio, numeroPedido, carrinho.somarPedido(carrinhos), cliente.get().getNome(), cliente.get().getEmail(), nomeProdutos, valorUnitarioItemsPedido, codigoProdutosPedido);
                            System.out.println("\nO numero de observadores é de: " + carrinho.contadorObservers() + ".\n");
                            carrinho.finalizarPedido();
                            
                            finalizar= false;
                        }
                        default -> System.out.println("Opção inválida.");
                    }} while(finalizar==true);
                }
                case 4 -> {
                    System.out.println("""
                                       1. Realizar Agendamento Prévio de Aula
                                       2. Confirmar Agendamento Prévio
                                       3. Cancelar Agendamento
                                       3. Verificar Horários
                                       4. Voltar ao menu principal""");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                            gerenciarAgendamentos.realizarAgendamentoPrevio();
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
                                       1. Verificar Relatórios de Vendas
                                       2. Balanços
                                       3. Voltar ao menu principal""");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                           System.out.println("""
                                       Qual tipo de relátorio voce deseja?
                                       1. Vendas Diária
                                       2. Vendas Mensal
                                       3. Voltar ao menu principal""");
                            n = scanner.nextInt();
                            switch (n) {
                                case 1 -> {
                                    GerenciarRelatorios gerenciarRelatorios =  new GerenciarRelatorios();
                                    List<RelatorioVenda> relatoriosVenda = new ArrayList<>();
                                    relatoriosVenda = gerenciarRelatorios.carregarJSONRelatorioVenda(relatoriosVenda);
                                    System.out.println("Informe o dia:");
                                    scanner.nextLine();
                                    LocalDate diaSolicitado = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
                                    //formatando de LocalDate para String
                                    String diaSolicitadoFormatado = diaSolicitado.format(DATE_FORMATTER);
                                    List<RelatorioVenda> relatoriosVendaDiario = gerenciarRelatorios.buscarRelatoriosPorDia(relatoriosVenda, diaSolicitadoFormatado);
                                    System.out.println("o relatorio: " + relatoriosVendaDiario);
                                }
                                case 2 -> {
                                    GerenciarRelatorios gerenciarRelatorios =  new GerenciarRelatorios();
                                    List<RelatorioVenda> relatoriosVenda = new ArrayList<>();
                                    relatoriosVenda = gerenciarRelatorios.carregarJSONRelatorioVenda(relatoriosVenda);
                                    System.out.println("Informe o mes:");
                                    scanner.nextLine();
                                    int mesSolicitado = scanner.nextInt();
                                    System.out.println("Informe o ano:");
                                    scanner.nextLine();
                                    int anoSolicitado = scanner.nextInt();
                                    relatoriosVenda = gerenciarRelatorios.buscarRelatorioVendaMensal(relatoriosVenda, mesSolicitado, anoSolicitado);
                                    System.out.println(relatoriosVenda);
                                }
                                default -> System.out.println("Opção inválida.");
                            }
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
                    System.out.println("""
                                       1. Lançar Despesa
                                       2. Verificar Despesas Diárias
                                       3. Verificar Despesas Mensais
                                       4. Remover Despesa
                                       5. Voltar ao menu principal""");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            GerenciarDespesas gerenciarDespesas = new GerenciarDespesas();
                            gerenciarDespesas.gerarNovaDespesa();
                        }
                        case 2 -> {
                            GerenciarDespesas gerenciarDespesas = new GerenciarDespesas();
                            List<RegistroDespesas> registrosDespesa = new ArrayList<>();
                            registrosDespesa = gerenciarDespesas.carregarJSONRegistroDespesas(registrosDespesa);
                            System.out.println("Qual a data que voce deseja receber as despesas? ");
                            scanner.nextLine();
                            LocalDate diaSolicitado = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
                            //formatando de LocalDate para String
                            String diaSolicitadoFormatado = diaSolicitado.format(DATE_FORMATTER);
                            List<RegistroDespesas> registrosDespesaDiario = gerenciarDespesas.buscarDespesasDiarias(registrosDespesa, diaSolicitadoFormatado);
                            System.out.println("as despesas: " + registrosDespesaDiario);
                            System.out.println("O valor total das despesas do dia "+ diaSolicitado.format(DATE_FORMATTER) + ", foi de: " + gerenciarDespesas.calcularTotalDespesas(registrosDespesa));
                        }
                        case 3 -> {
                            GerenciarDespesas gerenciarDespesas = new GerenciarDespesas();
                            List<RegistroDespesas> registrosDespesa = new ArrayList<>();
                            registrosDespesa = gerenciarDespesas.carregarJSONRegistroDespesas(registrosDespesa);
                            System.out.println("Informe o mes:");
                            scanner.nextLine();
                            int mesSolicitado = scanner.nextInt();
                            System.out.println("Informe o ano:");
                            scanner.nextLine();
                            int anoSolicitado = scanner.nextInt();
                            registrosDespesa = gerenciarDespesas.buscarDespesasMensais(registrosDespesa, mesSolicitado, anoSolicitado);
                            System.out.println(registrosDespesa);
                            System.out.println("O valor total de despesas no mês "+ mesSolicitado + " foi de: " + gerenciarDespesas.calcularTotalDespesas(registrosDespesa));
                        }
                        case 4 -> {
                            GerenciarDespesas gerenciarDespesas = new GerenciarDespesas();
                            System.out.println("Qual o id da despesa que você deseja remover? ");
                            int id = scanner.nextInt();
                            gerenciarDespesas.apagarDespesa(id);
                            System.out.println("Despesa removida com sucesso");
                        }
                        case 5 -> {
                            
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 9 -> {
                    //Balanços
                    System.out.println("""
                                       1. Balanço Mensal
                                       2. Balanço Mensal com estatísticas
                                       3. Voltar ao menu principal""");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1 -> {
                            double receitasTotal;
                            double despesasTotal;
                            
                            System.out.println("Qual o ano desejado para o balanço?");
                            int ano = scanner.nextInt();
                            System.out.println("Qual o mês desejado para o balanço?");
                            int mes = scanner.nextInt();
                            
                            GerenciarRelatorios gerenciarRelatorios = new GerenciarRelatorios();
                            GerenciarDespesas gerenciarDespesas = new GerenciarDespesas();
                            
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
                case 10 -> {
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