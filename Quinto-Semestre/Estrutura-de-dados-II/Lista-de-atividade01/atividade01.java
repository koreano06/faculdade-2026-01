/*Exercício 1 — Sistema de Entregas

Uma empresa de logística desenvolveu um sistema para organizar a sequência de entregas realizadas diariamente por seus motoristas. Cada entrega precisa ser registrada em ordem de execução, permitindo inserções e remoções frequentes ao longo do expediente.

Durante a modelagem do sistema, a equipe de desenvolvimento optou pela utilização de uma lista encadeada simples, em vez de um vetor tradicional, visando maior flexibilidade na manipulação dos dados.

Considere que cada nó da estrutura armazena:

o código da entrega
um ponteiro para o próximo elemento da lista

A lista abaixo representa a sequência atual de entregas:

101 → 205 → 310 → 412 → NULL

Com base nessa situação, desenvolva a implementação em linguagem C que:

a)  Crie manualmente essa lista encadeada com os quatro elementos apresentados.

b)  Percorra a lista exibindo todos os códigos das entregas.

c)  Remova o primeiro elemento da lista.

d)  Exiba novamente a lista após a remoção.
*/

public class Lista_de_atividade01 {

    static class Entrega {
        int codigoPacote;
        Entrega proximaParada;
    }

    // Função para mostrar todas as entregas
    static void mostrarRoteiro(Entrega primeiraEntrega) {
        Entrega entregaAtual = primeiraEntrega;

        while (entregaAtual != null) {
            System.out.print(entregaAtual.codigoPacote + " -> ");
            entregaAtual = entregaAtual.proximaParada;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Entrega ponto1 = new Entrega();
        Entrega ponto2 = new Entrega();
        Entrega ponto3 = new Entrega();
        Entrega ponto4 = new Entrega();

        ponto1.codigoPacote = 101;
        ponto2.codigoPacote = 205;
        ponto3.codigoPacote = 310;
        ponto4.codigoPacote = 412;

        ponto1.proximaParada = ponto2;
        ponto2.proximaParada = ponto3;
        ponto3.proximaParada = ponto4;
        ponto4.proximaParada = null;

        System.out.println("Roteiro original:");
        mostrarRoteiro(ponto1);

        Entrega entregaCancelada = ponto1;
        ponto1 = ponto1.proximaParada; 
        entregaCancelada = null;    

        System.out.println("\nRoteiro apos remover a primeira entrega:");
        mostrarRoteiro(ponto1);
    }
}

