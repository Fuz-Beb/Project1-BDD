package health;

import java.util.HashMap;

import javax.json.stream.JsonGenerator;

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
        // Ecrit l'objet actuel dans le générateur JSON
        jsonGenerator.writeStartObject();
        
        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("Organ");
        for (int i = 0; i < organTab.size(); i++)
        {
            organTab.get(i).toJSON(jsonGenerator);
        }                
        
        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }
}
