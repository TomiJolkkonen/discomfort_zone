#include <stdio.h>

#define NIMEN_PITUUS 21

typedef struct {

  char etunimi[NIMEN_PITUUS];
  char sukunimi[NIMEN_PITUUS];
  int opiskelijanumero;
  int jo_arvosana;

}Opiskelija_t;

void valikko( void );
int lueInt( void );
void lueRoskat( void );

int main(void){

  Opiskelija_t rekisteri[10];

  int i = 0;
  int j = 0;
  int loppu = 0;
  int komento = 0;

  do{
 
    valikko();
    komento = lueInt();

    switch( komento ){

      case 1: if( i < 10 ){

                 //kysy tiedot ja talleta reksiteriin
                 printf("Syota etunimi > ");
                 scanf("%21s", rekisteri[ i ].etunimi );
              
                 printf("Syota sukunimi > ");
                 scanf("%21s", rekisteri[ i ].sukunimi );

                 printf("Syota opiskelijanumero > ");
                 scanf("%d", &rekisteri[ i ].opiskelijanumero );
    
                 printf("Syota arvosana > ");
                 scanf("%d", &rekisteri[ i ].jo_arvosana );
          
                 i++; //lisättiin uusi opiskelija

              }else{
                 printf("Ei mahdu uusia opiskelijoita\n");
              }

              break;

       case 2: printf("\nEi ole toteutettu\n");
               break;


       case 3: if( i == 0 ){

                 printf("Reksiteri on tyhja\n");

               }else{

                  for(j=0; j < i; j++){

                     printf("Etunimi: %s\n", rekisteri[ j ].etunimi );
                     printf("sukunimi: %s\n", rekisteri[ j ].sukunimi );
                     printf("Nro: %d\n", rekisteri[ j ].opiskelijanumero );
                     printf("Arvosana: %d\n", rekisteri[ j ].jo_arvosana );

                  }
               }
                 
               break;
        case 0: loppu = 1;
                break;


        default: printf("\nVAARA KOMOENTO!\n");
                 break;


    }  
  
  }while( !loppu );

  return 0;

}

void valikko(void){  

  printf("1:lisää uusi opiskelija \n");
  printf("2:etsi opiskelijaa \n");
  printf("3:tulosta reksiterin sisalto \n");
  printf("0:lopetus \n");
  printf("\n > ");

}

int lueInt(void){
  
   int luku;
   char mki;
   int result;

   while(  (result = scanf("%d%c", &luku, &mki) )==0 || ( result == 2 && mki != '\n' ) ){

      lueRoskat();

      printf(" > ");


   }

   return luku;


}

void lueRoskat(void){

   while( fgetc( stdin ) != '\n' )
     ;
}