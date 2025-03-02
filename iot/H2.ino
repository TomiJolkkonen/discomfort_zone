const byte ledipinni = 12;       // pinni jossa ledi on kiinni
const byte keskeytyspinni = 3;   // pinni jossa nappi1 on kiinni
volatile byte ledintila = LOW;   // palaako ledi, LOW=ei pala
int laskuri = 0;				 // alustetaan laskuri, jota tulostellaan sarjamonitorissa

void setup() {
   pinMode(ledipinni, OUTPUT);
   pinMode(keskeytyspinni, INPUT);
   Serial.begin(9600);
   // attachInterruptille viedään kaksi argumenttia inputtina;
   // keskeytyspinni, ja funktio joka pyöräytetään kun keskeytys tulee
   // kolmas argumentti = mitä keskeytystä käytetään, CHANGE = signaalin vaihto
   // keskeytys siis tulee vain jos nappia 1 painetaan
   attachInterrupt(digitalPinToInterrupt(keskeytyspinni), palaako, RISING);

} 

// loopissa pyöritetään ledin tilaa, joka on oletuksena LOW,
// ellei tule keskeytysta, jolloin tila vaihtuu keskeytysfunktiossa "palaako"
void loop() {
   digitalWrite(ledipinni,ledintila);
}

// täämä funktio pyöräytetään kun keskeytys tulee, el ledin tila vaihtuu
// ts. se syttyy palamaan niin kauaksi aikaa kun keskeytys on voimassa,
// eli nappi 1 on pohjassa
void palaako() {

  laskuri++;					//nappia painettaessa laskuri laskee
  if (!(laskuri % 2 == 0)) { 	// parittomat painallukset sytyttää ledin
    ledintila = HIGH;  	
  } else {
  	ledintila = LOW;
  }
  Serial.print("Laskuri: ");	// tulostetaan painallukset sarjamonitoriin
  Serial.println(laskuri);
  
}