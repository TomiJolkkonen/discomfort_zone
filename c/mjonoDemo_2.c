#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main(void){

   char mjono[256];
   char kopio[256];
   int i, j;
 
   printf("anna merkkijono > ");
   fgets( mjono, 256, stdin );

   if( mjono[ strlen(mjono)-1 ] =='\n'){
     mjono[ strlen(mjono)-1 ] ='\0';
   }

   printf("Alkuperainen merkkijono alussa: %s\n", mjono); 

   for(i=0, j=strlen(mjono)-1; i < strlen(mjono); i++, j--){

     kopio[i] = mjono[j];

   }
   
   kopio[i] ='\0';
 

   printf("Kopioitu merkkijono  %s\n", kopio);   

 
   return 0;
}

     