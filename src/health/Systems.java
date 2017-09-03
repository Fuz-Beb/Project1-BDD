package health;

import java.util.HashMap;


// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Systems
{
    // Attributes
    private HashMap<Integer, System> systemTab;

    // Default Constructor
    public Systems()
    {
        systemTab = new HashMap<Integer, System>();
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
    
    // Methods

    public void addSystem(System system)
    {
        systemTab.put(systemTab.size() - 1, system);
    }
}
