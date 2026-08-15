#include <stdio.h>

int main() {
    int matriz[5][5], mult[5][5];
    int i, j, contador = 1;

    printf("Matriz principal:\n");
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            matriz[i][j] = contador++;
            printf("%d\t", matriz[i][j]);
        }
        printf("\n");
    }

    printf("\n Matriz ao Quadrado:\n");
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            mult[i][j] = matriz[i][j] * matriz[i][j];
            printf("%d\t", mult[i][j]);
        }
        printf("\n");
    }

    return 0;
}