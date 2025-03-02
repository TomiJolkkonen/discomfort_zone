//
//  paivitysDemo.c
//
//
//  Created by Ilkka Räsänen on 18/10/17.
//
//

#include <stdio.h>
#include <string.h>

typedef struct asiakas{
   
   int asiakasnumero;
   char nimi[51];
   
}Asiakas_t;

void tulostaValikko(void);
int lueInt(void);
void lueRoskat(void);
Asiakas_t lueAsiakas(void);
void tulostaAsiakas(Asiakas_t as);
void lisaa(void);
void etsi(void);
void poista(void);
void tulostaRekisteri(void);



int main(void){
   
   int komento;
   
   do {
      tulostaValikko();
      
      komento = lueInt();
      
      switch(komento){
            
         case 1: //lisäys
            lisaa();
            break;
            
         case 2: //etsintä
            etsi();
            break;
            
         case 3: //poisto
            poista();
            break;
            
         case 4: //tulota rekisterin tiedot
            tulostaRekisteri();
            break;
            
         case 0:
            return 0;
            break;
            
         default:
            printf("Virheellinen valinta \n");
            break;
            
            
      }
      
   }while(1);
   
   
   return 0;
}


void tulostaValikko(void){
   
   printf("1 Lisää \n");
   printf("2 Etsi  \n");
   printf("3 poista\n");
   printf("4 tulosta kaikki\n");
   printf("0 Lopeta\n");
   
   printf("\nValintasi >");
   
}

void lisaa(void){
   
   Asiakas_t as;
   Asiakas_t temp;
   FILE * rekisteri;
   
   
   if((rekisteri = fopen( "asiakkaat.txt", "r+"))==NULL){
      
      if((rekisteri = fopen( "asiakkaat.txt", "w"))==NULL) {
         printf("VIRHE; EI VOI TEHDÄ MITÄÄN\n");
         return;
      }else {
         
         printf("Rekisteri on tyhja:\n");
         as = lueAsiakas();

         fwrite( &as, sizeof(Asiakas_t), 1, rekisteri );
         printf("Lisättiin uusi asiakas\n");
         fclose( rekisteri );
         return;
         
      }
      
   }
   
   as = lueAsiakas();
   
   fread( &temp, sizeof(Asiakas_t), 1, rekisteri );
   
   while( !feof(rekisteri) ){
      
      if( temp.asiakasnumero == as.asiakasnumero ){
         printf("Asiakasnumero on jo kaytossa\n");
         fclose( rekisteri );
         return;
         
      }
      
      fread( &temp, sizeof(Asiakas_t), 1, rekisteri );
      
   }
   
   fwrite( &as, sizeof(Asiakas_t), 1, rekisteri );
   printf("Lisättiin uusi asiakas\n");
   fclose( rekisteri );
   return;
}

void etsi(void){
   
   Asiakas_t as;
   Asiakas_t temp;
   FILE * rekisteri;
   
   
   if((rekisteri = fopen( "asiakkaat.txt", "r"))==NULL){
      printf("Ei onnistu, ei ole tiedostoa\n");
      return;
   }
   
   printf("Anna etsittvan asiakasnumero > ");
   as.asiakasnumero = lueInt();
   
   fread( &temp, sizeof(Asiakas_t), 1, rekisteri );
   while( !feof(rekisteri) ){
      
      if( temp.asiakasnumero == as.asiakasnumero ){
         printf("Asiakas löytyi\n");
         tulostaAsiakas( temp );
         fclose( rekisteri );
         return;
         
      }
      
      fread( &temp, sizeof(Asiakas_t), 1, rekisteri );
      
   }
   
   printf("Asiakasta %d ei löydy rekisteristä\n", as.asiakasnumero);
   return;
   
}

void poista(void){
   int asiakasnumero;
   Asiakas_t temp;
   FILE * rekisteri;
   FILE * temprek;
   
   
   if((rekisteri = fopen( "asiakkaat.txt", "r"))==NULL){
      printf("Ei onnistu, ei ole tiedostoa\n");
      return;
   }
   
   if((temprek = fopen("loput.txt", "w"))==NULL){
      printf("VIRHE\n");
      return;
   }
   
   
   printf("Anna poistettavan asiakasnumero > ");
   asiakasnumero = lueInt();

   fread( &temp, sizeof(Asiakas_t), 1, rekisteri );
   
   while( !feof(rekisteri) ){
      
      if( temp.asiakasnumero == asiakasnumero ){
         printf("Asiakas poistettiin\n");
         tulostaAsiakas( temp );
         
      }else{
         printf("EI POISTETTU  ASIAkasta\n");
         fwrite( &temp, sizeof(Asiakas_t), 1, temprek );
      }
      
      fread( &temp, sizeof(Asiakas_t), 1, rekisteri );
      
   }
   
   fclose( rekisteri );
   fclose( temprek );
   
   remove( "asiakkaat.txt" );
   rename( "loput.txt", "asiakkaat.txt");
   
}

void tulostaRekisteri(void){
   
   Asiakas_t as;
   FILE * rekisteri;
   int i = 1;
   
   
   if((rekisteri = fopen( "asiakkaat.txt", "r"))==NULL){
      printf("Ei onnistu, tiedostoa ei loydy\n");
      return;
   }
   
   fread( &as, sizeof(Asiakas_t), 1, rekisteri );
   
   while( !feof(rekisteri) ){
      
      tulostaAsiakas( as );
      
      fread( &as, sizeof(Asiakas_t), 1, rekisteri );
      
      if( i % 10 == 0)
         getchar();
      
   }
   
   fclose( rekisteri );
   return;
}


Asiakas_t lueAsiakas(void){
   Asiakas_t as;
   
   printf("Anna asiakasnumero > ");
   as.asiakasnumero = lueInt();
   
   printf("Anna asiakkaan nimi > ");
   fgets( as.nimi, 51, stdin);
   
   if(as.nimi[ strlen(as.nimi)-1] == '\n')
      as.nimi[ strlen(as.nimi)-1] = '\0';
   else
      lueRoskat();
   
   return as;
   
}

void tulostaAsiakas(Asiakas_t as){
   
   printf("Asiakasnumero: %d\n", as.asiakasnumero);
   printf("Nimi: %s\n", as.nimi);
   
}

int lueInt(void){
   
   int luku;
   int result;
   char mki;
   
   while((result=scanf("%d%c", &luku, &mki))==0 || (result==2 && mki !='\n')){
      
      lueRoskat();
      printf("Ei käy, yrita uudelleen > ");
   }
   return luku;
}

void lueRoskat(void){
   while( getchar()!='\n');
}
