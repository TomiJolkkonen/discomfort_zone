#include <stdio.h>
#include <string.h>
#define NIMEN_PITUUS 11
#define TUOTE_LKM 5


	typedef struct { //prototyyppien jälkeen ennen main-funktiota, vain malli, eli muuttujat ei vielä perustettu
		char nimi[NIMEN_PITUUS]; //kenttä nimelle
		double hinta; //kenttä hinnalle
		
	}TuoteTietue; //päättyy puolipisteeseen
	
	
	
	typedef struct { //taulukko eri lajikkeista
		char lajike[NIMEN_PITUUS];
		TuoteTietue tuotteet[TUOTE_LKM];
		
	}TuotelajiTietue; //joskus auttaa piirtää kuva
	
void tulostaTuote(TuoteTietue t); //voi siirtää structit funktioihin

int main(void) {
	
	TuoteTietue tuote1, tuote2 = {"luomumaito", 1.5};
	
	strcpy(tuote1.hinta, "Maitotuotteet");
	tuote1.hinta=2.99;

	printf("Tuotteen %s hinta on %.2lf euroa\n", tuote1.nimi, tuote1.hinta);

	tulostaTuote(tuote1);
	
	return (0);
		
}

void tulostaTuote(TuoteTietue t) { //structin funktio
	
		printf("Tuote %s.2lf, t.nimi, t.hinta9;
}
