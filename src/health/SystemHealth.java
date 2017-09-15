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

public class SystemHealth
{
    // Attributes
    private String name;
    private int id;
    private int type;
    private HashMap<Integer, FlowHealth> flowTab;

    // Comfort Constructor

    /**
     * Constructeur de confort pour XML -> JSON
     * 
     * @param attrs
     * @throws IFT287Exception
     */
    public SystemHealth(Attributes attrs) throws IFT287Exception
    {
        flowTab = new HashMap<Integer, FlowHealth>();

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
    public SystemHealth(JsonObject jsonObject) throws IFT287Exception
    {
        JsonArray arraySystem = jsonObject.getJsonArray("System");
        JsonObject systemObject = arraySystem.getJsonObject(0);
        JsonArray tempArray = systemObject.getJsonArray("Flow");
        int sizeTempArray = tempArray.size();

        flowTab = new HashMap<Integer, FlowHealth>();

        id = systemObject.getInt("id");
        name = systemObject.getString("name");
        type = systemObject.getInt("type");

        for (int boucle = 0; boucle < sizeTempArray; boucle++)
            flowTab.put(flowTab.size(), new FlowHealth((JsonObject) tempArray.get(boucle)));
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
    public HashMap<Integer, FlowHealth> getFlowTab()
    {
        return flowTab;
    }

    /**
     * @param flowTab
     *            the flowTab to set
     */
    public void setFlowTab(HashMap<Integer, FlowHealth> flowTab)
    {
        this.flowTab = flowTab;
    }

    // Methods

    /**
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        int sizeFlowTab = flowTab.size();

        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("name", this.name);
        jsonGenerator.write("id", this.id);
        jsonGenerator.write("type", this.type);

        // Ecrit le sous-menu et le parcours tant qu'il y a des données
        jsonGenerator.writeStartArray("Flow");

        // Parcours des noeuds enfants
        for (int boucle = 0; boucle < sizeFlowTab; boucle++)
            flowTab.get(boucle).toJSON(jsonGenerator);

        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }

    /**
     * @param document
     * @param node
     */
    public void toXML(Document document, Node node)
    {
        // Création de la balise SystemHealth avec ses attributs
        Node system = document.createElement("System");
        ((Element) system).setAttribute("type", String.valueOf(type));
        ((Element) system).setAttribute("id", String.valueOf(id));
        ((Element) system).setAttribute("name", name);
        node.appendChild(system);

        // Création des balises enfants de SystemHealth
        for (int i = 0; i < flowTab.size(); i++)
            flowTab.get(i).toXML(document, system);
    }
}
