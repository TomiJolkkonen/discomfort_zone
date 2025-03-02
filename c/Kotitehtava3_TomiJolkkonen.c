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

       printf("Väärä tunnusluku.\n");
       laskuri++;

    } while (laskuri < 4 || syotettyTunnusluku != oikeaTunnusluku);

    if(syotettyTunnusluku != oikeaTunnusluku) {
        printf("Edelleen väärä tunnusluku, ota yhteys pankkiisi.\n");
        return 0;
        }


    printf("Valitse S = setelinostot tai T = tilitiedot\n");
    scanf("%c", &kayttajanValinta);
    if (kayttajanValinta == 'S') {
        printf("Täällä tehdään setelinostoja\n");
    }
    if (kayttajanValinta == 'T') {
        printf("Täällä näytetään tilitietoja\n");
    }

    printf("Kiitos ja näkemiin!\n");
    return 0;
}
