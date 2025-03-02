#include <stdio.h>
#include <stdlib.h>

int main() {
	FILE * tiedosto;
    char tilinumero[59];
    char tiedostonimi[64];
    int syotettyTunnusluku;
    int oikeaTunnusluku;
    int laskuri = 0;
    char kayttajanValinta;

    do {
		puts("Anna tilinumero");
       
		scanf("%s", tilinumero);
		sprintf (tiedostonimi, "%s.tili", tilinumero);

		tiedosto = fopen(tiedostonimi, "r");
		
		fscanf(tiedosto, "%d", &oikeaTunnusluku)

    } while (laskuri < 3 && syotettyTunnusluku != oikeaTunnusluku);

    if(syotettyTunnusluku != oikeaTunnusluku) {
        printf("Edelleen vaara tunnusluku, ota yhteys pankkiisi.\n");
        return 0;
        }

	while(getchar() != '\n');

    printf("Valitse S = setelinostot tai T = tilitiedot\n");
    scanf("%c", &kayttajanValinta);
    
    if (kayttajanValinta == 'S') {
        int nostettavaSumma;
        int viisikymppiset = 0;
        int kaksikymppiset = 0;

        printf("Valitse nostettava summa, joko 20, 40 tai 50 euroa tai sen yli, maksimi on 1000 euroa:\n");
        scanf("%d", &nostettavaSumma);
        
	while (nostettavaSumma < 40 && nostettavaSumma != 20 && nostettavaSumma > 1000 && nostettavaSumma % 10 != 0) {
			printf("Anna summa joka on tasan 20 euroa tai yli 40 euroa, nostot 10 euron v‰lein, maksiminosto 1000 euroa.\n");
	}

	while (nostettavaSumma %50!= 0 ) {
        kaksikymppiset++;
        nostettavaSumma = nostettavaSumma-20;
	}

	while (nostettavaSumma-50 >= 0) {
        viisikymppiset++;
        nostettavaSumma = nostettavaSumma-50;
	}

        printf("Saat %d kpl viisikymppisia ja %d kpl kaksikymppisia.", viisikymppiset, kaksikymppiset);

        }
        
    
    if (kayttajanValinta == 'T') {
		while(getchar() != '\n');
        printf("Haluatko tilitiedot R = ruudulle vai K = kuitille\n");
	if (kayttajanValinta == 'R') {
            printf("Tilill‰si on rahaa hyvin paljon euroja\n");
	}
	if (kayttajanValinta == 'K') {
            printf("Leikit‰‰n ett‰ nyt tulostui kuitti.\n");
	}
    

    printf("Kiitos ja nakemiin!");
    
    return 0;
	}
}

