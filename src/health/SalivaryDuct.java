package health;

import org.xml.sax.Attributes;

import tp1.IFT287Exception;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class SalivaryDuct
{
    // Attributes
    private String name;
    private int id;
    private double length;
    private double volume;

    // Comfort constructor
    public SalivaryDuct(Attributes attrs) throws IFT287Exception
    {
        if (attrs != null)
        {
            name = attrs.getValue(0);
            id = Integer.parseInt(attrs.getValue(1));
            length = Double.parseDouble(attrs.getValue(2));
            volume = Double.parseDouble(attrs.getValue(3));
        }
        else
        {
            throw new IFT287Exception("SalivaryDuct : bad attributes");
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