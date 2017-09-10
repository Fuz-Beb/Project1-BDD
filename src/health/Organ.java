package health;

import java.util.HashMap;

import javax.json.stream.JsonGenerator;

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
    public Organ(HashMap<String, String> attrs) throws IFT287Exception
    {
        if (attrs != null)
        {
            name = attrs.get("name");
            id = Integer.parseInt(attrs.get("id"));
            systemID = Integer.parseInt(attrs.get("systemID"));
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
}
