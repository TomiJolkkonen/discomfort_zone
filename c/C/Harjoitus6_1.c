#include <stdio.h>
#include <ctype.h>

int main ( void ) {
    int i = 0;
    char merkkijono [100];
    
    printf("Anna merkkijono");
    scanf("%c\n", &merkkijono);
    
    while (merkkijono[i] != '\0') {
        merkkijono[i] = toupper(merkkijono[i]);
        i++;
    }
    printf ("syöte muutettuna suuriksi kirjaimiksi: %s", merkkijono);
    
    i = 0;
    while (merkkijono[i] != '\0') {
        merkkijono[i] = tolower(merkkijono[i]);
        i++;
    }
    printf ("takaisin alas muutettuna: %s", merkkijono);

    return 0;
}
