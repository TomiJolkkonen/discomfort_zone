#include <stdio.h>

int main(void){

  int koepisteet=-1;
  int result = 0;

  do{

     printf("Anna pistemaara > ");
     result = scanf("%d", &koepisteet);

     if( 0 == result ){

       while( getchar() != '\n'){ //tyhjent‰‰ puskurin v‰‰rist‰ merkeist‰
           printf("Luetettiin vaara merkki\n");
       }
     }

     if( koepisteet < 0 ){
        printf("Liian pieni pistemaara\n");
     }else if( koepisteet > 24 ){
        printf("Liian suuri pistemaara\n");
     }

 
  }while( koepisteet < 0 || koepisteet > 24 ); // || on TAI 

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

   } //switch

  return 0;

}//main