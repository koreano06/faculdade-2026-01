#include <stdio.h>
#include <math.h>

int main() {
    
    int i, j, contador = 1, expoente;
    int matriz[5][5];
    int mult[5][5];
    
    printf("Digite o expoente: ");
    scanf("%d", &expoente);

    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            matriz[i][j] = contador;
            contador++;
        }
    }
    
    for(i = 0; i < 5; i++, j = 0){
        for(j = 0; j < 5; j++){
            printf("%d\t", matriz [i][j]);
        }
        printf("\n");
    }
    
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            mult[i][j] = (int) pow(matriz[i][j], expoente);
        }
    }
    
    printf("\n");
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            printf("%d\t", mult [i][j]);
        }
        printf("\n");
    }
    
    return 0;
}