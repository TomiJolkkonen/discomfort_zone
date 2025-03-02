//
//  h2t3_a.c
//  
//
//  Created by Ilkka Räsänen on 29/09/16.
//
//

#include <stdio.h>

int main(void){
   
   int pisteet;
   
   //lue pisteet
   printf("Anna koepisteet ( 0 - 24 ) >");
   scanf("%d", &pisteet);
   
   //arvioi arvosana
   if( 0 > pisteet ){
      printf("Ei käy, liian pieni pistemaara\n");
   }else{
      if( 24 < pisteet ){
         printf("Ei käy, liian suuri pistemaara\n");
      }else {
         if( pisteet < 12 ){
            printf("Hylatty\n");
         }else{
            if( pisteet < 14 ){
               printf("1\n");
            }else {
               if( pisteet < 17 ){
                  printf("2\n");
               }else {
                  if( pisteet < 20 ){
                     printf("3\n");
                  }else {
                     if( pisteet < 23 ){
                        printf("4\n");
                     }else {
                        printf("5\n");
                     }
                  }
               }
            }
         }
      }
   }

   return 0;
}
