#include <stdio.h>

double korotaPotenssiin(int luku, int potenssi);
int lueInt(void);
void lueRoskat(void);

int main(void){

    int tulos = 0;
    int luku = 0, potenssi = 0;

    do{
        printf("Anna positiivinen koknaisluku > ");
       luku = lueInt();
    }
    while( luku <= 0 );


    do{
        printf("Anna positiivinen potenssi > ");
        potenssi = lueInt();
    }
    while(potenssi <= 0);

    tulos = korotaPotenssiin(luku, potenssi);

    printf("Luku %d korotettuna potenssiin %d on %d\n", luku, potenssi, tulos);

    return 0;
}


double korotaPotenssiin(int luku, int potenssi)
{
    int tulos = 1;
    int i;

    for(i=0; i < potenssi; i++)
        tulos = tulos * luku;

    return tulos;


}

int lueInt(void){
   int luku;
   int result;
   char mki;
   
   while((result=scanf("%d%c", &luku, &mki))== 0 || (result == 2 && mki != '\n')){
      
      lueRoskat();
      
      printf("Ei käy, yritä uudelleen > ");
   }
   
   return luku;
}

void lueRoskat(void){
   while(getchar() != '\n')
      ; // tyhjä käsky
}
