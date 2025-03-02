#include <stdio.h>
#include <stdlib.h>

int main(void){

   int komento = 0;
   int luku1 = 0, luku2 = 0, vastaus = 0;
   int oikeat = 0, vaarat = 0;
   int LOPPU=0;

   srand((unsigned) time(NULL));

   do{

     printf("Paina 1 jos haluat yhteenlaskun\n");
     printf("Paina 2 jos haluat vahennyslaskun\n");
     printf("Paina 0 jos haluat lopettaa\n");

     printf(" > ");

     scanf("%d", &komento);

     switch( komento ){

        case 1: 
           //printf("Yhteenlasku tulee tahan\n");

           luku1 = rand() % 11; // 0 - 10
           luku2 = rand() % 11; // 0 - 10

           printf("Paljonko on %d + %d ?", luku1, luku2);
           scanf("%d", &vastaus);

           if( vastaus == (luku1 + luku2) ){
              printf("OIKEIN!\n");
              oikeat++;
           }else{
              printf("VAARIN\n");
              vaarat++;
           }
         
           break;

        case 2:
           //printf("Vahennyslasku tulee tahan\n");

           luku1 = rand() % 11; // 0 - 10
           luku2 = rand() % 11; // 0 - 10

           printf("Paljonko on %d - %d ?", luku1, luku2);
           scanf("%d", &vastaus);

           if( vastaus == (luku1 - luku2) ){
              printf("OIKEIN!\n");
              oikeat++;
           }else{
              printf("VAARIN\n");
              vaarat++;
           }
           break;

        case 0:
           LOPPU = 1;
           break;

        default:
           printf("Tuntematon komento\n\n");
           break;   
     }

   }while( !LOPPU );

   printf("Vastasit oikein %d kertaa\n", oikeat);
   printf("Vastasit vaarin %d kertaa\n", vaarat);

   return 0;

}