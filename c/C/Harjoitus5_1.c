#include <stdio.h>

double laskeParkkimaksu (double);

int main(void) {
	
	double pysakointitaulukko [256][2];
	int i=0;
	
	do {
		printf("Anna pysäköintiaikoja tunteina: ");
		scanf("%lf", &pysakointitaulukko[i][0]);
		while (getchar() != '\n'); 
		pysakointitaulukko [i][1] = laskeParkkimaksu (pysakointitaulukko[i][0]);
		i++;
	} while (pysakointitaulukko [i-1][0] != 0 && i <= 256);
	

	printf("Annoit seuraavat tiedot:\n" );
	printf("%-15s %-15s %-15s", "Asiakas", "Tunnit", "Veloitus\n");
	for (i=0; i<10; i++) {
		printf("%-15d %-15.2lf %-15.2lf\n", i+1, pysakointitaulukko[i][0], pysakointitaulukko[i][1]);
	}
	
	printf("\n");
    return 0;
}

double laskeParkkimaksu (double aika) {
		double hinta;
		if (aika == 0) {
			hinta = 0;
		} else if (aika >24) {
			hinta = 10;
			printf("Liian pitkä pysäköinti, autosi hinataan pois.\n");
		} else if (aika <= 24 && aika > 19) {
			hinta = 10;
		} else if (aika <= 3) {
			hinta = 2;
		} else {
			hinta = 2;
			while (aika > 3 && aika <= 19) {
				hinta = hinta + 0.5;
				aika--;
			}
		}
	return (hinta);	
}
		
