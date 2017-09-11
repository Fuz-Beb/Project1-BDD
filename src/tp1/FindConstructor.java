package tp1;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import org.xml.sax.Attributes;

import health.Connectible;
import health.Connection;
import health.Connections;
import health.Flow;
import health.MainBody;
import health.Organ;
import health.Organs;
import health.Systems;
import health.System;
import health.To;

/**
 * 
 */
public class FindConstructor
{
    // Attributes
    
    private static MainBody mainBody;

    // Getters / Setters

    /**
     * @return the mainBody
     */
    public static MainBody getMainBody()
    {
        return mainBody;
    }

    /**
     * @param mainBody
     *            the mainBody to set
     */
    public static void setMainBody(MainBody mainBody)
    {
        FindConstructor.mainBody = mainBody;
    }

    // Methods

    /**
     * Find Constructor method
     * 
     * @param qName
     * @param attrs
     * @throws IFT287Exception
     */
    public void findConstructor(String qName, Attributes attrs) throws IFT287Exception
    {
        switch (qName)
        {
            case "MainBody":
                mainBody = new MainBody(attrs);
                break;
            case "Systems":
                break;
            case "Organs":
                break;
            case "System":
                mainBody.addSystem(new System(attrs));
                break;
            case "Flow":
                mainBody.getLastSystem().addFlow(new Flow(attrs));
                break;
            case "Connectible":
                break;
            case "Connections":
                break;
            case "Connection":
                mainBody.getLastFlow().addConnection(new Connection(attrs));
                break;
            case "to":
                mainBody.getLastConnection().addTo(new To(attrs));
                break;
            case "Organ":
                mainBody.addOrgan(new Organ(attrs));
                break;
            default:
                mainBody.getLastFlow().addConnectible(new Connectible(qName, attrs));
        }
    }
}