package health;

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

public class To
{
    // Attributes
    private int id;

    // Comfort Constructor
    public To(Attributes attrs) throws IFT287Exception
    {
        if (attrs != null)
        {
            id = Integer.parseInt(attrs.getValue(0));
        }
        else
        {
            throw new IFT287Exception("To : bad attributes");
        }
    }

    /**
     * Constructeur de confort offrant comme argument un objet JSON
     * 
     * @param jsonObject
     */
    public To(JsonObject jsonObject)
    {
        id = jsonObject.getInt("id");
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

    // Methods

    /**
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();
        
        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("id", id);
        
        jsonGenerator.writeEnd();
    }

    /**
     * @param document
     * @param node
     */
    public void toXML(Document document, Node node)
    {
        // Création de la balise to avec son attribut
        Node to = document.createElement("to");
        ((Element) to).setAttribute("id", String.valueOf(id));
        node.appendChild(to);
    }
}