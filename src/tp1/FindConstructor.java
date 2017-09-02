package tp1;

//Travail fait par :
//Bobet Pierrick - 17 131 792
//Bouteloup Remy - 17 132 265

import org.xml.sax.Attributes;

import health.AirConnectible;
import health.Alveoli;

public class FindConstructor
{
    // Comfort Constructor
    FindConstructor(String qName, Attributes attributes) {
        switch(qName) {
            case "AirConnectible": new AirConnectible(attributes);
                break;
            case "Alveoli": new Alveoli(attributes);
                break;
                // Voir si c'est une bonne idée
            default: System.err.println("Error with the choice of the constructor");     
        }
    }
}
