#include <stdio.h>
#include <stdlib.h>

#include "omat_1.h"



int main(void){

  int * taulukko;
  int lukuja[10];
  int koko;

  printf("Anna taulukon koko > ");
  scanf("%d", &koko);
  getchar();

  taulukko = malloc( koko * sizeof(int) );

  if( NULL != taulukko ){

    taytaTaulukko( taulukko, koko );
    tulostaTaulukko( taulukko, koko );

    free( taulukko );
    taulukko = NULL;     

     
  }else{
    printf("Jokin meni pieleen, ei tullut muistia varatuksi\n");
  }

  return 0;
} //main

/*
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

*/

