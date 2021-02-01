package com;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;

import com.example.Example;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;


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

    public static List<Example> prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        Gson gson = new Gson();
        List<Example> example = null;
        JsonArray jsonArray = json.get("documents").getAsJsonArray();
        example = gson.fromJson(jsonArray, new TypeToken<List<Example>>() {
        }.getType());
        return example;
    }
}
