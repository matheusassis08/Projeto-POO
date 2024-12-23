package academia;
import academia.Control.Carrinho;
import academia.Control.ComparadorPorIdCliente;
import academia.Control.CompararPorNome;
import academia.Control.GerenciarAgendamentos;
import academia.Control.GerenciarCatraca;
import academia.Control.GerenciarCliente;
import academia.Control.GerenciarDespesas;
import academia.Control.GerenciarFuncionario;
import academia.Control.GerenciarPagamentos;
import academia.Control.GerenciarProduto;
import academia.Control.GerenciarRelatorios;
import academia.Control.GerenciarSala;
import academia.Model.Gerente;
import academia.Model.Instrutor;
import academia.Control.SistemaLogin;
import academia.Model.Agendamento;
import academia.Model.Cliente;
import academia.Model.Produto;
import academia.Model.Recepcionista;
import academia.Model.RegistroDespesas;
import academia.Model.RelatorioVenda;
import academia.Model.Vendedor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
/**
 * A classe main do nosso sistema.
 */
public class Academia {
    /**
     Atributo para definir a formatação das datas(dd/MM/yyyy).
     */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    /**
     * A main do sistema
     * @param args
     */
    public static void main(String[] args) {
        //Para gerenciar entrada e saida da catraca
        GerenciarCatraca gerenciarCatraca = new GerenciarCatraca();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        boolean catr = true;

        
        //Listas para pegar a senha e login para autenticar login
        GerenciarFuncionario gerenciarFuncionario = new GerenciarFuncionario();
        List<Recepcionista> recepcionistas = gerenciarFuncionario.carregarFuncionarios(GerenciarFuncionario.getFILE_RECEPCIONISTAS(), Recepcionista.class);
        List<Instrutor> instrutores = gerenciarFuncionario.carregarFuncionarios(GerenciarFuncionario.getFILE_INSTRUTORES(), Instrutor.class);
        List<Vendedor> vendedores = gerenciarFuncionario.carregarFuncionarios(GerenciarFuncionario.getFILE_VENDEDORES(), Vendedor.class);
        List<Gerente> gerentes = gerenciarFuncionario.carregarFuncionarios(GerenciarFuncionario.getFILE_GERENTES(), Gerente.class);
        SistemaLogin sistemaLogin = new SistemaLogin(gerentes, instrutores, vendedores, recepcionistas);
        
        //Verificando e autenticando login, e dependendo do tipo de funcionario mostra os acessos disponiveis do sistema
        System.out.println("Qual o login para acesso?");
        String login = scanner.nextLine();
        System.out.println("Qual a senha para acesso?");
        String senha = scanner.nextLine();
        sistemaLogin.verificarLogin(login, senha);
        if(sistemaLogin.verificarLogin(login, senha)==true){
            //acesso do Gerente
            if(sistemaLogin.getTipoFuncionario().equalsIgnoreCase("Gerente")){
                while (continuar) {
                    System.out.println("""
                                       Qual opção você deseja acessar?
                                       1. Clientes
                                       2. Produtos
                                       3. Realizar Venda
                                       4. Agendamentos e Mensalidades
                                       5. Relatórios
                                       6. Instrutor
                                       7. Funcionários
                                       8. Despesas
                                       9. Balanços
                                       10. Catraca
                                       11. Exibir Salas
                                       12. Questão 13, Comparator Agendamento/Cliente
                                       13. Questão 12, Método de classe para ver instâncias de clientes/produtos
                                       14. Questão 11, Dois tipos Variaveis private e protected.
                                       15. Questão 15, Instanciar um iterator para a arraylist
                                       16. Questão 16, Apresentar no main testes do comparator implementado.
                                       17. Questão 17, Criar um método find para clientes utilizando o interator e comparator.
                                       18. Sair""");

                    int n = scanner.nextInt();

                    switch (n) {
                        case 1 -> {
                            System.out.println("""
                                               1. Adicionar Cliente
                                               2. Alterar Cliente
                                               3. Apagar Cliente
                                               4. Ver Despesa Diária de Cliente
                                               5. Voltar ao menu principal""");
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
                                    GerenciarCliente gerenciarCliente = new GerenciarCliente();
                                    List<Cliente> clientes = new ArrayList<>();
                                    clientes = gerenciarCliente.carregarJSONClientes(clientes);
                                    System.out.println("Qual o email do cliente para ser verificado suas despesas diárias?");
                                    scanner.nextLine();
                                    String email = scanner.nextLine();
                                    gerenciarCliente.gerarDespesasDiariasCliente(email);
                                }
                                case 5 -> {
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
                                               4. Verificar Horários
                                               5. Cadastrar novo Mensalista
                                               6. Pagar mensalidade
                                               7. Voltar ao menu principal""");
                            n = scanner.nextInt();
                            switch (n) {
                                case 1 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    gerenciarAgendamentos.realizarAgendamentoPrevio();
                                }
                                case 2 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    gerenciarAgendamentos.confimarAgendamentoPrevio();
                                }
                                case 3 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    gerenciarAgendamentos.cancelarAgendamento();
                                }
                                case 4 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    System.out.println("Qual a data que deseja verificar os horários?");
                                    LocalDate data = gerenciarAgendamentos.solicitarData();
                                    gerenciarAgendamentos.verificarVagasAgenda(data);
                                }
                                case 5 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    gerenciarAgendamentos.cadastarMensalista();
                                }
                                case 6 -> {
                                    GerenciarPagamentos gerenciarPagamentos = new GerenciarPagamentos();
                                    gerenciarPagamentos.confirmarPagamentoMensalidade();
                                }
                                case 7 -> {

                                }
                                default -> System.out.println("Opção inválida.");
                            }
                        }
                        case 5 -> {
                            System.out.println("""
                                               1. Verificar Relatórios de Vendas
                                               2. Verficar Relatórios de Agendamentos
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
                                            List<RelatorioVenda> relatoriosVendaDiario = gerenciarRelatorios.buscarRelatoriosVendaPorDia(relatoriosVenda, diaSolicitadoFormatado);
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
                                    GerenciarRelatorios gerenciarRelatorio = new GerenciarRelatorios();
                                    gerenciarRelatorio.gerarBalançoMensal();
                                }
                                case 2 -> {
                                    GerenciarRelatorios gerenciarRelatorio = new GerenciarRelatorios();
                                    gerenciarRelatorio.gerarBalançoMensalEstatisticas();

                                }
                                default -> System.out.println("Opção inválida.");
                            }
                        }
                        case 10 -> {

                                    /**
                                    * Sistema de controle de acesso da academia.
                                    */

                                    System.out.println("=== Sistema de Acesso da Academia ===");

                                    while (true) {
                                        System.out.print("Digite o ID do cliente para entrada (positivo), saída (negativo) ou 0 para encerrar: ");
                                        int idCliente = scanner.nextInt();

                                        // Verifica se o usuário deseja encerrar o sistema
                                        if (idCliente == 0) {
                                            System.out.println("Encerrando sistema...");
                                            break;
                                        }

                                        // Condição para registrar entrada (ID positivo)
                                        if (idCliente > 0) {
                                            if (gerenciarCatraca.validarAcessoPorId(idCliente)) {
                                                gerenciarCatraca.registrarEntrada(idCliente);
                                            } else {
                                                System.out.println("Acesso negado. ID inválido.");
                                            }
                                        } else {
                                            // Condição para registrar saída (ID negativo)
                                            gerenciarCatraca.registrarSaida(-idCliente);
                                        }
                                    }
                                }
                        case 11 -> {
                        System.out.println(GerenciarSala.getSalas());
                        }
                        case 12 -> {
                            System.out.println("Questão 13: ");
                            GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                            List<Agendamento> agendamentos = new ArrayList<>();
                            agendamentos = gerenciarAgendamentos.carregarJSONAgendamentos();

                            GerenciarCliente gerenciarClientes = new GerenciarCliente();
                            List<Cliente> clientes = new ArrayList<>();
                            clientes = gerenciarClientes.carregarJSONClientes(clientes);

                            System.out.println("Comparando valores de agendamento(1 maior, 2 menor, 0 igual):  " + gerenciarAgendamentos.compararPorValor().comparar(agendamentos.getLast(), agendamentos.getFirst()));
                            System.out.println("Comparando id de clientes(1 maior, 2 menor, 0 igual): " + gerenciarClientes.compararPorId().comparar(clientes.getFirst(), clientes.getLast()));
                        }
                        case 13 -> {
                            System.out.println("Questão 12: ");
                            System.out.println(instanciasDeClientesEProdutos());
                        }
                        case 14 -> {
                            System.out.println("Questão 11: ");
                            System.out.println("Numero de Instancias(Private): " + Cliente.getInstanciasClientes());
                            System.out.println("Numero de Instancias(Protected): " + Cliente.getInstanciasClientesProtected());
                            //O private tem acesso em outras classe apenas com o get, o protected em suas subclasses não é necessario uso de get.
                        }
                        case 15 -> {
                            //Percorrendo todo os clientes a partir do Iterator
                             System.out.println("Percorrendo com Iterator: \n");
                            List<Cliente> clientes = new ArrayList<>();
                            clientes = new GerenciarCliente().carregarJSONClientes(clientes);

                            Iterator<Cliente> iterator = clientes.iterator();
                            while(iterator.hasNext()){
                                imprimir(iterator.next());
                            }

                            System.out.println("\nAgora percorrendo com o for-each: \n");
                            clientes.forEach(System.out::println);

                        }
                        case 16 -> {
                            List<Cliente> clientes = new ArrayList<>();
                            clientes = new GerenciarCliente().carregarJSONClientes(clientes);

                            GerenciarCliente gerenciarCliente = new GerenciarCliente();
                            // Ordenando por idCliente
                            ComparadorPorIdCliente comparatorPorIdCliente = new ComparadorPorIdCliente();
                            Collections.sort(clientes, comparatorPorIdCliente);
                            System.out.println("\nLista ordenada por ID do Cliente:");
                            clientes.forEach(System.out::println);

                            // Ordenando por nome
                            CompararPorNome compararPorNome = new CompararPorNome();
                            Collections.sort(clientes, compararPorNome);
                            System.out.println("\nLista ordenada por Nome do Cliente:");
                            clientes.forEach(System.out::println);
                        }
                        case 17 -> {
                            GerenciarCliente gerenciarCliente = new GerenciarCliente();
                            List<Cliente> clientes = new ArrayList<>();
                            clientes = gerenciarCliente.carregarJSONClientes(clientes);

                            //Buscando o cliente a partir do find com iterator e comparator implementados.
                            System.out.println("Qual o id do cliente que está buscando?");
                            scanner.nextLine();
                            int idCliente = scanner.nextInt();
                            Cliente cliente = gerenciarCliente.findPorId(idCliente, clientes, gerenciarCliente.comparatorPorId);
                            System.out.println("Cliente: " + cliente);

                            //Com Binary Search agora
                            Collections.sort(clientes, new ComparadorPorIdCliente());
                            int index = Collections.binarySearch(clientes, new Cliente("", "", "", "", "", idCliente), new ComparadorPorIdCliente());

                            if (index >= 0) {
                                System.out.println("Cliente encontrado via binarySearch: " + clientes.getFirst());
                            } else {
                                System.out.println("Cliente não encontrado via binarySearch.");
                            }

                        }
                        case 18 -> {
                            System.out.println("Encerrando o sistema...");
                            continuar = false;
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                scanner.close();
            }
            //acesso do Instrutor
            if(sistemaLogin.getTipoFuncionario().equalsIgnoreCase("Instrutor")){
                while (continuar) {
                    System.out.println("""
                                       Qual opção você deseja acessar?
                                       1. Agendamentos
                                       2. Fichas de Treino
                                       3. Sair""");

                    int n = scanner.nextInt();

                    switch (n) {
                        case 1 -> {
                            System.out.println("""
                                               1. Realizar Agendamento Prévio de Aula
                                               2. Verificar Horários
                                               3. Voltar ao menu principal""");
                            n = scanner.nextInt();
                            switch (n) {
                                case 1 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    gerenciarAgendamentos.realizarAgendamentoPrevio();
                                }
                                case 2 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    System.out.println("Qual a data que deseja verificar os horários?");
                                    LocalDate data = gerenciarAgendamentos.solicitarData();
                                    gerenciarAgendamentos.verificarVagasAgenda(data);
                                }
                                case 3 -> {

                                }
                                default -> System.out.println("Opção inválida.");
                            }
                        }
                        case 2 -> {
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
                        case 3 -> {
                            System.out.println("Encerrando o sistema...");
                            continuar = false;
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                scanner.close();
            }
            //acesso do Vendedor
            if(sistemaLogin.getTipoFuncionario().equalsIgnoreCase("Vendedor")){
                while (continuar) {
                    System.out.println("""
                                       Qual opção você deseja acessar?
                                       1. Realizar Venda
                                       3. Produtos
                                       3. Sair""");

                    int n = scanner.nextInt();

                    switch (n) {
                        case 1 -> {
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
                            System.out.println("Encerrando o sistema...");
                            continuar = false;
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                scanner.close();
            }
            //acesso do recepcionista
            if(sistemaLogin.getTipoFuncionario().equalsIgnoreCase("Recepcionista")){
                while (continuar) {
                    System.out.println("""
                                       Qual opção você deseja acessar?
                                       1. Clientes
                                       3. Agendamentos e Mensalidades
                                       3. Catraca
                                       4. Sair""");

                    int n = scanner.nextInt();

                    switch (n) {
                        case 1 -> {
                            System.out.println("""
                                               1. Adicionar Cliente
                                               2. Alterar Cliente
                                               3. Apagar Cliente
                                               4. Ver Despesa Diária de Cliente
                                               5. Voltar ao menu principal""");
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
                                    GerenciarCliente gerenciarCliente = new GerenciarCliente();
                                    List<Cliente> clientes = new ArrayList<>();
                                    clientes = gerenciarCliente.carregarJSONClientes(clientes);
                                    System.out.println("Qual o email do cliente para ser verificado suas despesas diárias?");
                                    scanner.nextLine();
                                    String email = scanner.nextLine();
                                    gerenciarCliente.gerarDespesasDiariasCliente(email);
                                }
                                case 5 -> {
                                    //Volta ao menu principal
                                }
                                default -> System.out.println("Opção inválida.");
                            }
                        }
                        case 2 -> {
                            System.out.println("""
                                               1. Realizar Agendamento Prévio de Aula
                                               2. Confirmar Agendamento Prévio
                                               3. Cancelar Agendamento
                                               4. Verificar Horários
                                               5. Cadastrar novo Mensalista
                                               6. Pagar mensalidade
                                               7. Voltar ao menu principal""");
                            n = scanner.nextInt();
                            switch (n) {
                                case 1 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    gerenciarAgendamentos.realizarAgendamentoPrevio();
                                }
                                case 2 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    gerenciarAgendamentos.confimarAgendamentoPrevio();
                                }
                                case 3 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    gerenciarAgendamentos.cancelarAgendamento();
                                }
                                case 4 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    System.out.println("Qual a data que deseja verificar os horários?");
                                    LocalDate data = gerenciarAgendamentos.solicitarData();
                                    gerenciarAgendamentos.verificarVagasAgenda(data);
                                }
                                case 5 -> {
                                    GerenciarAgendamentos gerenciarAgendamentos = new GerenciarAgendamentos();
                                    gerenciarAgendamentos.cadastarMensalista();
                                }
                                case 6 -> {
                                    GerenciarPagamentos gerenciarPagamentos = new GerenciarPagamentos();
                                    gerenciarPagamentos.confirmarPagamentoMensalidade();
                                }
                                case 7 -> {

                                }
                                default -> System.out.println("Opção inválida.");
                            }
                        }
                                    
                        case 3 -> {
                            System.out.println("=== Sistema de Acesso da Academia ===");

                            while (true) {
                                System.out.print("Digite o ID do cliente para entrada ou saída, ou 0 para encerrar: ");
                                int idCliente = scanner.nextInt();

                                // Verifica se o usuário deseja encerrar o sistema diretamente
                                if (idCliente == 0) {
                                    System.out.println("Encerrando sistema...");
                                    break; // Encerra o loop
                                }

                                // Verifica se o cliente existe na base de dados antes de registrar a entrada ou saída
                                if (!gerenciarCatraca.validarAcessoPorId(idCliente)) {
                                    System.out.println("ID inválido ou cliente não registrado.");
                                    continue; // Solicita um novo ID caso o atual seja inválido
                                }

                                // Se o cliente já está na academia, registra a saída; caso contrário, registra a entrada
                                gerenciarCatraca.registrarEntrada(idCliente);

                                // Encerra o loop após o registro de entrada ou saída
                                break;
                            }

                            scanner.close();
                        }

                                   
                        
                        case 4 -> {
                            System.out.println("Encerrando o sistema...");
                            continuar = false;
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                scanner.close();
            }
        }else{
            System.out.println("Login inválido");
        }
        scanner.close();
    }
    
    public static DateTimeFormatter getDATE_FORMATTER() {
        return DATE_FORMATTER;
    }
    
    public static DateTimeFormatter getTIME_FORMATTER() {
        return TIME_FORMATTER;
    }
    
    public static String instanciasDeClientesEProdutos(){
        int instanciasClientes = Cliente.getInstanciasClientes();
        int instanciasProdutos = Produto.getInstanciasProdutos();
        String resultado = "A quantidade de instancias de Clientes e de : " + instanciasClientes + "\nA quantidade de instancias de Produtos e de: " + instanciasProdutos;
        return resultado;
    }
    
    private static void imprimir(Cliente cliente){
        System.out.println(cliente);
    }
    
}