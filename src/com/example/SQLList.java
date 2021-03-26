package com.example;

import com.JdbcUtil;
import com.Test;

import java.util.ArrayList;

public class SQLList {

    private int num;
    private double x;
    private double y;
    private String bCode;
    private String hCode;


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


}
