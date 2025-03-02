#include <stdio.h>
#include <string.h>

typedef struct {
    char sukumimi[100];
    char etunimi[100];
    int opiskelijanumero;
    int tulovuosi;
}Opiskelijat;

int lisaaOpiskelija (struct Opiskelijat);
char etsiOpiskelija (struct Opiskelijat);
void selaaOpiskelijoita(struct Opiskelijat);

int main (void) {
    
    int valinta;

	printf("Tervetuloa opiskelijarekisteriin!\n");
	printf("Valitse seuraavista vaihtoehdoista:\n");
	printf("Lisää opiskelija painamalla yksi(1)\n");
	printf("Etsi opiskelijaa painamalla kaksi (2)\n");
	printf("Selaa opiskelijoita painamalla kolme (3)\n");
	printf("Lopeta ohjelma painamalla nolla (0)\n"); 

    while (valinta != 0) {
        switch (valinta){
            case 1:
                lisaaOpiskelija(Opiskelijat);
                break;
            case 2:
                etsiOpiskelija (Opiskelijat);
                break;
            case 3:
                selaaOpiskelijoita(Opiskelijat);
                break;
            case 0:
                break;
            default:
                printf("Et valinnut oikein.");
                break;
        }
    }
    
		
    return 0;
}


int lisaaOpiskelija (struct Opiskelijat) {
    printf("Sukunimi:\n");
    strcpy(sukunimi.Opiskelijat);
    printf("Etunimi:\n");
    strcpy(etunimi.Opiskelijat);
    printf("Opiskelijanumero:\n");
    strcpy(opiskelijanumero.Opiskelijat);
    printf("Tulovuosi:\n");
    strcpy(tulovuosi.Opiskelijat);
    return;
}

char etsiOpiskelija (struct Opiskelijat) {
    char etsittavaEtunimi[50];
    char etsittavaSukunimi[50];
    printf("Anna etunimi:\n");
    scanf("%s\n", &etsittavaEtunimi);
    printf("Anna sukunimi:\n");
    scanf("%s\n", &etsittavaSukunimi);
    if(strcmp(etsittavaEtunimi, etunimi) && etsittavaSukunimi, sukunimi)
		printf("Löytyi");
	else
		printf("Ei löytynyt");
}

 
void selaaOpiskelijoita (struct Opiskelijat) {
    int i;
    int laskuri = 0;
    for (i=0; i<laskuri; i++) {
        printf("%d. Opiskelija:\n", i+1);
   }

}
