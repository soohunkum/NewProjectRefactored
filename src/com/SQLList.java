package com;

import com.JdbcUtil;
import com.JdbcUtilChild;
import com.Test;
import com.TestChild;

import java.util.ArrayList;

public class SQLList {

     int num;
     double x;
     double y;
     String bCode;
     String hCode;
     String addressName;


//    Test test = new Test();
//
//    public SQLList(int num, double x, double y) {
//        this.num = num;
//        this.x = x;
//        this.y = y;
//        System.out.println("관리번호 :" + num);
//        System.out.println("x :" + x);
//        System.out.println("y :" + y);
//
//    }



    public SQLList() {
    }

    public SQLList(int num, double x, double y, String bCode, String hCode, String addressName){
        this.num = num;
        this.x = x;
        this.y = y;
        this.bCode = bCode;
        this.hCode = hCode;
        this.addressName = addressName;
        System.out.println("num" + num + "x" + x + "y" + y + "bCode" + bCode + "hCode" + hCode + "addressName" + addressName);
    }

    public String passByValue() {

        return this.num + this.x + this.y + this.bCode + this.hCode + this.addressName;
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
