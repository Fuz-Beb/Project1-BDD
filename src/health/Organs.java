package health;

import java.util.HashMap;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Organs
{
    // Attributes
    private HashMap<Integer, Organ> organTab;

    // Default Constructor
    public Organs()
    {

    }

    // Getters / Setters

    /**
     * @return the organTab
     */
    public HashMap<Integer, Organ> getOrganTab()
    {
        return organTab;
    }

    /**
     * @param organTab
     *            the organTab to set
     */
    public void setOrganTab(HashMap<Integer, Organ> organTab)
    {
        this.organTab = organTab;
    }
}
