package com;

import com.example.voHttps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.postgresql.util.PSQLException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;

public class JdbcUtil {

    public int num;
    public double x;
    public double y;


    public void variables() {

        Connection conn = null;
        Statement st1 = null;
        Statement st2 = null;
        Statement st3 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        PreparedStatement pstmt = null;


        String url = "jdbc:postgresql://localhost/wfis47210a";
        String user = "postgres";
        String password = "root";
        String sql = "SELECT 관리번호,\n" +
                "       ROUND(CAST(ST_X(ST_Transform(ST_GeometryN(geom, 1), 4326)) AS numeric), 6) AS \"x\",\n" +
                "       ROUND(CAST(ST_Y(ST_Transform(ST_GeometryN(geom, 1), 4326)) AS numeric), 6) AS \"y\"\n" +
                "from viw_wtt_wutl_ht;";
        String sql2 = "SELECT COUNT(*)FROM viw_wtt_wutl_ht";

//        SQLHashSet sqlHashSet = new SQLHashSet();

        SQLList sqlList = new SQLList();

        ArrayList<String> array = null;
        ArrayList<Double> arrayX = null;
        ArrayList<Double> arrayY = null;
        try {

            conn = DriverManager.getConnection(url, user, password);
//            pstmt = conn.prepareStatement();
            st1 = conn.createStatement();

            // st3 = conn.createStatement();
            rs1 = st1.executeQuery(sql);
            array = new ArrayList<>();
            arrayX = new ArrayList<>();
            arrayY = new ArrayList<>();
            while (rs1.next()) {
//                new SQLList(rs1.getInt("관리번호"), rs1.getDouble("x"), rs1.getDouble("y"));
                double myX = rs1.getDouble("x");
                double myY = rs1.getDouble("y");
                int num = rs1.getInt("관리번호");

                sqlList.setX(myX);
                sqlList.setY(myY);
                sqlList.setNum(num);

                System.out.println(sqlList.getXY2());
                //System.out.println(num + myX + myY);
                array.add(sqlList.getXY2());
                arrayX.add(sqlList.getX());
                arrayY.add(sqlList.getY());


            }


        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();

        } finally {
            try {
                conn.close();
                st1.close();
//st2.close();
//st3.close();
//rs2.close();
//rs3.close();


            } catch (PSQLException sqlEX) {
                System.out.println(sqlEX);
                sqlEX.printStackTrace();
            } catch (SQLException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

    }

    public boolean gettrue() throws SQLException, MalformedURLException, NullPointerException, IndexOutOfBoundsException {


        Connection conn = null;
        Statement st1 = null;
        Statement st2 = null;
        Statement st3 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        PreparedStatement pstmt = null;


        String url = "jdbc:postgresql://localhost/wfis47210a";
        String user = "postgres";
        String password = "root";
        String sql = "SELECT 관리번호,\n" +
                "       ROUND(CAST(ST_X(ST_Transform(ST_GeometryN(geom, 1), 4326)) AS numeric), 6) AS \"x\",\n" +
                "       ROUND(CAST(ST_Y(ST_Transform(ST_GeometryN(geom, 1), 4326)) AS numeric), 6) AS \"y\"\n" +
                "from viw_wtt_wutl_ht;";
        String sql2 = "SELECT COUNT(*)FROM viw_wtt_wutl_ht";

//        SQLHashSet sqlHashSet = new SQLHashSet();
        voHttps vohttps = new voHttps();
        SQLList sqlList = new SQLList();
        URL urls = null;
        String query = null;
        TestChild testChild = null;
        Boolean a = null;
        StringBuffer buffer = null;
        BufferedReader reader = null;
        JsonObject json = null;
        JsonObject address = null;
        HttpURLConnection connection = null;
        try {

            conn = DriverManager.getConnection(url, user, password);
//            pstmt = conn.prepareStatement();
            st1 = conn.createStatement();

            // st3 = conn.createStatement();
            rs1 = st1.executeQuery(sql);

            while (rs1.next()) {
                query = sqlList.getXY(rs1.getDouble("x"), rs1.getDouble("y"));
                urls = new URL(vohttps.getHost() + vohttps.getPath() + "?" + query);
                connection = (HttpsURLConnection) urls.openConnection();
                connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                connection.setRequestProperty("cache-control", "no-cache");
                connection.setRequestProperty("Authorization", voHttps.getKey());
                connection.setDoOutput(true);

                connection.connect();

                int code = connection.getResponseCode();
                String message = connection.getResponseMessage();

                if (code == HttpURLConnection.HTTP_OK) {
                    buffer = new StringBuffer();

                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                    String temp = null;
                    while ((temp = reader.readLine()) != null) {
                        buffer.append(temp);
                        String bufferString = buffer.toString();
                        JsonParser parser = new JsonParser();
                        json = parser.parse(bufferString).getAsJsonObject();
                        JsonArray jsonArray = json.getAsJsonArray("documents");
                        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
                        if (jsonObject == null) a = false;
                        else a = true;

                    }

                    reader.close();
                }
                connection.disconnect();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();

        } catch (NullPointerException nullPointerException) {
            nullPointerException.printStackTrace();
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            indexOutOfBoundsException.printStackTrace();
        }
        return a;
    }


    public static Integer getCount() {

        Connection conn = null;
        Statement st1 = null;
        Statement st2 = null;
        Statement st3 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        PreparedStatement pstmt = null;


        String url = "jdbc:postgresql://localhost/wfis47210a";
        String user = "postgres";
        String password = "root";

        String sql = "SELECT COUNT(*)FROM viw_wtt_wutl_ht";

//        SQLHashSet sqlHashSet = new SQLHashSet();

        int rscount = 0;
        try {

            conn = DriverManager.getConnection(url, user, password);
//            pstmt = conn.prepareStatement();


            st2 = conn.createStatement();
            rs2 = st2.executeQuery(sql);

            // st3 = conn.createStatement();
            if (rs2.next()) rscount = rs2.getInt(1);

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();

        } finally {
            try {
                conn.close();
                st2.close();
//st2.close();
//st3.close();
//rs2.close();
//rs3.close();


            } catch (PSQLException sqlEX) {
                System.out.println(sqlEX);
                sqlEX.printStackTrace();
            } catch (SQLException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        return rscount;
    }


    public static ArrayList<String> getArray() throws SQLException {

        Connection conn = null;
        Statement st1 = null;
        Statement st2 = null;
        Statement st3 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        PreparedStatement pstmt = null;


        String url = "jdbc:postgresql://localhost/wfis47210a";
        String user = "postgres";
        String password = "root";
        String sql = "SELECT 관리번호,\n" +
                "       ROUND(CAST(ST_X(ST_Transform(ST_GeometryN(geom, 1), 4326)) AS numeric), 6) AS \"x\",\n" +
                "       ROUND(CAST(ST_Y(ST_Transform(ST_GeometryN(geom, 1), 4326)) AS numeric), 6) AS \"y\"\n" +
                "from viw_wtt_wutl_ht;";
        String sql2 = "SELECT COUNT(*)FROM viw_wtt_wutl_ht";

//        SQLHashSet sqlHashSet = new SQLHashSet();

        SQLList sqlList = new SQLList();
        ArrayList<String> array = null;
        ArrayList<Double> arrayX = null;
        ArrayList<Double> arrayY = null;
        try {

            conn = DriverManager.getConnection(url, user, password);
//            pstmt = conn.prepareStatement();
            st1 = conn.createStatement();

            // st3 = conn.createStatement();
            rs1 = st1.executeQuery(sql);
            array = new ArrayList<>();
            arrayX = new ArrayList<>();
            arrayY = new ArrayList<>();
            while (rs1.next()) {


                array.add(sqlList.getXY(rs1.getDouble("x"), rs1.getDouble("y")));

            }


        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();

        } finally {
            try {
                st1.close();
                conn.close();
//st2.close();
//st3.close();
//rs2.close();
//rs3.close();


            } catch (PSQLException sqlEX) {
                System.out.println(sqlEX);
                sqlEX.printStackTrace();
            } catch (SQLException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        return array;

    }

    public static String makebCodeSql() throws MalformedURLException, UnsupportedEncodingException {
        TestChild testChild = new TestChild();
        testChild.runbCodehCode();
        StringBuffer sb = new StringBuffer();
        for (String s : testChild.getbCodeArrayList()) {

            sb.append(s);

            sb.append(",");
        }

        sb.deleteCharAt(sb.lastIndexOf(","));
        String str = sb.toString();
        return str;
    }

    public String makehCodeSql() throws MalformedURLException, UnsupportedEncodingException {
        TestChild testChild = new TestChild();
        testChild.runbCodehCode();
        StringBuffer sb = new StringBuffer();
        for (String s : testChild.gethCodeArrayList()) {
            sb.append("'");
            sb.append(s);
            sb.append("'");
            sb.append(",");
        }
        String str = sb.toString();
        return str;
    }

    public static String makeNumSql() throws SQLException {
        JdbcUtilChild jdbcUtilChild = new JdbcUtilChild();
        jdbcUtilChild.returnNum();
        StringBuffer sb = new StringBuffer();

        for (Integer s : jdbcUtilChild.getArrayNum()) {
            sb.append(s);

            sb.append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        String str = sb.toString();
        return str;
    }


    public static void main(String[] args) throws IOException, SQLException, PSQLException, NullPointerException, IndexOutOfBoundsException {
        JdbcUtilChild jdbcUtilChild = new JdbcUtilChild();

        Connection conn = null;
        Statement st1 = null;
        jdbcUtilChild.makeSql();

        String url = "jdbc:postgresql://localhost/wfis47210a";
        String user = "postgres";
        String password = "root";

        try {

            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            st1 = conn.createStatement();
            for (int i = 0; i < getCount(); i++) {
                String sqlName = jdbcUtilChild.getSqlArray().get(i);
                System.out.println(sqlName);
                if (sqlName == null) continue;
                    st1.executeUpdate(sqlName);
                }

            conn.commit();


        } catch (PSQLException | NullPointerException | IndexOutOfBoundsException e) {
            System.out.println(e);
            System.err.println(e);
            e.printStackTrace();

        } finally {
            try {
                conn.close();
                st1.close();


            } catch (PSQLException sqlEX) {
                System.out.println(sqlEX);
                sqlEX.printStackTrace();
            } catch (SQLException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

    }

}