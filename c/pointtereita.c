#include <stdio.h>

int main(void) {
	
	int taulu [10] = {1,2,3,4,5};
	int *pi;
	int i = 3;
	
	pi = &taulu[0];
	
	taulu[i] = 11; //paikkaan kolme laitetaan 11
	*(pi+1) = 22; //sama kuin pi + 3 * sizeof(int) eli luvun 11 paikalle tulee luku 22
	*(i+pi) = 33; //tallettaa luvun 22 päälle luvun 33
	i[taulu] = 44; //sama kuin *(taulu+i), älkää tehkö tällä tavalla, tulee luku 44
	
	return (0);
		
}
