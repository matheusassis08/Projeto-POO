package academia;
/**
 * Interface para implementar Comparator
 */
public interface Comparator<T> {
    /**
     * Método para ser sobrescrito para comparar dois objetos.
     * @param o1
     * @param o2
     */
    int comparar(T o1, T o2);
}
