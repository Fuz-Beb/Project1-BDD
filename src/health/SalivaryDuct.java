package health;

import org.xml.sax.Attributes;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class SalivaryDuct
{
    // Attributes
    private String name;
    private int id;
    private double length;
    private int volume;

<<<<<<< HEAD
    // Comfort constructor
=======
    // Comfort Constructor
>>>>>>> a3cbb8205bd0a43d4396b91ed5ff4c0ea500a455
    public SalivaryDuct(Attributes attrs)
    {

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
     * @return the length
     */
    public double getLength()
    {
        return length;
    }

    /**
     * @param length
     *            the volume to set
     */
    public void setLength(double length)
    {
        this.length = length;
    }

    /**
     * @return the volume
     */
    public int getVolume()
    {
        return volume;
    }

    /**
     * @param volume
     *            the volume to set
     */
    public void setVolume(int volume)
    {
        this.volume = volume;
    }
}