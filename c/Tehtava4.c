#include <stdio.h>
#include <stdlib.h>

int main()
{
    int tontinLeveys = 0;
    int tontinPituus = 0;
    int talonLeveys = 0;
    int talonPituus = 0;
    double ajovauhti = (5 / 3.6);

    printf("Anna tontin leveys metreinä:\n");
    scanf("%d", &tontinLeveys);
    printf("Anna tontin pituus metreinä:\n");
    scanf("%d", &tontinPituus);
    printf("Anna talon leveys metreinä:\n");
    scanf("%d", &talonLeveys);
    printf("Anna talon pituus metreinä:\n");
    scanf("%d", &talonPituus);

    int tontinKoko = (tontinLeveys * tontinPituus);
    int talonKoko = (talonLeveys * talonPituus);
    int nurmikonKoko = (tontinKoko - talonKoko);

    double ajettavaMatka = nurmikonKoko / 0.7;
    double ajoaika = (ajovauhti / ajettavaMatka);

    printf("Nurmikon leikkaamiseen menee aikaa %lf sekuntia.", ajoaika);
    return 0;
}
