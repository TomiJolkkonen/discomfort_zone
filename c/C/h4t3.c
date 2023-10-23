#include <stdio.h>

int onkoKarkausvuosi(int vuosi);
int lueInt(void);
void lueRoskat(void);

int main(void)
{

    int vuosi = 0;


    do {
        printf("Anna vuosiluku > ");
        vuosi = lueInt();

    }
    while( vuosi <= 0 );

    if( onkoKarkausvuosi( vuosi ) )
        printf("\nVuosi %d on karkausvuosi\n", vuosi);
    else
        printf("\nVuosi %d ei ole karkausvuosi\n", vuosi);


    return 0;
}

int onkoKarkausvuosi(int vuosi) {
    int tulos = 0;

    if( vuosi % 400 == 0 )
        tulos = 1;
    else if ( vuosi % 100 == 0 )
        tulos  = 0;
    else if( vuosi % 4 == 0 )
        tulos = 1;
    else tulos = 0;


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


