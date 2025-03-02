#include <stdio.h>
	
int main(void) {
	
	int vuosi;
	
	printf("Anna vuosi: ");
	scanf("%d, &vuosi);
	
	int karkausvuosi;
	if (vuosi % 400 == 0) {
		karkausvuosi = 1;
	} else if (vuosi % 100 == 0) {
		karkausvuosi = 0;	
	} else if (vuosi % 4 == 0) {
		karkausvuosi = 1;
	} else {
		karkausvuosi = 0;
	}
	
	if karkausvuosi == 1 {
			printf("Vuosi on karkausvuosi.");
	} else {
			printf("Vuosi ei ole karkausvuosi.");
	}

    return 0;
}




		
