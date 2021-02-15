package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import java.util.Arrays;

import com.example.Address;
import com.example.voHttps;


public class Connect {

    static String key = "KakaoAK 2b80b94ece8eb5cace6ef21359edac62";

    static String host = "https://dapi.kakao.com";
    static String path = "/v2/local/geo/coord2address.json";

    static String query = "x=127.423084873712&y=37.0789561558879&input_coord=WGS84";


    static String[] queries = {
            "x=127.423084873712&y=37.0789561558879&input_coord=WGS84",
            "x=127.424084873712&y=37.0789561558879&input_coord=WGS84",
            "x=127.425084873712&y=37.0789561558879&input_coord=WGS84",
            "x=127.426084873712&y=37.0789561558879&input_coord=WGS84",
            "x=127.427084873712&y=37.0789561558879&input_coord=WGS84"
    };




    public static InputStream search() throws Exception {
        String encoded_query = URLEncoder.encode(query, "UTF-8");
        String params = "?" + query;
        URL url = new URL(host + path + params);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", key);
        connection.setDoOutput(true);
        InputStream inputstream = connection.getInputStream();

        return inputstream;


    }

    public static InputStream search2() throws Exception {
        Address address = new Address();
        String add = address.getAddressName();
        String encoded_query = URLEncoder.encode(query, "UTF-8");
        URL url = new URL(host + path + "?" + add);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", key);
        connection.setDoOutput(true);
        InputStream inputstream = connection.getInputStream();

        return inputstream;

    }

}




