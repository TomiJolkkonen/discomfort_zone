#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <ctype.h>
#include "harjoitustyo.h"

//Sanan parserointi
int parseroi(FILE * tiedosto, char * sana) {
    char merkki;
    int laskuri=0;
    
    while (merkki != EOF) {
		merkki = fgetc(tiedosto);
		if ((merkki >= 65 && merkki <= 90) || (merkki >= 97 && merkki <= 122) || merkki == '\'') {
			sana[laskuri] = tolower(merkki);
			laskuri++;
		}
		else
			break;
	}
	sana[laskuri] = '\0';
	if (merkki == EOF)
		return 0;
	return 1;
}


// Lisataan 2.tiedostosta sana puuhun
void lisaa(binaarihakupuu *juuri, char *sana){
	solmupointteri uusilehti = (solmupointteri)malloc(sizeof(solmu));
	int wordlength = strlen(sana);
	uusilehti->satelliittidata = (char*)malloc((wordlength+1) * sizeof(char));
	strcpy(uusilehti->satelliittidata, sana);
	uusilehti->vanhempi = uusilehti->oikea = uusilehti->vasen = NULL;
	solmupointteri x = juuri->juuri;
	solmupointteri y = NULL;
	while(x != NULL){
		y = x;
		if(strcmp(uusilehti->satelliittidata, x->satelliittidata) < 0) {
			x = x->vasen;
		}
		else if(strcmp(uusilehti->satelliittidata, x->satelliittidata) > 0) {
			x = x->oikea;
		}
		else {
			free(uusilehti->satelliittidata);
			free(uusilehti);
			return;
		}	
	}	
	uusilehti->vanhempi = y;
	if(y == NULL) {
		juuri->juuri = uusilehti;
	}
	else if(strcmp(sana, y->satelliittidata) < 0)
		y->vasen = uusilehti;
	else 
		y->oikea = uusilehti;
}


// Verrataan 1.tiedoston sanaa 2.tiedostoon ja palautetaan eri sana
int etsi(binaarihakupuu *binaaripuu, char *sana){
	solmupointteri pointteri = binaaripuu->juuri;
	
	while(pointteri != NULL && strcmp(pointteri->satelliittidata, sana) != 0){
		if(strcmp(pointteri->satelliittidata, sana) < 0){
			pointteri = pointteri->oikea;
		}
		else {
			pointteri = pointteri->vasen;
		}
	}
	if (pointteri == NULL) {
		return 0;
	}
	else {
		return 1;
	} 	
}
