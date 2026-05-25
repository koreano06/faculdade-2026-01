/*Exercício 3 — Operações Fundamentais em Lista Encadeada

Uma instituição de ensino está desenvolvendo um sistema para armazenar as matrículas de alunos utilizando listas encadeadas simples. O objetivo é praticar as principais operações de manipulação dessa estrutura.

Cada nó da lista deverá armazenar:

o número da matrícula do aluno
um ponteiro para o próximo nó

Considere inicialmente a seguinte lista:

15 → 30 → 45 → NULL

Com base nesse cenário, desenvolva a implementação em linguagem C que realize as seguintes operações:

a) Inserir um novo elemento com valor 60 no final da lista.

b) Inserir um novo elemento com valor 5 no início da lista.

c) Percorrer e exibir todos os elementos da lista atualizada.

d) Contar quantos nós existem após todas as inserções.

e) Encontrar e exibir o maior valor armazenado na lista.
*/

public class Lista_de_atividade03 {

    static class Aluno {
        int matricula;
        Aluno proximo;
    }

    public static void main(String[] args) {

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();

        a1.matricula = 15;
        a2.matricula = 30;
        a3.matricula = 45;

        a1.proximo = a2;
        a2.proximo = a3;
        a3.proximo = null;

        Aluno novoFinal = new Aluno();
        novoFinal.matricula = 60;
        novoFinal.proximo = null;
        a3.proximo = novoFinal;

        Aluno novoInicio = new Aluno();
        novoInicio.matricula = 5;
        novoInicio.proximo = a1;
        a1 = novoInicio;
        
        Aluno atual = a1;
        int quantidade = 0;
        int maior = a1.matricula;

        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.matricula + " -> ");
            quantidade++;
            if (atual.matricula > maior) {
                maior = atual.matricula;
            }
            atual = atual.proximo;
        }
        System.out.println("NULL");

        System.out.println("Total de nos: " + quantidade);
        System.out.println("Maior valor: " + maior);
    }
}