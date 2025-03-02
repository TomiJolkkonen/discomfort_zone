#include <stdio.h>
#include <string.h>

void lueRoskat(void);
int luenInt(void);

int main(void){
   
   char tilinumero[256];
   FILE * tili;
   int saldo;
   int result;
   char pinkoodi[256];
   char tarkistusPin[256];
   
   do {
      
      printf("\nAnna tilinumero > ");
      fgets( tilinumero, 256, stdin );
      
      if( tilinumero[ strlen(tilinumero) -1] == '\n')
         tilinumero[ strlen(tilinumero) -1] = '\0';
      else
         lueRoskat();
      
      strcat(tilinumero, ".tili");
      
      if( ( tili = fopen( tilinumero, "r" ))!=NULL){
         printf("Anna pinkoodisi > ");
         
         fgets( pinkoodi, 256, stdin );
         
         if( pinkoodi[ strlen(pinkoodi) -1] == '\n')
            pinkoodi[ strlen(pinkoodi) -1] = '\0';
         else
            lueRoskat();
         
         
         fgets( tarkistusPin, 256, tili );
         
         do {
            
            if( tarkistusPin[ strlen(tarkistusPin) -1] == '\n') //poista rivinvaihto
               tarkistusPin[ strlen(tarkistusPin) -1] = '\0';
            
            // WINDOWS OHJELMILLA LUODUISSA TIEDOSTOISSA ON RIVIN LOPPU
            // MERKATTU KAHDELLA MERKILLÄ
            // (carriage return = cr = '\r' ja newline/linefeed = lf = '\n')
            //
            // JOTEN, JOS VERTAIU PIN-KOODIEN VÄLILLÄ
            // EI ONNISTU, TEE SEURAAVA TOIMENPIDE:
            if( tarkistusPin[ strlen(tarkistusPin) -1] == '\r') //poista telanpalautus cr
               tarkistusPin[ strlen(tarkistusPin) -1] = '\0';
            
            
            if( (result = strcmp( pinkoodi, tarkistusPin ))  == 0 ){
               fscanf( tili, "%d", &saldo);
            }else
               printf("Vaara pin-koodi, yrita uudelleen");
            
         }while( !result );
         
         
         
      } else {
         printf("\nTilisi on suljettu\n");
      }
      
   }while(1);
   
   return 0;
   
}

void lueRoskat(void){
   
   while(fgetc(stdin) != '\n');
   
}



