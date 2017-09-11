package tp1;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import java.lang.System;
import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import health.Connectible;
import health.Connection;
import health.Flow;
import health.MainBody;
import health.Organ;
import health.To;

public class ParserXMLToJSON extends DefaultHandler
{
    MainBody mainbody;

    public void startDocument()
    {
    }

    public void endDocument()
    {
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs)
    {
        System.out.println("Start element = " + qName);
        
        switch (qName)
        {
            case "MainBody":
                mainbody = new MainBody(attrs);
                break;
            case "Systems":
                break;
            case "Organs":
                break;
            case "System":
                mainbody.getSystemTab().put(mainbody.getSystemTab().size(), new System(attrs));
                break;
            case "Flow":
                mainbody.getLastSystem().getFlowTab().put(mainbody.getLastSystem().getFlowTab().size(), new Flow(attrs));
                break;
            case "Connectible":
                break;
            case "Connections":
                break;
            case "Connection":
                mainbody.getLastFlow().getConnectionTab().put(mainbody.getLastFlow().getConnectionTab().size(), new Connection(attrs));
                break;
            case "to":
                mainbody.getLastConnection().getToTab().put(mainbody.getLastConnection().getToTab().size(), new To(attrs));
                break;
            case "Organ":
                mainbody.getOrganTab().put(mainbody.getOrganTab().size(), new Organ(attrs));
                break;
            default:
                mainbody.getLastFlow().getConnectibleTab().put(mainbody.getLastFlow().getConnectibleTab().size(), new Connectible(qName, attrs));
        }
    }

    public void endElement(String namespace, String lName, String qName)
    {
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

    /**
     * @return the mainbody
     */
    public MainBody getMainbody()
    {
        return mainbody;
    }
}