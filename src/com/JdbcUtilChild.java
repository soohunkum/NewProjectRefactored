package com;

import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;

public class JdbcUtilChild extends JdbcUtil{

    int num;
    double x;
    double y;



    public void variables() {

        Connection conn = null;
        Statement st1 = null;
        Statement st2 = null;
        Statement st3 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        PreparedStatement pstmt = null;


        String url = "jdbc:postgres6+" +
                "+" +
                "ql://localhost/wfis47210a";
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
                this.num = num;
                this.x = myX;
                this.y = myY;
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
        return array;

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

    //        public static ArrayList<String> getContent() throws SQLException {
//
//        Connection conn = null;
//        Statement st1 = null;
//        Statement st2 = null;
//        Statement st3 = null;
//        ResultSet rs1 = null;
//        ResultSet rs2 = null;
//        ResultSet rs3 = null;
//        PreparedStatement pstmt = null;
//
//
//
//        String url = "jdbc:postgresql://localhost/wfis47210a";
//        String user = "postgres";
//        String password = "root";
//        String sql = ;
//
//        SQLList sqlList = new SQLList();
//
//        try {
//
//            conn = DriverManager.getConnection(url, user, password);
////            pstmt = conn.prepareStatement();
//            st3 = conn.createStatement();
//
//            // st3 = conn.createStatement();
//            rs3 = st3.executeQuery(sql);
//
//            while(rs3.next()){
//
//                for (int i = 0; i < this.getCount(); i++) {
//
//                }
//
//            }
//
//
//
//
//
//        } catch (SQLException e) {
//            System.out.println(e);
//            e.printStackTrace();
//
//        } finally {
//            try {
//                conn.close();
//                st3.close();
////st2.close();
////st3.close();
////rs2.close();
////rs3.close();
//
//
//            } catch (PSQLException sqlEX) {
//                System.out.println(sqlEX);
//                sqlEX.printStackTrace();
//            } catch (SQLException e) {
//                System.out.println(e);
//                e.printStackTrace();
//            }
//        }
//    }
    public static ArrayList<Double> arrayX(){
        return arrayX();
    }
    public static ArrayList<Double> arrayY(){
        return arrayY();
    }
}
