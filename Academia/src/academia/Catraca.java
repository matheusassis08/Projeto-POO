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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *Classe para administrar a catraca da academia
 * 
 */
public class Catraca {
    
    private List<Cliente> listaClientes = new ArrayList<>();
    
    public Catraca() {
        
    }

    // Método para validar o acesso usando o ID do cliente
    public boolean validarAcessoPorId(int id) {
        GerenciarCliente gerenciarCliente = new GerenciarCliente();
        listaClientes = gerenciarCliente.carregarJSONClientes(listaClientes);
        
        Optional<Cliente> cliente = gerenciarCliente.buscarClientePorId(listaClientes, id);
        return cliente.isPresent();  // Retorna true se o cliente for encontrado
    }

    public void abrirCatraca() {
        System.out.println("Acesso concedido. Catraca liberada.");
    }

    public void negarAcesso() {
        System.out.println("Acesso negado. ID inválido.");
    }
}


