package academia.Control;

import academia.Model.Catraca;
import academia.Model.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Classe responsável pelo gerenciamento das entradas e saídas de clientes na academia.
 * <p>
 * Esta classe permite validar o acesso dos clientes, registrar eventos de entrada e saída, 
 * e salvar ou carregar os dados dos eventos em um arquivo JSON.
 */
public class GerenciarCatraca {
    private static final String FILE_CATRACAS = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\catracas.json";
    private final File arquivoCatraca = new File(FILE_CATRACAS);
    private ObjectMapper mapper = new ObjectMapper();

    private List<Cliente> listaClientes = new ArrayList<>();
    private Map<Integer, Catraca> entradasAtivas = new HashMap<>();

    /**
     * Valida o acesso de um cliente pelo seu ID.
     * <p>
     * Verifica se o cliente com o ID fornecido está registrado na lista de clientes.
     * </p>
     *
     * @param id o identificador único do cliente
     * @return {@code true} se o cliente existe e tem acesso permitido, {@code false} caso contrário
     */
    public boolean validarAcessoPorId(int id) {
        GerenciarCliente gerenciarCliente = new GerenciarCliente();
        listaClientes = gerenciarCliente.carregarJSONClientes(listaClientes);
        return listaClientes.stream().anyMatch(cliente -> cliente.getIdCliente() == id);
    }

    /**
     * Registra a entrada de um cliente na academia.
     * <p>
     * Cria um evento de entrada com a data e o horário atuais para o cliente especificado,
     * e adiciona este evento à lista de entradas ativas.
     * </p>
     *
     * @param idCliente o identificador único do cliente
     */
    public void registrarEntrada(int idCliente) {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String horarioEntrada = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        Catraca eventoEntrada = new Catraca(data, horarioEntrada, idCliente);
        entradasAtivas.put(idCliente, eventoEntrada);
        System.out.println("Entrada registrada para o cliente " + idCliente);
    }

    /**
     * Registra a saída de um cliente da academia.
     * <p>
     * Verifica se o cliente possui um registro de entrada ativo, atualiza o horário de saída, 
     * calcula o tempo de permanência, e salva o evento atualizado no arquivo JSON.
     * </p>
     *
     * @param idCliente o identificador único do cliente
     */
    public void registrarSaida(int idCliente) {
        Catraca eventoEntrada = entradasAtivas.get(idCliente);
        if (eventoEntrada != null) {
            String horarioSaida = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            eventoEntrada.setHorarioSaida(horarioSaida);
            eventoEntrada.calcularTempoPermanencia();

            List<Catraca> catracas = carregarJSONCatraca(new ArrayList<>());
            catracas.add(eventoEntrada);
            salvarJSONCatracas(catracas);

            entradasAtivas.remove(idCliente);
            System.out.println("Saída registrada para o cliente " + idCliente + ".");
        } else {
            System.out.println("Erro: cliente " + idCliente + " não possui registro de entrada.");
        }
    }

    /**
     * Carrega os eventos de catraca do arquivo JSON.
     * <p>
     * Lê os dados de eventos do arquivo JSON especificado e retorna uma lista de eventos.
     * </p>
     *
     * @param catracas lista onde os eventos serão carregados (geralmente uma lista vazia)
     * @return uma lista de objetos {@link Catraca} carregados do arquivo JSON
     */
    public List<Catraca> carregarJSONCatraca(List<Catraca> catracas) {
        if (arquivoCatraca.exists()) {
            try {
                catracas = mapper.readValue(arquivoCatraca, new TypeReference<List<Catraca>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return catracas;
    }

    /**
     * Salva os eventos de catraca no arquivo JSON.
     * <p>
     * Grava a lista de eventos fornecida no arquivo JSON especificado.
     * </p>
     *
     * @param catracas lista de eventos {@link Catraca} a serem salvos no arquivo JSON
     */
    public void salvarJSONCatracas(List<Catraca> catracas) {
        try {
            mapper.writeValue(arquivoCatraca, catracas);
            System.out.println("Eventos salvos no arquivo: " + arquivoCatraca.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



