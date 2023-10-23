#include <stdio.h>

int main(void){
   int maara;
   int rivi, sarake;
   
   do {
      
      printf("anna lukumaara >");
      scanf("%d", &maara);
      
   }while( maara < 1 || maara > 20);
   
   for(rivi = 0; rivi < maara; rivi++){
      
      for( sarake = 0; sarake < maara; sarake++){
         printf("*");
      }
      
      printf("\n");
   }
   
   
   
   return 0;
   
}