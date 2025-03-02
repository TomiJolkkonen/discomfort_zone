#include <stdio.h>
#include <string.h>

int main(void){

   char mjono[256];
   char * pmjono;

   printf("anna merkkijono > ");
   fgets( mjono, 256, stdin );

   if( mjono[ strlen(mjono)-1 ] =='\n'){
     mjono[ strlen(mjono)-1 ] ='\0';
   }

   printf("Alkuperainen merkkijono alussa: %s\n", mjono); 

   pmjono = strtok( mjono, " " );

   while( NULL != pmjono ){

      printf("Sana: %s\n", pmjono);
      
      pmjono = strtok( NULL, " " );
   }
 

   printf("Alkuperainen merkkijono lopussa %s\n", mjono);   

 
   return 0;
}

     