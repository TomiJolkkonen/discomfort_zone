#include <stdio.h>

void tulostaValikko( void );
int lueInt( void );
void yhteenlaskutehtava( int * oikein, int * vaarin );
void vahennyslaskutehtava( int * oikein, int * vaarin );
void lueRoskat(void);


int main( void ) {

  int loppu = 0;
  int komento = 0;
  int vastaus = 0;
  int oikein = 0;
  int vaarin = 0;

  do{

    tulostaValikko();

    printf(" > ");
    
    komento = lueInt();
    

    switch( komento ){

       case 1: yhteenlaskutehtava( &oikein, &vaarin );

               break;

       case 2: vahennyslaskutehtava( &oikein, &vaarin );

               break;

       case 0: loppu = 1;
               break;

       default:printf("\nTUNTEMATON KOMENTO!\n");
               break;
            
    }

  }while( !loppu );

  printf("\nVastasit %d oikein ja %d vaarin\n", oikein, vaarin );

  return 0;

}//main p‰‰ttyy 


void tulostaValikko( void ){

    printf("1: yhteenlaskutehtava \n");
    printf("2: vahennyslaskutehtava \n");
    printf("0: LOPETTAA \n");

}// tulostaValikko p‰‰ttyy

// lukee yhden kokonaisluvun
// ja paluttaa sen kutsujalle
//
int lueInt( void ){

  int luku = 0;
  int result = 0;
  char merkki;

  while( (result = scanf("%d%c", &luku, &merkki))== 0 || (result == 2 && merkki != '\n') ){

     lueRoskat();

     printf(" > ");

  }

  return luku;

}//lueInt p‰‰ttyy

void yhteenlaskutehtava( int * oikein, int * vaarin ){

  int vastaus;

  printf("paljonko on 1 + 1 ?");
  vastaus = lueInt( );

  if( vastaus == 2 ){
      printf("\nOIKEIN\n");
      *oikein = *oikein + 1;

  }
  else{
      printf("\nVAARIN!\n");
      *vaarin = *vaarin +1;
  }

}

void lueRoskat(void){

   while( getchar() != '\n' )
        ; //tyhj‰ lause

}

void vahennyslaskutehtava( int * oikein, int * vaarin ){

  int vastaus;

  printf("paljonko on 1 - 1 ?");
  vastaus = lueInt( );

  if( vastaus == 0 ){
      printf("\nOIKEIN\n");
      *oikein = *oikein + 1;

  }
  else{
      printf("\nVAARIN!\n");
      *vaarin = *vaarin +1;
  }

}