#include <stdio.h>

int main(void) {
	
	double luku;
	int result;
	
	do{
	
			printf("Anna positiivinen reaaliluku ");
			
			while ( (result = scanf("%lf", &luku) ) <= 0 ) {
				
				printf("result on %d\n", result);
				printf("et syöttänyt reaalilukua!\n");
				
				while ( getchar() != '\n')
					printf("luettiin roska\n");
				printf("Anna reaaliluku ");
			}
		
	} while ( luku <= 0.0 ); //muista puolipiste perään!
	
	printf("Kiitos, syotit luvun %f\n", luku);
	
	return (0);
		
}
