package health;

import java.util.HashMap;

import org.xml.sax.Attributes;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class MainBody
{
    // Attributes
    private String bodyName;
    private int bodyId;
    private HashMap<Integer, Systems> systemsTab;
    private HashMap<Integer, Organs> organsTab;

    // Comfort Constructor
    public MainBody(Attributes attrs)
    {
        
    }

    // Getters / Setters

    /**
     * @return the bodyName
     */
    public String getBodyName()
    {
        return bodyName;
    }

    /**
     * @param bodyName
     *            the bodyName to set
     */
    public void setBodyName(String bodyName)
    {
        this.bodyName = bodyName;
    }

    /**
     * @return the bodyId
     */
    public int getBodyId()
    {
        return bodyId;
    }

    /**
     * @param bodyId
     *            the bodyId to set
     */
    public void setBodyId(int bodyId)
    {
        this.bodyId = bodyId;
    }

    /**
     * @return the systemsTab
     */
    public HashMap<Integer, Systems> getSystemsTab()
    {
        return systemsTab;
    }

    /**
     * @param systemsTab
     *            the systemsTab to set
     */
    public void setSystemsTab(HashMap<Integer, Systems> systemsTab)
    {
        this.systemsTab = systemsTab;
    }

    /**
     * @return the organsTab
     */
    public HashMap<Integer, Organs> getOrgansTab()
    {
        return organsTab;
    }

    /**
     * @param organsTab
     *            the organsTab to set
     */
    public void setOrgansTab(HashMap<Integer, Organs> organsTab)
    {
        this.organsTab = organsTab;
    }
}
