package health;

import java.util.HashMap;

import org.xml.sax.Attributes;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Systems
{
    // Attributes
    private HashMap<Integer, System> systemTab;

    // Comfort Constructor
    public Systems(Attributes attrs)
    {

    }

    // Getters / Setters

    /**
     * @return the systemTab
     */
    public HashMap<Integer, System> getSystemTab()
    {
        return systemTab;
    }

    /**
     * @param systemTab
     *            the systemTab to set
     */
    public void setSystemTab(HashMap<Integer, System> systemTab)
    {
        this.systemTab = systemTab;
    }
}
