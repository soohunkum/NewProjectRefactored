package com;

import com.example.Address;
import com.example.voHttps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.Certificate;


public class RestapiSend {

    private static voHttps vohttps;
    public static InputStream search() throws Exception {
        String params = "?" + vohttps.getQuery();
        URL url = new URL(vohttps.getHost() + vohttps.getPath() + params);
        String encoded_query = URLEncoder.encode(vohttps.getQuery(), "UTF-8");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", vohttps.getKey());
        connection.setDoOutput(true);
        connection.connect();
        InputStream inputstream = connection.getInputStream();

        return inputstream;

    }

}
