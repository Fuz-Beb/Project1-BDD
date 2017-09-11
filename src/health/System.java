package health;

import java.util.HashMap;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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

    /**
     * Constructeur de confort pour XML -> JSON
     * @param attrs 
     * @throws IFT287Exception
     */
    public System(Attributes attrs) throws IFT287Exception
    {
        flowTab = new HashMap<Integer, Flow>();

        if (attrs != null)
        {
            id = Integer.parseInt(attrs.getValue("id"));
            name = attrs.getValue("name");
            type = Integer.parseInt(attrs.getValue("type"));
        }
        else
        {
            throw new IFT287Exception("System : bad attributes");
        }
    }

    /**
     * Constructeur de confort pour JSON -> XML
     * 
     * @param jsonObject
     * @throws IFT287Exception
     */
    public System(JsonObject jsonObject) throws IFT287Exception
    {
        flowTab = new HashMap<Integer, Flow>();
        JsonArray tempArray = jsonObject.getJsonArray("System");

        id = jsonObject.getInt("id");
        name = jsonObject.getString("name");
        type = jsonObject.getInt("type");

        for (int boucle = 0; boucle < tempArray.size(); boucle++)
        {
            flowTab.put(flowTab.size(), new Flow((JsonObject) flowTab.get(boucle)));
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

    /**
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("name", this.name);
        jsonGenerator.write("id", this.id);
        jsonGenerator.write("type", this.type);

        // Ecrit le sous-menu et le parcours tant qu'il y a des données
        jsonGenerator.writeStartArray("Flow");
        for (int i = 0; i < this.flowTab.size(); i++)
        {
            // Parcours des noeuds enfants
            flowTab.get(i).toJSON(jsonGenerator);
        }

        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }

    /**
     * @param document
     * @param node
     */
    public void toXML(Document document, Node node)
    {
        // Création de la balise System avec ses attributs
        Node system = document.createElement("System");
        ((Element) system).setAttribute("type", String.valueOf(type));
        ((Element) system).setAttribute("id", String.valueOf(id));
        ((Element) system).setAttribute("name", name);
        node.appendChild(system);

        // Création des balises enfants de System
        for (int i = 0; i < flowTab.size(); i++)
        {
            flowTab.get(i).toXML(document, system);
        }
    }
}
