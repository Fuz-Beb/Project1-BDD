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
    private HashMap<Integer, Connections> connectionsTab;

    // Comfort Constructor
    public MainBody(Attributes attrs) throws IFT287Exception
    {
        systemsTab = new HashMap<Integer, Systems>();
        organsTab = new HashMap<Integer, Organs>();
        systemTab = new HashMap<Integer, System>();
        flowTab = new HashMap<Integer, Flow>();
        connectibleTab = new HashMap<Integer, Connectible>();
        connectionsTab = new HashMap<Integer, Connections>();

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

    /**
     * @return HashMap<Integer, System>
     */
    public HashMap<Integer, System> getLastSystem()
    {
        return systemsTab.get(systemsTab.size() - 1).getSystemTab();
    }

    /**
     * @return HashMap<Integer, Flow>
     */
    public HashMap<Integer, Flow> getLastFlow()
    {
        return getLastSystem().get(getLastSystem().size() - 1).getFlowTab();
    }

    /**
     * @return HashMap<Integer, Connectible>
     */
    public HashMap<Integer, Connectible> getLastConnectible()
    {
        return getLastFlow().get(getLastFlow().size() - 1).getTabConnectible();
    }

    /**
     * @return Connections
     */
    public HashMap<Integer, Connections> getLastConnections()
    {
        return getLastFlow().get(getLastFlow().size() - 1).getTabConnections();
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

    /**
     * @param systems
     */
    public void addSystems(Systems systems)
    {
        systemsTab.put(systemsTab.size() - 1, systems);
    }

    /**
     * @param organs
     */
    public void addOrgans(Organs organs)
    {
        organsTab.put(organsTab.size() - 1, organs);
    }

    /**
     * @param system
     */
    public void addSystem(System system)
    {
        systemsTab.get(systemsTab.size() - 1).addSystem(system);
    }

    /**
     * @param flow
     */
    public void addFlow(Flow flow)
    {
        getLastSystem().get(getLastSystem().size() - 1).addFlow(flow);
    }

    /**
     * @param connectible
     */
    public void addConnectible(Connectible connectible)
    {
        getLastFlow().get(getLastFlow().size() - 1).addConnectible(connectible);
    }

    /**
     * @param connections
     */
    public void addConnections(Connections connections)
    {
        getLastFlow().get(getLastFlow().size() - 1).addConnections(connections);
    }

    /**
     * @param atrium
     */
    public void addAtrium(Atrium atrium)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addAtrium(atrium);
    }

    /**
     * @param ventricle
     */
    public void addVentricle(Ventricle ventricle)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addVentricle(ventricle);
    }

    /**
     * @param artery
     */
    public void addArtery(Artery artery)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addArtery(artery);
    }

    /**
     * @param vein
     */
    public void addVein(Vein vein)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addVein(vein);
    }

    /**
     * @param capillaries
     */
    public void addCapillaries(Capillaries capillaries)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addCapillaries(capillaries);
    }

    /**
     * @param nose
     */
    public void addNose(Nose nose)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addNose(nose);
    }

    /**
     * @param airConnectible
     */
    public void addAirConnectible(AirConnectible airConnectible)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addAirConnectible(airConnectible);
    }

    /**
     * @param alveoli
     */
    public void addAlveoli(Alveoli alveoli)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addAlveoli(alveoli);
    }

    /**
     * @param digestiveTract
     */
    public void addDigestiveTract(DigestiveTract digestiveTract)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addDigestiveTract(digestiveTract);
    }

    /**
     * @param stomachTract
     */
    public void addStomachTract(StomachTract stomachTract)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addStomachTract(stomachTract);
    }

    /**
     * @param duodenumTract
     */
    public void addDuodenumTract(DuodenumTract duodenumTract)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addDuodenumTract(duodenumTract);
    }

    /**
     * @param rectumTract
     */
    public void addRectumTract(RectumTract rectumTract)
    {
        getLastConnectible().get(getLastConnectible().size() - 1).addRectumTract(rectumTract);
    }
}