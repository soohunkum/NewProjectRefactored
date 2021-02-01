package com;

import com.example.Example;

import static com.Restapi.search;

public class insert {

    public void SetInsert() throws Exception {
        Restapi restapi = new Restapi();
        String response = restapi.search();
        restapi.prettify(response);
        try {
            response = search();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static void main (String[]args){
            try {

                Example example = new Example();
                example.getAddress();
                System.out.println(example);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Array" + e);
            } catch (NullPointerException e) {
                e.printStackTrace();
                System.err.println("Null" + e);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

