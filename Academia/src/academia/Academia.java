/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academia;

public class Academia {
    public static void main(String[] args) {
        // Teste da classe Pessoa
        System.out.println("=== Teste Pessoa ===");
        Pessoa pessoa1 = new Cliente("Carlos Almeida", "12345678900", "Rua X, 123", "99999-8888", "carlos@email.com");
        System.out.println(pessoa1.toString()); // Verificar se o método toString funciona
        System.out.println("Tipo: " + pessoa1.obterTipo()); // Verificando o tipo

        // Testando Getters e Setters
        pessoa1.setNome("Carlos Silva");
        System.out.println("Nome atualizado: " + pessoa1.getNome()); // Verificando se o setter funcionou

        // Teste da classe Cliente
        System.out.println("\n=== Teste Cliente ===");
        Cliente cliente1 = new Cliente("Ana Souza", "98765432100", "Rua Y, 456", "99999-7777", "ana@email.com");
        System.out.println(cliente1.toString()); // Verificar se o toString do cliente funciona
        cliente1.setTelefone("88888-7777");
        System.out.println("Telefone atualizado do cliente: " + cliente1.getTelefone()); // Testando o setter

        // Teste da classe Instrutor
        System.out.println("\n=== Teste Instrutor ===");
        Instrutor instrutor1 = new Instrutor("João Pereira", "12398745600", "Rua Z, 789", "99999-6666", "joao@email.com", "Gerente", 3500.0);
        System.out.println(instrutor1.toString()); // Verificar se o toString do instrutor funciona
        instrutor1.setSalario(3800.0);
        System.out.println("Salário atualizado: " + instrutor1.getSalario()); // Verificar se o setter do salário funcionou
        System.out.println("Tipo: " + instrutor1.obterTipo()); // Verificando o tipo
    }
}
