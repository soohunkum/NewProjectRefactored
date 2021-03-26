package com;

import com.example.Address;
import com.example.voHttps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonSyntaxException;
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


    public static ArrayList<HttpsURLConnection> connection() throws IOException, MalformedURLException {
        UrlFor urlfor = new UrlFor();

        urlfor.urlconnection();
        HttpsURLConnection connection = null;
        URLConnection urlconnection = null;
        InputStream inputstream = null;
        ArrayList<HttpsURLConnection> httpsarray = new ArrayList<HttpsURLConnection>();
        int count = urlfor.urlconnection().size();
        try {
            for (int l = 0; l < count; l++) {
                urlconnection = urlfor.urlconnection().get(l).openConnection();

                for (int k = 0; k < count; k++) {
                    connection = (HttpsURLConnection) urlconnection;

                }
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Authorization", vohttps.getKey());
                connection.setDoOutput(true);
                connection.connect();
                httpsarray.add(connection);
            }
        } catch (MalformedURLException a) {
            a.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return httpsarray;

    }


    //x,y좌표 inputstream으로 넘기기
    public static ArrayList<InputStream> search1() throws Exception {
        connection();
        InputStream inputstream = null;
        ArrayList<InputStream> inputstreamarray = new ArrayList<InputStream>();
        int count = connection().size();
        for (int u = 0; u < count; u++) {
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
        int count = search1().size();

        for(int q = 0; q < count; q++) {
            inputstreamreader = new InputStreamReader(search1().get(q));
            in = new BufferedReader(inputstreamreader);
            line = in.readLine();
            response1.append(line);
            stringarray.add(response1.append((line)).toString());
        }

        in.close();
        System.out.println("eeeeeeeeeeeeeeeeeeeeeee" + stringarray);
        System.out.println();
        //System.out.println("ABC" + response1.toString());
        return stringarray;

    }

    public static ArrayList<StringReader> stringReader() throws Exception {
        StringReader reader = null;
        ArrayList<StringReader>readerarray = new ArrayList<StringReader>();
        int count =  receive1().size();
        for (int e = 0; e < count; e++) {
            reader = new StringReader(receive1().get(e));
            reader.read();
           readerarray.add(reader);
//System.out.println(readerarray.get(e));
        }

        return readerarray;
    }

public static ArrayList<String> jsonreaderarraylisttostring() throws Exception {
    int count = receive1().size();
    ArrayList<String> jsonreaderarraylisttostring = new ArrayList<String>();
    ArrayList<JsonReader> jsonreaderarraylist = new ArrayList<JsonReader>();
    for (int b = 0; b < count; b++) {
        jsonreaderarraylist.add(new JsonReader((Reader)stringReader().get(b)));
        jsonreaderarraylisttostring.add(jsonreaderarraylist.get(b).toString());
    }
    return jsonreaderarraylisttostring;
}

    public static ArrayList<String> addressnamelist() throws Exception {
//        Address address = new Address();

        ArrayList<JsonReader> jsonreader = new ArrayList<JsonReader>();
        JsonParser parser = new JsonParser();
        String addressName = null;
        ArrayList<String> addressnamelist = new ArrayList<String>();

        try {
            int count = stringReader().size();
//            for (int z = 0; z <count ; z++) {
//                jsonreader.setLenient(true);
//                jsonreader.add(new JsonReader((Reader)jsonreaderarraylisttostring().get(z)));
                int b=0;
                for (int a = 0; a < count; a++) {
                    JsonObject json = parser.parse(jsonreaderarraylisttostring().get(a)).getAsJsonObject();
                    JsonArray jsonArray = json.getAsJsonArray("documents");
                    JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
                    JsonObject roadAddress = jsonObject.get("address").getAsJsonObject();
                    addressName = roadAddress.get("address_name").getAsString();
                    addressnamelist.add(addressName);
                }

            }


//            jsonreader.close();
        catch(JsonSyntaxException e){
            e.printStackTrace();
            System.out.println(e);
        }
         catch (IllegalStateException e) {
            e.printStackTrace();
            System.out.println (e);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println (e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println (e);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println (e);
        }
System.out.println(addressnamelist);
        return addressnamelist;
    }



    public static void readaddress() throws Exception {
        try {
            int count = addressnamelist().size();
            for (int l = 0; l <count ; l++) {
                System.out.println(addressnamelist().get(l));
            }
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println (e);

            } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {
        String addressName = null;
        try {
//            String response1 = receive1().toString();
//            System.out.println(TAG_D + jsonReader(response1));
//            readaddress();

            Test test = new Test();
            addressName = test.getAddressName();
            test.runSome();

        }
        catch (Exception e) {
//            System.out.println (e);
            e.printStackTrace();
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
