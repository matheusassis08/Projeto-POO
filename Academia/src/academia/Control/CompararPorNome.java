package academia.Control;
import academia.Model.Cliente;
import java.util.Comparator;
/**
 *  Classe para usar o comparador por Id do cliente
 */
public class CompararPorNome implements Comparator<Cliente>{
        @Override
        public int compare(Cliente cliente1, Cliente cliente2) {
            return cliente1.getNome().compareTo(cliente2.getNome());
        }
}
