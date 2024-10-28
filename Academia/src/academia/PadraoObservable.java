package academia;

import java.util.Vector;

/**
 *
 * Classe para utilizar o Observable do padrão de projeto.
 */
@SuppressWarnings("doclint:reference")
public class PadraoObservable {
    private boolean mudado = false;
    private Vector<PadraoObserver> obs;
    
    public PadraoObservable() {
        obs = new Vector<>();
    }
    
    public synchronized void adicionarObserver(PadraoObserver o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }
    
    public synchronized void removerObserver(PadraoObserver o) {
        obs.removeElement(o);
    }
    
    public void notificarObservers() {
        PadraoObservable.this.notificarObservers(null);
    }
    
    public void notificarObservers(Object arg) {
        Object[] arrLocal;

        synchronized (this) {
                if (!mudado)
                return;
            arrLocal = obs.toArray();
            limparAlteracao();
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            ((PadraoObserver)arrLocal[i]).update(this, arg);
    }
    
    public synchronized void apagarOberservers() {
        obs.removeAllElements();
    }
    
    protected synchronized void foiAlterado() {
        mudado = true;
    }
    
    protected synchronized void limparAlteracao() {
        mudado = false;
    }
    
    public synchronized boolean mudou() {
        return mudado;
    }
    
    public synchronized int contadorObservers() {
        return obs.size();
    }
}