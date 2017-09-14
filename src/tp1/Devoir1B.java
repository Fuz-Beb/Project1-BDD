package tp1;

import java.io.File;
import java.io.FileNotFoundException;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.System;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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
     * @throws IOException
     * @throws SAXException
     */
    public static void main(String[] args) throws SAXException, IOException
    {
        // Attributes
        MainBody mainbody;

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
            // Lecture du JSON et affectation du mainbody
            mainbody = lectureXML(nomFichierJSON);
            ecritureXML(nomFichierXML, mainbody);
        }
        catch (ParserConfigurationException | FileNotFoundException | TransformerException e)
        {
            e.printStackTrace();
        }

        System.out.println("Conversion terminee.");
    }

    /**
     * Lecture du fichier XML avec SAXP
     * 
     * @param nomFichierJSON
     * @return mainBody
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static MainBody lectureXML(String nomFichierJSON)
            throws SAXException, IOException, ParserConfigurationException
    {
        // Construction du parseur
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        SAXParser parser = factory.newSAXParser();
        DefaultHandler hdl = new ParserXMLToJSON();
        parser.parse(new File(nomFichierJSON), hdl);

        return ((ParserXMLToJSON) hdl).getMainbody();
    }

    /**
     * Permet d'écrire un fichier XML et de générer un fichier
     * 
     * @param nomFichierXML
     * @param mainbody
     * 
     * @throws ParserConfigurationException
     * @throws FileNotFoundException
     * @throws TransformerException
     */
    public static void ecritureXML(String nomFichierXML, MainBody mainbody)
            throws ParserConfigurationException, FileNotFoundException, TransformerException
    {

        // Construction et préparation du document de sortie XML
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        Document document = f.newDocumentBuilder().newDocument();
        FileOutputStream output = new FileOutputStream(nomFichierXML);
        PrintStream out = new PrintStream(output);
        TransformerFactory allSpark = TransformerFactory.newInstance();
        Transformer transformer = allSpark.newTransformer();
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "HumanBody.dtd");
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        // Récupération des données à écrire
        mainbody.toXML(document);

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(out);
        transformer.transform(source, result);
    }
}