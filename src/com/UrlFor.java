package com;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import com.example.voHttps;

public class UrlFor {
voHttps vohttps = new voHttps();
//    String[] queries = {
////    "x=127.423084873712&y=37.0789561558879&input_coord=WGS84",
//
//            "x=128.619305&y=36.806944&input_coord=WGS84",
//            "x=127.425084873712&y=37.0789561558879&input_coord=WGS84",
//            "x=127.426084873712&y=37.0789561558879&input_coord=WGS84",
//            "x=127.427084873712&y=37.0789561558879&input_coord=WGS84"
//
//    };
    JdbcUtil jdbcUtil = new JdbcUtil();


    ArrayList<String> query;

    {
        try {
            query = jdbcUtil.getArray();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    ;

    public ArrayList<URL> urlconnection() throws MalformedURLException {

        String line = null;
        URL url = null;
        ArrayList<URL> urlarray = new ArrayList<URL>(10);
        for (int j = 0; j < this.query.size() ; j++) {
            line = query.get(j);
            for (int i = 0; i < this.query.size(); i++) {
               url = new URL(vohttps.getHost() + vohttps.getPath() + "?" + line);

            }
            // urlarray = new ArrayList<>(Arrays.asList(url));
          urlarray.add(url);

//            System.out.println(url.toString());
        }
        return urlarray;
    }
}

