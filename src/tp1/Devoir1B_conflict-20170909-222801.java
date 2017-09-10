package tp1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.xml.sax.Attributes;


// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import java.lang.System;
import java.util.HashMap;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import health.MainBody;

/**
 * Fichier de base pour le Devoir1B du cours IFT287
 *
 * <pre>
 * 
 * Vincent Ducharme
 * Universite de Sherbrooke
 * Version 1.0 - 6 août 2016
 * IFT287 - Exploitation de BD relationnelles et OO
 * 
 * Ce programme permet de convertir un fichier JSON en son équivalent en XML.
 *
 * Paramètres du programme
 * 0- Nom du fichier JSON
 * 1- Nom du fichier XML
 * 
 * </pre>
 */
public class Devoir1B
{
    /**
     * La méthode principale
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        MainBody mainBody;

        if (args.length < 2)
        {
            System.out.println("Usage: java tp1.Devoir1B <fichierJSON> <fichierXML>");
            return;
        }

        String nomFichierJSON = args[0];
        String nomFichierXML = args[1];

        System.out.println("Debut de la conversion du fichier " + nomFichierJSON + " vers le fichier " + nomFichierXML);

        
        try
        {
        
            FileInputStream file = new FileInputStream(new File(nomFichierJSON));
            JsonReader reader =  Json.createReader(file);
            
            JsonObject obj = reader.readObject();
            mainBody = new MainBody(obj);
        

            // Lecture du fichier JSON
//            mainBody = lectureJSON(nomFichierJSON, null);

            System.out.println("Conversion terminee.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Methods

    public static MainBody lectureJSON(String nomFichierJSON, JsonObject jsonArg) throws FileNotFoundException, IFT287Exception
    {
        FileInputStream file = new FileInputStream(new File(nomFichierJSON));
        JsonReader reader = Json.createReader(file);
        JsonObject jsonObject;
        HashMap<String, String> attributes = null;
        FindConstructor findConstructor = new FindConstructor();
        
        // Initialisation de la récusivité
        if(jsonArg == null)
            jsonObject = reader.readObject();
        else
            jsonObject = jsonArg;
        
        
        
        
        System.out.println("Test 1 : " + jsonObject);
                
        
        for (Object key : jsonObject.keySet()) {
            String keyStr = (String)key;
            Object keyValue = jsonObject.get(keyStr);
            
            attributes = new HashMap<String, String>();
            attributes.put(keyStr, keyValue.toString());
            
//            findConstructor.findConstructor(keyStr, attributes);

            //Print key and value
            System.out.println("key: "+ keyStr + " value: " + keyValue);

            //for nested objects iteration if required
            if (keyValue instanceof JsonArray) {
                JsonObject test = null;
                test.put(((JsonArray) keyValue).getString(0), (JsonValue) keyValue);
                
                
                
                System.out.println("Recursivite");
                
                lectureJSON(nomFichierJSON, test);

            }
        }
        
        return (new MainBody(jsonObject));
    }

}
