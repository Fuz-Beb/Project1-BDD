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

public class Artery
{
    // Attributes
    private String name;
    private int id;
    private double startRadius;
    private double endRadius;
    private double length;
<<<<<<< HEAD
    
    // Comfort constructor
    public Artery(Attributes attrs) {
    	
    }
    
=======

    // Comfort Constructor
    public Artery(Attributes attrs)
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
     * @return the startRadius
     */
    public double getStartRadius()
    {
        return startRadius;
    }

    /**
     * @param startRadius
     *            the startRadius to set
     */
    public void setStartRadius(double startRadius)
    {
        this.startRadius = startRadius;
    }

    /**
     * @return the endRadius
     */
    public double getEndRadius()
    {
        return endRadius;
    }

    /**
     * @param endRadius
     *            the endRadius to set
     */
    public void setEndRadius(double endRadius)
    {
        this.endRadius = endRadius;
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
     *            the length to set
     */
    public void setLength(double length)
    {
        this.length = length;
    }
}
