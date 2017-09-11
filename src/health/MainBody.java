package health;

import java.util.HashMap;

import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
    private HashMap<Integer, System> systemTab;
    private HashMap<Integer, Organ> organTab;

    // Comfort Constructor

    /**
     * @param attrs
     * @throws IFT287Exception
     */
    public MainBody(Attributes attrs) throws IFT287Exception
    {
        systemTab = new HashMap<Integer, System>();
        organTab = new HashMap<Integer, Organ>();

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
        return systemTab.get(systemTab.size() - 1);
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
    public HashMap<Integer, System> getSystemTab()
    {
        return systemTab;
    }

    /**
     * @param systemTab
     *            the systemsTab to set
     */
    public void setSystemTab(HashMap<Integer, System> systemTab)
    {
        this.systemTab = systemTab;
    }

    /**
     * @return the organsTab
     */
    public HashMap<Integer, Organ> getOrganTab()
    {
        return organTab;
    }

    /**
     * @param organTab
     *            the organsTab to set
     */
    public void setOrganTab(HashMap<Integer, Organ> organTab)
    {
        this.organTab = organTab;
    }

    // Methods

    /**
     * @param system
     */
    public void addSystem(System system)
    {
        systemTab.put(systemTab.size(), system);
    }

    /**
     * @param organ
     */
    public void addOrgan(Organ organ)
    {
        organTab.put(organTab.size(), organ);
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

        // Ecrit le sous-menu et le parcours tant qu'il y a des données
        jsonGenerator.writeStartArray("Systems");
        for (int i = 0; i < systemTab.size(); i++)
        {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStartArray("System");

            // Parcours des noeuds enfants
            systemTab.get(i).toJSON(jsonGenerator);

            jsonGenerator.writeEnd();
            jsonGenerator.writeEnd();
        }

        jsonGenerator.writeEnd();

        // Ecrit le sous-menu et le parcours tant qu'il y a des données
        jsonGenerator.writeStartArray("Organs");

        for (int i = 0; i < organTab.size(); i++)
        {
            // Ecrit l'objet actuel dans le générateur JSON
            jsonGenerator.writeStartObject();

            // Ecrit le sous-menu et le parcours tant qu'il y a des données
            jsonGenerator.writeStartArray("Organ");

            // Parcours des noeuds enfants
            organTab.get(i).toJSON(jsonGenerator);

            jsonGenerator.writeEnd();
            jsonGenerator.writeEnd();
        }
        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }

    /**
     * @param document
     */
    public void toXML(Document document)
    {
        // Création de la balise MainBody avec ses attributs
        Node racine = document.createElement("MainBody");
        ((Element) racine).setAttribute("bodyName", name);
        ((Element) racine).setAttribute("bodyID", String.valueOf(id));
        document.appendChild(racine);

        // Création de la balise Systems
        Node systems = document.createElement("Systems");
        racine.appendChild(systems);

        // Création des balises enfants de Systems
        for (int i = 0; i < systemTab.size(); i++)
        {
            systemTab.get(i).toXML(document, systems);
        }

        // Création de la balise Organs
        Node organs = document.createElement("Organs");
        racine.appendChild(organs);

        // Création des balises enfants de Organs
        for (int i = 0; i < organTab.size(); i++)
        {
            organTab.get(i).toXML(document, organs);
        }
    }
}