#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "harjoitustyo.h"

int main(int argc, char ** argv){
	
	// Aletaan laskemaan aikaa
	clock_t alku;
    alku = clock();
    clock_t loppu;
    double kulutettuaika;
    int wl;
	
	// Tiedostoille muuttujat
	FILE * verrattavaTiedosto;
	FILE * kokoTiedosto;
		
	if ((kokoTiedosto = fopen(argv[2], "r")) == NULL) {
		puts("Tiedostoa ei ole.\n");
		return 0;
	}
	
	
	verrattavaTiedosto = fopen(argv[1], "r");
	kokoTiedosto = fopen(argv[2], "r");

	// Puun juuri
	binaarihakupuu puunjuuri;
	puunjuuri.juuri=NULL;
	
	char sana[200];	
	
	// 2. tiedosto sana kerrallaan parserin läpi ja sana puuhun talteen
	while (parseroi(kokoTiedosto, sana)) {
		wl = strlen(sana);
		if(wl > 0)
			lisaa(&puunjuuri, sana);
	}
	
	
	// Verrataan 1.tiedoston sanoja 2.tiedostoon ja tulostetaan 50 ensimmaista eri sanaa
	if ((verrattavaTiedosto = fopen(argv[1], "r")) == NULL) {
		puts("Tiedostoa ei ole.\n");
		return 0;
	}
	
	int laskuri=0;
	while ((parseroi(verrattavaTiedosto, sana))) {
		wl = strlen(sana);
		if (wl > 0) {
			if (!etsi(&puunjuuri, sana)) {
				printf("%d. %s\n", laskuri+1, sana);
				lisaa(&puunjuuri, sana); //TÄHÄN LISÄTTY UUTENA RIVINÄ SE ETTA VERRATTAVA SANA LISATAAN MYOS PUUHUN, ELI KAYTETAAN PARSEROINTIA MYOS 1.TIEDOSTOON
				laskuri++;
			}
		}
		if (laskuri == 50) {
			break;
		}
	}
	
	// Lopetetaan ajan laskeminen ja tulostetaan aika
    loppu = clock();
    kulutettuaika = (double)(loppu - alku) / CLOCKS_PER_SEC;
    printf("Ohjelman kayttama aika %lfs\n", kulutettuaika);
	
	return 0;
}
