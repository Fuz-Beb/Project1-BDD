package health;

//Travail fait par :
//Bobet Pierrick - 17 131 792
//Bouteloup Remy - 17 132 265

import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;

import tp1.IFT287Exception;

/**
 * Classe qui représente un objet To
 */
public class ToHealth
{
    // Attribut
    private int id;

    /**
     * Constructeur de confort pour la lecture du fichier XML
     * @param attrs
     * @throws IFT287Exception
     */
    public ToHealth(Attributes attrs) throws IFT287Exception
    {
        if (attrs != null)
        {
            id = Integer.parseInt(attrs.getValue("id"));
        }
        else
        {
            throw new IFT287Exception("To : bad attributes");
        }
    }

    /**
     * Constucteur de confort pour la lecture du fichier JSON
     * @param jsonObject
     */
    public ToHealth(JsonObject jsonObject)
    {
        id = jsonObject.getInt("id");
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

    // Methods

    /**
     * Génération des objets To dans le fichier JSON de sortie
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("id", id);

        jsonGenerator.writeEnd();
    }

    /**
     * Génération des objets To dans le fichier XML de sortie
     * @param document
     * @param node
     */
    public void toXML(Document document, Node node)
    {
        // Création de la balise to avec son attribut
        Node to = document.createElement("to");
        ((Element) to).setAttribute("id", String.valueOf(id));
        node.appendChild(to);
    }
}