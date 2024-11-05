package academia;

import java.util.Arrays;
import java.util.List;

/**
 *  Classe para gerenciar as salas da academia
 */
public class GerenciarSala {
    /**
     * Lista de salas da academia sendo salvas de forma estatica
     */
    private static final List<Sala> SALAS = Arrays.asList(
        new Sala(15, "Spinning", "Leonardo", 40, "Primeiro Andar"),
        new Sala(35, "musculação", "Leonardo", 200, "Primeiro Andar"),
        new Sala(15, "fit dance", "Matheus", 200, "Segundo Andar"),
        new Sala(20, "pilates", "Matheus", 40, "Segundo Andar")
    );
    
    public static List<Sala> getSalas() {
        return SALAS;
    }
}