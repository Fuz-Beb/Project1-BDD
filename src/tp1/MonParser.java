package tp1;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import java.lang.System;
import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MonParser extends DefaultHandler
{

    public void startDocument()
    {
        System.out.println("Start document");
    }

    public void endDocument()
    {
        System.out.println("End document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        System.out.println("Start element = " + qName);

        HashMap<String, String> attributesTab = null;
        FindConstructor findConstructor = new FindConstructor();

        if (attributes != null)
        {
            attributesTab = new HashMap<String, String>();
            
            for(int boucle = 0; boucle < attributes.getLength(); boucle++)
                attributesTab.put(attributes.getLocalName(boucle), attributes.getValue(boucle));
        }

        try
        {
            findConstructor.findConstructor(qName, attributesTab);
        }
        catch (IFT287Exception e)
        {
            e.printStackTrace();
        }
    }

    public void endElement(String namespace, String lName, String qName)
    {
        System.out.println("End element = " + qName);
    }

    public void warning(SAXParseException e)
    {
        System.out.println("Warning catched ! Message : " + e.getMessage());
    }

    public void error(SAXParseException e)
    {
        System.out.println("Error catched ! Message : " + e.getMessage());
    }

    public void fatalError(SAXParseException e)
    {
        System.out.println("FatalError catched ! Message : " + e.getMessage());
    }
}