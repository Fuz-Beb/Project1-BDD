package health;

//Travail fait par :
//Bobet Pierrick - 17 131 792
//Bouteloup Remy - 17 132 265

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
 * Classe qui représente un objet Connections
 */
public class ConnectionHealth
{
    // Attributs
    private int id;
    private HashMap<Integer, ToHealth> toTab;

    /**
     * Constructeur de confort pour la lecture du fichier XML
     * @param attrs
     * @throws IFT287Exception
     */
    public ConnectionHealth(Attributes attrs) throws IFT287Exception
    {
        toTab = new HashMap<Integer, ToHealth>();

        if (attrs != null)
        {
            id = Integer.parseInt(attrs.getValue("id"));
        }
        else
        {
            throw new IFT287Exception("Connection : bad attributes");
        }
    }

    /**
     * Constructeur de confort pour la lecture du fichier JSON
     * @param jsonObject
     */
    public ConnectionHealth(JsonObject jsonObject)
    {
        JsonArray tempConnection = jsonObject.getJsonArray("Connection");
        JsonObject connectionObject = tempConnection.getJsonObject(0);
        JsonArray tempTo = connectionObject.getJsonArray("to");

        toTab = new HashMap<Integer, ToHealth>();
        id = connectionObject.getInt("id");

        for (int boucle = 0; boucle < tempTo.size(); boucle++)
        {
            toTab.put(toTab.size(), new ToHealth((JsonObject) tempTo.get(boucle)));
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
     * @return the toTab
     */
    public HashMap<Integer, ToHealth> getToTab()
    {
        return toTab;
    }

    /**
     * @param toTab
     *            the toTab to set
     */
    public void setToTab(HashMap<Integer, ToHealth> toTab)
    {
        this.toTab = toTab;
    }

    // Methods
    /**
     * Méthode permettant l'écriture des objets Connection dans le fichier JSON
     * de sortie
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("id", this.getId());

        jsonGenerator.writeStartArray("to");

        // Parcours des noeuds enfants
        for (int i = 0; i < toTab.size(); i++)
        {
            toTab.get(i).toJSON(jsonGenerator);
        }

        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }

    /**
     * Méthode permettant l'écriture des objets Connection dans le fichier XML
     * de sortie
     * 
     * @param document
     * @param node
     */
    public void toXML(Document document, Node node)
    {
        // Création de la balise ConnectionHealth avec son attribut
        Node connection = document.createElement("Connection");
        ((Element) connection).setAttribute("id", String.valueOf(id));
        node.appendChild(connection);

        // Création des balises enfants de ConnectionHealth
        for (int i = 0; i < toTab.size(); i++)
        {
            toTab.get(i).toXML(document, connection);
        }
    }
}
