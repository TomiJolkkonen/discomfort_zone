#include <stdio.h>

int main(void){

  int i;

  int lukuja[5] = {12345};
  int kukkaruukku=99999;

  

  for(i=0; i<20;i++){
     printf("%d\n", lukuja[i]);
  }

  lukuja[7] = 77777;


  for(i=0; i<20;i++){
     printf("%d\n", lukuja[i]);
  }

  printf("Kukkaruukku %d\n", kukkaruukku);

  return 0;
}
