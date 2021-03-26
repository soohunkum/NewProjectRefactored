package com;

import com.example.SQLList;

import java.util.ArrayList;

public class getObject {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
    ArrayList<SQLList> make = new ArrayList<>();
    SQLList sqlList = new SQLList();
    make.add(sqlList);
            System.out.println(make.get(i).getNum());

        }
    }
}
