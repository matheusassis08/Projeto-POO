/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

/**
 *
 * 
 */
public class FichaTreino {
    private String nomeCliente;
    private String data;
    private int numeroFicha;
    private String nomeInstrutor;
    private String listaExercicio;
    
    /** Usado para iniciar um cadastro de ficha de treino para algum aluno*/
    void gerarFicha(){ 
        
    };
    /** Altera os exercicios de alguma ficha já cadastrada */
    void alterarFicha(){
    
    }
    /** Excluir alguma ficha de treino cadastrada*/
    void excluirFicha(){
    
    }
    /** Realiza uma busca e retorna as informações de alguma ficha cadastrada*/
    void buscarFicha(){
    
    }

    public FichaTreino(String nomeCliente, String data, int numeroFicha, String nomeInstrutor, String listaExercicio) {
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.numeroFicha = numeroFicha;
        this.nomeInstrutor = nomeInstrutor;
        this.listaExercicio = listaExercicio;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(int numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public String getListaExercicio() {
        return listaExercicio;
    }

    public void setListaExercicio(String listaExercicio) {
        this.listaExercicio = listaExercicio;
    }

    @Override
    public String toString() {
        return "FichaTreino{" + "nomeCliente=" + nomeCliente + ", data=" + data + ", numeroFicha=" + numeroFicha + ", nomeInstrutor=" + nomeInstrutor + ", listaExercicio=" + listaExercicio + '}';
    }
    
    
}
