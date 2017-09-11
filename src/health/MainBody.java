package health;

import java.util.HashMap;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

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
    private HashMap<Integer, System> systemsTab;
    private HashMap<Integer, Organ> organsTab;

    // Comfort Constructor

    /**
     * @param attrs
     * @throws IFT287Exception
     */
    public MainBody(HashMap<String, String> attrs) throws IFT287Exception
    {
        systemsTab = new HashMap<Integer, System>();
        organsTab = new HashMap<Integer, Organ>();

        if (attrs != null)
        {
            name = attrs.get("bodyName");
            id = Integer.parseInt(attrs.get("bodyID"));
        }
        else
        {
            throw new IFT287Exception("MainBody : bad attributes");
        }
    }
    
    public MainBody(JsonObject jsonObject) throws IFT287Exception
    {
        JsonArray tempSystems = jsonObject.getJsonArray("Systems");
        JsonArray tempOrgans = jsonObject.getJsonArray("Organs");
        systemsTab = new HashMap<Integer, System>();
        organsTab = new HashMap<Integer, Organ>();

        name = jsonObject.getString("bodyName");
        id = jsonObject.getInt("bodyID");
        
        for (int boucle = 0; boucle < tempSystems.size(); boucle++) {
            systemsTab.put(systemsTab.size(), new System((JsonObject) tempSystems.get(boucle)));
        }
        
        for (int boucle = 0; boucle < tempOrgans.size(); boucle++) {
            organsTab.put(organsTab.size(), new Organ((JsonObject) tempOrgans.get(boucle)));
        }        
    }
    
    // Getters / Setters
    
    /**
     * @return HashMap<Integer, System>
     */
    public System getLastSystem()
    {
        return systemsTab.get(systemsTab.size() - 1);
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
    public HashMap<Integer, System> getSystemsTab()
    {
        return systemsTab;
    }

    /**
     * @param systemsTab
     *            the systemsTab to set
     */
    public void setSystemsTab(HashMap<Integer, System> systemsTab)
    {
        this.systemsTab = systemsTab;
    }

    /**
     * @return the organsTab
     */
    public HashMap<Integer, Organ> getOrgansTab()
    {
        return organsTab;
    }

    /**
     * @param organsTab
     *            the organsTab to set
     */
    public void setOrgansTab(HashMap<Integer, Organ> organsTab)
    {
        this.organsTab = organsTab;
    }

    // Methods

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
        jsonGenerator.writeStartArray("Systems");
        for (int i = 0; i < systemsTab.size(); i++)
        {
            systemsTab.get(i).toJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();

        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("Organs");
        for (int i = 0; i < organsTab.size(); i++)
        {
            organsTab.get(i).toJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }
}