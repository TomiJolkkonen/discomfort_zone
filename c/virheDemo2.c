#include <stdio.h>
#include <stdlib.h>


int main( void ) {

  char * merkkijono = (char *)malloc( sizeof(char) * 40 );

  if( merkkijono != NULL ){

    printf("\nAnna merkkijono > ");

    scanf("%s", merkkijono);
    printf("\nSyötit merkkijono \2%s\n\n", merkkijono);

  }else {
     printf("Muistinvaraus epaonnistui\n");
  }

  free( merkkijono );
  
  merkkijono = NULL;

  return 0;
}