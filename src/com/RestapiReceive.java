package com;
import com.RestapiSend;
import com.example.Address;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RestapiReceive {

    public static String receive() throws IOException {
        RestapiSend restapisend = new RestapiSend();
        InputStream inputstream = null;
        try {
            inputstream = restapisend.search();
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
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
            String response = receive();
            System.out.println(prettify(response));
        }
        catch (Exception e) {
            System.out.println (e);
        }
    }
}
