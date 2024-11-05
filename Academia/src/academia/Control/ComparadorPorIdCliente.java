package academia;
import java.util.Comparator;

/**
 * Classe para usar o comparador por Id do cliente
 */
public class ComparadorPorIdCliente implements Comparator<Cliente>{
        @Override
        public int compare(Cliente cliente1, Cliente cliente2) {
            return Integer.compare(cliente1.getIdCliente(), cliente2.getIdCliente());
        }
}
