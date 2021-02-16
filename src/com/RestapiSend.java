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


public class RestapiSend {


    private static voHttps vohttps = null;

public static QueriesArrayList add() {
    QueriesArrayList queriesarraylist = new QueriesArrayList();
    Queries query1 = new Queries("x=127.423084873712&y=37.0789561558879&input_coord=WGS84");
    Queries query2 = new Queries("x=127.424084873712&y=37.0789561558879&input_coord=WGS84");
    Queries query3 = new Queries("x=127.425084873712&y=37.0789561558879&input_coord=WGS84");
    Queries query4 = new Queries("x=127.426084873712&y=37.0789561558879&input_coord=WGS84");
    Queries query5 = new Queries("x=127.427084873712&y=37.0789561558879&input_coord=WGS84");

    queriesarraylist.addQueries(query1);
    queriesarraylist.addQueries(query2);
    queriesarraylist.addQueries(query3);
    queriesarraylist.addQueries(query4);
    queriesarraylist.addQueries(query5);

    return queriesarraylist;
}
public static String show(){
    QueriesArrayList queriesarraylist = new QueriesArrayList();
    queriesarraylist.returnQueries(add());

    return queriesarraylist.toString();

}



    public static URL urlconnection() throws MalformedURLException {

        URL url = new URL(vohttps.getHost() + vohttps.getPath() +"?"+ show());

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

    public static InputStream search1() throws Exception {

        InputStream inputstream = connection().getInputStream();

        return inputstream;
    }

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
