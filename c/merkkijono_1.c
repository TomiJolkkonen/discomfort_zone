#include <stdio.h>

int main(void){

  char mjono1[6];
  char mjono2[6];
  char mjono3[6];

  printf("Anna 1. merkkijono > ");
  scanf("%s", mjono1 );

  printf("Anna 2. merkkijono > ");
  scanf("%s", mjono2 );

  printf("Anna 3. merkkijono > ");
  scanf("%s", mjono3 );

  printf("Syotit merkkijonot %s ja %s ja %s\n", mjono1, mjono2, mjono3);

  return 0;
}
