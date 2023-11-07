int nappi1 = 0; // painonapeille alustukset
int nappi2 = 0;
// setup pyöräytetään kerran läpi kun laite resetoidaan tai käynnistetään
// täällä tehdään muu "pohjustus" laitteelle, eli
// tässä kerrotaan että meillä on yksi ledi ja kaksi painonappia
void setup() {
  pinMode(12, OUTPUT);     // ledi
  pinMode(3, INPUT);       // ensimmäinen painonappi
  pinMode(2, INPUT);       // toinen painonappi 
  Serial.begin(9600);      // avaa sarjamonitorin, johon tulostetaan
}
// ikuinen silmukka, jota ajetaan koko ajan ellei koodata keskeytyksiä
// jos pinni on auki, ledi päällä, tai nappi pohjassa, arvo on HIGH
// muussa tapauksessa arvo on LOW
void loop() {
  nappi1 = digitalRead(3);   // muuttujaan luetaan pinniä
  nappi2 = digitalRead(2);
  
  if (nappi1 == LOW || nappi2 == LOW) {
  digitalWrite(12, HIGH);     // ledi päälle
  Serial.println("LED ON");  // viesti sarjamonitorille
  delay(2000);               // odotetaan 2 sekuntia
  digitalWrite(12, LOW);      // ledi pois päältä
  Serial.println("LED OFF"); // viesti sarjamonitorille
  delay(2000);               // odotetaan 2 sekuntia
  }

}