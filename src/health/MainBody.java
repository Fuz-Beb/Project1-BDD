package health;

import java.util.HashMap;

import javax.json.stream.JsonGenerator;

import org.xml.sax.Attributes;

import tp1.IFT287Exception;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

/**
 * 
 */
public class MainBody
{
    // Attributes
    private String name;
    private int id;
    private HashMap<Integer, Systems> systemsTab;
    private HashMap<Integer, Organs> organsTab;

    // Comfort Constructor

    /**
     * @param attrs
     * @throws IFT287Exception
     */
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

    /**
     * @return HashMap<Integer, System>
     */
    public System getLastSystem()
    {
        return systemsTab.get(systemsTab.size() - 1).getSystemTab()
                .get(systemsTab.get(systemsTab.size() - 1).getSystemTab().size() - 1);
    }

    /**
     * @return HashMap<Integer, Flow>
     */
    public Flow getLastFlow()
    {
        return getLastSystem().getFlowTab().get(getLastSystem().getFlowTab().size() - 1);
    }

    /**
     * @return Connection
     */
    public Connection getLastConnection()
    {
        return getLastFlow().getConnectionTab().get(getLastFlow().getConnectionTab().size() - 1);
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
        systemsTab.put(systemsTab.size(), systems);
    }

    /**
     * @param organs
     */
    public void addOrgans(Organs organs)
    {
        organsTab.put(organsTab.size(), organs);
    }

    /**
     * Convertit l'objet actuel en JSON
     * 
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("bodyID", this.id);
        jsonGenerator.write("bodyName", this.name);

        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("systems");
        for (int i = 0; i < systemsTab.size(); i++)
        {
            systemsTab.get(i).toJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();

        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("organs");
        for (int i = 0; i < organsTab.size(); i++)
        {
            organsTab.get(i).toJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }
}