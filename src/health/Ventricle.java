package health;

import org.xml.sax.Attributes;

<<<<<<< HEAD
//Travail fait par :
//Bobet Pierrick - 17 131 792
//Bouteloup Remy - 17 132 265
=======
// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265
>>>>>>> a3cbb8205bd0a43d4396b91ed5ff4c0ea500a455

public class Ventricle
{
    // Attributes
    private String name;
    private int id;
    private int volume;
<<<<<<< HEAD
    
    // Comfort constructor
    public Ventricle(Attributes attrs) {
    	
    }
    
=======

    // Comfort Constructor
    public Ventricle(Attributes attrs)
    {

    }

>>>>>>> a3cbb8205bd0a43d4396b91ed5ff4c0ea500a455
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
