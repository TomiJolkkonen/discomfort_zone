#include <stdio.h>
#include <stdlib.h>

int main()
{
    int lampotila_C = 0;

    printf("Anna lämptila celsius-asteina:\n");
    scanf("%d", &lampotila_C);

    double lampotila_K = lampotila_C + 273.15;
    double lampotila_F = (lampotila_C) * 1.8 + 32;

    printf("Antamasi celsiusasteet %d ovat Kelvineinä %f ja Fahrenheiteinä %f.", lampotila_C, lampotila_K, lampotila_F);

    return 0;
}
