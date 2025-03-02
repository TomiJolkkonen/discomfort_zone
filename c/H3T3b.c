#include <stdio.h>

int main(void){
   int luku = 1;
   int kertoma = 1; // 0:n kertoma on 1
   
   while( luku <= 5){
      
      printf("luvun %d kertoma %d\n", luku, kertoma);
      luku++;
      kertoma = kertoma * luku;
      
   }
   
   
   
   return 0;
}