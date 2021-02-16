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

    //x,y좌표 넘긴 후 도로명주소 받기
    public static String receive1() throws IOException {
        RestapiSend restapisend = new RestapiSend();
        InputStream inputstream = null;
        try {
            inputstream = restapisend.search1();
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

        return response1.toString();

    }

    //도로명주소 넘긴 후 행정동 법정동 코드 받기
    public static String receive2() throws IOException {
        RestapiSend restapisend = new RestapiSend();
        InputStream inputstream = null;
        try {
            inputstream = restapisend.search2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
        BufferedReader in = new BufferedReader(inputstreamreader);
        StringBuilder response2 = new StringBuilder();

        String line;

        while ((line = in.readLine()) != null) {
            response2.append(line);
        }
        in.close();

        return response2.toString();

    }

    //도로명주소 저장하기
    public static String prettify1(String json_text) {
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

    //법정동 코드 저장하기
    public static String prettify2(String json_text) {
        Address address = new Address();
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        JsonArray jsonArray = json.getAsJsonArray("documents");
        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
        JsonObject address2 = jsonObject.get("address").getAsJsonObject();
        String b_code = address2.get("b_code").getAsString();
        address.setB_code(b_code);
        return address.getB_code();
    }

    //행정동 코드 저장하기
    public static String prettify3(String json_text) {
        Address address = new Address();
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        JsonArray jsonArray = json.getAsJsonArray("documents");
        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
        JsonObject address2 = jsonObject.get("address").getAsJsonObject();
        String h_code = address2.get("h_code").getAsString();
        address.setH_code(h_code);
        return address.getH_code();
    }



    public static void main(String[] args) {
        try {
            String response1 = receive1();
            System.out.println(prettify1(response1));
            String response2 = receive2();
            System.out.println(prettify2(response2));
            System.out.println(prettify3(response2));
        }
        catch (Exception e) {
            System.out.println (e);
        }
    }
}



