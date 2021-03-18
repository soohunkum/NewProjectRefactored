package com.example;

import com.JdbcUtil;
import com.Test;

import java.util.ArrayList;

public class SQLList {


    private int AdminAddress;
    private double x;
    private double y;
    private int bCode;
    private int hCode;

    Test test = new Test();

    public SQLList(int AdminAddress, double x, double y){
        this.AdminAddress = AdminAddress;
        this.x = x;
        this.y = y;
        System.out.println("관리번호 :" + AdminAddress);
        System.out.println("x :" + x);
        System.out.println("y :" + y);

    }

    public SQLList(){};

    public String getXY(double x, double y){

        return "x="+x+"&y="+y+"&input_coord=WGS84";
    }

    public String getXY2(){

        return "x="+this.x+"&y="+this.y+"&input_coord=WGS84";
    }






        public int getAdminAddress () {
            return AdminAddress;
        }

        public void setAdminAddress ( int AdminAddress){
            this.AdminAddress = AdminAddress;
        }

        public double getX () {
            return x;
        }

        public void setX ( double x){
            this.x = x;
        }

        public double getY () {
            return y;
        }

        public void setY ( double y){
            this.y = y;
        }
    }
