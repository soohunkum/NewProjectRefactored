package com;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;

public class Test {

    String urlStr = "https://dapi.kakao.com/v2/local/search/address.json?query=";
    URL url = null;
    HttpURLConnection connection = null;
    BufferedReader reader = null;
    ArrayList<String> addressArrayList = new ArrayList<>();

    public ArrayList<String> getbCodeArrayList() {
        return bCodeArrayList;
    }

    public ArrayList<String> gethCodeArrayList() {
        return hCodeArrayList;
    }


    ArrayList<String> bCodeArrayList = new ArrayList<>();
    ArrayList<String> hCodeArrayList = new ArrayList<>();

    public Test(){}



    public JsonObject getaddress(URL url) {
        StringBuffer buffer = getBuffer(url);
        JsonObject roadAddress = null;
        JsonObject json = null;
        try {
            String bufferString = buffer.toString();
            JsonParser parser = new JsonParser();
            json = parser.parse(bufferString).getAsJsonObject();
            JsonArray jsonArray = json.getAsJsonArray("documents");
            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
            roadAddress = jsonObject.get("address").getAsJsonObject();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println(url);
            System.out.println(json);
        }
        return roadAddress;
    }

    public StringBuffer getBuffer(URL url) {
        StringBuffer buffer = null;
        try {
            connection = urlStr.startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setRequestProperty("cache-control", "no-cache");
            connection.setRequestProperty("Authorization", voHttps.getKey());
            connection.setDoOutput(true);

            connection.connect();

            int code = connection.getResponseCode();
            String message = connection.getResponseMessage();

            if (code == HttpURLConnection.HTTP_OK) {
                buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                String temp = null;
                while ((temp = reader.readLine()) != null) {
                    buffer.append(temp);
                }

                reader.close();
            }
            connection.disconnect();

        } catch (IOException e) {

        }
        return buffer;
    }


}
