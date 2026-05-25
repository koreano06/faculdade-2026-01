/*Exercício 2 — Sistema de Atendimento Hospitalar

Um hospital utiliza um sistema para organizar a sequência de pacientes aguardando atendimento médico. Cada paciente recebe uma senha numérica e é inserido em uma estrutura dinâmica que permite atualizações frequentes durante o dia.

Para facilitar a manutenção dessa fila de atendimento, a equipe de desenvolvimento decidiu utilizar uma lista encadeada simples.

Cada nó da estrutura armazena:

o número da senha do paciente
um ponteiro para o próximo paciente

Considere a seguinte sequência atual:

12 → 18 → 25 → 31 → 40 → NULL

Com base nessa situação, desenvolva a implementação em linguagem C que:

a) Crie a lista encadeada com os valores apresentados.

b) Percorra a lista e calcule a soma de todas as senhas armazenadas.

c) Exiba a quantidade total de pacientes presentes na lista.
*/

public class Lista_de_atividade02 {

    static class Paciente {
        int numeroDaSenha;
        Paciente proximoPaciente;
    }

    static int calcularSomaSenhas(Paciente primeiroNaFila) {
        Paciente atendendo = primeiroNaFila;
        int totalSoma = 0;

        while (atendendo != null) {
            totalSoma += atendendo.numeroDaSenha;
            atendendo = atendendo.proximoPaciente;
        }
        return totalSoma;
    }

    static int contarPacientes(Paciente primeiroNaFila) {
        Paciente atendendo = primeiroNaFila;
        int quantidadePessoas = 0;

        while (atendendo != null) {
            quantidadePessoas++;
            atendendo = atendendo.proximoPaciente;
        }
        return quantidadePessoas;
    }

    public static void main(String[] args) {

        Paciente senha12 = new Paciente();
        Paciente senha18 = new Paciente();
        Paciente senha25 = new Paciente();
        Paciente senha31 = new Paciente();
        Paciente senha40 = new Paciente();

        senha12.numeroDaSenha = 12;
        senha18.numeroDaSenha = 18;
        senha25.numeroDaSenha = 25;
        senha31.numeroDaSenha = 31;
        senha40.numeroDaSenha = 40;

        senha12.proximoPaciente = senha18;
        senha18.proximoPaciente = senha25;
        senha25.proximoPaciente = senha31;
        senha31.proximoPaciente = senha40;
        senha40.proximoPaciente = null;

        int somaTotal = calcularSomaSenhas(senha12);
        System.out.println("Soma de todas as senhas: " + somaTotal);

        int totalPacientes = contarPacientes(senha12);
        System.out.println("Total de pacientes na fila: " + totalPacientes);
    }
}