#include <Arduino.h>
#include <WiFi.h>
// https://randomnerdtutorials.com/esp32-http-get-post-arduino/
#include <HTTPClient.h>
#include "DHT.h"
//source : https://randomnerdtutorials.com/esp32-dht11-dht22-temperature-humidity-sensor-arduino-ide/
#define DHTPIN 4   
#define DHTTYPE DHT22  

DHT dht(DHTPIN, DHTTYPE);
const char* ssid = "Ste-adele";
const char* password = "allo1234";

const char* serverName = "http://10.0.0.154:8001/data";


unsigned long lastTime = 0;

unsigned long timerDelay = 5000;

void setup() {
  Serial.begin(9600);
  dht.begin();
  WiFi.begin(ssid, password);
  Serial.println("Connecting");
  while(WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());
 
  Serial.println("Timer set to 5 seconds (timerDelay variable), it will take 5 seconds before publishing the first reading.");
}

void loop() {
  delay(2000);
  float h = dht.readHumidity();
  float t = dht.readTemperature();

  if ((millis() - lastTime) > timerDelay) {
    if(WiFi.status()== WL_CONNECTED){
      WiFiClient client;
      HTTPClient http;
    
      http.begin(client, serverName);
      Serial.println(client);
      Serial.println(serverName);


      http.addHeader("Content-Type", "application/json");
      http.addHeader("Accept", "*/*");
      String data = "{\"sensor\":\"DHT22\",\"temperature\":\"" + String(t) + "\",\"humidity\":\"" + String(h) + "\"}";
      http.addHeader("Content-Length", String(data.length()));
      int httpResponseCode = http.POST(data);
      Serial.println(httpResponseCode);

     
      Serial.print("HTTP Response code: ");
      Serial.println(httpResponseCode);
        
      // Free resources
      http.end();
    }
    else {
      Serial.println("WiFi Disconnected");
    }
    lastTime = millis();
  }
}
