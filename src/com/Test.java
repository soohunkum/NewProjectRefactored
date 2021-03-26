package com;

import com.example.SQLList;
import com.example.voHttps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.util.ArrayList;

public class Test {

    private String bCode;
    private String hCode;

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String gethCode() {
        return hCode;
    }

    public void sethCode(String hCode) {
        this.hCode = hCode;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    private String addressName;
//
//    public int getSize() throws MalformedURLException {
//        UrlFor urlfor = new UrlFor();
//        int count = urlfor.urlconnection().size();
//        return count;
//    }

    String urlStr = "https://dapi.kakao.com/v2/local/search/address.json?query=";
    URL url = null;
    HttpURLConnection connection = null;
    BufferedReader reader = null;
    ArrayList<String> addressArrayList = new ArrayList<>();


    public void runSome() {
        System.out.println("runSome 실행됨");
        int resultCount = 0;
        try {
            UrlFor urlfor = new UrlFor();
            ArrayList<URL> urls = urlfor.urlconnection();
            int count = urls.size();
            System.out.println("총 URL 수: " +count);
            for (int i = 0; i < count; i++) {
                    url = urls.get(i);
                JsonObject roadAddress = getaddress(url);
                if (roadAddress == null) continue;
                addressName = roadAddress.get("address_name").getAsString();
                System.out.println(addressName);
                setAddressName(addressName);
                addressArrayList.add(addressName);
                ++resultCount;

//                if (roadAddress != null) {
//                    String addressName = roadAddress.get("address_name").getAsString();
//                    System.out.println(addressName);
//                    addressArrayList.add(addressName);
//                    ++resultCount;
//                }
            }
            System.out.println(addressArrayList.size());
            for (int i = 0; i < addressArrayList.size(); i++) {
                String addressName = addressArrayList.get(i);
                setAddressName(addressName);
                runSomeNext(addressName);


            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void runSomeNext(String addressName) {
        SQLList sqlList = new SQLList();
        try {
            String encoded_query = URLEncoder.encode(addressName, "UTF-8");
            url = new URL(urlStr + encoded_query);
            JsonObject roadAddress = getaddress(url);
            bCode = roadAddress.get("b_code").getAsString();
            sqlList.setbCode(bCode);
            String bCode = getbCode();
            System.out.println(bCode);
            hCode = roadAddress.get("h_code").getAsString();
            sqlList.sethCode(hCode);
            String hCode = gethCode();
            System.out.println(hCode);
            System.out.println("법정동코드: " + bCode + "/" + "행정동코드: " + hCode);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public JsonObject getaddress(URL url){
        StringBuffer buffer = getBuffer(url);

//            System.out.println(String.format("Response : %d, %s", code, message));
//            System.out.println("Response DATA : ");
//            System.out.println(buffer == null ? "NULL " : buffer.toString());
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