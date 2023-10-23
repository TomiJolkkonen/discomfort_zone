#include <stdio.h>

int main(void){
   int luku;
   int maara = 0;
   int summa = 0;
   double keskiarvo = 0.0;
   
   do {
      
      printf("Anna luku (nolla lopettaa) > ");
      scanf("%d", &luku);
      
      if( luku != 0 ){
         summa = summa + luku;
         maara++;
      }
      
   }while( luku != 0 );
   
   if( maara > 0 ){
      keskiarvo = (double)summa/(double)maara; //lasketaa reaalilukuvastineilla
      printf("\nLukujen keskiarvo on %lf\n", keskiarvo);
   }else{
      printf("Et syottanyt yhtaan nollasta poikkeavaa arvoa\n");
   }
   
   
   return 0;
}