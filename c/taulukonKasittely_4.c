#include <stdio.h>

void tulostaTaulukko( double taulukko[], int koko);
void taytaTaulukko( double taulukko[], int koko);
int etsiSuurin( double taulukko[], int koko);

int main(void){

   int koko;
   int indeksi;
   int taulukonKoko;

   printf("Anna taulukon koko > ");
   scanf("%d", &koko);

   double lukemat[koko]; 

   taulukonKoko = sizeof( lukemat )/sizeof( double );

   printf("Taulukon koko on %d paikkaa\n", taulukonKoko);

   taytaTaulukko( lukemat, koko ); //lukemat == &lukemat[0]

   tulostaTaulukko( lukemat ,koko );

   indeksi = etsiSuurin( lukemat, koko );

   printf("lukemat taulukon suurin arvo on %lf\n\
 ja se sijaitsee paikassa %d\n", lukemat[indeksi], indeksi);
   
   
   return 0;
}

void taytaTaulukko( double taulukko[], int koko){
  int i;

  for(i=0; i < koko; i=i+1){
     printf("Anna %d. lampotila >", (i+1));
     scanf("%lf", &taulukko[i]);
   }
}

void tulostaTaulukko( double taulukko[], int koko){
  int i;

  for(i=0; i < koko; i=i+1){
     printf("[%d] = %lf\n", i, taulukko[i] );
   }
}

int etsiSuurin( double taulukko[], int koko){
   int i;
   int indeksi = 0;

   for(i=0; i < koko; i++){

      if( taulukko[i] > taulukko[indeksi] ){
         indeksi = i;
      }
   }

   return indeksi;
}