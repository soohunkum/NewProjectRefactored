package com;

import java.io.OptionalDataException;

public class voHttps {


    static String key = "KakaoAK 2b80b94ece8eb5cace6ef21359edac62";
    static String host = "https://dapi.kakao.com";
    static String path = "/v2/local/geo/coord2address.json";
    static String path2 = "/v2/local/search/address.json?query";



    public static String getKey() {
        return key;
    }

    public static String getHost() {
        return host;
    }

    public static String getPath() {
        return path;
    }

}
