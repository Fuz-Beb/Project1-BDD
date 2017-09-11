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

public class Connection
{
    // Attributes
    private int id;
    private HashMap<Integer, To> toTab;

    // Comfort Constructor

    /**
     * 
     * @param attrs
     * @throws IFT287Exception
     */
    public Connection(Attributes attrs) throws IFT287Exception
    {
        toTab = new HashMap<Integer, To>();

        if (attrs != null)
        {
            id = Integer.parseInt(attrs.getValue("id"));
        }
        else
        {
            throw new IFT287Exception("Connection : bad attributes");
        }
    }

    /**
     * Constructeur de confort offrant comme argument un objet JSON
     * 
     * @param jsonObject
     */
    public Connection(JsonObject jsonObject)
    {
        JsonArray tempTo = jsonObject.getJsonArray("to");
        toTab = new HashMap<Integer, To>();
        id = jsonObject.getInt("id");

        for (int boucle = 0; boucle < tempTo.size(); boucle++)
        {
            toTab.put(toTab.size(), new To((JsonObject) tempTo.get(boucle)));
        }
    }

    // Getters / Setters

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
     * @return the toTab
     */
    public HashMap<Integer, To> getToTab()
    {
        return toTab;
    }

    /**
     * @param toTab
     *            the toTab to set
     */
    public void setToTab(HashMap<Integer, To> toTab)
    {
        this.toTab = toTab;
    }

    // Methods

    /**
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("id", this.getId());

        jsonGenerator.writeStartArray("to");

        for (int i = 0; i < toTab.size(); i++)
        {
            // Parcours des noeuds enfants
            toTab.get(i).toJSON(jsonGenerator);
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
        // Création de la balise Connection avec son attribut
        Node connection = document.createElement("Connection");
        ((Element) connection).setAttribute("id", String.valueOf(id));
        node.appendChild(connection);

        // Création des balises enfants de Connection
        for (int i = 0; i < toTab.size(); i++)
        {
            toTab.get(i).toXML(document, connection);
        }
    }
}
