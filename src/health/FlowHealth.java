package health;

import java.util.HashMap;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;

import tp1.IFT287Exception;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class FlowHealth
{
    // Attributes
    private int id;
    private String name;
    private HashMap<Integer, ConnectibleHealth> connectibleTab;
    private HashMap<Integer, ConnectionHealth> connectionTab;

    // Comfort Constructor
    /**
     * 
     * @param attrs
     * @throws IFT287Exception
     */
    public FlowHealth(Attributes attrs) throws IFT287Exception
    {
        connectibleTab = new HashMap<Integer, ConnectibleHealth>();
        connectionTab = new HashMap<Integer, ConnectionHealth>();

        if (attrs != null)
        {
            name = attrs.getValue("name");
            id = Integer.parseInt(attrs.getValue("id"));
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
    public FlowHealth(JsonObject objectJSON)
    {
        JsonArray tempConnectibles = objectJSON.getJsonArray("connectibles");
        JsonArray tempConnections = objectJSON.getJsonArray("connections");

        connectibleTab = new HashMap<Integer, ConnectibleHealth>();
        connectionTab = new HashMap<Integer, ConnectionHealth>();
        id = objectJSON.getInt("id");
        name = objectJSON.getString("name");

        // Lecture des connectibles
        for (int boucle = 0; boucle < tempConnectibles.size(); boucle++)
        {
            connectibleTab.put(connectibleTab.size(), new ConnectibleHealth((JsonObject) tempConnectibles.get(boucle)));
        }

        // Lecture des connections
        for (int boucle = 0; boucle < tempConnections.size(); boucle++)
        {
            connectionTab.put(connectionTab.size(), new ConnectionHealth((JsonObject) tempConnections.get(boucle)));
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
    public HashMap<Integer, ConnectibleHealth> getConnectibleTab()
    {
        return connectibleTab;
    }

    /**
     * @param connectibleTab
     *            the connectibleTab to set
     */
    public void setConnectibleTab(HashMap<Integer, ConnectibleHealth> connectibleTab)
    {
        this.connectibleTab = connectibleTab;
    }

    /**
     * @return the connectionTab
     */
    public HashMap<Integer, ConnectionHealth> getConnectionTab()
    {
        return connectionTab;
    }

    /**
     * @param connectionTab
     *            the connectionTab to set
     */
    public void setConnectionTab(HashMap<Integer, ConnectionHealth> connectionTab)
    {
        this.connectionTab = connectionTab;
    }

    // Methods

    /**
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("id", this.id);
        jsonGenerator.write("name", this.name);

        // Ecrit le sous-menu et le parcours tant qu'il y a des données
        jsonGenerator.writeStartArray("Connectible");
        jsonGenerator.writeStartObject();
        
        for (int i = 0; i < this.connectibleTab.size(); i++)
        {     
            // Parcours des noeuds enfants
            connectibleTab.get(i).toJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();

        // Ecrit le sous-menu et le parcours tant qu'il y a des données
        jsonGenerator.writeStartArray("Connections");

        for (int i = 0; i < this.connectionTab.size(); i++)
        {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStartArray("Connection");

            // Parcours des noeuds enfants
            connectionTab.get(i).toJSON(jsonGenerator);

            jsonGenerator.writeEnd();
            jsonGenerator.writeEnd();
        }
        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }

    /**
     * @param document
     * @param node
     */
    public void toXML(Document document, Node node)
    {
        // Création de la balise FlowHealth avec les attributs
        Node flow = document.createElement("Flow");
        ((Element) flow).setAttribute("id", String.valueOf(id));
        ((Element) flow).setAttribute("name", name);
        node.appendChild(flow);

        // Test si des objets connectibles sont présents
        if (!connectibleTab.isEmpty())
        {
            // Création de la balise ConnectibleHealth
            Node connectible = document.createElement("Connectible");
            flow.appendChild(connectible);

            // Création des balises enfants de ConnectibleHealth
            for (int i = 0; i < connectibleTab.size(); i++)
            {
                connectibleTab.get(i).toXML(document, connectible);
            }
        }

        // Test si des objets connections sont présents
        if (!connectionTab.isEmpty())
        {
            // Création de la balise Connections
            Node connections = document.createElement("Connections");
            flow.appendChild(connections);

            // Création des balises enfants de Connections
            for (int i = 0; i < connectionTab.size(); i++)
            {
                connectionTab.get(i).toXML(document, connections);
            }
        }
    }
}