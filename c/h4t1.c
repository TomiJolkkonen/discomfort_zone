#include <stdio.h>
#include <math.h>

double laskePmaksu(double aika);
int lueInt(void);
void lueRoskat(void);

int main(void){
   
   double maksu1, maksu2, maksu3, aika1, aika2, aika3;
   double ajatYht = 0.0, maksutYht = 0.0;
   
   
   do {
      printf("Anna aika ");
      aika1 = lueInt();
      
   }while(aika1 <= 0.0 || aika1 > 24.0);
   
   do {
      printf("Anna aika ");
      aika2 = lueInt();
      
   }while(aika2 <= 0.0 || aika2 > 24.0);
   
   do {
      printf("Anna aika ");
      aika3 = lueInt();
      
   }while(aika3 <= 0.0 || aika3 > 24.0);
   
   maksu1 = laskePmaksu(aika1);
   maksu2 = laskePmaksu(aika2);
   maksu3 = laskePmaksu(aika3);
   
   ajatYht = aika1 + aika2 + aika3;
   maksutYht = maksu1 + maksu2 + maksu3;
   
   printf("%-10s%-10s%-10s\n","Asiakas","Tunnit", "Velotus");
   printf("%-10d%-10.2lf%-10.2lf\n", 1, aika1, maksu1);
   printf("%-10d%-10.2lf%-10.2lf\n", 2, aika2, maksu2);
   printf("%-10d%-10.2lf%-10.2lf\n", 3, aika3, maksu3);
   printf("%-10s%-10.2lf%-10.2lf\n", "Yhteensa", ajatYht, maksutYht);
   
   return 0;
   
}


double laskePmaksu(double aika){
   double maksu = 0.0;

   if( aika <= 3.0)
      maksu = 2.0;
   else if( aika <= 17.0){
      maksu = 2 + (aika-3.0) *.5;
   }else
      maksu = 10;
   
   return maksu;
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

