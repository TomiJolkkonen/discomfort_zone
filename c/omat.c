#include <stdio.h>
#include <stdlib.h>
#include <time.h>



void taytaTaulukko( double lukuja[], int koko ){

   int i;

   srand((unsigned)time(NULL)); 

   for(i=0; i<koko; i++){
 
      lukuja[i] = 10 -rand() %21; // luvut -10 ... 10

   }

}

void tulostaTaulukko( double lukuja[], int  koko ){

   int i;


   printf("\nTaulukon sisalto:\n");

   for(i=0; i < koko; i++ ){

      printf("%lf ", lukuja[i] );

   }
}