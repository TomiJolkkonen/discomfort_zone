const byte keskeytyspinni = 3;   	// pinni jossa nappi1 on kiinni
int laskuri = 0;				 	// alustetaan laskuri
int sensorInput;    				// Tänne talletetaan sensorin input tieto
double temp;        				// Tilapäinen muuttuja lämpötilan tallentamiseen asteina 

void setup() {
   pinMode(keskeytyspinni, INPUT);
   Serial.begin(9600);
   // attachInterruptille viedään kaksi argumenttia inputtina;
   // keskeytyspinni, ja funktio joka pyöräytetään kun keskeytys tulee
   // kolmas argumentti = mitä keskeytystä käytetään, RISING = nappia painetaan
   attachInterrupt(digitalPinToInterrupt(keskeytyspinni), laskeLampotila, RISING);
} 

// loopissa ei tehdä nyt mitään, vaan keskeytysfunktiossa
void loop() {
	//
}

// täämä funktio pyöräytetään kun keskeytys tulee, eli nappia painetaan
// otetaan analogipinnistä 50 adc-lämpötilalukua 20ms välein ja lasketaan niiden ka.
// muunnetaan se myös celsiukseksi, ja tulostetaan molemmat luvut sarjamonitoriin
// ja tulostetaan molemmat sarjamonitoriin
// lämpötila-arvo saadaan muunnoskaavalla 0.7 * avgADC – 77.4
void laskeLampotila() {
  while (laskuri < 51) { // otetaan 50 mittausta sensorista
  	sensorInput = sensorInput + analogRead(A0);	// lasketaan yhteen
    delay(20);	// 20ms viiveellä mittaukset
    laskuri++; 
  }
  sensorInput = (sensorInput / 50);		// lasketaan mittauksista keskiarvo
  	temp = (double)sensorInput / 1024;  // lasketaan ne celsiukseksi
   	temp = temp * 5;                    
   	temp = temp - 0.5;                 
   	temp = temp * 100;   				
   	Serial.print("ADC: ");				// tulostus sarjamonitoriin
  	Serial.print(sensorInput);	
    Serial.print(" lt: ");
   	Serial.println(temp); 
}