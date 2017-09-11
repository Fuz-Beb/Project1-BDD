package tp1;

import java.util.HashMap;

import javax.json.JsonArray;
import javax.json.JsonObject;

import health.MainBody;

public class JsonParser
{
    // Attributes
    private FindConstructor findConstructor;
    private JsonObject objJson;
    
    // Methods

    public MainBody convertHashMap(JsonObject obj)
    {
        // Initialisation du findConstructor et objet json
        findConstructor = new FindConstructor();
        objJson = obj;
        
        convertBaliseMainBody();
        
        
        JsonArray arraySystems = objJson.getJsonArray("Systems");
        JsonArray arraySystem;
        JsonObject systems;
        JsonObject value;
        systems = (JsonObject) arraySystems.get(0);
        arraySystem = systems.getJsonArray("System");
        value = arraySystem.getJsonObject(0);
        
        
        convertBaliseSystem();
        convertBaliseOrgan();
        
        return FindConstructor.getMainBody();
    }
  
    private void convertBaliseMainBody()
    {
        // HashMap contenant les différents attributs
        HashMap<String, String> attributes = new HashMap<String, String>();

        attributes.put("bodyName", objJson.getString("bodyName"));
        attributes.put("bodyID", Integer.toString(objJson.getInt("bodyID")));

        try
        {
            findConstructor.findConstructor("MainBody", attributes);
        }
        catch (IFT287Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void convertBaliseSystem()
    {
        // HashMap contenant les différents attributs
        HashMap<String, String> attributes = new HashMap<String, String>();
        
        attributes.put("name", objJson.getString("name"));
        attributes.put("id", Integer.toString(objJson.getInt("id")));
        attributes.put("type", Integer.toString(objJson.getInt("type")));
        
        try
        {
            findConstructor.findConstructor("Systems", attributes);
        }
        catch (IFT287Exception e)
        {
            e.printStackTrace();
        }        
    }

    private void convertBaliseOrgan()
    {
        // HashMap contenant les différents attributs
        HashMap<String, String> attributes = new HashMap<String, String>();
        
        attributes.put("name", objJson.getString("name"));
        attributes.put("id", Integer.toString(objJson.getInt("id")));
        attributes.put("type", Integer.toString(objJson.getInt("type")));
        
        try
        {
            findConstructor.findConstructor("Systems", attributes);
        }
        catch (IFT287Exception e)
        {
            e.printStackTrace();
        }        
    }    
}
