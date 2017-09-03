package health;

import java.util.HashMap;

import org.xml.sax.Attributes;

import tp1.IFT287Exception;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Connection
{
    // Attributes
    private int id;
    private HashMap<Integer, To> toTab;

    // Comfort Constructor
    public Connection(Attributes attrs) throws IFT287Exception
    {
        toTab = new HashMap<Integer, To>();

        if (attrs != null)
        {
            id = Integer.parseInt(attrs.getValue(0));
        }
        else
        {
            throw new IFT287Exception("Connection : bad attributes");
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
     * @return the toTab
     */
    public HashMap<Integer, To> getToTab()
    {
        return toTab;
    }

    /**
     * @param toTab
     *            the toTab to set
     */
    public void setToTab(HashMap<Integer, To> toTab)
    {
        this.toTab = toTab;
    }
}
