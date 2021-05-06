package com;
import org.postgresql.util.PSQLException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JdbcUtil {

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


            st2 = conn.createStatement();
            rs2 = st2.executeQuery(sql);


            if (rs2.next()) rscount = rs2.getInt(1);

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();

        } finally {
            try {
                conn.close();
                st2.close();


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


        SQLList sqlList = new SQLList();
        ArrayList<String> array = null;
        ArrayList<Double> arrayX = null;
        ArrayList<Double> arrayY = null;
        try {

            conn = DriverManager.getConnection(url, user, password);

            st1 = conn.createStatement();

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
                st1.close();
                conn.close();


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