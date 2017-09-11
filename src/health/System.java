package health;

import java.util.HashMap;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import org.xml.sax.Attributes;

import tp1.IFT287Exception;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class System
{
    // Attributes
    private String name;
    private int id;
    private int type;
    private HashMap<Integer, Flow> flowTab;

    // Comfort Constructor

    /**
     * 
     * @throws IFT287Exception
     */
    public System(HashMap<String, String> attrs) throws IFT287Exception
    {
        flowTab = new HashMap<Integer, Flow>();

        if (attrs != null)
        {
            id = Integer.parseInt(attrs.get("id"));
            name = attrs.get("name");
            type = Integer.parseInt(attrs.get("type"));

            // JsonArray tempFlows = attrs.getJsonArray("flows");
            // for (int i = 0; i < tempFlows.size(); i++)
            // {
            // flowTab.put(flowTab.size(), new Flow((JsonObject)
            // tempFlows.get(i)));
            // }
        }
        else
        {
            throw new IFT287Exception("System : bad attributes");
        }
    }

    public System(JsonObject jsonObject)
    {
        flowTab = new HashMap<Integer, Flow>();

        JsonArray tempArray = jsonObject.getJsonArray("System");
        JsonObject test;
        String test2;

////        for (int boucle = 0; boucle < tempArray.size(); boucle++)
////        {
//            test = (JsonObject) tempArray.get(boucle);
//
////            for (int boucleArgs = 0; boucleArgs < test.size(); boucleArgs++)
////            {
//                name = test.getString("name");
//                id = test.getInt("id");
//                type = test.getInt("type");
////            }
//
//        }

        if (jsonObject != null)
        {
//            id = jsonObject.getInt("id");
//            name = jsonObject.getString("name");
//            type = jsonObject.getInt("type");

            JsonArray tempFlows = jsonObject.getJsonArray("flows");

            for (int boucle = 0; boucle < tempFlows.size(); boucle++)
            {
                flowTab.put(flowTab.size(), new Flow((JsonObject) tempFlows.get(boucle)));
            }
        }
    }

    // Getters / Setters

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
     * @return the type
     */
    public int getType()
    {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(int type)
    {
        this.type = type;
    }

    /**
     * @return the flowTab
     */
    public HashMap<Integer, Flow> getFlowTab()
    {
        return flowTab;
    }

    /**
     * @param flowTab
     *            the flowTab to set
     */
    public void setFlowTab(HashMap<Integer, Flow> flowTab)
    {
        this.flowTab = flowTab;
    }

    // Methods

    /**
     * @param jsonGenerator
     */
    public void toJSON(JsonGenerator jsonGenerator)
    {
        jsonGenerator.writeStartObject();

        // Ecrit les attributs de l'objet actuel dans le générateur JSON
        jsonGenerator.write("name", this.name);
        jsonGenerator.write("id", this.id);
        jsonGenerator.write("type", this.type);

        // Ecrit le sous-menu et le parcourt tant qu'il y a des données
        jsonGenerator.writeStartArray("Flow");
        for (int i = 0; i < this.flowTab.size(); i++)
        {
            flowTab.get(i).toJSON(jsonGenerator);
        }

        jsonGenerator.writeEnd();
        jsonGenerator.writeEnd();
    }
}
