#include <stdio.h>

int main(void) {
	
	int tulo = 1;
	int luku = 0;
	
	while (tulo<1000) {
			printf("Anna kokonaisluku: ");
			scanf("%d", &luku);
			
			tulo = tulo * luku;
	}
	
	printf("Tulo on: %d\n\n", tulo);
	
	return (0);
		
}
