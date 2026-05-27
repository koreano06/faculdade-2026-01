#include <stdio.h>
#include <string.h>

#define MAX 10

// representa a pilha de chamadas, guardando os nomes das funções
// e o índice do topo pra saber onde estamos
typedef struct {
    char funcoes[MAX][20];
    int topo;
} CallStack;

// inicializa com topo -1, que significa pilha vazia
void inicializar(CallStack *stack) {
    stack->topo = -1;
}

// pilha vazia quando o topo ainda está em -1
int estaVazia(CallStack *stack) {
    return stack->topo == -1;
}

// pilha cheia quando chegamos no limite definido pelo MAX
int estaCheia(CallStack *stack) {
    return stack->topo == MAX - 1;
}

// push: empilha uma função quando ela é chamada
// incrementa o topo e salva o nome da função lá
void push(CallStack *stack, char *nomeFuncao) {
    if (estaCheia(stack)) {
        printf("  [ERRO] Stack Overflow! Pilha cheia.\n");
        return;
    }

    stack->topo++;
    strcpy(stack->funcoes[stack->topo], nomeFuncao);

    printf("  >> PUSH: funcao '%s' foi chamada e entrou na pilha\n", nomeFuncao);
}

// pop: desempilha a função quando ela retorna
// sempre remove o topo, seguindo o comportamento LIFO
void pop(CallStack *stack) {
    if (estaVazia(stack)) {
        printf("  [ERRO] Stack Underflow! Pilha vazia.\n");
        return;
    }

    char removida[20];
    strcpy(removida, stack->funcoes[stack->topo]);
    stack->topo--;

    printf("  << POP: funcao '%s' retornou e saiu da pilha\n", removida);
}

// exibe o estado atual da pilha do topo até a base
// ajuda a visualizar o comportamento LIFO em tempo real
void exibirPilha(CallStack *stack) {
    printf("\n  +-----------------------+\n");
    printf("  |   CALL STACK ATUAL    |\n");
    printf("  +-----------------------+\n");

    if (estaVazia(stack)) {
        printf("  |     (pilha vazia)     |\n");
    } else {
        for (int i = stack->topo; i >= 0; i--) {
            if (i == stack->topo)
                printf("  | %-21s | <-- topo\n", stack->funcoes[i]);
            else
                printf("  | %-21s |\n", stack->funcoes[i]);
        }
    }

    printf("  +-----------------------+\n\n");
}

int main() {
    CallStack stack;
    inicializar(&stack);

    printf("=======================================================\n");
    printf("        SIMULACAO DE CALL STACK — LIFO EM C\n");
    printf("=======================================================\n");

    // fase 1: simulando as chamadas entre funções
    // main chama A, A chama B, B chama C
    // cada chamada empilha a função no topo
    printf("\n--- Chamando as funcoes (PUSH) ---\n\n");

    push(&stack, "main");
    exibirPilha(&stack);

    push(&stack, "funcaoA");
    exibirPilha(&stack);

    push(&stack, "funcaoB");
    exibirPilha(&stack);

    push(&stack, "funcaoC");
    exibirPilha(&stack);

    // fase 2: simulando os retornos
    // a última função chamada é sempre a primeira a retornar
    // esse é exatamente o princípio LIFO funcionando na prática
    printf("--- Retornando as funcoes (POP) ---\n\n");

    pop(&stack);
    exibirPilha(&stack);

    pop(&stack);
    exibirPilha(&stack);

    pop(&stack);
    exibirPilha(&stack);

    pop(&stack);
    exibirPilha(&stack);

    printf("=======================================================\n");
    printf(" Ultimo a entrar, primeiro a sair — isso e o LIFO!\n");
    printf("=======================================================\n");

    return 0;
}