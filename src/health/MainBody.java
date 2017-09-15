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
 * Classe principale du modèle objets. Accès à l'ensemble de ses enfants (accès sous forme de cascades)
 */
public class MainBody
{
    // Attributs
    private String name;
    private int id;
    private HashMap<Integer, SystemHealth> systemTab;
    private HashMap<Integer, OrganHealth> organTab;

    /**
     * Constructeur de confort pour la lecture du fichier JSON
     * @param attrs
     * @throws IFT287Exception
     */
    public MainBody(Attributes attrs) throws IFT287Exception
    {
        systemTab = new HashMap<Integer, SystemHealth>();
        organTab = new HashMap<Integer, OrganHealth>();

        if (attrs != null)
        {
            name = attrs.getValue("bodyName");
            id = Integer.parseInt(attrs.getValue("bodyID"));
        }
        else
        {
            throw new IFT287Exception("MainBody : bad attributes");
        }                
    }

    /**
     * Constructeur de confort pour la lecture du fichier XML
     * @param jsonObject
     * @throws IFT287Exception
     */
    public MainBody(JsonObject jsonObject) throws IFT287Exception
    {
        // Récupération du bon JsonArray concernant "System"
        JsonArray tempSystems = jsonObject.getJsonArray("Systems");
        // Récupération du bon JsonArray concernant "Organ"
        JsonArray tempOrgans = jsonObject.getJsonArray("Organs");
        int sizeTempSystems = tempSystems.size();
        int sizeTempOrgans = tempOrgans.size();        
        
        systemTab = new HashMap<Integer, SystemHealth>();
        organTab = new HashMap<Integer, OrganHealth>();

        name = jsonObject.getString("bodyName");
        id = jsonObject.getInt("bodyID");

        for (int boucle = 0; boucle < sizeTempSystems; boucle++)
            systemTab.put(systemTab.size(), new SystemHealth((JsonObject) tempSystems.get(boucle)));

        for (int boucle = 0; boucle < sizeTempOrgans; boucle++)
            organTab.put(organTab.size(), new OrganHealth((JsonObject) tempOrgans.get(boucle)));
    }

    // Getters / Setters

    /**
     * @return HashMap<Integer, SystemHealth>
     */
    public SystemHealth getLastSystem()
    {
        return systemTab.get(systemTab.size() - 1);
    }

    /**
     * @return HashMap<Integer, FlowHealth>
     */
    public FlowHealth getLastFlow()
    {
        return getLastSystem().getFlowTab().get(getLastSystem().getFlowTab().size() - 1);
    }

    /**
     * @return ConnectionHealth
     */
    public ConnectionHealth getLastConnection()
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
    public HashMap<Integer, SystemHealth> getSystemTab()
    {
        return systemTab;
    }

    /**
     * @param systemTab
     *            the systemsTab to set
     */
    public void setSystemTab(HashMap<Integer, SystemHealth> systemTab)
    {
        this.systemTab = systemTab;
    }

    /**
     * @return the organsTab
     */
    public HashMap<Integer, OrganHealth> getOrganTab()
    {
        return organTab;
    }

    /**
     * @param organTab
     *            the organsTab to set
     */
    public void setOrganTab(HashMap<Integer, OrganHealth> organTab)
    {
        this.organTab = organTab;
    }

    // Methods

    /**
     * Génération de l'objet MainBody dans le fichier JSON
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStartArray("MainBody");
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
        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }

    /**
     * Génération de l'objet MainBody dans le fichier XML
     * @param document
     */
    public void toXML(Document document)
    {
        // Création de la balise MainBody avec ses attributs
        Node racine = document.createElement("MainBody");        
        // Création de la balise Systems
        Node systems = document.createElement("Systems");
        // Création de la balise Organs
        Node organs = document.createElement("Organs");
        
        int sizeSystemTab = systemTab.size();
        int sizeOrganTab = organTab.size();
        
        ((Element) racine).setAttribute("bodyName", name);
        ((Element) racine).setAttribute("bodyID", String.valueOf(id));
        document.appendChild(racine);

        racine.appendChild(systems);

        // Création des balises enfants de Systems
        for (int boucle = 0; boucle < sizeSystemTab; boucle++)
            systemTab.get(boucle).toXML(document, systems);
                
        racine.appendChild(organs);

        // Création des balises enfants de Organs
        for (int boucle = 0; boucle < sizeOrganTab; boucle++)
            organTab.get(boucle).toXML(document, organs);
    }
}