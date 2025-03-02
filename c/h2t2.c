//
//  h2t2.c
//  
//
//  Created by Ilkka Räsänen on 29/09/16.
//
//

#include <stdio.h>

int main(void){
   
   double celsiusAsteet = 0.0;
   double fahrenheitAsteet = 0.0;
   double kelvinAsteet = 0.0;
   
   //pyyda ja luen lampotila celsius-asteissa
   printf("Anna lampotila celsius -asteissa >");
   scanf("%lf", &celsiusAsteet);
   
   //tee muunnokset
   kelvinAsteet = celsiusAsteet + 273.15;
   fahrenheitAsteet = celsiusAsteet * 1.8 + 32;
   
   //tulosta tulokset
   printf("\n%.2lf celsius-astetta on %.2lf Kelvin -astetta\n", celsiusAsteet, kelvinAsteet);
   printf("%.2lf celsius-astetta on %.2lf Fahrenheit -astetta\n", celsiusAsteet, fahrenheitAsteet);

   return 0;
}
