#ifndef _HARJOITUSTYO_H
#define _HARJOITUSTYO_H

//Funktioiden esittelyt, headeritiedosto


	
// Maaritellaan sen solmut ja pointterit
typedef struct kakkiainen {
	char * satelliittidata;
	struct kakkiainen* vanhempi;
	struct kakkiainen* vasen;
	struct kakkiainen* oikea;
}solmu, *solmupointteri; 

// Maaritellaan binaarihakupuu
typedef struct binaarihakupuu {
	solmupointteri juuri;
} binaarihakupuu; 

//Sanojen parserointi
int parseroi(FILE * tiedosto, char sana[200]);

// Lisataan 2.tiedosto puuhun
void lisaa(binaarihakupuu *juuri, char *sana);

// Verrataan 1.tiedoston sanaa 2.tiedostoon ja palautetaan eri sana ja lisätään se puuhun
int etsi(binaarihakupuu *binaaripuu, char *sana);

#endif // _HARJOITUSTYO_H
