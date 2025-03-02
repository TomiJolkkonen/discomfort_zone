#include <stdio.h>
#include <stdlib.h>


int main(void){

  char * mjono;
  int koko;

  printf("Anna tekstin maksimipituus > ");
  scanf("%d", &koko);
  getchar();

  mjono = malloc( koko * sizeof(char) );

  if( NULL != mjono ){

     printf("Anna merkkijono (max %d merkkia) > ", koko );
     fgets( mjono, koko, stdin );

     printf("Syotit merkkijonon \"%s\"\n", mjono );
     free( mjono );
     //mjono = NULL;
 
     printf("Syotit merkkijonon \"%s\"\n", mjono );

  }else{
    printf("Jokin meni pieleen, ei tullut muistia varatuksi\n");
  }

  return 0;
}