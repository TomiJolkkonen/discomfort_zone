#include <stdio.h>
#include <stdlib.h>

//void taytaTaulukko (int * jokunimi, int koko);
//void tulostaTaulukko (int * jokunimi, int koko);

int main(void) {
	
	char * mjono;
	int koko;
	
	printf("Anna tekstin maksimipituus ");
	scanf("%d", &koko);
	getchar();
	
	mjono = malloc(koko * sizeof(char));
	
	if(NULL != mjono) {
			printf("Anna merkkijono (max %d merkkiä) ", koko);
			fgets(mjono, koko, stdin);
			
			printf("Syötit merkkijonon %s", mjono);
			free(mjono); //vapautetaan muisti, koska dynaaminen muistinvaraus
			mjono = NULL; //unohtaa totaalisesti mihin osoitettiin
			
			// tai: taytaTaulukko(taulukko, koo);
			//tulostaTaulukko(taulukko, koko);
			//free(taulukko);
			//taulukko = NULL;
	} else {
			printf("Jokin meni pieleen, ei tullut muistia varatuksi\n");
	}
	
	return (0);
		
}

/* 			funktiot voi laittaa tiedostoihin, tai tehdä mainin ulkopuolelle funktiot
 * 			// void taytaTaulukko(int * taulukko, int koko){
 * 				int i;
 * 
 * 				for (i=0; i < koko; i++) {
 * 					printf("Anna jokin kokonaisluku");
 * 					scanf("%d", &taulukko[i]);
 * 				}
 * 			}
			*
			* 
			* 
			//void tulostaTaulukko(int * taulukko, int koko) {
			* 	int i;
			* 
			* 	for(i=0; i < koko; i++) {
			* 		printf("taulukko[%d] = %d\n”, i, taulukko[i]);
			* }
			* }
			* 
			* 
			* /
