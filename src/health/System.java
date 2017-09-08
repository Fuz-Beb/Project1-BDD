package health;

import java.util.HashMap;

import javax.json.stream.JsonGenerator;

import org.xml.sax.Attributes;

import tp1.IFT287Exception;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class System
{
    // Attributes
    private String name;
    private int id;
    private int type;
    private HashMap<Integer, Flow> flowTab;

    // Comfort Constructor
    public System(Attributes attrs) throws IFT287Exception
    {
        flowTab = new HashMap<Integer, Flow>();

        if (attrs != null)
        {
            name = attrs.getValue(0);
            id = Integer.parseInt(attrs.getValue(1));
            type = Integer.parseInt(attrs.getValue(2));
        }
        else
        {
            throw new IFT287Exception("System : bad attributes");
        }
    }

    // Getters / Setters

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the type
     */
    public int getType()
    {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(int type)
    {
        this.type = type;
    }

    /**
     * @return the flowTab
     */
    public HashMap<Integer, Flow> getFlowTab()
    {
        return flowTab;
    }

    /**
     * @param flowTab
     *            the flowTab to set
     */
    public void setFlowTab(HashMap<Integer, Flow> flowTab)
    {
        this.flowTab = flowTab;
    }

    // Methods

    public void addFlow(Flow flow)
    {
        flowTab.put(flowTab.size(), flow);
    }

    /**
     * @param jsonGenerator
     */
    public void ToJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("name", this.name);
        jsonGenerator.write("id", this.id);
        jsonGenerator.write("type", this.type);

        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("Flow");
        for (int i = 0; i < this.flowTab.size(); i++)
        {
            this.flowTab.get(i).ToJSON(jsonGenerator);
        }

        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }
}
