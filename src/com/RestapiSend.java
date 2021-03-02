package com;

import com.example.Address;
import com.example.voHttps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.*;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import com.google.gson.stream.JsonReader;

public class RestapiSend {

    private static final String TAG_A = "";
    private static final String TAG_B = "receive1: ";
    private static final String TAG_C = "prettify1:aaaaaaaaaaaaaaaaaaaaaaaa ";
    private static final String TAG_D = "main: ";
    private static voHttps vohttps = null;



//public static String add() {
//
//        QueriesArrayList queriesarraylist = new QueriesArrayList();
//
//    Queries query1 = new Queries("x=127.423084873712&y=37.0789561558879&input_coord=WGS84");
//    Queries query2 = new Queries("x=127.424084873712&y=37.0789561558879&input_coord=WGS84");
//    Queries query3 = new Queries("x=127.425084873712&y=37.0789561558879&input_coord=WGS84");
//    Queries query4 = new Queries("x=127.426084873712&y=37.0789561558879&input_coord=WGS84");
//    Queries query5 = new Queries("x=127.427084873712&y=37.0789561558879&input_coord=WGS84");
//
//    queriesarraylist.addQueries(query1);
//    queriesarraylist.addQueries(query2);
//    queriesarraylist.addQueries(query3);
//    queriesarraylist.addQueries(query4);
//    queriesarraylist.addQueries(query5);
//
//    queriesarraylist.returnQueries(query1);
//
//    return queriesarraylist.returnQueries(query1);
//}



    public static ArrayList<HttpsURLConnection> connection() throws IOException,MalformedURLException {
        UrlFor urlfor = new UrlFor();

        urlfor.urlconnection();
        HttpsURLConnection connection = null;
        URLConnection urlconnection = null;
        InputStream inputstream = null;
        ArrayList<HttpsURLConnection> httpsarray=  new ArrayList<HttpsURLConnection>();
try {
    for (int l = 0; l < urlfor.urlconnection().size(); l++) {
        urlconnection = urlfor.urlconnection().get(l).openConnection();

        for (int k = 0; k < urlfor.urlconnection().size(); k++) {
            connection = (HttpsURLConnection) urlconnection;

        }
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", vohttps.getKey());
        connection.setDoOutput(true);
        connection.connect();
        httpsarray.add(connection);
    }
}catch(MalformedURLException a){
    a.printStackTrace();
}catch(IOException e){
    e.printStackTrace();
        }

        return httpsarray;
    }


    //x,y좌표 inputstream으로 넘기기
    public static ArrayList<InputStream> search1() throws Exception {
        connection();
        InputStream inputstream = null;
        ArrayList<InputStream> inputstreamarray = new ArrayList<InputStream>();
        for(int u=0; u< connection().size(); u++) {
            inputstream = connection().get(u).getInputStream();
            inputstreamarray.add(inputstream);

        }
        return inputstreamarray;

    }

    //x,y좌표 넘긴 후 도로명주소 받기
    public static ArrayList<String> receive1() throws Exception {
        ArrayList<String> stringarray = new ArrayList<String>();
        InputStreamReader inputstreamreader = null;
        BufferedReader in = null;
        StringBuilder response1 = new StringBuilder();
        String line;

        for(int q=0; q< search1().size(); q++) {
            inputstreamreader = new InputStreamReader(search1().get(q));
            in = new BufferedReader(inputstreamreader);

            while ((line = in.readLine()) != null) {
                response1.append(line);
                stringarray.add(response1.append((line)).toString());
            }
        }
        in.close();
    System.out.println("eeeeeeeeeeeeeeeeeeeeeee" + response1.toString());
        //System.out.println("ABC" + response1.toString());
        return stringarray;

    }
    private static String jsonReader(String json_text) throws Exception {
        Address address = new Address();
        StringReader reader = null;
        JsonParser parser = new JsonParser();
        try{
        for (int e = 0; e < receive1().size(); e++) {
            reader = new StringReader(receive1().get(e));
            JsonReader jsonReader = new JsonReader(reader);
            jsonReader.setLenient(true);
            JsonObject json = parser.parse(jsonReader).getAsJsonObject();
            JsonArray jsonArray = json.getAsJsonArray("documents");
            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
            JsonObject roadAddress = jsonObject.get("road_address").getAsJsonObject();
            String addressName = roadAddress.get("address_name").getAsString();

            address.setAddressName(addressName);
        }

        } catch (NullPointerException e){
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return address.getAddressName();
        }

    public static void main(String[] args) {
        try {
            String response1 = receive1().toString();
            System.out.println(TAG_D + jsonReader(response1));
        }
        catch (Exception e) {
            System.out.println (e);
        }
    }



    //도로명주소 추출
    public static String setAddress() throws IOException {

        InputStream inputstream = null;
        try {
            //inputstream = search1();
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
