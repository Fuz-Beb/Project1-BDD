package health;

import java.util.HashMap;

import org.xml.sax.Attributes;

import tp1.IFT287Exception;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class MainBody
{
    // Attributes
    private String name;
    private int id;
    private HashMap<Integer, Systems> systemsTab;
    private HashMap<Integer, Organs> organsTab;
    private HashMap<Integer, System> systemTab;
    private HashMap<Integer, Flow> flowTab;
    private HashMap<Integer, Connectible> connectibleTab;
    private HashMap<Integer, Connectible> connectionsTab;
    
    // Comfort Constructor
    public MainBody(Attributes attrs) throws IFT287Exception
    {
        systemsTab = new HashMap<Integer, Systems>();
        organsTab = new HashMap<Integer, Organs>();
        
        if (attrs != null)
        {
            name = attrs.getValue(0);
            id = Integer.parseInt(attrs.getValue(1));
        }
        else
        {
            throw new IFT287Exception("MainBody : bad attributes");
        }
    }

    // Getters / Setters

    /**
     * @return the bodyName
     */
    public String getBodyName()
    {
        return name;
    }

    /**
     * @param bodyName
     *            the bodyName to set
     */
    public void setBodyName(String bodyName)
    {
        this.name = bodyName;
    }

    /**
     * @return the bodyId
     */
    public int getBodyId()
    {
        return id;
    }

    /**
     * @param bodyId
     *            the bodyId to set
     */
    public void setBodyId(int bodyId)
    {
        this.id = bodyId;
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

    // Methods

    public void addSystems(Systems systems)
    {
        systemsTab.put(systemsTab.size() - 1, systems);
    }

    public void addOrgans(Organs organs)
    {
        organsTab.put(organsTab.size() - 1, organs);
    }

    public void addSystem(System system)
    {
        systemsTab.get(systemsTab.size() - 1).addSystem(system);
    }

    public void addFlow(Flow flow)
    {    
        systemTab = systemsTab.get(systemsTab.size() - 1).getSystemTab();
        systemTab.get(systemTab.size() - 1).addFlow(flow);
    }

    public void addConnectible(Connectible connectible)
    {     
        systemTab = systemsTab.get(systemsTab.size() - 1).getSystemTab();
        flowTab = systemTab.get(systemTab.size() - 1).getFlowTab();
        
        flowTab.get(flowTab.size() - 1).addConnectible(connectible);
    }

    public void addConnections(Connections connections)
    {
        systemTab = systemsTab.get(systemsTab.size() - 1).getSystemTab();
        flowTab = systemTab.get(systemTab.size() - 1).getFlowTab();
        
        flowTab.get(flowTab.size() - 1).addConnections(connections);
    }

    public void addAtrium(Atrium atrium)
    {
        systemTab = systemsTab.get(systemsTab.size() - 1).getSystemTab();
        flowTab = systemTab.get(systemTab.size() - 1).getFlowTab();
        //connectibleTab.get(connectibleTab.size() - 1).
        
        //flowTab.get(flowTab.size() - 1).addConnections(connections);
    }
}
