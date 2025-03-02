#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

void tulosta( int * buffer, int koko);

int main(void){

    int koko = 5; // taulukon koko alkutilanteessa
    int *buffer = NULL; //osoitin taulukkoon
    int * temp; // apuosoitin uuteen vähän isompaan taulukkoon, jonne kopioidaan aina entisen taulukon sisältö
    int luku;
    int paikka = 0; //indeksi seuraavan vapaaseen tiedon talletuspaikkaan

    buffer  = (int *)malloc(koko * sizeof(int)); //taulukon luonti

    while(paikka < 25){

        if( paikka < koko ){

           printf("Anna kokonaisluku > ");
           scanf("%d", &buffer[paikka]);

        }else{
            temp = (int *)malloc((koko+5) * sizeof(int)); //uusen isomman taulukon luonti

           if( temp != NULL ){
              
              memcpy( temp, buffer, (sizeof(int)*koko)); //kopioi vanhasta uuteen taulukkoon
              free( buffer );  // vanhan taulukon muistin vapautus
              buffer = temp; // vanha alkaa osoittaa uuteen
              temp = NULL;
              koko= koko + 5; //uuden taulukon paikkojen määrä

              printf("Anna kokonaisluku > ");
              scanf("%d", &buffer[paikka]);
           }

        }

        paikka++;
        tulosta(buffer, paikka);
       
    }


   free(buffer); //lopullinen muistin vapautus
   buffer = NULL;


   return 0;
}

void tulosta( int * buffer, int koko){
  int i;

  printf("\nTAULUKON KOKO ON %d\n", koko);

  for(i=0; i< koko; i++)
     printf("luku: %d\n", buffer[i]);


}
