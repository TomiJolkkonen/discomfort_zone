#include <stdio.h>
#include <string.h>

#define NIMEN_PITUUS 50

typedef struct {
	char nimi[NIMEN_PITUUS];
	double arvo;
} Arvonimet;

void tulostaArvonimi(Arvonimet lista);

int main(void){
	
	Arvonimet arvonimi1 = {"hippi", 520.19};
	Arvonimet arvonimi2 = {"porvari", -100.00};
	
	tulostaArvonimi(arvonimi1);
	tulostaArvonimi(arvonimi2);
	
	return 0;

} 

void tulostaArvonimi(Arvonimet lista) {
	printf("\nArvonimen %s merkitys eläinkunnalle on %.2lf prosenttia.\n", lista.nimi, lista.arvo);
}


