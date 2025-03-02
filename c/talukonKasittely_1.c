#include <stdio.h>

int main(void){

   int koko;
   int i;

   printf("Anna taulukon koko > ");
   scanf("%d", &koko);

   double lukemat[koko]; //lukemat[0], lukemat[koko-1], koko=365

   for(i=0; i < koko; i=i+1){
     printf("Anna %d. lampotila >", (i+1));
     scanf("%lf", &lukemat[i]);
   }

   for(i=0; i < koko; i=i+1){
     printf("lukemat[%d] = %lf\n", i, lukemat[i] );
   }
    
   return 0;
}