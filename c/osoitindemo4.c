#include <stdio.h>

void vaihda( int , int ); //esittely

int main(void){

   int luku1 = 0;
   int luku2 = 0;
   int luku3 = 0;
   

   printf("\nAnna luku  >");
   scanf("%d", &luku1);

   printf("\nAnna luku  >");
   scanf("%d", &luku2);

   printf("\nAnna luku  >");
   scanf("%d", &luku3);


   printf("\nluku1: %d ja luku2: %d luku3: %d\n", luku1, luku2, luku3); 

   vaihda( luku1, luku2);
   vaihda( luku1, luku3);
   vaihda( luku2, luku3);

   printf("\nluku1: %d ja luku2: %d luku3: %d\n", luku1, luku2, luku3);

   return 0;
}

void vaihda( int p1, int p2){

   int temp = 0;

   if( p1 > p2 ){
      printf("\nVaihto kaynnistyy\n");
      temp = p1;
      p1 = p2;
      p2 = temp;
   }
}