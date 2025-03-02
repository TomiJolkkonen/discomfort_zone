#include <stdio.h>
#include <string.h>
#include <ctype.h>

void lopustaAlkuun (char *mjono1, char *mjono2);

int main ( void ) {

    char oikeinpain[100];
    char nurinpain[100];

    printf("Syötä merkkijono");
	scanf("%s", oikeinpain);

    lopustaAlkuun(oikeinpain, nurinpain);

    if (strcmp(oikeinpain, nurinpain) == 0) {
        printf("Merkkijono on palindromi\n");
    }
    else {
        printf("Merkkijono ei ole palindromi");
	}
	
    return 0;
    
}


void lopustaAlkuun(char *mjono1, char *mjono2) {
   int pituus = strlen(mjono2);
   int i;

   for(i=0; i< pituus; i++){
      mjono1[i] = mjono2[(pituus-1)-i];
   }
    mjono1[i] = '\0';
}
