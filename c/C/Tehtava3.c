#include <stdio.h>
#include <stdlib.h>

int main() {

    int pistemaara = 0;
    int arvosana = 0;

    printf("Anna tentin pistem‰‰r‰:\n");
    scanf("%d", &pistemaara);

    if (pistemaara < 12) {
        printf("Tenttisi on hyl‰tty.");
    } else if (pistemaara < 14) {
        arvosana = 1;
        printf("Arvosanasi on %d", arvosana);
    } else if (pistemaara < 17) {
        arvosana = 2;
        printf("Arvosanasi on %d", arvosana);
    } else if (pistemaara < 20) {
        arvosana = 3;
        printf("Arvosanasi on %d", arvosana);
    } else if (pistemaara < 23) {
        arvosana = 4;
        printf("Arvosanasi on %d", arvosana);
    } else if (pistemaara < 25) {
        arvosana = 5;
        printf("Arvosanasi on %d", arvosana);
    } else {
        printf("Virheellinen pistem‰‰r‰.");
    }
    return 0;
}
