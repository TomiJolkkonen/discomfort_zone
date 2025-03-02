#include <stdio.h>
#include <time.h>
#include <stdlib.h>


void taytaTaulukko( int taulukko[], int koko ){

   int i;
   
   for(i=0; i < koko; i++){
       taulukko[i] = (rand() % 21) - 10;
   }

   
   return;
}

void tulostaTaulukko( int taulukko[], int koko ){

   int i;
 
   printf("\nTAULUKON SISALTO:\n");

   for(i=0; i < koko; i++){
      printf("%d " , taulukko[i] );
   }

   printf("\n\n");

   return;
}
