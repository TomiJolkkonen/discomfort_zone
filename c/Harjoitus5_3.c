#include <stdio.h>
#include <math.h>

void lue_pisteet (double [][2], int koko);
void tulosta_taulukko (double [][2], int koko);
double laske_etaisyys (double, double, double, double);

int main (void) {

    double pisteet[10][2] = {0};
    double etaisyys;
    
    while (getchar() != '\n');

    lue_pisteet(taulukko, koko);
    tulosta_taulukko (rivi, koko);
    
    etaisyys = laske_etaisyys (etaisyys);

    printf ( "Pisteiden x %lf, y %lf ja x %lf, y %lf etäisyys on %lf\n", x1, y1, x2, y2, etaisyys);
    
    return 0;

}

void lue_pisteet (double taulukko[][2], int koko) {
	printf("Montako pistettä meinaat syöttää?");
	scanf("%d\n", &koko);
	for (int i=0; i<koko; i++) {
        printf ("Syötä pisteen x-arvo");
        scanf("%lf\n", taulukko[i][0]);
        printf ("Syötä pisteen y-arvo");
        scanf("%lf\n", taulukko[i][1]);
		}
}


void tulosta_taulukko (double rivi[][2], int koko) {
    for (int i=0; i<koko; i++) {
        printf("%d %5.2lf %5.2lf\n", i, rivi[i][0], rivi[i][1]);
    }
}


double laske_etaisyys (double x1, double y1, double x2, double y2) {
    double etaisyys;
    distance = sqrt(pow((x1-x2)+(y1-y2)));
    return etaisyys;
}
