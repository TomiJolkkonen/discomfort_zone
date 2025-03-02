#include <stdio.h>

int lueInt(void);
void lueRoskat();

int main(void){

  int koepisteet;

  printf("Anna pistemaara > ");
  //scanf("%d", &koepisteet);
  koepisteet = lueInt();

  switch( koepisteet ) {

     case 0 ... 11:
        printf("Hylatty\n");
        break;

     case 12 ... 13:
        printf("1\n");
        break;

     case 14 ... 16:
        printf("2\n");
        break;
    
     case 17 ... 19:
        printf("3\n");
        break;

     case 20 ... 22:
        printf("4\n");
        break;

     case 23 ... 24:
        printf("5\n");
        break;

     default:
        printf("Virheellinen pistemaara!\n");
        break;
 
  } //switch



  return 0;

}//main

int lueInt(void){

  int luku;
  char mki;
  int result;

  while((result = scanf("%d%c", &luku, &mki))== 0 || result==2 && mki!='\n'){
     lueRoskat();
     printf("EI KELPAA, SYOTA KOKONAISLUKU > ");

  }

  return luku;
}

void lueRoskat(void){

   char pois;
   while((pois=getchar())!='\n'){
     printf("Luettiin roska %c\n", pois);
   }

}
