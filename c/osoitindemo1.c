#include <stdio.h>
#include <string.h>


int main(void){

   int lukuja[7] = {1,2,3,4,5,6,-9};
   int i;

   int * ptr = NULL;

   ptr = lukuja; //ptr = &lukuja[0];



   for(i=0; i < 8; ptr++)
     printf("%d ", *ptr );


   return 0;
}

