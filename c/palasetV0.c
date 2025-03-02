#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#include "apu.h"

#define KOKO 10



int main( void ){

  int lukuja[KOKO];
  int maara;

  srand( time(NULL) ); //

  printf("\nAletaan tayttaa taulukkoa satunnaisluvuilla\n");

  taytaTaulukko( lukuja, KOKO );
  
  tulostaTaulukko( lukuja, KOKO );


  return 0;
}

