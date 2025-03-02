#include <stdio.h>
#include <stdlib.h>

int main() {
	FILE * tiedosto; //tiedostopointteri
    int tilinumero; //tilinumeron tarkistusmuuttuja
    char tiedostonimi[64]; //tietoston nimi
    int annettuTunnusluku; //k‰ytt‰j‰n antama tunnusluku jota verrataan oikeaan
    int oikeaTunnusluku; //oikea tunnusluku eli pin-luku tiedostosta
    int laskuri = 0; //laskuria k‰ytet‰‰n kun kysyt‰‰n 3 kertaa alussa oikeaa pin-koodia, v‰‰rist‰ vastauksista ohjelma katkaisee, korttti imaistaan ja ota yhteys pankkiin
    char kayttajanValinta; //k‰ytt‰j‰ valitsee ottaako h‰n rahaa vai katsooko tilitietoja
    double saldo; //tilin saldo

	puts("Anna tilinumero"); //tarkistetaan tilinumero ja verrataan sit‰ tiedostoon
       
	scanf("%d", &tilinumero);
	sprintf (tiedostonimi, "%d.tili", tilinumero);

	tiedosto = fopen(tiedostonimi, "r");
		
	fscanf(tiedosto, "%d", &oikeaTunnusluku);
	
	printf("Anna tunnuslukusi:\n");
	
	while (laskuri < 3 && annettuTunnusluku != oikeaTunnusluku){	//tarkistellaan tuleeko oikeaa tunnuslukua vai ei
		printf("V‰‰r‰ tunnusluku, kokeile uudestaan:\n");
		laskuri++;
    } 
    
    if (laskuri == 3) {
    printf("Annoit v‰‰r‰n tunnusluvun, korttisi imaistaan, ota yhteys pankkiisi.");
	return 0;
	}
	
	fscanf(tiedosto, "%lf", &saldo);
	fclose(tiedosto);
	
	while(getchar() != '\n'); //putsataan puskuri

    printf("Valitse S = setelinostot tai T = tilitiedot\n"); //alkuvalikko
    scanf("%c", &kayttajanValinta);
    
    if (kayttajanValinta == 'S') {
        int nostettavaSumma;
        int viisikymppiset = 0;
        int kaksikymppiset = 0;

        printf("Valitse nosto: 20, 40, tai 50 - 1000 euroa (kymmenen euron valein):\n"); //aletaan laskemaan oikeita setelim‰‰ri‰
        scanf("%d", &nostettavaSumma);
        
	while ((nostettavaSumma < 40 && nostettavaSumma != 20) || nostettavaSumma > 1000 || nostettavaSumma % 10 != 0) {
			printf("Valitse nosto: 20, 40, tai 50 - 1000 euroa (kymmenen euron valein):\n");
	}
	
	saldo = saldo - nostettavaSumma;
	tiedosto = fopen(tiedostonimi, "w");
	fprintf(tiedostonimi, "%d\n%lf\n", oikeaTunnusluku, saldo);
	fclose(tiedosto);

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
        
    
    if (kayttajanValinta == 'T') { //katsotaan saldoa
		while(getchar() != '\n');
        printf("Haluatko tilitiedot R = ruudulle vai K = kuitille\n");
	if (kayttajanValinta == 'R') {
            printf("Tilill‰si on %lf euroa.\n", &saldo);
	}
	if (kayttajanValinta == 'K') {
            printf("Leikit‰‰n ett‰ nyt tulostui kuitti.\n");
	}
    

    printf("Kiitos ja nakemiin!");
    
    return 0;
	}
}

