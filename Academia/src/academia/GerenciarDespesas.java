package academia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *  Classe para gerenciar e manipular as despesas do sistema.
 */
public class GerenciarDespesas{
    private static final String FILE_REGISTRODESPESAS = "C:\\POO\\Projeto-POO\\Academia\\src\\relatorios\\despesas.json";
    ObjectMapper mapper = new ObjectMapper();
    Scanner scanner = new Scanner(System.in);
    File arquivoRegistroDespesas = new File(FILE_REGISTRODESPESAS);
    
    /**
     * Salva uma nova despesa no sistema
     */
    public void gerarNovaDespesa(){
        System.out.println("Informe a descrição da despesa: ");
        String descricaoDespesa = scanner.nextLine();
        
        System.out.println("""
                           Informe o tipo de despesa: 
                           
                           1. Manutenção de equipamento
                           2. Salário de Funcionário
                           3. Material de uso diário
                           4. Conta de serviço público
                           5. Custos com Fornecedores de Insumos
                           6. Taxas e Licenças
                           7. Despesas de Software e Sistemas
                           8. Marketing e Publicidade
                           9. Aluguel ou Financiamento do Espaço
                           10. Cancelamento de Aula
                           11. Outro""");
        String tipoDeDespesa = "";
        int n = scanner.nextInt();
        switch(n){
            case(1)-> tipoDeDespesa = "Manutenção de equipamento";
            case(2)-> tipoDeDespesa = "Salário de Funcionário";
            case(3)-> tipoDeDespesa = "Material de uso diário";
            case(4)-> tipoDeDespesa = "Conta de serviço público";
            case(5)-> tipoDeDespesa = "Custos com Fornecedores de Insumos";
            case(6)-> tipoDeDespesa = "Taxas e Licenças";
            case(7)-> tipoDeDespesa = "Despesas de Software e Sistemas";
            case(8)-> tipoDeDespesa = "Marketing e Publicidade";
            case(9)-> tipoDeDespesa = "Aluguel ou Financiamento do Espaço";
            case(10)-> tipoDeDespesa = "Cancelamento de Aula";
            case(11)-> tipoDeDespesa = "Outro";
            default -> System.out.println("Opção inválida.");
        }
        
        System.out.println("Informe o valor da despesa: ");
        scanner.nextLine();
        double valorDespesa = scanner.nextDouble();
        
        LocalDate dataAtual = LocalDate.now();
        //Formata a data para (dia/mes/ano)
        String dataPedido = dataAtual.format(Academia.getDATE_FORMATTER());
        
        LocalTime horaAtual = LocalTime.now();
        //hora formatada para hora:minuto:segundo
        String horarioPedido = horaAtual.format(Academia.getTIME_FORMATTER());
        
        
        int idDespesa = gerarIdDespesa();
        
        RegistroDespesas registroDespesa = new RegistroDespesas(descricaoDespesa, tipoDeDespesa, valorDespesa, dataPedido, horarioPedido, idDespesa);
        
        List<RegistroDespesas> registrosDespesas = new ArrayList<>();
        registrosDespesas = carregarJSONRegistroDespesas(registrosDespesas);
        registrosDespesas.add(registroDespesa);
        salvarJSONRegistroDespesas(registrosDespesas);
    }
    /**
     * Remove algum despesa que estava salva a partir do seu id.
     * @param idDespesa
     */
    public void apagarDespesa(int idDespesa){
        List<RegistroDespesas> registrosDespesas = new ArrayList<>();
        registrosDespesas = carregarJSONRegistroDespesas(registrosDespesas);
        
        boolean clienteRemovido = false;
        for (int i = 0; i < registrosDespesas.size(); i++) {
            if (registrosDespesas.get(i).getIdDespesa()==idDespesa) {
                registrosDespesas.remove(i);
                clienteRemovido = true;
                break;
            }
        }
        salvarJSONRegistroDespesas(registrosDespesas);
    }
    
    /**
     *  Método para carregar o JSON salvo de RegistroDespesas.
     *  @param registroDespesas
     *  @return registroDespesas
     */
    public List<RegistroDespesas> carregarJSONRegistroDespesas(List<RegistroDespesas> registroDespesas){
        if (arquivoRegistroDespesas.exists()) {
            try {
                registroDespesas = mapper.readValue(arquivoRegistroDespesas, new TypeReference<List<RegistroDespesas>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return registroDespesas;
    }
    
    /**
     *  Método para salvar o JSON de RegistroDespesas.
     * @param registroDespesas
     */
    public void salvarJSONRegistroDespesas(List<RegistroDespesas> registroDespesas){
        try {
            mapper.writeValue(arquivoRegistroDespesas, registroDespesas);
            System.out.println("Produtos salvos no arquivo: " + arquivoRegistroDespesas.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int gerarIdDespesa(){
        Random random = new Random();
        List<RegistroDespesas> registroDespesas = new ArrayList<>();
        GerenciarDespesas gerenciarDespesas = new GerenciarDespesas();
        registroDespesas = gerenciarDespesas.carregarJSONRegistroDespesas(registroDespesas);

        int idRelatorio;
        List<Integer> numerosPedidos = new ArrayList<>();
        
        for (RegistroDespesas registroDespesa : registroDespesas) {
            numerosPedidos.add(registroDespesa.getIdDespesa());
        }

        do {
            idRelatorio = random.nextInt(100000);
        } while (numerosPedidos.contains(idRelatorio));

        return idRelatorio;
    }
    
    public List<RegistroDespesas> buscarDespesasDiarias(List<RegistroDespesas> despesas, String data) {
        return despesas.stream()
                .filter(despesa -> despesa.getDataDespesa().equals(data))
                .collect(Collectors.toList());
    }
    
    public List<RegistroDespesas> buscarDespesasMensais(List<RegistroDespesas> despesas, int mes, int ano) {
        return despesas.stream()
                .filter(relatorio -> {
                    String[] partesData = relatorio.getDataDespesa().split("/");
                    int mesRelatorio = Integer.parseInt(partesData[1]);
                    int anoRelatorio = Integer.parseInt(partesData[2]);
                    return mesRelatorio == mes && anoRelatorio == ano;
                })
                .collect(Collectors.toList());
    }
    
    public double calcularTotalDespesas(List<RegistroDespesas> despesas) {
        return despesas.stream()
                       .mapToDouble(RegistroDespesas::getValorDespesa)
                       .sum();
    }
}