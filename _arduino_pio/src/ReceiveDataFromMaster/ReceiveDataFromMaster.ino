

#include <Arduino.h>


bool onOff = false;


void setup() {

  Serial.begin(115200); 
  while (!Serial) {}; // wait for serial port to connect.

  pinMode(LED_BUILTIN, OUTPUT); // initialize digital pin LED_BUILTIN as an output.
}


void loop() {

  if (!Serial.available())
    return;


  if (Serial.read() != -1) {
    onOff = !onOff;
    digitalWrite(LED_BUILTIN, onOff);
  }
}
