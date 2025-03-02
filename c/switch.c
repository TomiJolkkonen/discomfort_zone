#include <stdio.h>

int main(void) {
	
	int lampunTeho;
	int elinIka;
	
	printf("Syota lampun teho");
	scanf("%d", &lampunTeho);
	
	switch (lampunTeho) {
			case 40:
				elinIka = 2400;
				break;
			case 60: case 80:
				elinIka = 2000;
				break;
			case 100:
				elinIka = 1800;
				break;
			default:
				elinIka = 1500;
				break;
	}
	printf("Lampun elinika on %d tuntia\n", elinIka);
	
	return (0);
		
}
