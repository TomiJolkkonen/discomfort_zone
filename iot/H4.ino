#include <EEPROM.h>
const byte nappi1 = 2;
const byte nappi2 = 3;
byte led = 12;
const byte lampotila = A0;
long mittausaika  = 0; 
long viimeisin_mittausaika = 0;
float viimeisin_anturilukema= 0;
// lampotila ja aika talteen
typedef struct Talteen
{
    float adc;
    long suoritusaika;
} Talteen;

Talteen talt;
int eeprom_addr = 0;

//setup-osiossa alustetaan portit ja pinnit jne
void setup() 
{
    pinMode(nappi1,INPUT);
    pinMode(nappi2,INPUT);
    pinMode(led,OUTPUT);
    //digitaalinen pinnikeskeytys napille
    attachInterrupt(digitalPinToInterrupt(nappi1), nollaaEeprom, FALLING);
    attachInterrupt(digitalPinToInterrupt(nappi2), tulostaTiedot, FALLING);
    Serial.begin(115200);
}

void loop() 
{

    int dummy=0;
    //Mitataan lampotilaa 5 sek valein
    mittaaLampotila();
}

//nollaus
void nollaaEeprom(){
    static unsigned long last_interrupt_time = 0;
    unsigned long interrupt_time = millis();
    // 200ms viive
    if (interrupt_time - last_interrupt_time > 200){
        int i;
        Serial.println("Tyhjennetaan EEPROM");
        // nollia tayteen kuten ohjeessa sanottiin
        for (int i = 0 ; i < EEPROM.length() ; i++) {
            EEPROM.write(i, 0);
        }
        eeprom_addr = 0;
        mittausaika = 0;
        Serial.println("Tyhja EEPROM");
    }
    last_interrupt_time = interrupt_time; 
}

void mittaaLampotila(){
    mittausaika = millis();
    if (mittausaika - viimeisin_mittausaika > 5000)
    {
        //alustetaan muuttujat
        float anturilukemasumma = 0;
        float anturilukema= 0;
        int naytemaara = 50;

        for (int i = 0; i < naytemaara; i++)
        {
            delay(20);
            anturilukemasumma += analogRead(lampotila);
        }
        //lasketaan keskiarvo 50 naytteesta
        anturilukema = anturilukemasumma /(float) naytemaara;
        if ( anturilukema != viimeisin_anturilukema )
        {
            talt.adc = anturilukema;
            //muunnetaan millisekunnit sekunneiksi
            talt.suoritusaika = mittausaika / 1000;
            // Tellennetaan tietue EEPROM-muistiin
            EEPROM.put(eeprom_addr, talt);
            
            eeprom_addr += sizeof(talt);
            if ( eeprom_addr >= EEPROM.length() )
                eeprom_addr = 0;
            viimeisin_anturilukema = anturilukema;
        }
        viimeisin_mittausaika = mittausaika;
    }
}
//Tulostus sarjaporttiin
void tulostaTiedot(){

    int i = 0;
    int x= 0;

    static unsigned long last_interrupt_time = 0;
    unsigned long interrupt_time = millis();
    if (interrupt_time - last_interrupt_time > 200){
        // Luetaan silmukan avulla EEPROM-muisti sarjaporttiin
        while (i < eeprom_addr)
        {

            Talteen talt1 = EEPROM.get(i, talt);
            float lampotila = 125.0 / 256.0 * talt1.adc - 50.0;
            long suoritusaika = talt1.suoritusaika;
//Tulostetaan sarjaporttiin
            Serial.print(++x);
            Serial.print(":\t");
            Serial.print("Aika: ");
            Serial.print(suoritusaika);
            Serial.print("\t Lampotila: ");
            Serial.println(lampotila);


            i += sizeof(talt); 
        }
    }
    last_interrupt_time = interrupt_time; 
}
