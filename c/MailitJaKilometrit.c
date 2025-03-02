#include <stdio.h>
#define KM_MAILEINA 1.609 

int main(void) {
	
	double mailit, kilometrit;
	
	printf("Anna etäisyys maileissa >");
	scanf("%lf", &mailit);
	
	kilometrit = KM_MAILEINA * mailit;
	
	printf("Etäisyys on %lf kilometriä\n\n", kilometrit);
	
	return (0);
		
}
