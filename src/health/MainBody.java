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
    private HashMap<Integer, System> systemTab;
    private HashMap<Integer, Flow> flowTab;
    private HashMap<Integer, Connectible> connectibleTab;
    private HashMap<Integer, Connectible> connectionsTab;
    
    // Comfort Constructor
    public MainBody(Attributes attrs)
    {
        systemsTab = new HashMap<Integer, Systems>();
        organsTab = new HashMap<Integer, Organs>();
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
