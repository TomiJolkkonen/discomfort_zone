#include <stdio.h>

// ohjelman käyttöesimerkki:

// ensin käännetään ohjelma, nimeksi tulee mpDemo
// gcc -o mpDemo mainParDemo.c

// mpDemo ohjelman käynnistys ja parametrit (-100 34 99 qwerty) perässä
// ./mpDemo -100 34 99 qwerty

//ohjelma tulostus (käynnistyskomento on aina ensimmäisenä):
// 0. parametri on : ./mpDemo
// 1. parametri on : -100
// 2. parametri on : 34
// 3. parametri on : 99
// 4. parametri on : qwerty
// Value: -100


// main -funktion parametrit
// argc, on parametrien lukumäärä
// args, taulukko jossa on osoittimia merkkijonoihin, jotka käyttäjä on syöttänyt komentoriviltä

int main( int argc, char * args[] ){
   
   int i;
   int value;
   
   if( 0 != argc ){
      
      for(i=0; i < argc; i++) {
         
         printf("%d. parametri on : %s\n", i, args[i] );
         
      }
      if( argc > 1 ){ // onko muutakin parametreja kuin ohjelman käynnistyskutsu
         
         if( 1 == sscanf( args[1], "%d", &value ) ){ //muuttaa merkkijonon luvuksi (jos voi muuttaa)
            printf("Value: %d\n", value);
         }
      }
      
   }
   
   return 0;
}
