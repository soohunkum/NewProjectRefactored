package com.example;

import com.JdbcUtil;

import java.util.ArrayList;
import java.util.HashSet;

public class SQLList {


    private int AdminAddress;
    private double x;
    private double y;

    public SQLList(int AdminAddress, double x, double y){
        this.AdminAddress = AdminAddress;
        this.x = x;
        this.y = y;
        System.out.println("관리번호 :" + AdminAddress);
        System.out.println("x :" + x);
        System.out.println("y :" + y);

    }

    public SQLList(){};

    public ArrayList<String> returnXY(double x, double y){
        ArrayList<String>queryarray = new ArrayList<String>();

        queryarray.add("x="+this.getX()+"&y="+this.getY()+"&input_coord=WGS84");

        return queryarray;
    }

    public int getAdminAddress() {
        return AdminAddress;
    }

    public void setAdminAddress(int AdminAddress) {
        this.AdminAddress = AdminAddress;
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







}
