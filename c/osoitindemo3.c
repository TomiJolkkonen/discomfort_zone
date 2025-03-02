//
//  pointteriDemo_v2.c
//  
//
//  Created by Ilkka Räsänen on 11/10/17.
//
//

#include <stdio.h>

int main(void){
   
   int lukuja[5] = {-11,2,-13,4,5};
   int * ptr;
   int i;
   
   ptr = lukuja;

   for(i=0; i<5; i++)
      printf("%d ", *(ptr++));
   
   
   return 0;
}
