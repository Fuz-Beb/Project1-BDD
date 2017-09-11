package health;

import java.util.HashMap;

import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

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
        organTab = new HashMap<Integer, Organ>();
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

    // Methods

    public void addOrgan(Organ organ)
    {
        organTab.put(organTab.size(), organ);
    }

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
        Node organs = document.createElement("Organs");
        node.appendChild(organs);
        
        // Création des balises enfants
        for (int i = 0; i < organTab.size(); i++)
        {
            organTab.get(i).toXML(document, organs);
        }
    }
}