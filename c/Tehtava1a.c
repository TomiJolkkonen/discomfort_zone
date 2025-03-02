#include <stdio.h>
#include <stdlib.h>

int main() {
    int tunnit = 0;
    int tuntipalkka = 0;
    int tyontekijalleMaksettavaPalkka = 0;

    printf("Anna tuntim‰‰r‰si:\n");
    scanf("%d", &tunnit);
    printf("Anna tuntipalkkasi:\n");
    scanf("%d", &tuntipalkka);

    tyontekijalleMaksettavaPalkka = tunnit * tuntipalkka;

    printf("Saat palkkaa %d euroa.", tyontekijalleMaksettavaPalkka);
    return 0;
}

