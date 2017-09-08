package tp1;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System;
import java.util.HashMap;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import health.MainBody;

/**
 * Fichier de base pour le Devoir1A du cours IFT287
 *
 * <pre>
 * 
 * Vincent Ducharme
 * Universite de Sherbrooke
 * Version 1.0 - 6 août 2016
 * IFT287 - Exploitation de BD relationnelles et OO
 * 
 * Ce programme permet de convertir un fichier XML en son équivalent en JSON.
 *
 * Paramètres du programme
 * 0- Nom du fichier XML
 * 1- Nom du fichier JSON
 * 
 * </pre>
 */
public class Devoir1A
{
    /**
     * La méthode principale
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        // Attributes
        MainBody mainBody;

        if (args.length < 2)
        {
            System.out.println("Usage: java tp1.Devoir1A <fichierXML> <fichierJSON>");
            return;
        }

        String nomFichierXML = args[0];
        String nomFichierJSON = args[1];

        System.out.println("Debut de la conversion du fichier " + nomFichierXML + " vers le fichier " + nomFichierJSON);

        try
        {
            // Lecture du fichier XML
            mainBody = lectureXML(nomFichierXML);

            // Ecrire du fichier JSON
            ecrireJSON(nomFichierJSON, mainBody);

            System.out.println("Conversion terminee.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //
    /**
     * Lecture du fichier XML avec SAXP
     * 
     * @param nomFichierXML
     * @return mainBody
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static MainBody lectureXML(String nomFichierXML)
            throws SAXException, IOException, ParserConfigurationException
    {

        // Construction du parseur
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        SAXParser parser = factory.newSAXParser();
        DefaultHandler handler = new MonParser();
        parser.parse(new File(nomFichierXML), handler);

        return FindConstructor.getMainBody();
    }

    /**
     * @param monFichierJSON
     * @param mainBody
     * @throws FileNotFoundException
     */
    public static void ecrireJSON(String monFichierJSON, MainBody mainBody) throws FileNotFoundException
    {
        HashMap<String, Object> config = new HashMap<String, Object>(1);
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        // Création du générateur JSON
        JsonGeneratorFactory fact = Json.createGeneratorFactory(config);
        JsonGenerator jsonGenerator = fact.createGenerator(new FileOutputStream(new File(monFichierJSON)));

        mainBody.toJSON(jsonGenerator);

        // Fermeture du générateur
        jsonGenerator.close();
    }
}