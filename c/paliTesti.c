#include <stdio.h>
#include <string.h>
#include <ctype.h>

//#define _debug

void pieneksi(char * mjono );
void kaanna(char * mjono1, char * mjono2 );
int onkohanPalindromi( char * mjono );
void poistaMahdollisetValimerkit( char * temp, char *uusi , char * erotin );
void lueMjono( char * mjono, int koko );

int main(void)
{

    int koko = 256;
    char mjono[koko];

    printf("Syota merkkijono > ");
    lueMjono( mjono, koko );

    if( onkohanPalindromi(mjono ))
        printf("Merkkijono \"%s\" on palindromi\n", mjono);
    else
        printf("Merkkijono \"%s\" ei ole palindromi\n", mjono);

    return 0;
}

// muuttaa parametrina tulevan merkkijonon merkin pienaakkosiksi
// input/output: char *, käsiteltävä merkkijono
//
void pieneksi(char * mjono )
{

    int  i;
    int pituus = strlen(mjono);

    for(i = 0; i < pituus; i++ )
        mjono[i] = tolower( mjono[i]);


}

//  funktio tutkii onko merkkijono palindromi
//  input: char * , osoitin tutkittavaan merkkijonoon
// output: int, palauttaa luvun 1, jos merkkijon on palindromi, mutoin luvun 0
//
int onkohanPalindromi( char * mjono )
{

    char uusi[ strlen(mjono) +1 ];
    char temp[ strlen(mjono) +1 ];

    temp[0] = '\0';
    char * ptr = NULL;
    char erotin[] = " ,.!"; // välilynnit, pilkut, pisteet ja huutomerkit poistetaan ennen analysiä

    strcpy( uusi, mjono );
    #ifdef _debug
    printf("UUSI: %s\n", uusi);
    #endif // _debug

    poistaMahdollisetValimerkit( temp, uusi , erotin );
    pieneksi( temp );
    kaanna( uusi, temp );

    if( strcmp( uusi, temp )== 0)
    {
        #ifdef _debug
        printf("Sana %s on palindromi\n", mjono);
        #endif // _debug
        return 1;
    }else{
        #ifdef _debug
        printf("Sana %s ei ole palindromi\n", mjono);
        #endif
        return 0;
    }

}

// funktio poistaa merkkijonosta välimerkit
// input1: char *, apumuuttuja, jonne talletetaam siivottu merkkijono
// input2: char *, siivottava merkkijono
// input3: cahr *, merkkijonosta siivottavat merkit
// output: void, ei palauta mitään
//
void poistaMahdollisetValimerkit( char * temp, char *uusi , char * erotin ){

    char * ptr = strtok( uusi, erotin );

    while( ptr != NULL ){
        strcat(temp, ptr );
        #ifdef _debug
        printf("ptr = %s ja Temp: %s\n", ptr, temp);
        #endif

        ptr = strtok( NULL, erotin );

    }
}

// lukee merkkijono naäppäimistöltä
// input1: char ', luettava merkkijono
// input2: int, luettavan merkkijonon maksimikoko
// output: void, ei palauta mitään
//
void lueMjono( char * mjono, int koko ){

    int pituus;

    fgets( mjono, koko, stdin );

    pituus = strlen(mjono)-1;

    if( mjono[pituus] == '\n')
        mjono[pituus] = '\0';
    else
        while( getchar() != '\n')
            ;
}
// kopioi paramtrina tulevan merkkinonon ja kopioi sen ensimmaisena tulevaan parametriin
// input: char * mjono2, kopioitava parametri
// input/output: char * mjono1 , kopioinnin tulos

void kaanna(char * mjono1, char * mjono2 ){
   int pituus = strlen(mjono2);
   int i;

   for(i=0; i< pituus; i++){
      mjono1[i] = mjono2[(pituus-1) - i];
   }

    mjono1[i] = '\0';

}
