/*********
  harjoitus 5 tomi jolkkonen
*********/

// Ladataan wifikirjasto
#include <WiFi.h>
#include <Wire.h>
#include <Adafruit_BME280.h>
#include <Adafruit_Sensor.h>

/*#include <SPI.h>
#define BME_SCK 18
#define BME_MISO 19
#define BME_MOSI 23
#define BME_CS 5*/

#define SEALEVELPRESSURE_HPA (1013.25)

Adafruit_BME280 bme; // I2C
//Adafruit_BME280 bme(BME_CS); // hardware SPI
//Adafruit_BME280 bme(BME_CS, BME_MOSI, BME_MISO, BME_SCK); // software SPI

const char* ssid     = "tassa_olisi_mun_verkon_tunnus";
const char* password = "tassa_olisi_verkkoni_salasana";

// portin maarittely
WiFiServer server(80);

// tanne talletetaan http request
String header;

// nykyhetki
unsigned long currentTime = millis();
// edellinen hetki
unsigned long previousTime = 0; 
// timeout millisekunteina, eli tassa 2 sekuntia
const long timeoutTime = 2000;

void setup() {
  Serial.begin(115200); // avataan sarjamonitori
  bool status;

  // default settings
  //status = bme.begin();  
  if (!bme.begin(0x76)) {
    Serial.println("ri löydy sensoria, tarkista piuhat");
    while (1);
  }

  // yhdistetaan wifi, annetaan verkon tunnus ja salasana
  Serial.print("Yhdistetaan ");
  Serial.println(ssid);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  // tulostetaan lokaali IP osoite ja kaynnistetaan serveri
  Serial.println("");
  Serial.println("WiFi connected.");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  server.begin();
}

void loop(){
  WiFiClient client = server.available();   // kuunnellaan

  if (client) {                             // jos loytyy
    currentTime = millis();
    previousTime = currentTime;
    Serial.println("uusi client");          // tulostetaan siita viesti
    String currentLine = "";                // tanne tuleva data
    while (client.connected() && currentTime - previousTime <= timeoutTime) {  // kun ollaan yhteydessa clientiin, niin..
      currentTime = millis();
      if (client.available()) {             // jos on jotain luettavaa,
        char c = client.read();             // luetaan, ja
        Serial.write(c);                    // tulostetaan se sarjamonitoriin
        header += c;
        if (c == '\n') {                    // jos tulee rivinvaihto
          // jos rivi on tyhja, silloin on kaksi rivinvaihtoa perakkain
          // ollaan silloin lopussa, joten
          if (currentLine.length() == 0) {
            // HTTP header alkaa response codella esim HTTP/1.1 200 OK
            client.println("HTTP/1.1 200 OK");
            client.println("Content-type:text/html");
            client.println("Connection: close");
            client.println();
            
            // naytetaan html-sivu
            client.println("<!DOCTYPE html><html>");
            client.println("<head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            client.println("<link rel=\"icon\" href=\"data:,\">");
            // CSS tyyli 
            client.println("<style>body { text-align: center; font-family: \"Trebuchet MS\", Arial;}");
            client.println("table { border-collapse: collapse; width:35%; margin-left:auto; margin-right:auto; }");
            client.println("th { padding: 12px; background-color: #0043af; color: white; }");
            client.println("tr { border: 1px solid #ddd; padding: 12px; }");
            client.println("tr:hover { background-color: #bcbcbc; }");
            client.println("td { border: none; padding: 12px; }");
            client.println(".sensor { color:white; font-weight: bold; background-color: #bcbcbc; padding: 1px; }");
            
            // nettisivu otsikko
            client.println("</style></head><body><h1>ESP32 with BME280</h1>");
            client.println("<table><tr><th>MEASUREMENT</th><th>VALUE</th></tr>");
            client.println("<tr><td>Temp. Celsius</td><td><span class=\"sensor\">");
            client.println(bme.readTemperature());
            client.println(" *C</span></td></tr>");  
            client.println("<tr><td>Temp. Fahrenheit</td><td><span class=\"sensor\">");
            client.println(1.8 * bme.readTemperature() + 32);
            client.println(" *F</span></td></tr>");       
            client.println("<tr><td>Pressure</td><td><span class=\"sensor\">");
            client.println(bme.readPressure() / 100.0F);
            client.println(" hPa</span></td></tr>");
            client.println("<tr><td>Approx. Altitude</td><td><span class=\"sensor\">");
            client.println(bme.readAltitude(SEALEVELPRESSURE_HPA));
            client.println(" m</span></td></tr>"); 
            client.println("<tr><td>Humidity</td><td><span class=\"sensor\">");
            client.println(bme.readHumidity());
            client.println(" %</span></td></tr>"); 
            client.println("</body></html>");
            
            // http response loppuu toiseen tyhjaan riviin
            client.println();
            // pois loopista
            break;
          } else { // tyhjennetaan nykyinen rivi
            currentLine = "";
          }
        } else if (c != '\r') {  // jos on mita tahansa muuta kuin carriage return
          currentLine += c;      // lisataan se nykyriville
        }
      }
    }
    // tyhjennetaan headerimuuttuja
    header = "";
    // suljetaan yhteys
    client.stop();
    Serial.println("Yhteys katkaistu");
    Serial.println("");
  }
}
