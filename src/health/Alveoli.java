package health;

import org.xml.sax.Attributes;

//Travail fait par :
//Bobet Pierrick - 17 131 792
//Bouteloup Remy - 17 132 265

public class Alveoli
{
    // Attributes
    private String name;
    private int id;
    private int volume;
    
    // Comfort Constructor
    
    public Alveoli(Attributes attributes)
    {
        // TODO Auto-generated constructor stub
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
     * @param name the name to set
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
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * @return the volume
     */
    public int getVolume()
    {
        return volume;
    }
    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume)
    {
        this.volume = volume;
    }
}