package com.example;

import java.io.OptionalDataException;

public class voHttps {


    static String key = "KakaoAK 2b80b94ece8eb5cace6ef21359edac62";

    static String host = "https://dapi.kakao.com";
    static String path = "/v2/local/geo/coord2address.json";
    static String path2 = "/v2/local/search/address.json?query";


    static String queryx = "x=127.423084873712";
    static String queryy = "y=37.0789561558879";
    static String coord = "&input_coord=WGS84";




    public static String getKey() {
        return key;
    }

    public static String getHost() {
        return host;
    }

    public static String getPath() {
        return path;
    }



    public static void setKey(String key) {
        voHttps.key = key;
    }

    public static void setHost(String host) {
        voHttps.host = host;
    }

    public static void setPath(String path) {
        voHttps.path = path;
    }


    public static String getPath2() {
        return path2;
    }

    public static void setPath2(String path2) {
        voHttps.path2 = path2;
    }

    public static String getQueryx() {
        return queryx;
    }

    public static void setQueryx(String queryx) {
        voHttps.queryx = queryx;
    }

    public static String getQueryy() {
        return queryy;
    }

    public static void setQueryy(String queryy) {
        voHttps.queryy = queryy;
    }

    public static String getCoord() {
        return coord;
    }

    public static void setCoord(String coord) {
        voHttps.coord = coord;
    }

}
