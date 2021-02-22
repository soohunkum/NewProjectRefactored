package com;

import com.example.Address;
import com.example.voHttps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;


public class RestapiSend {


    private static voHttps vohttps = null;



public static String add() {

        QueriesArrayList queriesarraylist = new QueriesArrayList();

        Queries queries = new Queries(vohttps.getQueryx()+"&"+vohttps.getQueryy()+vohttps.getCoord());


            queriesarraylist.addQueries(queries);


        return queriesarraylist.returnQueries(queries);
    }


    public static URL urlconnection() throws MalformedURLException {

        URL url = new URL(vohttps.getHost() + vohttps.getPath() +"?" + add());

        return url;
    }

    public static HttpsURLConnection connection() throws IOException {
        HttpsURLConnection connection = (HttpsURLConnection) urlconnection().openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", vohttps.getKey());
        connection.setDoOutput(true);
        connection.connect();

        return connection;
    }


    //x,y좌표 inputstream으로 넘기기
    public static InputStream search1() throws Exception {

        InputStream inputstream = connection().getInputStream();

        return inputstream;
    }



    //도로명주소 추출
    public static String setAddress() throws IOException {

        InputStream inputstream = null;
        try {
            inputstream = search1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
        BufferedReader in = new BufferedReader(inputstreamreader);
        StringBuilder response1 = new StringBuilder();

        String line;

        while ((line = in.readLine()) != null) {
            response1.append(line);
        }
        in.close();

        Address address = new Address();
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(response1.toString()).getAsJsonObject();
        JsonArray jsonArray = json.getAsJsonArray("documents");
        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
        JsonObject roadAddress = jsonObject.get("road_address").getAsJsonObject();
        String addressName = roadAddress.get("address_name").getAsString();
        address.setAddressName(addressName);
        String add = address.getAddressName();

        return add;
    }


    //도로명주소 inputstream으로 넘기기
        public static InputStream search2() throws Exception {
        String encoded_query = URLEncoder.encode(setAddress(), "UTF-8");
        URL url = new URL(vohttps.getHost() + vohttps.getPath2() + "=" +encoded_query);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", vohttps.getKey());
        connection.setDoOutput(true);
        InputStream inputstream = connection.getInputStream();

        return inputstream;


    }
}
