package com;

import java.util.ArrayList;

public class QueriesArrayList {
    private ArrayList<Queries> querieslist;

    public QueriesArrayList() {

        querieslist = new ArrayList<Queries>();
    }

    public void addQueries(Queries queries) {
        querieslist.add(queries);

    }

        public String returnQueries(QueriesArrayList queriesarraylist) {
            String a = null;
            for (int i = 0; i <= querieslist.size()-1; i++) {
                a = querieslist.get(i).toString();
            }
            return a;
        }
    }





