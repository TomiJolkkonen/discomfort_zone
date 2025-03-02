#include <stdio.h>


int main(void) {
	
	double asiakas1;
	double asiakas2;
	double asiakas3;
	double hinta1;
	double hinta2;
	double hinta3;
	

	do }
			
	printf("Asiakas1, anna parkkiaika tunteina, max 24h);
	scanf("%f", &asiakas1);
	
	printf("Asiakas2, anna parkkiaika tunteina, max 24h);
	scanf("%f", &asiakas2);
	
	printf("Asiakas3, anna parkkiaika tunteina, max 24h);
	scanf("%f", &asiakas3);
	
	if asiakas1 > 24 || asiakas2 > 24 || asiakas3 > 24 {
		printf("Maksimituntimäärä on 24h. Anna uusi luku\n");
		}
		
	} while asiakas1 > 24 || asiakas2 > 24 || asiakas3 > 24
	
	
	
	
	if asiakas1 <= 3 {
		hinta1 = 2;
	} else {
		hinta1 = hinta1 + ((asiakas1 - 3)*0.5);
		}
	if hinta1 > 10 {
		hinta1 = 10;
		}
		
		if asiakas2 <= 3 {
		hinta2 = 2;
	} else {
		hinta2 = hinta2 + ((asiakas1 - 3)*0.5);
		}
	if hinta2 > 10 {
		hinta2 = 10;
		}
		
		if asiakas3 <= 3 {
		hinta3 = 2;
	} else {
		hinta3 = hinta3 + ((asiakas1 - 3)*0.5);
		}
	if hinta3 > 10 {
		hinta3 = 10;
		}
		
	tunnitYhteensa = asiakas1 + asiakas2 + asiakas3;
	veloitusYhteensa = hinta1 + hinta2 + hinta3;
	
	printf("Asiakas \t Tunnit \t Veloitus \n");
	printf("1 \t %f \t %f \n", asiakas1, hinta1);
	printf("2 \t %f \t %f" \n, asiakas2, hinta2);
	printf("3 \t %f \t %f" \n, asiakas3, hinta3);
	printf("Yhteensä: \t %f \t %f \n", tunnitYhteensa, veloitusYhteensa); 

    return 0;
}
		
