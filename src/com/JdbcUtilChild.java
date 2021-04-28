package com;

import org.postgresql.util.PSQLException;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.ArrayList;

public class JdbcUtilChild extends JdbcUtil {

    String num;
    double x;
    double y;

    public ArrayList<String> getSqlArray() {
        return sqlArray;
    }

    ArrayList<String> sqlArray = null;

    public ArrayList<Integer> getArrayNum() {
        return arrayNum;
    }

    ArrayList<Integer> arrayNum = null;


    public ArrayList<Integer> returnNum() throws NullPointerException {

        Connection conn = null;
        Statement st1 = null;
        ResultSet rs1 = null;
        PreparedStatement pstmt = null;


        String url = "jdbc:postgresql://localhost/wfis47210a";
        String user = "postgres";
        String password = "root";
        String sql = "SELECT 관리번호,\n" +
                "       ROUND(CAST(ST_X(ST_Transform(ST_GeometryN(geom, 1), 4326)) AS numeric), 6) AS \"x\",\n" +
                "       ROUND(CAST(ST_Y(ST_Transform(ST_GeometryN(geom, 1), 4326)) AS numeric), 6) AS \"y\"\n" +
                "from viw_wtt_wutl_ht;";


        try {
            arrayNum = new ArrayList<>();
            conn = DriverManager.getConnection(url, user, password);
            st1 = conn.createStatement();
            rs1 = st1.executeQuery(sql);

            while (rs1.next()) {

                int num = rs1.getInt("관리번호");
                arrayNum.add(num);


            }


        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println(e);
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
            return arrayNum;

        }
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


        SQLList sqlList = new SQLList();
        ArrayList<String> array = null;
        try {

            conn = DriverManager.getConnection(url, user, password);
//            pstmt = conn.prepareStatement();
            st1 = conn.createStatement();

            // st3 = conn.createStatement();
            rs1 = st1.executeQuery(sql);
            array = new ArrayList<>();

            while (rs1.next()) {


                array.add(sqlList.getXY(rs1.getDouble("x"), rs1.getDouble("y")));

            }


        } catch (SQLException e) {
            System.out.println(e);
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
        return array;

    }

    public ArrayList<Double> returnX() {

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

        ArrayList<Double> arrayX = null;
        ArrayList<Double> arrayY = null;
        try {

            conn = DriverManager.getConnection(url, user, password);
//            pstmt = conn.prepareStatement();
            st1 = conn.createStatement();

            // st3 = conn.createStatement();
            rs1 = st1.executeQuery(sql);

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

                //System.out.println(sqlList.getXY2());
                //System.out.println(num + myX + myY);
                arrayX.add(rs1.getDouble("x"));
                arrayY.add(rs1.getDouble("y"));


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
        return arrayX;

    }

    public ArrayList<Double> returnY() {

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

        SQLList sqlList = new SQLList();

        ArrayList<Double> arrayY = null;
        try {

            conn = DriverManager.getConnection(url, user, password);

            st1 = conn.createStatement();

            rs1 = st1.executeQuery(sql);

            arrayY = new ArrayList<>();
            while (rs1.next()) {

                double myX = rs1.getDouble("x");
                double myY = rs1.getDouble("y");
                int num = rs1.getInt("관리번호");

                sqlList.setX(myX);
                sqlList.setY(myY);
                sqlList.setNum(num);


                arrayY.add(rs1.getDouble("y"));


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
        return arrayY;

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

    public void makeSql() throws MalformedURLException, UnsupportedEncodingException, SQLException {
        TestChild testChild = new TestChild();
        JdbcUtilChild jdbcUtilChild = new JdbcUtilChild();
        testChild.runbCodehCode();
        jdbcUtilChild.returnNum();
        sqlArray = new ArrayList<String>();
        String sql = null;
        for (int i = 0; i < getCount(); i++) {

            String bCodesql = testChild.getbCodeArrayList().get(i);
            String hCodesql = testChild.gethCodeArrayList().get(i);
            Integer numsql = jdbcUtilChild.getArrayNum().get(i);
            if (bCodesql == "0" || hCodesql == "0") {
                sql = "UPDATE wtt_wutl_ht SET bjd_cde = null, hjd_cde = null;";
            } else {
                sql = "UPDATE wtt_wutl_ht SET bjd_cde = (" + bCodesql + "), hjd_cde = (" + hCodesql + ") WHERE ftr_idn = (" + numsql + ");";
            }
            sqlArray.add(sql);
        }
    }
}
