#include <stdio.h>

void taytaTaulukko(int taulukko[], int koko) //hakasulut kertovat ett‰ kyseess‰ on taulukko. HUOM! nimen ei tarvitse olla lukemat vaan voi olla mit‰ tahansa
// voi myˆs kirjoittaa int * taulukko[], int koko
void tulostaTaulukko (int taulukko[], int koko)
int etsiSuurin (int taulukko[], int koko); //palauttaa taulukkon ja sen koon. t‰‰ll‰ ei tarvitse prototyypiss‰ olla nime‰ eli tuon taulukon voi j‰tt‰‰ pois

int main(void) {

	int koko;
	int indeksi;
	
	printf("Anna taulukon koko ");
	scanf("%d", &koko);
	
	int lukemat[koko]; // yll‰ olevat lukemat t‰‰ll‰, esim annetaan kooksi 365
	
	taytaTaulukko(lukemat, koko); // lukemat == &lukemat[0]
	tulostaTaulukko(lukemat, koko);
	
	indeksi = etsiSuurin(lukemat, koko); //mist‰ etsit‰‰n, kuinka suuresta koosta etsit‰‰n

	printf("lukemat taulukon suurin arvo on %d ja se sijaitsee paikassa %d", lukemat[indeksi], indeksi);
	
    return 0;
}

void taytaTaulukko (int taulukko [], int koko) {
		int i;
		for (i=0; i<koko; i++) { //t‰ytt‰‰ taulukkoa
		
		printf("Anna siihen lampotilat\n", (i+1));
		scanf("%d", &taulukko[i]);
		}

	}
	
void tulostaTaulukko (int taulukko[], int koko) {
		int i;
		for (i=0; i<koko; i++) { //tulostaa taulukon sis‰llˆn
		printf("[%d] = %d\n", i, taulukko[i] ); //ei &-merkki‰ eteen! &-merkki osoittaa muistipaikkaan
		}
	}
	
int etsiSuurin(int taulukko[], int koko) {
	int i;
	int indeksi = 0; //oletus ett‰ suurin voi lˆyty‰ myˆs eka kohdasta
	for (i=0, i<koko; i++) {
		if (taulukko[i] > taulukko[indeksi])
			indeksi = i;
		}
	
	}
	
	
