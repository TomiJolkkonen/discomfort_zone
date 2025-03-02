#include <stdio.h>

int laskeNegLkm( double  taulukko[], int n );
void taytaTaulukko( double taulukko[], int n );
void  tulostaTaulukko( double taulukko[], int n  );
int etsiPieninArvo( double taulukko[], int n  ); 


int main(Void){

   

   int koko = 0;
   int lkm = 0;
   double pieninLuku;
   int pienimmanPaikka;

   printf("Montako lukua haluat tallettaa > ");
   scanf("%d", &koko);

   double lukuja[koko];

   taytaTaulukko( lukuja, koko );

   tulostaTaulukko( lukuja , koko );

   lkm = laskeNegLkm( lukuja, koko );

   printf("Taulukosta loytyi %d negatiivista lukua\n", lkm);

   pienimmanPaikka = etsiPieninArvo( lukuja, koko );

   printf("Taulukon pienin arvo loytyy paikasta %d\n",pienimmanPaikka );

   printf("Taulukon pienin arvo on %lf\n", lukuja[pienimmanPaikka] );

   return 0;

}

int laskeNegLkm( double taulukko[] , int n){

  int i;
  int lkm = 0;
  double temp = 99;
 
  //taulukko = &temp;

  for( i=0; i < n; i++ ){

      if( taulukko[i] < 0.0 ){
         lkm++;
      }

   }

   return lkm;

}

void taytaTaulukko( double taulukko[], int n ){

   int i;

   for(i=0; i < n; i++){

      printf("Anna reaaliluku > ");
      scanf("%lf", &taulukko[i] );

   }

}


void  tulostaTaulukko( double taulukko[], int n  ){

   int i;

   for( i=0; i < n; i++){

      printf("luku %d = %lf\n", i, taulukko[i]);

   }

}

int etsiPieninArvo( double taulukko[], int n ){

   int i;
   int paikka = 0; //oletus

   for( i=1; i < n; i++){

      if( taulukko[i] < taulukko[paikka] ){
         paikka = i;
      }
   }

   return paikka;

} 
