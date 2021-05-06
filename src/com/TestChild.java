package com;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class TestChild extends Test {

    String urlStr = "https://dapi.kakao.com/v2/local/search/address.json?query=";
    URL url = null;
    HttpURLConnection connection = null;
    BufferedReader reader = null;
    ArrayList<String> bCodeArrayList = new ArrayList<>();
    ArrayList<String> hCodeArrayList = new ArrayList<>();
    ArrayList<String> addressArrayList = new ArrayList<>();
    JsonObject address = null;

    public ArrayList<String> getbCodeArrayList() {
        return bCodeArrayList;
    }

    public void setbCodeArrayList(ArrayList<String> bCodeArrayList) {
        this.bCodeArrayList = bCodeArrayList;
    }

    public ArrayList<String> gethCodeArrayList() {
        return hCodeArrayList;
    }

    public void sethCodeArrayList(ArrayList<String> hCodeArrayList) {
        this.hCodeArrayList = hCodeArrayList;
    }



    public TestChild() {
    }


    public void runbCodehCode() throws MalformedURLException, UnsupportedEncodingException {
        String bCode = null;
        String hCode = null;
        UrlFor urlfor = new UrlFor();
        URL url2 = null;
        String addressName = null;
        JsonObject roadAddress = null;
        String encoded_query = null;
        JsonObject Address = null;
        try {
            ArrayList<URL> urls = urlfor.urlconnection();
            int count = urls.size();
            for (int i = 0; i < count; i++) {
                url = urls.get(i);
                if (getaddress(url) == null) {
                    addressName = null;
                } else {
                    roadAddress = getaddress(url);
                    addressName = roadAddress.get("address_name").getAsString();
                }
                addressArrayList.add(addressName);
                System.out.println(addressName + "      " + i);
                //System.out.println(addressArrayList.get(i) + "             " + i);
                if (addressName == null) {
                    encoded_query = null;
                } else {
                    encoded_query = URLEncoder.encode(addressName, "UTF-8");
                }
                url2 = new URL(urlStr + encoded_query);
                if (getaddress(url2) == null) {
                    bCode = null;
                    hCode = null;
                } else {
                    Address = getaddress(url2);
                    bCode = Address.get("b_code").getAsString();
                    hCode = Address.get("h_code").getAsString();
                }
                bCodeArrayList.add(bCode);
                hCodeArrayList.add(hCode);
                //System.out.println(bCodeArrayList.get(i) + "                 " + i);
            }
        } catch (
                UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }

    }


    public JsonObject getaddress(URL url) throws IndexOutOfBoundsException {
        StringBuffer buffer = getBuffer(url);
        JsonObject address = null;
        JsonObject json = null;
        JsonObject jsonObject = null;
        try {
            String bufferString = buffer.toString();
            JsonParser parser = new JsonParser();
            json = parser.parse(bufferString).getAsJsonObject();
            JsonArray jsonArray = json.getAsJsonArray("documents");
            if (jsonArray.size() == 0) {
                address = null;
            } else {
                jsonObject = jsonArray.get(0).getAsJsonObject();
                address = jsonObject.get("address").getAsJsonObject();
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println(url);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return address;
        }
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


