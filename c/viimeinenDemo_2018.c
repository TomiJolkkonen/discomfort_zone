#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define NIMEN_PITUUS 81

typedef struct solmu * Solmuptr; //oma tyyppi osoitinta varten.

typedef struct asiakas{
   
   char nimi[NIMEN_PITUUS];
   char osoite[NIMEN_PITUUS];
   char asnro[9];
   double maksut;
   
}Asiakas_t;

typedef struct solmu {
   
   Asiakas_t asiakas;
   Solmuptr seuraava; //osoitin seuraavaan samankaltaiseen solmuun
   
}Solmu_t;

//
void valikko( void );

int lueInt( void );
double lueDouble(void);
void lueMerkkijono( char mjono[], int koko );
void lueRoskat( void );

void lisaaListaan( Solmuptr * alku );
void tulosta( Solmuptr * alku );
void etsi( Solmuptr * alku );
void listaTiedostoon( Solmuptr * alku );
void listaTiedostosta( Solmuptr * alku );

void tulostaAsiakas( Asiakas_t asiakas );
Asiakas_t lueAsiakas( void );


int main( void ){
   
   int valinta;
   int loppu = 0;
   Solmuptr alku = NULL; //lista on tyhj‰
   char vastaus[2];
   
   //haluaako käytäjä yrittää heti ottaa käyttöön vanhan asiakastiedoston
   printf("Haluatko ottaa kayttoon tiedostossa olevan asiakaslistan (K/E)? > ");
   lueMerkkijono( vastaus, 2 );
   
   if( toupper(vastaus[0]) == 'K'){
      listaTiedostosta( &alku ); // luetaan tiedot tiedostosta linkitettyyn listaan
   }
   
   
   do{
      
      valikko();
      valinta = lueInt();
      
      switch( valinta ){
            
         case 1: //lisaa
            lisaaListaan( &alku );
            break;
            
         case 2: //tulosta
            tulosta( &alku );
            break;
            
         case 3: //etsi
            etsi( &alku );
            break;
            
         case 4: //lajittele
                 // not implemented yet
            break;
            
         case 5: //lista tiedostoon
            listaTiedostoon( &alku );
            break;
            
         case 6: //lista tiedostosta
            listaTiedostosta( &alku );
            break;
            
         case 0: loppu = 1;
            break;
            
         default: printf("Virheellinen komento!\n");
            break;
            
      } //switch
      
   }while( !loppu );
   
   return 0;
}

void valikko( void ){
   
   printf("1 lisaa uusi \n");
   printf("2 tulosta\n");
   printf("3 etsi\n");
   printf("4 lajittele\n");
   printf("5 lista tiedostoon\n");
   printf("6 lista tiedostosta\n");
   printf("0 Loppu\n");
   
   printf("\n\nValintasi > ");
   
}

int lueInt(void){
   
   int luku;
   char mki;
   int status;
   
   while( (status = scanf("%d%c", &luku, &mki))==0 || (status==2 && mki != '\n')){
      
      lueRoskat();
      
      printf("Ei kay, yrita uudelleen > ");
      
   }
   
   return luku;
   
}

double lueDouble(void){
   
   double luku;
   char mki;
   int status;
   
   while( (status = scanf("%lf%c", &luku, &mki))==0 || (status==2 && mki != '\n')){
      
      lueRoskat();
      
      printf("Ei kay, yrita uudelleen > ");
      
   }
   
   return luku;
   
}

void lueRoskat( void ){
   while( getchar() != '\n')
      ;
}


void lueMerkkijono( char mjono[], int koko ){
   
   fgets( mjono, koko, stdin );
   
   if( mjono[ strlen(mjono) -1 ] == '\n'){
      mjono[ strlen(mjono) -1 ] = '\0';
   }else{
      lueRoskat();
   }
   
}

//lisää uuden solmun linkitettyyn listaan
// saa parametrina main-metodissa olevan listan alun osoittavan muuttujan osoitteen
// näiin mutokset välittyvät main -metodin muuttujalle

void lisaaListaan( Solmuptr * alku ){
   
   Solmuptr uusi = NULL;// lisattava solmu ennen lisamist‰a listaan
   Solmuptr ptr = NULL; //kaytetaan listan selaamiseen
   
   //uuden solmun luonti
   uusi = malloc( sizeof(Solmu_t) ); //varaa keko-muistista tilaa ja palauttaa varatun alueen osoitteen
   
   if( NULL == uusi ){
      
      printf("Hups, virhe \n");
      return;
      
   }
   //muutoin alustetaan uusi solmu
   // solmua ei ole vielä liitetty listaan
   uusi->seuraava = NULL;
   uusi->asiakas = lueAsiakas(); //luetaan asikakaskenttään arvot
   
   
   //onko lista tyhja
   if( NULL == *alku ){
      
      *alku = uusi; //uusi solmu lista 1. solmuksi
      
   }else { // ei ollut tyhjä lista
      
      ptr = *alku;
      // ptr-muuttujan avulla siirrytä listassa solmusta toiseen kunnes löytyy
      //viimeinen solmu, joka perään uusi solmu liitetään
      while( ptr->seuraava != NULL ){
         
         ptr = ptr->seuraava;
         
      }
      
      ptr->seuraava = uusi; //nyt on löytynyt solmu, jonka perään uusi liitetään
   }
   
}

Asiakas_t lueAsiakas( void ){
   
   Asiakas_t apu;
   
   printf("Anna asiakkaan nimi > ");
   lueMerkkijono( apu.nimi, NIMEN_PITUUS );
   
   printf("Anna asiakkaan osoite > ");
   lueMerkkijono( apu.osoite, NIMEN_PITUUS );
   
   printf("Anna asiakkaan asiakasnumero > ");
   lueMerkkijono( apu.asnro, 9 );
   
   printf("Anna asiakkaan maksut > ");
   apu.maksut = lueDouble();
   
   return apu;
   
}

void tulosta( Solmuptr * alku ){
   
   Solmuptr apu = *alku; //listasta kiinni
   
   if (NULL == apu ){
      
      printf("[alku] -> NULL\n");
      
   }else {
      
      printf("[alku]->\n");
      tulostaAsiakas( apu->asiakas );
      
      while( NULL!= apu -> seuraava ){
         printf("->\n");
         apu = apu -> seuraava;
         tulostaAsiakas( apu->asiakas );
      }
      
   }
}


void tulostaAsiakas( Asiakas_t asiakas ){
   
   printf("Nimi: %s\n", asiakas.nimi );
   printf("Osoite: %s\n", asiakas.osoite );
   printf("Asiakasnumero: %s\n", asiakas.asnro );
   printf("Nimi: %.3lf\n\n\n", asiakas.maksut );
   
}

void etsi( Solmuptr * alku ){
   
   Solmuptr apu = *alku; //kiinnitetaan apu listan alkuun
   char asiakasNumero[9]; //etsittävän asiakkaan asiakasnumero
   int loytyi = 0; // lippumuuttuja ilmaisee onko tieto löytynyt
   
   //onko lista tyhja
   if( NULL == apu ){ //tai NULL == *apu
      
      printf("Lista on tyhja\n");
      
   }else {
      
      //etsitään asiakasnumeron perusteella
      printf("Anna etsittavan asiakkaan asiakasnumero > ");
      lueMerkkijono( asiakasNumero, 9 );
      
      //listan läpikäynti päättyyy jos
      // 1. lista päättyy eikä löydy
      // 2. heti kun etsittävä tieto löytyy
      while( NULL != apu && !loytyi ){
         //koska asiakasnumero on merkkijono
         // tehdään vertailu strcmp funktiolla, joka palauttaa arvon nolla
         // jos merkkijonot ovat samoja
         
         if( strcmp( asiakasNumero, apu->asiakas.asnro) == 0){
            loytyi = 1 ;// tieto löytyi, haku voi päättyä
            tulostaAsiakas( apu->asiakas);
         }
         apu = apu->seuraava; //Siirry listan seuraavaan
      }
      
      if( !loytyi ){ //jos lippumuuttuja on edelleen nolla ===> etsittävää tietoa ei löytynyt listasta
         printf("Asiakasta \"%s\" ei loydy\n", asiakasNumero );
      }
   }
   
}

void listaTiedostoon(Solmuptr * alku ){
   
   FILE * tiedosto;
   char tiedostonNimi[NIMEN_PITUUS];
   Solmuptr apu = *alku;// kiinnitetään listan alkuun, alku -muuttujaa ei saa muuttaa
   
   
   printf("Anna tiedostolle nimi > ");
   lueMerkkijono( tiedostonNimi, NIMEN_PITUUS );
   
   //avaa tiedoston,
   // jos tiedosto on jo olemassa sen vanha sisältö häviää
   // jos tiedostoa ei ole olemassa, tiedosto luodaan
   tiedosto = fopen( tiedostonNimi, "w" );
   
   //onnistuiko avaaminen, NULL ilmaisee että ei onnistunut
   if( NULL == tiedosto ){
      printf("Virhe tiedoston avaamisessa\n");
   }else {
      
      //kirjoitaaan solmu kerraallaan asiakastiedot tiedostoon
      // kunnes apu saa arvon null, jolloin kaikki listan alkiot eli asikakkaat on talletettu
      while( NULL != apu ){
         
         //kirjoitetaan asiakkaan tiedot tiedostoon
         fwrite( &apu->asiakas, sizeof(Asiakas_t), 1, tiedosto);
         apu = apu->seuraava; // apu hyppää seuraavaan solmuun, jos
      }
      
      fclose( tiedosto );//lopuksi suljetaan tiedosto
      tiedosto = NULL;
   }
   
}

void listaTiedostosta( Solmuptr  * alku ){
   
   FILE * tiedosto;
   char tiedostonNimi[NIMEN_PITUUS];
   Solmuptr apu = *alku;
   Solmuptr uusi = NULL;
   
   Asiakas_t temp;
   
   
   printf("Anna tiedostolle nimi > ");
   lueMerkkijono( tiedostonNimi, NIMEN_PITUUS );
   
   //avaa tiedoston,
   tiedosto = fopen( tiedostonNimi, "r" );
   
   //onnistuiko avaaminen, NULL ilmaisee että ei onnistunut
   if( NULL == tiedosto ){
      printf("Virhe tiedoston avaamisessa\n");
   }else {
      
      //luetaan yksi asiakas tiedostosta
      fread( &temp, sizeof(Asiakas_t), 1, tiedosto );
      
      //jos ei tullut tiedoston loppu vastaan,
      // niin talletetaan luettu asiakastieto linkitettyyn listaan
      while( !feof(tiedosto )){
         
         //varataan uudelle solmulle tilaa
         uusi = malloc( sizeof( Solmu_t ));
         
         //onnistuiko tilanvaraus
         // voi mennä pieleen mm. sen vuoksi että vapaata muistia ei ole tarpeeksi
         if( NULL == uusi ){
            printf("Jokin meni pieleen\n");
         }else {
            
            //kopioidaan luetun asiakkaan tiedot solmun asiakaskenttiin
            uusi->asiakas = temp;
            uusi->seuraava = NULL; // uusi tulee listan hännille
            
            if( NULL == *alku ){ // onko lista tyhjä
               
               *alku = uusi; //lisäys alkuun
               apu = *alku;  // myös apu osoittamaan uuteen lisättyyn solmuun
               
               
            } else { // ei ollut uusi alkio listan loppuun
               
               apu->seuraava = uusi; //
               apu = apu->seuraava; //apu osoittamaan eteenpäin
            }
            
            //luetaan seuraava asiakastieto tiedostosta
            fread( &temp, sizeof(Asiakas_t), 1, tiedosto );
            
            
         }
      }
      
      
      fclose( tiedosto );
   }
   
   
}








