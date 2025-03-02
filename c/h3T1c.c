//
//  h3T1c.c "ontto" neliö
//
//
//  Created by Ilkka Räsänen on 06/10/17.
//
//

#include <stdio.h>

int main(void){
   int maara;
   int rivi, sarake;
   
   do {
      printf("anna lukumaara ( 1 - 20 ) >");
      scanf("%d", &maara);
   }while( maara < 1 || maara > 20 );
   
   
   for(rivi = 0; rivi < maara; rivi++){
      
      for( sarake = 0; sarake < maara; sarake++ ){
         
         if( (rivi == 0 || sarake == 0) || (rivi == maara-1 || sarake == maara-1)){
            printf("*");
         }else {
            printf(" ");
         }
   
      }
      printf("\n");
   }
   
   return 0;
   
}
