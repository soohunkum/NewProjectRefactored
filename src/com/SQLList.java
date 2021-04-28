package com;

import com.JdbcUtil;
import com.JdbcUtilChild;
import com.Test;
import com.TestChild;
import org.boon.primitive.Int;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLList {

    int num;
    double x;
    double y;
    String bCode;
    String hCode;
    String addressName;

    ArrayList<Integer> numA;
    ArrayList<Double> xA;
    ArrayList<Double> yA;
    ArrayList<String> bCodeA;
    ArrayList<String> hCodeA;
    ArrayList<String> addressNameA;

    public ArrayList<Integer> getNumA() {
        return numA;
    }

    public void setNumA(ArrayList<Integer> numA) {
        this.numA = numA;
    }

    public ArrayList<Double> getxA() {
        return xA;
    }

    public void setxA(ArrayList<Double> xA) {
        this.xA = xA;
    }

    public ArrayList<Double> getyA() {
        return yA;
    }

    public void setyA(ArrayList<Double> yA) {
        this.yA = yA;
    }

    public ArrayList<String> getbCodeA() {
        return bCodeA;
    }

    public void setbCodeA(ArrayList<String> bCodeA) {
        this.bCodeA = bCodeA;
    }

    public ArrayList<String> gethCodeA() {
        return hCodeA;
    }

    public void sethCodeA(ArrayList<String> hCodeA) {
        this.hCodeA = hCodeA;
    }

    public ArrayList<String> getAddressNameA() {
        return addressNameA;
    }

    public void setAddressNameA(ArrayList<String> addressNameA) {
        this.addressNameA = addressNameA;
    }




    public SQLList() {
    }

//    public SQLList(ArrayList<Integer> num, ArrayList<Double> x, ArrayList<Double> y, ArrayList<String> bCode, ArrayList<String> hCode, ArrayList<String> addressName) throws IOException, SQLException {
//        JdbcUtil jdbcUtil = new JdbcUtil();
//        TestChild testChild = new TestChild();
//        for (int i = 0; i < jdbcUtil.getCount(); i++) {
//            this.num = num.get(i);
//            this.x = x.get(i);
//            this.y = y.get(i);
//            this.bCode = bCode.get(i);
//            this.hCode = hCode.get(i);
//            this.addressName = addressName.get(i);
//            System.out.println(this.num + "          " + this.x + "            " + this.y + "           " + this.bCode + "            " + this.hCode + "            " + this.addressName);
//        }
//    }

    public SQLList(ArrayList<Integer> num, ArrayList<Double> x, ArrayList<Double> y, ArrayList<String> bCode, ArrayList<String> hCode, ArrayList<String> addressName) throws IOException, SQLException {
        this.numA = num;
        this.xA = x;
        this.yA = y;
        this.bCodeA = bCode;
        this.hCodeA = hCode;
        this.addressNameA = addressName;
//
//        JdbcUtil jdbcUtil = new JdbcUtil();
//        TestChild testChild = new TestChild();
//        for (int i = 0; i < jdbcUtil.getCount(); i++) {
//            this.numA = num;
//            this.xA = x;
//            this.yA = y;
//            this.bCodeA = bCode;
//            this.hCodeA = hCode;
//            this.addressNameA = addressName;
//
//        }
    }


    public String getXY(double x, double y) {

        return "x=" + x + "&y=" + y + "&input_coord=WGS84";
    }

    public String getXY2() {

        return "x=" + this.x + "&y=" + this.y + "&input_coord=WGS84";
    }


    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String gethCode() {
        return hCode;
    }

    public void sethCode(String hCode) {
        this.hCode = hCode;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }


}
