#include <stdio.h>
#include <math.h>

int main(void){
    double summa = 0.1 + 0.1+ 0.1+ 0.1+ 0.1+ 0.1+ 0.1+ 0.1+ 0.1+ 0.1;


    if( fabs(summa-1.0) < 0.00001 )
        printf("summa on: %.20f\n", summa);

    return 0;

}






