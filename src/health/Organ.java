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

public class Organ
{
    private String name;
    private int id;
    private int systemID;

    // Comfort Constructor

    /**
     * Constructeur de confort pour XML -> JSON
     * 
     * @param attrs
     * @throws IFT287Exception
     */
    public Organ(Attributes attrs) throws IFT287Exception
    {
        if (attrs != null)
        {
            name = attrs.getValue("name");
            id = Integer.parseInt(attrs.getValue("id"));
            systemID = Integer.parseInt(attrs.getValue("systemID"));
        }
        else
        {
            throw new IFT287Exception("Organ : bad attributes");
        }
    }

    /**
     * Constructeur de confort pour JSON -> XML
     * 
     * @param jsonObject
     * @throws IFT287Exception
     */
    public Organ(JsonObject jsonObject) throws IFT287Exception
    {
        if (jsonObject != null)
        {
            name = jsonObject.getString("name");
            id = jsonObject.getInt("id");
            systemID = jsonObject.getInt("systemID");
        }
        else
        {
            throw new IFT287Exception("Organ : bad attributes");
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
     * @return the systemID
     */
    public int getSystemID()
    {
        return systemID;
    }

    /**
     * @param systemID
     *            the systemID to set
     */
    public void setSystemID(int systemID)
    {
        this.systemID = systemID;
    }

    /**
     * Convertit l'objet actuel en JSON
     * 
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.writeStartObject();
        jsonGenerator.write("id", this.getId());
        jsonGenerator.write("name", this.getName());
        jsonGenerator.write("systemID", this.getSystemID());
        jsonGenerator.writeEnd();
    }

    /**
     * @param document
     * @param node
     */
    public void toXML(Document document, Node node)
    {
        // Création de la balise Organ avec ses attributs
        Node organ = document.createElement("Organ");
        ((Element) organ).setAttribute("name", name);
        ((Element) organ).setAttribute("id", String.valueOf(id));
        ((Element) organ).setAttribute("systemID", String.valueOf(systemID));
        node.appendChild(organ);
    }
}