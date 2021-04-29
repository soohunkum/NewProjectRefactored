package com;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import com.example.voHttps;

public class UrlFor {
voHttps vohttps = new voHttps();

    JdbcUtil jdbcUtil = new JdbcUtil();


    ArrayList<String> query;

    {
        try {
            query = jdbcUtil.getArray();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public ArrayList<URL> urlconnection() throws MalformedURLException {
        JdbcUtilChild jdbcUtilChild = new JdbcUtilChild();
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

