package com;

import com.example.Address;
import com.example.Example;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;



public class RestapiSend {


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
        InputStreamReader inputstreamreader = new InputStreamReader(connection.getInputStream());
        BufferedReader in = new BufferedReader(inputstreamreader);
        StringBuilder response = new StringBuilder();



        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        return response.toString();
    }




    public static String prettify(String json_text) {
            Address address = new Address();
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(json_text).getAsJsonObject();
            JsonArray jsonArray = json.getAsJsonArray("documents");
            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
            JsonObject roadAddress = jsonObject.get("road_address").getAsJsonObject();
            String addressName = roadAddress.get("address_name").getAsString();
            address.setAddressName(addressName);

             return address.getAddressName();
    }



    public static void main(String[] args) {
        try {
            String response = search ();
            prettify(response);
        }
        catch (Exception e) {
            System.out.println (e);
        }
    }
    }
