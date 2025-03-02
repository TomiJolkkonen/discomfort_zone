#include <stdio.h>
#include <stdlib.h>

int main()
{
    int syotettyTunnusluku;
    int oikeaTunnusluku = 1234;
    int laskuri = 0;
    char kayttajanValinta;

    do {
       printf("Anna tunnusluku: \n");
       scanf("%d", &syotettyTunnusluku);

       printf("V��r� tunnusluku.\n");
       laskuri++;

    } while (laskuri < 4 || syotettyTunnusluku != oikeaTunnusluku);

    if(syotettyTunnusluku != oikeaTunnusluku) {
        printf("Edelleen v��r� tunnusluku, ota yhteys pankkiisi.\n");
        return 0;
        }


    printf("Valitse S = setelinostot tai T = tilitiedot\n");
    scanf("%c", &kayttajanValinta);
    if (kayttajanValinta == 'S') {
        printf("T��ll� tehd��n setelinostoja\n");
    }
    if (kayttajanValinta == 'T') {
        printf("T��ll� n�ytet��n tilitietoja\n");
    }

    printf("Kiitos ja n�kemiin!\n");
    return 0;
}
