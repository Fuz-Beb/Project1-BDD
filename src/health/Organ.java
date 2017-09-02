package health;

//Travail fait par :
//Bobet Pierrick - 17 131 792
//Bouteloup Remy - 17 132 265

public class Organ
{
    private String name;
    private int id;
    private int systemID;
    
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
     * @return the systemID
     */
    public int getSystemID()
    {
        return systemID;
    }
    /**
     * @param systemID the systemID to set
     */
    public void setSystemID(int systemID)
    {
        this.systemID = systemID;
    }
}
