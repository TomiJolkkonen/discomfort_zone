//
//  h2t4.c
//  
//
//  Created by Ilkka Räsänen on 29/09/16.
//
//

#include <stdio.h>

int main(void){
   
   double tontinLeveys = 0.0, tontinPituus = 0.0;
   double talonLeveys = 0.0, talonPituus = 0.0;
   double tontinAla = 0.0;
   double talonAla = 0.0;
   double leikattavaAla = 0.0;
   double leikkurinLeveys = 0.7;
   double leikkurinNopeus = 5.0;
   double aika;
   
   //lue tontin mitat
   printf("Anna tontin leveys >");
   scanf("%lf", &tontinLeveys);
   
   printf("Anna tontin pituus > ");
   scanf("%lf", &tontinPituus);
   
   //laske tonti ala
   tontinAla = tontinLeveys * tontinPituus;
   
   //lue talon mitat
   printf("Anna talon leveys > ");
   scanf("%lf", &talonLeveys);
   
   printf("Anna talon pituus > ");
   scanf("%lf", &talonPituus);
   
   //laske talon ala
   talonAla = talonLeveys * talonPituus;
   
   //leikattava ala on tontin ala - talon ala
   leikattavaAla = tontinAla - talonAla;
   
   //laske leikkaamiseen kuluva aika
   // 5 km/h =>5/3.6 m/s
   aika = leikattavaAla / (leikkurinLeveys * (leikkurinNopeus/ 3.6));
   
   //tulosta aika
   printf("\nLeikkaamiseen kuluva aika on %.2lf sekuntia \n", aika);
   
   return 0;
}
