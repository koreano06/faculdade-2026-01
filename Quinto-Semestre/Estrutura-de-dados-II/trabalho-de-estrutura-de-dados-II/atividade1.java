import java.util.Scanner;
import java.util.Random;

//Trabalho 1 - Ordenacao e Busca
//Disciplina: Estrutura de Dados II
public class Main {

    // =========================================================
    // BUBBLE SORT
    // =========================================================

    /**
     * Ordena o vetor usando o algoritmo Bubble Sort.
     * Complexidade: O(n^2) no pior caso.
     *
     * @param arr      vetor a ser ordenado
     * @param contagem array de 1 posicao para acumular comparacoes
     */
    public static void bubbleSort(int[] numeros, long[] contador) {
        int tamanhoVetor = numeros.length;
        for (int volta = 0; volta < tamanhoVetor - 1; volta++) {
            for (int pos = 0; pos < tamanhoVetor - volta - 1; pos++) {
                contador[0]++; // conta comparacao
                if (numeros[pos] > numeros[pos + 1]) {
                    // troca
                    int valorGuardado = numeros[pos];
                    numeros[pos] = numeros[pos + 1];
                    numeros[pos + 1] = valorGuardado;
                }
            }
        }
    }

    // =========================================================
    // QUICK SORT
    // =========================================================

    
    //Particiona o vetor em torno de um pivo para o Quick Sort.
     //      ||
     //      ||            
     //      \/
     //@param arr     
     //@param low      
     //@param high     
     //@param contagem 
     //@return 

    private static int particionar(int[] numeros, int comeco, int fim, long[] contador) {
        int pivo = numeros[fim];
        int lugarMenor = comeco - 1;

        for (int andando = comeco; andando < fim; andando++) {
            contador[0]++; // conta comparacao
            if (numeros[andando] <= pivo) {
                lugarMenor++;
                int valorGuardado = numeros[lugarMenor];
                numeros[lugarMenor] = numeros[andando];
                numeros[andando] = valorGuardado;
            }
        }

        // coloca pivo na posicao correta
        int valorGuardado = numeros[lugarMenor + 1];
        numeros[lugarMenor + 1] = numeros[fim];
        numeros[fim] = valorGuardado;

        return lugarMenor + 1;
    }

    
    //Ordena o vetor usando o algoritmo Quick Sort (recursivo).
    //Complexidade: O(n log n) medio, O(n^2) pior caso.
     
     //@param arr      vetor a ser ordenado
     //@param low      indice inicial
     //@param high     indice final
     //@param contagem array de 1 posicao para acumular comparacoes
     
    public static void quickSort(int[] numeros, int comeco, int fim, long[] contador) {
        if (comeco < fim) {
            int lugarPivo = particionar(numeros, comeco, fim, contador);
            quickSort(numeros, comeco, lugarPivo - 1, contador);
            quickSort(numeros, lugarPivo + 1, fim, contador);
        }
    }

    // =========================================================
    // BUSCA SEQUENCIAL
    // =========================================================

    
     //Busca sequencial: percorre o vetor elemento a elemento.
     //Complexidade: O(n).
     
     //@param arr      vetor
     //@param alvo     valor procurado
     //@param contagem array de 1 posicao para acumular comparacoes
     //@return indice do elemento ou -1 se nao encontrado

    public static int buscaSequencial(int[] numeros, int numeroProcurado, long[] contador) {
        for (int pos = 0; pos < numeros.length; pos++) {
            contador[0]++;
            if (numeros[pos] == numeroProcurado) {
                return pos;
            }
        }
        return -1;
    }

    // =========================================================
    // BUSCA BINARIA
    // =========================================================

     //Busca binaria: divide o intervalo ao meio a cada passo.
     //Requer que o vetor esteja previamente ordenado.
     //Complexidade: O(log n).
     //@param arr      vetor ORDENADO
     //@param alvo     valor procurado
     //@param contagem array de 1 posicao para acumular comparacoes
     //@return indice do elemento ou -1 se nao encontrado
     
    public static int buscaBinaria(int[] numeros, int numeroProcurado, long[] contador) {
        int comecoBusca = 0;
        int fimBusca = numeros.length - 1;

        while (comecoBusca <= fimBusca) {
            int meio = (comecoBusca + fimBusca) / 2;
            contador[0]++;

            if (numeros[meio] == numeroProcurado) {
                return meio;
            } else if (numeros[meio] < numeroProcurado) {
                comecoBusca = meio + 1;
            } else {
                fimBusca = meio - 1;
            }
        }
        return -1;
    }

    // =========================================================
    // UTILITARIOS
    // =========================================================

    //Gera vetor de inteiros aleatorios no intervalo [0, 10*tamanho]. 
    public static int[] gerarVetor(int tamanho, Random sorteio) {
        int[] vetorNovo = new int[tamanho];
        for (int pos = 0; pos < tamanho; pos++) {
            vetorNovo[pos] = sorteio.nextInt(tamanho * 10);
        }
        return vetorNovo;
    }

    // Copia um vetor (para nao alterar o original nos testes). 
    public static int[] copiarVetor(int[] vetorOriginal) {
        int[] vetorCopia = new int[vetorOriginal.length];
        for (int pos = 0; pos < vetorOriginal.length; pos++) {
            vetorCopia[pos] = vetorOriginal[pos];
        }
        return vetorCopia;
    }

    // Exibe os primeiros 'max' elementos de um vetor.
    public static void exibirVetor(int[] numeros, int max) {
        System.out.print("  [");
        int ateOndeVai = Math.min(numeros.length, max);
        for (int pos = 0; pos < ateOndeVai; pos++) {
            System.out.print(numeros[pos]);
            if (pos < ateOndeVai - 1) System.out.print(", ");
        }
        if (numeros.length > max) System.out.print(", ...");
        System.out.println("]");
    }

    // =========================================================
    // TESTES EXPERIMENTAIS
    // =========================================================

     //Executa os testes comparativos com volumes Pequeno, Medio e Grande.
     //Exibe tempo de execucao e numero de comparacoes para cada algoritmo.
     
    public static void executarTestes() {
        int[] tamanhos = {1000, 50000, 500000};
        String[] nomesVolumes = {"Pequeno (1.000)", "Medio (50.000)", "Grande (500.000)"};
        Random sorteio = new Random(42); // semente fixa para reproducibilidade

        System.out.println("\n============================================================");
        System.out.println("           TESTES EXPERIMENTAIS COMPARATIVOS");
        System.out.println("============================================================");

        for (int i = 0; i < tamanhos.length; i++) {
            int tamanhoAtual = tamanhos[i];
            System.out.println("\n--- Volume: " + nomesVolumes[i] + " ---");

            int[] vetorBase = gerarVetor(tamanhoAtual, sorteio);
            int numeroEscolhido = vetorBase[sorteio.nextInt(tamanhoAtual)]; 

            // --- Bubble Sort ---
            int[] vetorBubble = copiarVetor(vetorBase);
            long[] contBubble = {0};
            long comecoBubble = System.currentTimeMillis();
            bubbleSort(vetorBubble, contBubble);
            long tempoBubble = System.currentTimeMillis() - comecoBubble;

            // --- Quick Sort ---
            int[] vetorQuick = copiarVetor(vetorBase);
            long[] contQuick = {0};
            long comecoQuick = System.currentTimeMillis();
            quickSort(vetorQuick, 0, vetorQuick.length - 1, contQuick);
            long tempoQuick = System.currentTimeMillis() - comecoQuick;

            System.out.println("\n  [ORDENACAO]");
            System.out.printf("  %-12s | Tempo: %6d ms | Comparacoes: %,d%n",
                    "Bubble Sort", tempoBubble, contBubble[0]);
            System.out.printf("  %-12s | Tempo: %6d ms | Comparacoes: %,d%n",
                    "Quick Sort", tempoQuick, contQuick[0]);

            // Busca no vetor ordenado (Quick Sort como referencia)
            long[] contSeq = {0};
            long[] contBin = {0};

            long comecoSeq = System.currentTimeMillis();
            int posSeq = buscaSequencial(vetorQuick, numeroEscolhido, contSeq);
            long tempoSeq = System.currentTimeMillis() - comecoSeq;

            long comecoBin = System.currentTimeMillis();
            int posBin = buscaBinaria(vetorQuick, numeroEscolhido, contBin);
            long tempoBin = System.currentTimeMillis() - comecoBin;

            System.out.println("\n  [BUSCA] Alvo: " + numeroEscolhido);
            System.out.printf("  %-20s | Tempo: %3d ms | Comparacoes: %,d | Posicao: %d%n",
                    "Busca Sequencial", tempoSeq, contSeq[0], posSeq);
            System.out.printf("  %-20s | Tempo: %3d ms | Comparacoes: %,d | Posicao: %d%n",
                    "Busca Binaria", tempoBin, contBin[0], posBin);
        }

        System.out.println("\n============================================================");
        System.out.println("                  FIM DOS TESTES");
        System.out.println("============================================================\n");
    }

    // =========================================================
    // MENU INTERATIVO
    // =========================================================

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random sorteio = new Random();

        System.out.println("============================================================");
        System.out.println("   TRABALHO 1 - ORDENACAO E BUSCA - Estrutura de Dados II");
        System.out.println("============================================================");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMENU PRINCIPAL:");
            System.out.println("  1 - Ordenar vetor (modo interativo)");
            System.out.println("  2 - Buscar elemento em vetor ordenado");
            System.out.println("  3 - Executar testes experimentais comparativos");
            System.out.println("  0 - Sair");
            System.out.print("\nEscolha uma opcao: ");

            int opcaoEscolhida = teclado.nextInt();

            switch (opcaoEscolhida) {

                case 1: {
                    System.out.print("\nInforme o tamanho do vetor: ");
                    int tamanhoPedido = teclado.nextInt();

                    System.out.println("Escolha o algoritmo de ordenacao:");
                    System.out.println("  1 - Bubble Sort");
                    System.out.println("  2 - Quick Sort");
                    System.out.print("Opcao: ");
                    int tipoOrdenacao = teclado.nextInt();

                    int[] vetorMontado = gerarVetor(tamanhoPedido, sorteio);
                    System.out.println("\nVetor ANTES da ordenacao:");
                    exibirVetor(vetorMontado, 20);

                    long[] contador = {0};
                    long comeco = System.currentTimeMillis();

                    if (tipoOrdenacao == 1) {
                        bubbleSort(vetorMontado, contador);
                        System.out.println("Algoritmo usado: Bubble Sort");
                    } else if (tipoOrdenacao == 2) {
                        quickSort(vetorMontado, 0, vetorMontado.length - 1, contador);
                        System.out.println("Algoritmo usado: Quick Sort");
                    } else {
                        System.out.println("Opcao invalida. Bubble Sort sera usado.");
                        bubbleSort(vetorMontado, contador);
                    }

                    long tempoGasto = System.currentTimeMillis() - comeco;

                    System.out.println("Vetor APOS a ordenacao:");
                    exibirVetor(vetorMontado, 20);
                    System.out.println("Tempo de execucao : " + tempoGasto + " ms");
                    System.out.println("Numero de comparacoes: " + contador[0]);
                    break;
                }

                case 2: {
                    System.out.print("\nInforme o tamanho do vetor: ");
                    int tamanhoPedido = teclado.nextInt();

                    int[] vetorMontado = gerarVetor(tamanhoPedido, sorteio);
                    // ordena antes da busca
                    long[] contOrd = {0};
                    quickSort(vetorMontado, 0, vetorMontado.length - 1, contOrd);

                    System.out.print("Informe o valor a buscar: ");
                    int numeroUsuario = teclado.nextInt();

                    System.out.println("\nEscolha o algoritmo de busca:");
                    System.out.println("  1 - Busca Sequencial");
                    System.out.println("  2 - Busca Binaria");
                    System.out.println("  3 - Ambos (comparar)");
                    System.out.print("Opcao: ");
                    int tipoBusca = teclado.nextInt();

                    if (tipoBusca == 1 || tipoBusca == 3) {
                        long[] contSeq = {0};
                        long comecoBusca = System.currentTimeMillis();
                        int pos = buscaSequencial(vetorMontado, numeroUsuario, contSeq);
                        long tempo = System.currentTimeMillis() - comecoBusca;
                        System.out.println("\nBusca Sequencial:");
                        if (pos >= 0) {
                            System.out.println("  Elemento " + numeroUsuario + " encontrado na posicao " + pos);
                        } else {
                            System.out.println("  Elemento " + numeroUsuario + " NAO encontrado.");
                        }
                        System.out.println("  Comparacoes: " + contSeq[0] + " | Tempo: " + tempo + " ms");
                    }

                    if (tipoBusca == 2 || tipoBusca == 3) {
                        long[] contBin = {0};
                        long comecoBusca = System.currentTimeMillis();
                        int pos = buscaBinaria(vetorMontado, numeroUsuario, contBin);
                        long tempo = System.currentTimeMillis() - comecoBusca;
                        System.out.println("\nBusca Binaria:");
                        if (pos >= 0) {
                            System.out.println("  Elemento " + numeroUsuario + " encontrado na posicao " + pos);
                        } else {
                            System.out.println("  Elemento " + numeroUsuario + " NAO encontrado.");
                        }
                        System.out.println("  Comparacoes: " + contBin[0] + " | Tempo: " + tempo + " ms");
                    }
                    break;
                }

                case 3:
                    executarTestes();
                    break;

                case 0:
                    continuar = false;
                    System.out.println("\nEncerrando o programa. Ate logo!");
                    break;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
        teclado.close();
    }
}
