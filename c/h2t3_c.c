//
//  h2t3_c.c
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
   
   switch( pisteet ){
      case 0 ... 11:
         printf("Hylatty\n");
         break;
      case 12 ... 13:
         printf("1\n");
         break;
      case 14 ... 16:
         printf("2\n");
         break;
      case 17 ... 19:
         printf("3\n");
         break;
      case 20 ... 22:
         printf("4\n");
         break;
      case 23 ... 24:
         printf("5\n");
         break;
      default:
         printf("Virheellinen pistemaara\n");
         break;
   }
   
   return 0;
}
