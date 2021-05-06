package com;

import org.postgresql.util.PSQLException;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.ArrayList;

public class JdbcUtilChild extends JdbcUtil {

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

    public void makeSql() throws MalformedURLException, UnsupportedEncodingException, SQLException {
        TestChild testChild = new TestChild();
        JdbcUtilChild jdbcUtilChild = new JdbcUtilChild();
        testChild.runbCodehCode();
        jdbcUtilChild.returnNum();
        sqlArray = new ArrayList<String>();
        String sql = null;
        for (int i = 0; i < jdbcUtilChild.returnNum().size(); i++) {
            String bCodesql = testChild.getbCodeArrayList().get(i);
            String hCodesql = testChild.gethCodeArrayList().get(i);
            Integer numsql = jdbcUtilChild.getArrayNum().get(i);
            System.out.println(numsql);
            if (bCodesql == null || hCodesql == null) {
                sql = null;
            } else {
                sql = "UPDATE wtt_wutl_ht SET bjd_cde = (" + bCodesql + "), hjd_cde = (" + hCodesql + ") WHERE ftr_idn = (" + numsql + ");";
            }
            System.out.println(sql);
            sqlArray.add(sql);
        }
    }
}


