package health;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import java.util.HashMap;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;

import tp1.IFT287Exception;

/**
 * Classe permettant de représenter un objet Flow
 */
public class FlowHealth
{
    // Attributs
    private int id;
    private String name;
    private HashMap<Integer, ConnectibleHealth> connectibleTab;
    private HashMap<Integer, ConnectionHealth> connectionTab;

    /**
     * Constructeur de confort pour la lecture du fichier XML
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
            throw new IFT287Exception("Flow : bad attributes");
    }

    /**
     * Constructeur de confort pour la lecture du fichier JSON
     * 
     * @param objectJSON
     */
    public FlowHealth(JsonObject objectJSON)
    {

        JsonArray tempConnectibles = objectJSON.getJsonArray("Connectible");
        JsonArray tempConnections = objectJSON.getJsonArray("Connections");
        int sizeTabTempConnectibles = tempConnectibles.size();
        int sizeTabTempConnections = tempConnections.size();

        connectibleTab = new HashMap<Integer, ConnectibleHealth>();
        connectionTab = new HashMap<Integer, ConnectionHealth>();
        id = objectJSON.getInt("id");
        name = objectJSON.getString("name");

        // Lecture des connectibles
        if (tempConnectibles != null)
            for (int boucle = 0; boucle < sizeTabTempConnectibles; boucle++)
                connectibleTab.put(connectibleTab.size(),
                        new ConnectibleHealth((JsonObject) tempConnectibles.get(boucle)));

        // Lecture des connections
        if (tempConnections != null)
            for (int boucle = 0; boucle < sizeTabTempConnections; boucle++)
                connectionTab.put(connectionTab.size(), new ConnectionHealth((JsonObject) tempConnections.get(boucle)));
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
     * Ajout des objets Flow dans le fichier JSON de sortie
     * 
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

        // Création des enfants
        for (int i = 0; i < this.connectibleTab.size(); i++)
        {
            // Parcours des noeuds enfants
            connectibleTab.get(i).toJSON(jsonGenerator);
        }
        // Fermeture pour Connectible
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
     * Ajout des objets Flow dans le fichier XML de sortie
     * 
     * @param document
     * @param node
     */
    public void toXML(Document document, Node node)
    {
        // Création de la balise FlowHealth avec les attributs
        Node flow = document.createElement("Flow");

        // Création de la balise Connections
        Node connections = document.createElement("Connections");

        // Création de la balise ConnectibleHealth
        Node connectible = document.createElement("Connectible");

        ((Element) flow).setAttribute("id", String.valueOf(id));
        ((Element) flow).setAttribute("name", name);
        node.appendChild(flow);

        // Test si des objets connectibles sont présents
        if (!connectibleTab.isEmpty())
        {
            flow.appendChild(connectible);

            // Création des balises enfants de ConnectibleHealth
            for (int i = 0; i < connectibleTab.size(); i++)
                connectibleTab.get(i).toXML(document, connectible);
        }

        // Test si des objets connections sont présents
        if (!connectionTab.isEmpty())
        {
            // Création de la balise Connections

            flow.appendChild(connections);

            // Création des balises enfants de Connections
            for (int i = 0; i < connectionTab.size(); i++)
                connectionTab.get(i).toXML(document, connections);
        }
    }
}