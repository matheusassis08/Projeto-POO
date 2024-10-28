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
    //addObserver
    public synchronized void adicionarObserver(PadraoObserver o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }
    //deleteObserver
    public synchronized void removerObserver(PadraoObserver o) {
        obs.removeElement(o);
    }
    //notifyObservers
    public void notificarObservers() {
        PadraoObservable.this.notificarObservers(null);
    }
    //notifyObservers
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
    //deleteObservers
    public synchronized void apagarOberservers() {
        obs.removeAllElements();
    }
    //setChanged
    protected synchronized void foiAlterado() {
        mudado = true;
    }
    //clearChanged
    protected synchronized void limparAlteracao() {
        mudado = false;
    }
    //hasChanged
    public synchronized boolean mudou() {
        return mudado;
    }
    //countObservers
    public synchronized int contadorObservers() {
        return obs.size();
    }
}