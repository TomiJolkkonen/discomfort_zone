#include <stdio.h>
#include <string.h>

int main(void){

   char mjono[15];
   char sana[] = "kukkaruukku";
   int i;
   char kehote[] = "Anna merkkijono > ";

   printf( kehote );
   gets( mjono );

   if( mjono[ strlen(mjono)-1 ]=='\n'){
       mjono[ strlen(mjono)-1 ] ='\0';
   
       if( mjono[ strlen(mjono)-1 ]=='\r')
         mjono[ strlen(mjono)-1 ] ='\0';
   }

   printf("Syotit merkkijonon %s \n", mjono);

   printf("Merkkijonon pituus on %d \n", strlen(mjono));

   if( strcmp(mjono, sana)==0 ){
     printf("Sanat ovat samat\n");
   }else{
     printf("Sanat eivat ole samoja\n");
   }

   return 0;
}

     