#include <stdio.h>

int main(void){
   int luku;
   int maara = 0;
   int summa = 0;
   double keskiarvo = 0.0;
   
   printf("Anna luku (nolla lopettaa) > ");
   scanf("%d", &luku);
   
   while( luku != 0 ){
   
      summa = summa + luku;
      maara++;
      
      printf("Anna luku (nolla lopettaa) > ");
      scanf("%d", &luku);
      
   }
   
   if( maara > 0 ){
      keskiarvo = (double)summa/maara;
      printf("\nLukujen keskiarvo on %lf\n", keskiarvo);
   }else{
      printf("Et syottanyt yhtaan nollasta poikkeavaa arvoa\n");
   }
   
   
   return 0;
}