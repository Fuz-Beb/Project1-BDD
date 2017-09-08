package health;

import java.util.HashMap;

import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

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
    private HashMap<Integer, Connectible> connectibleTab;
    private HashMap<Integer, Connection> connectionTab;

    // Comfort Constructor
    /**
     * 
     * @param attrs
     * @throws IFT287Exception
     */
    public Flow(Attributes attrs) throws IFT287Exception
    {
        connectibleTab = new HashMap<Integer, Connectible>();
        connectionTab = new HashMap<Integer, Connection>();

        if (attrs != null)
        {
            if (attrs.getLocalName(0) == "name")
            {
                name = attrs.getValue(0);
                id = Integer.parseInt(attrs.getValue(1));
            }
            else
            {
                id = Integer.parseInt(attrs.getValue(0));
                name = attrs.getValue(1);
            }
        }
        else
        {
            throw new IFT287Exception("Flow : bad attributes");
        }
    }


    /**
     * Constructeur de confort
     * 
     * @param objectJSON
     */
    public Flow(JsonObject objectJSON)
    {
        connectibleTab = new HashMap<Integer, Connectible>();
        connectionTab = new HashMap<Integer, Connection>();
        id = objectJSON.getInt("id");
        name = objectJSON.getString("name");

        // Permet de lire les connectionsTab et de les assigner au HasMap
        // correspondant
        for (int boucle = 0; boucle < connectionTab.size(); boucle++)
        {
            connectionTab.put(connectionTab.size(), new Connection((JsonObject) connectionTab.get(boucle)));
        }

        // Permet de lire les connectibles et de les assigner au HasMap
        // correspondant
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
     * @return the connectionTab
     */
    public HashMap<Integer, Connection> getConnectionTab()
    {
        return connectionTab;
    }


    /**
     * @param connectionTab the connectionTab to set
     */
    public void setConnectionTab(HashMap<Integer, Connection> connectionTab)
    {
        this.connectionTab = connectionTab;
    }
    
    // Methods
    


    /**
     * 
     * @param connectible
     */
    public void addConnectible(Connectible connectible)
    {
        connectibleTab.put(connectibleTab.size(), connectible);
    }

    /**
     * 
     * @param connection
     */
    public void addConnection(Connection connection)
    {
        connectionTab.put(connectionTab.size(), connection);
    }

    /**
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("id", this.id);
        jsonGenerator.write("name", this.name);

        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("Connectible");
        for (int i = 0; i < this.connectibleTab.size(); i++)
        {
            connectibleTab.get(i).toJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();

        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("Connections");
        for (int i = 0; i < this.connectionTab.size(); i++)
        {
            connectionTab.get(i).toJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }
}