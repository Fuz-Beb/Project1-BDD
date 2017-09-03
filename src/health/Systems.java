package health;

import java.util.HashMap;


import tp1.IFT287Exception;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Systems
{
    // Attributes
    private HashMap<Integer, System> systemTab;

<<<<<<< HEAD
    // Default Constructor
=======
    // Comfort Constructor
>>>>>>> 1b741857bca58348ba10f494505346df7ece3019
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
