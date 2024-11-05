package academia;
import java.util.Comparator;

/**
 *
 * 
 */
public class ComparadorPorIdCliente implements Comparator<Cliente>{
        @Override
        public int compare(Cliente cliente1, Cliente cliente2) {
            return Integer.compare(cliente1.getIdCliente(), cliente2.getIdCliente());
        }
}
