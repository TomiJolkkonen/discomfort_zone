#include <stdio.h>

int onkoKarkausvuosi(int vuosi);
int paivienLkmkuukaudessa( int kk );
int lueInt(void);
void lueRoskat(void);

int main(void){
   int pvLkm = 0;
   int vuosi, alkukk, loppukk;
   int kk;
   
   do {
      printf("Anna vuosi >");
      vuosi = lueInt();
   }while( vuosi <= 0 );
  
   
   do {
      printf("Anna alkukuukausi > ");
      alkukk = lueInt();
   }while( alkukk < 1 || alkukk > 12);
   
   do {
      printf("Anna loppukuukausi > ");
      loppukk = lueInt();
   }while( loppukk < 1 || loppukk > 12 || loppukk < alkukk); // jos alkukk > loppukk
   
   for( kk = alkukk; kk <= loppukk; kk++){
      pvLkm = pvLkm + paivienLkmkuukaudessa( kk );
      
      //jos on karkausvuosi ja kuukausi on helmikuu
      if( kk == 2 && onkoKarkausvuosi(vuosi))
         pvLkm++;
   }
   
   printf("Paivien lukumaara on %d\n", pvLkm);
   
   return 0;
}


int onkoKarkausvuosi(int vuosi)
{
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

int paivienLkmkuukaudessa( int kk ){
   /* vaihtoehtoinen tapa
    
    int pvlkm[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    return pvlkm[kk];
    
    */
   
   switch(kk){
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
         
         return 31;
         break;
         
      case 2:
         return 28;
         break;
      default:
         return 30;
         break;
   }
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
