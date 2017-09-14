package tp1;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import java.lang.System;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import health.ConnectibleHealth;
import health.ConnectionHealth;
import health.FlowHealth;
import health.MainBody;
import health.OrganHealth;
import health.SystemHealth;
import health.ToHealth;

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
        
        try
        {        
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
                    mainbody.getSystemTab().put(mainbody.getSystemTab().size(), new SystemHealth(attrs));
                    break;
                case "Flow":
                    mainbody.getLastSystem().getFlowTab().put(mainbody.getLastSystem().getFlowTab().size(), new FlowHealth(attrs));
                    break;
                case "Connectible":
                    break;
                case "Connections":
                    break;
                case "Connection":
                    mainbody.getLastFlow().getConnectionTab().put(mainbody.getLastFlow().getConnectionTab().size(), new ConnectionHealth(attrs));
                    break;
                case "to":
                    mainbody.getLastConnection().getToTab().put(mainbody.getLastConnection().getToTab().size(), new ToHealth(attrs));
                    break;
                case "Organ":
                    mainbody.getOrganTab().put(mainbody.getOrganTab().size(), new OrganHealth(attrs));
                    break;
                default:
                    mainbody.getLastFlow().getConnectibleTab().put(mainbody.getLastFlow().getConnectibleTab().size(), new ConnectibleHealth(qName, attrs));
            }
        }
        catch (IFT287Exception e)
        {        
            e.printStackTrace();
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