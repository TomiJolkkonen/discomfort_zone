#include <stdio.h>

//void taytaTaulukko( double * taulukko, int koko);
void taytaTaulukko( double taulukko[], int koko);

int main(void){

   int koko;
   int i;

   printf("Anna taulukon koko > ");
   scanf("%d", &koko);

   double lukemat[koko]; 

   taytaTaulukko( lukemat, koko ); //lukemat == &lukemat[0]

   

   for(i=0; i < koko; i=i+1){
     printf("lukemat[%d] = %lf\n", i, lukemat[i] );
   }
    
   return 0;
}

void taytaTaulukko( double taulukko[], int koko){
  int i;

  for(i=0; i < koko; i=i+1){
     printf("Anna %d. lampotila >", (i+1));
     scanf("%lf", &taulukko[i]);
   }


}