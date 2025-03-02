#include <stdio.h>
#include <stdlib.h>

typedef struct solmu * solmuptr;

typedef struct solmu {
   int data;
   solmuptr link;
}Solmu;
    
void tulostaLista( solmuptr );
void lisaaListaan( solmuptr *, int );
void tuhoaLista( solmuptr *);

int main(){

   solmuptr alku = NULL;

   int i = 0;
   
   printf("\nAlkutilanne:");
   tulostaLista(alku);

   for(i=1; i <= 5; i++){
      //lisätään listaan i:n arvoja
      //funktiolle on välitettävä osoittimen osoite, jotta muutokset
      // näkyvät alku-muuttujasta
      lisaaListaan( &alku, i ); 
   }
   
   printf("\nLopullinen lista:");
   tulostaLista(alku); // tässä ei tarvitse välittää muuttujan osoitetta
		       // koska tulostaminen ei muuta listan sisältöä

   //funktiolle on välitettävä osoittimen osoite, jotta muutokset
   // näkyvät alku-muuttujasta
   printf("\nListan täystuho alkaa...\n");
   tuhoaLista( &alku );  

   return 0;
}

void tulostaLista( solmuptr  alku){

   solmuptr temp;

   temp = alku;

   printf("\n");
   printf("[alku]->");

   while( NULL != temp ){

      printf("[%d]->", temp->data);
      temp=temp->link;

   }
   printf("NULL\n\n");

}

// Funktio saa parametrina listan alkuosoitinmuuttujan osoitteen,
// jotta muutokset välittyvät pääohjelmassa olevaan listan alkuosoittimeen.
void lisaaListaan( solmuptr  * alku, int arvo){

    solmuptr uusi = NULL;
    solmuptr temp = NULL;

    //luo uusi lisättävä solmu
    uusi = (solmuptr) malloc( sizeof( Solmu ) );

    //täytä solmun muuttujat
    uusi -> link = NULL;
    uusi -> data = arvo;
    
    //kiinnitetään temp listaan
    //tempin avulla käydään läpi listaa
    //alkua ei saa käyttää läpikäyntiin, koska tällöin hukataan listan alkioita
    temp = *alku;

    //onko lista tyhjä?
    if( NULL == temp ){

       // lisäys listan 1. solmuksi
       *alku = uusi;
       printf("\n1. alkion lisäyksen jälkeen:");
       tulostaLista( *alku );
       

    }else{

       //lisäys listan hännille
       //temp = alku;

       //haetaan viimeisin solmu
       while( NULL != temp->link)
          temp = temp->link;

       //lisää uusi solmu 
       temp->link = uusi;
       
       printf("\nUuden alkion lisäyksen jälkeen:");
       tulostaLista( *alku );

   }
   printf("\nReturn jatkaa\n");
   getchar();

} 

// Funktio saa parametrina listan alkuosoitinmuuttujan osoitteen,
// jotta muutokset välittyvät pääohjelmassa olevaan listan alkuosoittimeen.
// Funktio poistaa aina yhden solmun listan alusta ja tulostaa
// muuttuneen listan sisällön.
// Poistamista jatketaan kunnes lista on tyhjä.

void tuhoaLista( solmuptr * alku ){

   solmuptr pois = NULL; //osoittaa listasta poistettavaa solmua

   //tuhotaan listaa solmu kerralla, kunnes lista on tyhjä, eli *alku on NULL  
   while( NULL != *alku ){
  
      //kiinnitetään listan 1. solmu poistettavaksi
      pois = *alku;
      *alku = pois->link; // aseta alku osoittamaan lista 2. solmua

      pois->link = NULL; // solmu "unohtaa" olleensa listassa, tämä ei ole pakollista
      free(pois); // vapauta solmun käyttämä muisti

      printf("\nLista alkion eli solmun poistamisen jälkeen:");
      tulostaLista( * alku );
      printf("\nReturn jatkaa\n");
      getchar();
   }
}
    

    


