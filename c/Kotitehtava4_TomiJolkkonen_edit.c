#include <stdio.h>
#include <stdlib.h>

int main()
{
    int syotettyTunnusluku;
    int oikeaTunnusluku = 1234;
    int laskuri = 0;
    char kayttajanValinta;
    char toinenKayttajanValinta;

    do {
       printf("Anna tunnusluku: \n");
       scanf("%d", &syotettyTunnusluku);

       printf("V��r� tunnusluku.\n");
       laskuri++;

    } while (laskuri < 4 && syotettyTunnusluku != oikeaTunnusluku);

    if(syotettyTunnusluku != oikeaTunnusluku) {
        printf("Edelleen v��r� tunnusluku, ota yhteys pankkiisi.\n");
        return 0;
        }


    printf("Valitse S = setelinostot tai T = tilitiedot\n");
    scanf("%c", &kayttajanValinta);
    if (kayttajanValinta == 'S') {
        printf("Valitse nostettava summa, maksimi on 1000 euroa:\n");


    }
    if (kayttajanValinta == 'T') {
        printf("Haluatko tilitiedot R = ruudulle vai K = kuitille\n");
        if (kayttajanValinta == 'R') {
            printf("Tilill�si on rahaa x euroa\n");
        }
        if (kayttajanValinta == 'K') {
            printf("Leikit��n ett� nyt tulostui kuitti.\n");
        }
    }

    printf("Kiitos ja n�kemiin!\n");
    return 0;
}
