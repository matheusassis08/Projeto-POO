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
    private Set<Integer> clientesNaAcademia;

    public GerenciarCatraca() {
        // Inicializa o conjunto
        clientesNaAcademia = new HashSet<>();
    }

    public boolean validarAcessoPorId(int id) {
        GerenciarCliente gerenciarCliente = new GerenciarCliente();
        listaClientes = gerenciarCliente.carregarJSONClientes(listaClientes);
        return listaClientes.stream().anyMatch(cliente -> cliente.getIdCliente() == id);
    }

    public Set<Integer> getClientesNaAcademia() {
        return clientesNaAcademia;
    }

    public void registrarEntrada(int idCliente) {
        // Verifica se o cliente já está na academia
        if (clientesNaAcademia.contains(idCliente)) {
            // Se o cliente já está na academia, registra a saída
            registrarSaida(idCliente);
        } else {
            // Se o cliente não está na academia, registra a entrada
            String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String horarioEntrada = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            Catraca eventoEntrada = new Catraca(data, horarioEntrada, idCliente);
            entradasAtivas.put(idCliente, eventoEntrada);

            // Adiciona o cliente à lista de clientes dentro da academia
            clientesNaAcademia.add(idCliente);
            System.out.println("Entrada registrada para o cliente " + idCliente);
        }
    }

    public void registrarSaida(int idCliente) {
        // Verifica se o cliente está dentro da academia
        if (!clientesNaAcademia.contains(idCliente)) {
            System.out.println("Erro: O cliente " + idCliente + " não está na academia.");
            return; // Cliente não pode sair sem estar na academia
        }

        // Remove o cliente da lista de clientes na academia
        clientesNaAcademia.remove(idCliente);

        // Registra a saída
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

    public void salvarJSONCatracas(List<Catraca> catracas) {
        try {
            mapper.writeValue(arquivoCatraca, catracas);
            System.out.println("Eventos salvos no arquivo: " + arquivoCatraca.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}