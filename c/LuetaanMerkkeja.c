#include <stdio.h>

int main(void) {
	
	char kirjain1, kirjain2, kirjain3; /* kolme kirjainta */
	int vuosi; /*kuluva vuosi*/
	
	printf("Anna kolmikirjaiminen tunnus ja paina returnia ");
	scanf("%c%c%c", &kirjain1, &kirjain2, &kirjain3);
	
	printf("Anna kuluva vuosi ja paina returnia ");
	scanf("%d", &vuosi);
	
	printf("Tervehdys %c%c%c. \nVuosi on %d\n", kirjain1, kirjain2, kirjain3, vuosi);
	
	return (0);
		
}
