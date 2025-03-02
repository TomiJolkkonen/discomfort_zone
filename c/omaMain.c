#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "omat.h"

int main( void ){
   int koko = 5;

   //srand((unsigned)time(NULL)); 

   double lukuja[koko];

   taytaTaulukko( lukuja, koko );

   tulostaTaulukko( lukuja, koko );

   return 0;
}