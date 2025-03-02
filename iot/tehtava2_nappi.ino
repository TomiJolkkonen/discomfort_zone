int switchState = 0; // luodaan muuttuja napin painamiselle, alustetaan nollaksi
// setup pyöräytetään kerran läpi kun laite resetoidaan tai käynnistetään
// täällä esitellään muuttujat tai tehdään muu "pohjustus" laitteelle, eli
// tässä kerrotaan että meillä on kolme lediä digitaalipinneissä 3, 4 ja 5.
// lisäksi meillä on nappi pinnissä kaksi.
void setup() {
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(2, INPUT); //painonappi mukaan koodiin
}

// ikuinen silmukka, jota ajetaan koko ajan ellei koodata keskeytyksiä
// tässä kerromme, että "kirjoita" pinni auki HIGH, eli laita ledi päälle,
// tai "kirjoita" pinni kiinni LOW, eli sulje se
// Lisäksi nyt on nappi, eli kun sille ei mene virtaa eli se on LOW, ledit ei pala.
// jos nappi on pohjassa eli virta on HIGH, leditkin on HIGH eli päällä.
void loop() {
  switchState = digitalRead(2);
  if (switchState == LOW) { // nappi ei ole pohjassa
  	digitalWrite(3, LOW);  // valot ei ole päällä
  	digitalWrite(4, LOW);
  	digitalWrite(5, LOW);
  }
  else { 				   // nappi on pohjassa
  	digitalWrite(3, HIGH); // valot on päällä
  	digitalWrite(4, HIGH);
  	digitalWrite(5, HIGH);
  }
}