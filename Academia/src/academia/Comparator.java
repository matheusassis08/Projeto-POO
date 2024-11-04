package academia;

/**
 *  Interface de comparator para comparar objetos.
 * @param <C> */
public interface Comparator<C> {
    int comparar(C objeto1, C objeto2);
    
    boolean equals(Object objeto);
}
