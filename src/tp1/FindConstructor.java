package tp1;

import java.util.HashMap;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import health.Connectible;
import health.Connection;
import health.Flow;
import health.MainBody;
import health.Organ;
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
    public void findConstructor(String qName, HashMap<String, String> attrs) throws IFT287Exception
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
                mainBody.getSystemTab().put(mainBody.getSystemTab().size(), new System(attrs));
                break;
            case "Flow":
                mainBody.getLastSystem().getFlowTab().put(mainBody.getLastSystem().getFlowTab().size(), new Flow(attrs));
                break;
            case "Connectible":
                break;
            case "Connections":
                break;
            case "Connection":
                mainBody.getLastFlow().getConnectionTab().put(mainBody.getLastFlow().getConnectionTab().size(), new Connection(attrs));
                break;
            case "to":
                mainBody.getLastConnection().getToTab().put(mainBody.getLastConnection().getToTab().size(), new To(attrs));
                break;
            case "Organ":
                mainBody.getOrganTab().put(mainBody.getOrganTab().size(), new Organ(attrs));
                break;
            default:
                mainBody.getLastFlow().getConnectibleTab().put(mainBody.getLastFlow().getConnectibleTab().size(), new Connectible(qName, attrs));
        }        
    }
}