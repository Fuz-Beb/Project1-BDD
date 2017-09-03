package health;

import java.util.HashMap;

import org.xml.sax.Attributes;

import tp1.IFT287Exception;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Flow
{
    // Attributes
    private int id;
    private String name;
    private HashMap<Integer, Connectible> connectibleTab;
    private HashMap<Integer, Connections> connectionsTab;

    // Comfort Constructor
    public Flow(Attributes attrs) throws IFT287Exception
    {
        connectibleTab = new HashMap<Integer, Connectible>();
        connectionsTab = new HashMap<Integer, Connections>();
        
        if (attrs != null)
        { 
            id = Integer.parseInt(attrs.getValue(1));
            name = attrs.getValue(0);  
        }
        else
        {
            throw new IFT287Exception("Flow : bad attributes");
        }
    }

    // Getters / Setters

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
}
