package com;

import com.example.SQLList;
import org.postgresql.util.PSQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.*;

public class JdbcUtil {

    public static void main(String[] args) throws SQLException {

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

//        SQLHashSet sqlHashSet = new SQLHashSet();

SQLList sqlList = new SQLList();
        try {

            conn = DriverManager.getConnection(url, user, password);
//            pstmt = conn.prepareStatement();
            st1 = conn.createStatement();

           // st3 = conn.createStatement();
            rs1 = st1.executeQuery(sql);
            while(rs1.next()){
                new SQLList(rs1.getInt("관리번호"), rs1.getDouble("x"), rs1.getDouble("y"));


                }



        } catch (PSQLException e) {
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
}