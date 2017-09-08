package health;

import java.util.HashMap;

import javax.json.stream.JsonGenerator;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265


public class Systems
{
    // Attributes
    private HashMap<Integer, System> systemTab;

    // Default Constructor
    /**
     * 
     */
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

    /**
     * @param system
     */
    public void addSystem(System system)
    {
        systemTab.put(systemTab.size(), system);
    }

    /**
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();
        
        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("System");
        for (int i = 0; i < this.systemTab.size(); i++)
        {
            this.systemTab.get(i).ToJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }
}