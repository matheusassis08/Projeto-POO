package academia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GerenciarCatraca {
    private static final String FILE_CATRACAS = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\catracas.json";
    private final File arquivoCatraca = new File(FILE_CATRACAS);
    private ObjectMapper mapper = new ObjectMapper();
    
    private List<Cliente> listaClientes = new ArrayList<>();
    private Map<Integer, Catraca> entradasAtivas = new HashMap<>();

    public boolean validarAcessoPorId(int id) {
        GerenciarCliente gerenciarCliente = new GerenciarCliente();
        listaClientes = gerenciarCliente.carregarJSONClientes(listaClientes);
        return listaClientes.stream().anyMatch(cliente -> cliente.getIdCliente() == id);
    }

    public void registrarEntrada(int idCliente) {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String horarioEntrada = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        Catraca eventoEntrada = new Catraca(data, horarioEntrada, idCliente);
        entradasAtivas.put(idCliente, eventoEntrada);
        System.out.println("Entrada registrada para o cliente " + idCliente);
    }

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



