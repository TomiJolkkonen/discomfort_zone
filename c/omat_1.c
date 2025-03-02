#include <stdio.h>
#include "omat_1.h"


void taytaTaulukko( int * taulukko, int koko ){

   int i;

   for(i=0; i < koko; i++){

      printf("Anna jokin kokonaisluku > ");
      scanf("%d", (taulukko +i));

   }
}


void tulostaTaulukko( int * taulukko, int koko ){
 
   int i;

   for(i=0; i < koko; i++){
   
     printf("taulukko[%d] = %d\n",i,*taulukko +i ); 
   
   }   

}