#include <stdio.h>

int main(void){

  int i;
  int koko;

  printf("Anna taulukon koko >");
  scanf("%d", &koko);

  double pituudet[koko];


  for( i = 0; i < koko; i++ ){
     printf("Anna reaaliluku > ");
     scanf("%lf", &pituudet[i]);
  }

  printf("\nTaulukon sisalto\n");

  for( i = 0; i < koko; i++ ){
     printf("pituudet[%d] = %lf\n", i, pituudet[i]);
  } 

  return 0;

}









