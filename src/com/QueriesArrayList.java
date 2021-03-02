package com;

import java.util.ArrayList;
import java.util.Iterator;

public class QueriesArrayList {

    //필드
    private ArrayList<Queries> querieslist;

    //생성자
    public QueriesArrayList() {

        querieslist = new ArrayList<Queries>();
    }

    //매소드
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





