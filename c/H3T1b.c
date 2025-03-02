#include <stdio.h>

int main(void){
   int maara;
   int rivi, sarake;
   
   printf("anna lukumaara >");
   scanf("%d", &maara);
   
   for(rivi = 0; rivi < maara; rivi++){
      
      if( rivi == 0 || rivi == maara-1){
         
         for( sarake = 0; sarake < maara; sarake++){
            printf("*");
         }
         
         printf("\n");
         
      }else {
         
         printf("*");
         
         for( sarake = 0; sarake < maara-2; sarake++){
            printf(" ");
         }
         
         printf("*\n");
         
      }
   }
   
   
   
   return 0;
   
}