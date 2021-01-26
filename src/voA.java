import com.Restapi;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class voA extends Restapi{

    Restapi restapi = new Restapi();

}



/*    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        Gson gson = new Gson();
        List<Map<String, Object>> myPushList = null;
        JsonArray jsonArray = json.get("documents").getAsJsonArray();
        myPushList = gson.fromJson(jsonArray, new TypeToken<List<Map<String, Object>>>() {
        }.getType());
        return myPushList.toString();
    }*/
