package tp1;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import java.lang.System;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
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
        FindConstructor findConstructor = new FindConstructor();

        try
        {
            findConstructor.findConstructor(qName, attributes);
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