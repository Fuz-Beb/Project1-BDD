package health;

//Travail fait par :
//Bobet Pierrick - 17 131 792
//Bouteloup Remy - 17 132 265

public class Vein
{
    // Attributes
    private String name;
    private int id;
    private double startRadius;
    private double endRadius;
    private double length;
    
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
     * @return the startRadius
     */
    public double getStartRadius()
    {
        return startRadius;
    }
    /**
     * @param startRadius the startRadius to set
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
     * @param endRadius the endRadius to set
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
     * @param length the length to set
     */
    public void setLength(double length)
    {
        this.length = length;
    } 
}
