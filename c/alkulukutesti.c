//
//  alkulukutesti.c
//  
//
//  Created by Ilkka Räsänen on 27/09/2018.
//

#include <stdio.h>
#include <math.h>

#define MAX 1000

int lueInt(void);
void lueRoskat(void);
int parillinen(int n );
int haeJakaja(int n );

int main(void){
   
   int n = 0;
   int minJakaja;
   
   do {
      printf("Anna kokonaisluku, luvun tulee olla suurempi kuin yksi > ");
      n = lueInt();
      
      if( n < 2 )
         printf("LUVUN TULEE OLLA SUUREMPI KUIN YKSI\n");
      
   }while( n < 2 );
   
   if( n < MAX ){
      minJakaja = haeJakaja( n );
      
      if( minJakaja == n ){
         printf("\nLuku %d on alkuluku\n", n);
      }else{
         printf("\nLuvun %d pienin jakaja on %d\n", n, minJakaja);
      }
      
   }else{
      printf("\nLUVUN TULEE OLLA PIENEMPI KUIN %d\n", MAX);
   }
   
   return 0;
}

int lueInt(void){
   int luku;
   int status;
   char merkki;
   
   while((status = scanf("%d%c", &luku, &merkki))==0 || (status == 2 && merkki !='\n')){
   
      //printf("Luettiin luku-muuttujaan luku %d ja merkki-muuttujaan merkki %c\n", luku, merkki);
      
      lueRoskat(); 
      
      printf("\nEt syöttänyt kokonaislukua, yritä uudelleen > ");
      
   }
   
   return luku;
}

void lueRoskat(void){

   char merkki;
   
   //printf("PING\n");
   while( (merkki = getchar() ) != '\n'){
     ; //printf("Luettiin merkki %c\n", merkki ); 
   }
   //printf("Luettiin enter eli luku %d\n", (int)merkki);
   
}

int parillinen(int n ){
   return (n % 2) == 0;
}

int haeJakaja(int n ){
   int jakaja = 0; //
   int testi;
   
   if( parillinen(n)){
      jakaja = 2; //jakaja löytyi, n on parillinen
   }else{
      jakaja = 0;
      testi = 3;
   }
   
   while( jakaja == 0 ){
      
      printf("Testi alkaa \n");
      
      if( testi > sqrt(n) ){
         jakaja = n;
      
      }else {
         if( (n % testi) == 0){
            jakaja = testi;
         }else{
            testi = testi + 2;
         }

      }
   }
   
   return jakaja;

}


