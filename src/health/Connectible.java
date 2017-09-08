package health;

import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Connectible
{
    // Attributes
    private String type;
    private int id;
    private String name;
    private Double volume;
    private Double length;
    private Double startRadius;
    private Double endRadius;

    // Comfort Constructor

    /**
     * Constructeur de confort avec les attributs communs
     * 
     * @param type
     * @param id
     * @param name
     */
    public Connectible(String type, int id, String name)
    {
        this.type = type;
        this.id = id;
        this.name = name;
    }

    /**
     * Constructeur de confort avec les attributs communs et spéciaux
     * 
     * @param type
     * @param id
     * @param name
     * @param volume
     * @param length
     * @param startRadius
     * @param endRadius
     */
    public Connectible(String type, int id, String name, Double volume, Double length, Double startRadius,
            Double endRadius)
    {
        this(type, id, name);
        this.volume = volume;
        this.length = length;
        this.startRadius = startRadius;
        this.endRadius = endRadius;
    }

    /**
     * Constructeur de confort offrant comme argument un objet JSON
     * 
     * @param jsonObject
     */
    public Connectible(JsonObject jsonObject)
    {
        type = jsonObject.getString("type");
        id = jsonObject.getInt("id");
        name = jsonObject.getString("name");

        if (jsonObject.getJsonNumber("volume") != null)
        {
            this.volume = jsonObject.getJsonNumber("volume").doubleValue();
        }
        if (jsonObject.getJsonNumber("length") != null)
        {
            this.length = jsonObject.getJsonNumber("length").doubleValue();
        }
        if (jsonObject.getJsonNumber("startRadius") != null)
        {
            this.startRadius = jsonObject.getJsonNumber("startRadius").doubleValue();
        }
        if (jsonObject.getJsonNumber("endRadius") != null)
        {
            this.endRadius = jsonObject.getJsonNumber("endRadius").doubleValue();
        }
    }

    // Getters / Setters

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type)
    {
        this.type = type;
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
     * @return the volume
     */
    public Double getVolume()
    {
        return volume;
    }

    /**
     * @param volume
     *            the volume to set
     */
    public void setVolume(Double volume)
    {
        this.volume = volume;
    }

    /**
     * @return the length
     */
    public Double getLength()
    {
        return length;
    }

    /**
     * @param length
     *            the length to set
     */
    public void setLength(Double length)
    {
        this.length = length;
    }

    /**
     * @return the startRadius
     */
    public Double getStartRadius()
    {
        return startRadius;
    }

    /**
     * @param startRadius
     *            the startRadius to set
     */
    public void setStartRadius(Double startRadius)
    {
        this.startRadius = startRadius;
    }

    /**
     * @return the endRadius
     */
    public Double getEndRadius()
    {
        return endRadius;
    }

    /**
     * @param endRadius
     *            the endRadius to set
     */
    public void setEndRadius(Double endRadius)
    {
        this.endRadius = endRadius;
    }

    // Methods

    /**
     * Convertit l'objet actuel en JSON
     * 
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        // Ecrit l'objet actuel dans le générateur JSON
        jsonGenerator.writeStartObject();
        jsonGenerator.write("id", this.getId());
        jsonGenerator.write("type", this.getType());
        jsonGenerator.write("name", this.getName());

        if (this.getVolume() != null)
        {
            jsonGenerator.write("volume", this.getVolume());
        }
        if (this.getStartRadius() != null)
        {
            jsonGenerator.write("startRadius", this.getStartRadius());
        }
        if (this.getEndRadius() != null)
        {
            jsonGenerator.write("endRadius", this.getEndRadius());
        }
        if (this.getLength() != null)
        {
            jsonGenerator.write("length", this.getLength());
        }

        jsonGenerator.writeEnd();
    }
}