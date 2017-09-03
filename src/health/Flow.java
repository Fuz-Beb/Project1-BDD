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
    private HashMap<Integer, Connectible> tabConnectible;
    private HashMap<Integer, Connections> tabConnections;
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

    /**
     * @return the tabConnectible
     */
    public HashMap<Integer, Connectible> getTabConnectible()
    {
        return tabConnectible;
    }

    /**
     * @param tabConnectible the tabConnectible to set
     */
    public void setTabConnectible(HashMap<Integer, Connectible> tabConnectible)
    {
        this.tabConnectible = tabConnectible;
    }

    /**
     * @return the tabConnections
     */
    public HashMap<Integer, Connections> getTabConnections()
    {
        return tabConnections;
    }

    /**
     * @param tabConnections the tabConnections to set
     */
    public void setTabConnections(HashMap<Integer, Connections> tabConnections)
    {
        this.tabConnections = tabConnections;
    }

    public void addConnectible(Connectible connectible)
    {
        tabConnectible.put(tabConnectible.size() - 1, connectible);
    }

    public void addConnections(Connections connections)
    {
        tabConnections.put(tabConnections.size() - 1, connections);
    }
}
