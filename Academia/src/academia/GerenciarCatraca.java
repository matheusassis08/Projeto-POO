package academia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GerenciarCatraca {
    private static final String FILE_CATRACAS = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\catracas.json";
    private final File arquivoCatraca = new File(FILE_CATRACAS);
    private ObjectMapper mapper = new ObjectMapper();

    private List<Cliente> listaClientes = new ArrayList<>();

    public GerenciarCatraca() {}

    public boolean validarAcessoPorId(int id) {
        GerenciarCliente gerenciarCliente = new GerenciarCliente();
        listaClientes = gerenciarCliente.carregarJSONClientes(listaClientes);
        Optional<Cliente> cliente = gerenciarCliente.buscarClientePorId(listaClientes, id);
        return cliente.isPresent();
    }

 
    public void abrirCatraca() {
        System.out.println("Acesso concedido. Catraca liberada.");
    }

    public void negarAcesso() {
        System.out.println("Acesso negado. ID inválido.");
    }

    public void registrarEvento(int idCliente, String tipoEvento) {
        LocalDate dataAtual = LocalDate.now();
        String dataDeRealizacao = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime horaAtual = LocalTime.now();
        String horarioDeRealizacao = horaAtual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        List<Catraca> catracas = carregarJSONCatraca(new ArrayList<>());
        Catraca evento = new Catraca(dataDeRealizacao, horarioDeRealizacao, idCliente, tipoEvento);
        catracas.add(evento);
        salvarJSONCatracas(catracas);
    }

    public void calcularTempoPermanencia(int idCliente) {
        List<Catraca> catracas = carregarJSONCatraca(new ArrayList<>());
        List<Catraca> eventosCliente = catracas.stream()
                .filter(c -> c.getIdCliente() == idCliente)
                .collect(Collectors.toList());

        Catraca entrada = null;
        for (Catraca evento : eventosCliente) {
            if ("entrada".equals(evento.getTipoEvento())) {
                entrada = evento;
            } else if ("saída".equals(evento.getTipoEvento()) && entrada != null) {
                calcularDiferencaTempo(entrada, evento);
                entrada = null;
            }
        }
    }

    private void calcularDiferencaTempo(Catraca entrada, Catraca saida) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime horaEntrada = LocalTime.parse(entrada.getHorario(), formatter);
            LocalTime horaSaida = LocalTime.parse(saida.getHorario(), formatter);
            Duration duracao = Duration.between(horaEntrada, horaSaida);
            System.out.println("Tempo de permanência: " + duracao.toHoursPart() + " horas e " + duracao.toMinutesPart() + " minutos.");
        } catch (Exception e) {
            System.out.println("Erro ao calcular tempo de permanência.");
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



