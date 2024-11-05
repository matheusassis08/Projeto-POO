package academia;
import java.util.Comparator;
/**
 *
 * 
 */
public class CompararPorNome implements Comparator<Cliente>{
        @Override
        public int compare(Cliente cliente1, Cliente cliente2) {
            return cliente1.getNome().compareTo(cliente2.getNome());
        }
}
