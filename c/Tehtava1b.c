#include <stdio.h>
#include <stdlib.h>

int main()
{
    int veroprosentti;
    int tyontekijalleMaksettavaPalkka;

    printf("Anna kokonaispalkkasi:\n");
    scanf("%d", &tyontekijalleMaksettavaPalkka);
    printf("Anna veroprosenttisi:\n");
    scanf("%d", &veroprosentti);

    int lopullinen_Verotus = tyontekijalleMaksettavaPalkka * veroprosentti/100;
    int kateenjaavaPalkka = tyontekijalleMaksettavaPalkka - lopullinen_Verotus;

    printf("Saat palkkaa verojen jälkeen %d euroa.", kateenjaavaPalkka);

    return 0;
}


