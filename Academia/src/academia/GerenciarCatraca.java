package academia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;


/**
 *Classe para gerenciar a catraca da academia
 * 
 */
public class GerenciarCatraca {
    
    private static final String FILE_CATRACAS = "C:\\POO\\Projeto-POO\\Academia\\src\\arquivos\\catracas.json";
    private final File arquivoCatraca = new File(FILE_CATRACAS);
    Scanner scanner = new Scanner(System.in);
    ObjectMapper mapper = new ObjectMapper();
    
    private List<Cliente> listaClientes = new ArrayList<>();
    
    public GerenciarCatraca() {
        
    }

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

    public List<Catraca> carregarJSONCatraca(List<Catraca> catracas){
        if (arquivoCatraca.exists()) {
            try {
                catracas = mapper.readValue(arquivoCatraca, new TypeReference<List<Catraca>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return catracas;
    }
    
    public void salvarJSONCatracas(List<Catraca> catracas){
        try {
            mapper.writeValue(arquivoCatraca, catracas);
            System.out.println("Produtos salvos no arquivo: " + arquivoCatraca.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


