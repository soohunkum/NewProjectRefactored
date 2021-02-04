package com;

import com.example.Example;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jdk.swing.interop.SwingInterOpUtils;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;


public class Restapi {


    static String key = "KakaoAK 2b80b94ece8eb5cace6ef21359edac62";

    static String host = "https://dapi.kakao.com";
    static String path = "/v2/local/geo/coord2address.json";

    static String query = "x=127.423084873712&y=37.0789561558879&input_coord=WGS84";

    public static String search() throws Exception {
        String encoded_query = URLEncoder.encode(query, "UTF-8");
        String params = "?" + query;
        URL url = new URL(host + path + params);

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", key);
        connection.setDoOutput(true);

        StringBuilder response = new StringBuilder();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        return response.toString();
    }

    public static void prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        Gson gson = new Gson();
        List<Example> example = null;
//        JsonArray jsonArray = json.get("documents").getAsJsonArray();
        JsonArray jsonArray2 = json.getAsJsonArray("documents");
        System.out.println(jsonArray2);
        JsonObject jsonObject = jsonArray2.get(0).getAsJsonObject();
        System.out.println(jsonObject.getClass().getName());
        JsonObject roadAddress = jsonObject.get("road_address").getAsJsonObject();
        System.out.println(roadAddress.getClass().getName());
        String addressName = roadAddress.get("address_name").getAsString();
        System.out.println(addressName);

//        example = gson.fromJson(jsonArray, new TypeToken<List<Example>>() {
//        }.getType());
//        System.out.println(example);
    }

    public static void mapper(String json_text){
//        JsonParser parser = new JsonParser();
//        JsonObject json = parser.parse(json_text).getAsJsonObject();
//        JsonArray jsonArray = json.get("documents").getAsJsonArray();
//        ObjectMapper mapper = new JsonFactory().create();
//        Example e = mapper.fromJson(jsonArray.getAsCharacter(), Example.class);
//        System.out.println(e.getAddress());
    }

    public static void main(String[] args) {
        try {
            String response = search ();
            prettify(response);
//           mapper(response);
        }
        catch (Exception e) {
            System.out.println (e);
        }
    }
    }
