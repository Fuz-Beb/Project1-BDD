package health;

import java.util.HashMap;

import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import org.xml.sax.Attributes;

import tp1.IFT287Exception;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Connection
{
    // Attributes
    private int id;
    private HashMap<Integer, To> toTab;

    // Comfort Constructor
    
    /**
     * 
     * @param attrs
     * @throws IFT287Exception
     */
    public Connection(Attributes attrs) throws IFT287Exception
    {
        toTab = new HashMap<Integer, To>();
    
       if (attrs != null)
       {
           id = Integer.parseInt(attrs.getValue(0));
       }
       else
       {
           throw new IFT287Exception("Connection : bad attributes");
       }
    }

    /**
     * Constructeur de confort offrant comme argument un objet JSON
     * 
     * @param jsonObject
     */
    public Connection(JsonObject jsonObject)
    {
        id = jsonObject.getInt("id");

        for (int boucle = 0; boucle < toTab.size(); boucle++)
        {
            //toTab.put(toTab.size(), new To((JsonObject) toTab.get(boucle)));
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
    public HashMap<Integer, To> getToTab()
    {
        return toTab;
    }

    /**
     * @param toTab
     *            the toTab to set
     */
    public void setToTab(HashMap<Integer, To> toTab)
    {
        this.toTab = toTab;
    }

    // Methods
    
    /**
     * @param to
     */
    public void addTo(To to)
    {
        toTab.put(toTab.size(), to);
    }

    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        jsonGenerator.write("id", this.getId());

        jsonGenerator.writeStartArray("tos");
        for (int i = 0; i < toTab.size(); i++)
        {
            //toTab.get(i).toJSON(jsonGenerator);
        }
        jsonGenerator.writeEnd();

        jsonGenerator.writeEnd();
    }
}
