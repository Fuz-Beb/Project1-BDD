package health;

import java.util.HashMap;

import org.xml.sax.Attributes;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Connections
{
    // Attributes
    private HashMap<Integer, Connection> tabConnection;

    // Comfort Constructor
    public Connections()
    {
        tabConnection = new HashMap<Integer, Connection>();
    }

    // Getters / Setters

    /**
     * @return the tabConnection
     */
    public HashMap<Integer, Connection> getTabConnection()
    {
        return tabConnection;
    }

    /**
     * @param tabConnection
     *            the tabConnection to set
     */
    public void setTabConnection(HashMap<Integer, Connection> tabConnection)
    {
        this.tabConnection = tabConnection;
    }
}
