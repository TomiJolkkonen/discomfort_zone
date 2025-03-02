#include <stdio.h>
	
int laskeKarkausvuosi (int annettuVuosi);

int main(void) {
	
	int annettuVuosi;
	int alkukuukausi;
	int loppukuukausi;
	int paivienMaara;
	int onkoKarkausvuosi;
	int summa;
	
	printf("Anna vuosi: ");
	scanf("%d", &annettuVuosi);
	printf("Anna alkukuukausi: ");
	scanf("%d", &alkukuukausi);
	printf("Anna loppukuukausi: ");
	scanf("%d", &loppukuukausi);
	
	switch (paivienMaara) { //otetaan ylös kuukausien päivien lukumäärät
		case 1 + 3 + 5 + 7 + 8 + 10 + 12:
			paivienMaara = 31;
			break;
		case 4 + 6 + 9 + 11:
			paivienMaara = 30;
			break;
		case 2:
			paivienMaara = 28;
			break;
		default:
			printf("Virhe");
			break;
	}
	
	for (int i = alkukuukausi; i <= loppukuukausi; i++) { //lasketaan päivien summa
        summa = summa+i;
    }


	onkoKarkausvuosi = laskeKarkausvuosi(annettuVuosi); //lisätään summaan karkausvuoden ekstrapäivä
	if (onkoKarkausvuosi == 1) {
		summa++;
	}
	
	printf("Annettujen kuukausien väliset päivät yhteensä: %d", summa);

    return 0;
}


int laskeKarkausvuosi (int annettuVuosi) { //lasketaan karkausvuosi
	int karkausvuosi;
	
	if (annettuVuosi % 400 == 0) {
		karkausvuosi = 1;
	} else if (annettuVuosi % 100 == 0) {
		karkausvuosi = 0;	
	} else if (annettuVuosi % 4 == 0) {
		karkausvuosi = 1;
	} else {
		karkausvuosi = 0;
	}
	return (karkausvuosi);
	}




		
