package health;

import java.util.HashMap;

import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import org.xml.sax.Attributes;

import tp1.IFT287Exception;
import tp1_model.ConnectibleModel;

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
    
    /**
     * Constructeur de confort
     * @param attrs
     * @throws IFT287Exception
     */
    public Flow(JsonObject objectJSON)
    {
        connectibleTab = new HashMap<Integer, Connectible>();
        connectionsTab = new HashMap<Integer, Connections>();
        id = objectJSON.getInt("id");
        name = objectJSON.getString("name");

        for(int boucle = 0; boucle < connectibleTab.size(); boucle++) {
            connectibleTab.put(connectibleTab.size(), new Connectible((JsonObject)connectibleTab.get(boucle)))
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
     * @return the connectibleTab
     */
    public HashMap<Integer, Connectible> getConnectibleTab()
    {
        return connectibleTab;
    }

    /**
     * @param connectibleTab
     *            the connectibleTab to set
     */
    public void setConnectibleTab(HashMap<Integer, Connectible> connectibleTab)
    {
        this.connectibleTab = connectibleTab;
    }

    /**
     * @return the connectionsTab
     */
    public HashMap<Integer, Connections> getConnectionsTab()
    {
        return connectionsTab;
    }

    /**
     * @param connectionsTab
     *            the connectionsTab to set
     */
    public void setConnectionsTab(HashMap<Integer, Connections> connectionsTab)
    {
        this.connectionsTab = connectionsTab;
    }

    // Methods

    public void addConnectible(Connectible connectible)
    {
        connectibleTab.put(connectibleTab.size(), connectible);
    }

    public void addConnections(Connections connections)
    {
        connectionsTab.put(connectionsTab.size(), connections);
    }

    /**
     * @param jsonGenerator
     */
    public void ToJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("id", this.id);
        jsonGenerator.write("name", this.name);

        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("Connectible");
        for (int i = 0; i < this.connectibleTab.size(); i++)
        {
            this.connectibleTab.get(i).ToJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();

        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("Connections");
        for (int i = 0; i < this.connectionsTab.size(); i++)
        {
            this.connectionsTab.get(i).ToJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }
}