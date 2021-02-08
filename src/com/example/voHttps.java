package com.example;

public class voHttps {


    static String key = "KakaoAK 2b80b94ece8eb5cace6ef21359edac62";

    static String host = "https://dapi.kakao.com";
    static String path = "/v2/local/geo/coord2address.json";

    static String query = "x=127.423084873712&y=37.0789561558879&input_coord=WGS84";


    public static String getKey() {
        return key;
    }

    public static String getHost() {
        return host;
    }

    public static String getPath() {
        return path;
    }

    public static String getQuery() {
        return query;
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

    public static void setQuery(String query) {
        voHttps.query = query;
    }



}
