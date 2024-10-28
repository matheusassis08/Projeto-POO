package academia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe para administrar os agendamentos das aulas
 */
public class Agendamentos {
    private static final String FILE_AGENDAMENTOS = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\agendamentos.json";

    private String data;
    private String horario;
    private String nomeCliente;
    private String emailCliente;
    private String nomeInstrutor;
    
    private Scanner scanner = new Scanner(System.in);
    private ObjectMapper mapper = new ObjectMapper();

    /** 
     * Para agendar um horário para um aluno ter aula
     */
    void realizarAgendamento() {
        System.out.println("Informe o e-mail do cliente para o agendamento: ");
        String email = scanner.nextLine();
        List<Cliente> clientes = carregarClientes();

        Cliente cliente = buscarClientePorEmail(clientes, email);
        if (cliente == null) {
            System.out.println("Cliente com e-mail " + email + " não encontrado.");
            return;
        }
        
        LocalDate dataIn = solicitarData();
        
        LocalTime horarioIn = solicitarHorario();
        
        List<Agendamentos> agendamentos = carregarAgendamentos();

        Agendamentos agendamento = new Agendamentos(
                dataIn.format(Academia.getDATE_FORMATTER()),
                horarioIn.format(Academia.getTIME_FORMATTER()),
                cliente.getNome(),
                cliente.getEmail(),
                "");
        // teve que ficar na frente dos outros por problema na leitura das linhas do scanner.
        System.out.println("Qual o nome do instrutor designado para a aula?");
        String nomeInstrutorIn = scanner.nextLine();
        agendamento.setNomeInstrutor(nomeInstrutorIn);
        
        agendamentos.add(agendamento);

        salvarAgendamentos(agendamentos);
        System.out.println("Agendamento salvo com sucesso!");
    }
    /**
     * Solicita as horas no formato (hh:mm:ss) e retorna no formato LocalTime.
     * @return LocalTime
     */
    public LocalTime solicitarHorario() {
        LocalTime horario = null;
        while (horario == null) {
            System.out.println("Digite o horário (HH:mm:ss): ");
            try {
                horario = LocalTime.parse(scanner.nextLine(), Academia.getTIME_FORMATTER());
            } catch (Exception e) {
                System.out.println("Horário inválido. Tente novamente no formato HH:mm:ss.");
            }
        }
        return horario;
    }
    
    /**
     * Solicita a data no formato (dd/mm/yyyy) e retorna no formato LocalDate.
     * @return LocalDate
     */
    private LocalDate solicitarData() {
        LocalDate data = null;
        while (data == null) {
            System.out.println("Digite o dia do agendamento (dd/MM/yyyy): ");
            try {
                data = LocalDate.parse(scanner.nextLine(), Academia.getDATE_FORMATTER());
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente no formato dd/MM/yyyy.");
            }
        }
        return data;
    }
    
    /**
     * Carrega a lista de clientes a partir de seu arquivo JSON.
     * @return ArrayList
     */
    private List<Cliente> carregarClientes() {
        File arquivo = new File(GerenciarCliente.getFILE_CLIENTES());
        try {
            if (arquivo.exists() && arquivo.length() > 0) {
                return mapper.readValue(arquivo, new TypeReference<List<Cliente>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    /**
     * Realiza uma busca em uma lista de clientes a partir de seu email.
     * @param clientes
     * @param email
     * @return Cliente
     */
    private Cliente buscarClientePorEmail(List<Cliente> clientes, String email) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                return cliente;
            }
        }
        return null;
    }
    
    /**
     * Carrega o arquivo com todos os agendamentos.
     * @return ArrayList
     */
    private List<Agendamentos> carregarAgendamentos() {
        File arquivo = new File(FILE_AGENDAMENTOS);
        try {
            if (arquivo.exists() && arquivo.length() > 0) {
                return mapper.readValue(arquivo, new TypeReference<List<Agendamentos>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    /**
     * Salva a lista de agendamentos realizados.
     * @param agendamentos
     */
    private void salvarAgendamentos(List<Agendamentos> agendamentos) {
        File arquivo = new File(FILE_AGENDAMENTOS);
        try {
            mapper.writeValue(arquivo, agendamentos);
            System.out.println("Agendamentos salvos com sucesso em: " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Construtor padrão da classe Agendamentos.
     */
    public Agendamentos() {
        
    }
    /**
     * Construtor da classe Agendamentos.
     * @param data
     * @param horario
     * @param nomeCliente
     * @param emailCliente
     * @param nomeInstrutor
     */
    public Agendamentos(String data, String horario, String nomeCliente, String emailCliente, String nomeInstrutor) {
        this.data = data;
        this.horario = horario;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.nomeInstrutor = nomeInstrutor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }
    
    

    @Override
    public String toString() {
        return "Agendamentos{" + "data=" + data + ", horario=" + horario + ", nomeCliente=" + nomeCliente + ", emailCliente=" + emailCliente + ", nomeInstrutor=" + nomeInstrutor + '}';
    }
}