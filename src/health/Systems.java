package health;

import java.util.HashMap;

import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

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
        
    }

    /**
     * @param document
     * @param node
     */
    public void toXML(Document document, Node node)
    {
        // Création de la balise
        Node systems = document.createElement("Systems");
        node.appendChild(systems);

        // Création des balises enfants
        for (int i = 0; i < systemTab.size(); i++)
        {
            systemTab.get(i).toXML(document, systems);
        }
    }
}