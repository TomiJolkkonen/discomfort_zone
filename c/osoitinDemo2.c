#include <stdio.h>

void teeJotainYksi( int * par );
void teeJotainKaksi( int * par );

int main(void){

  int luku = 0;

  printf("luku on = %d\n", luku);

  teeJotainYksi( &luku );

  printf("main: luku on = %d\n", luku);

  return 0;
}

void teeJotainYksi( int * par ){

   printf("teejotainYksi: luku on = %d\n", *par);

   teeJotainKaksi( par );

}

void teeJotainKaksi( int * par ){

   printf("teeJotainKaksi: luku on = %d\n", *par);

   *par = 56;

}
