package com.andrei.simple;

import com.andrei.Customer;
import com.andrei.linearprobing.LinearProbingHashtable;


public class MainSimple {

    public static void main(String[] args) {

        Customer jj = new Customer("Jane", "Jones");
        Customer jd = new Customer("John", "Doe");
        Customer ms = new Customer("Mary", "Smith");
        Customer mw = new Customer("Mike", "Wilson");
        Customer be = new Customer("Bill", "End");

        SimpleHashtable ht = new SimpleHashtable();

        ht.put("Jones", jj);
        ht.put("Doe", jd);
        ht.put("Wilson", mw);
        ht.put("Smith", ms);

        ht.printHashtable();

        System.out.println("Retrieve key Wilson " + ht.get("Wilson"));





    }
}
