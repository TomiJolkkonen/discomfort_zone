#include <stdio.h>

void piirraYmpyra(void);
void piirraKolmio(void);
void piirraSuorat(void);
void piirraKanta(void);




int main(void){

  // piirrä ympyrä

  piirraYmpyra( );


  // piirrä kolmio

  piirraKolmio( );


  // pirrä suorat

  piirraSuorat( );

  return 0;


}

void piirraYmpyra(void){

   //printf("\nPiirretaan ympyraa\n");
   printf("  *   * \n\n");
   printf(" *     *\n\n");
   printf("    *\n");
   

}

void piirraKolmio(void){

   //printf("\npiirretaan Kolmiota\n");

   piirraSuorat( );

   piirraKanta( );

}
void piirraSuorat(void){

   //printf("\npiirretaan suorat\n");
   printf("   / \\ \n");
   printf("  /   \\ \n");
   printf(" /     \\ \n");
   printf("/       \\ \n");
   

}

void piirraKanta(void){

  //printf("\npiirretaan kantaviivaa\n");
  printf("---------\n");

}
