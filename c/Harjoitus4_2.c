#include <stdio.h>


int korotaPotenssiin (int, int); 
	
int main(void) {
	
	int luku;
	int potenssi;
	int tulos;
	
	printf("Anna luku: ");
	scanf("%d, &luku);
	
	printf("Anna potenssi: ");
	scanf("%d, &potenssi);
	
	tulos = korotaPotenssiin ( luku, potenssi );
	
	printf("Tulos on %d", tulos);

    return 0;
}

int korotaPotenssiin (int luku, int potenssi) {
	int toisto = 1;
	while (toisto <= potenssi) {
			luku = luku * luku;
			toisto++;
	}	
	return (luku);
}


		
