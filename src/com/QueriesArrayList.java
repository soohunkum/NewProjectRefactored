package com;

import java.util.ArrayList;
import java.util.Iterator;

public class QueriesArrayList {
    private ArrayList<Queries> querieslist;

    public QueriesArrayList() {

        querieslist = new ArrayList<Queries>();
    }

    public void addQueries(Queries queries) {
        querieslist.add(queries);

    }

        public String returnQueries(Queries queries) {
        Iterator<Queries> itr = querieslist.iterator();
        StringBuffer buf = new StringBuffer();
            String a = null;
            while(itr.hasNext()){
                queries = itr.next();
                buf.append(queries.getCode());
                a=buf.toString();
            }
            return a;

        }
    }





