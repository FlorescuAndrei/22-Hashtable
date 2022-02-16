package com.andrei.chaining;

import com.andrei.Customer;
import com.andrei.linearprobing.LinearProbingHashtable;

public class MainChained {
    public static void main(String[] args) {
        Customer jj = new Customer("Jane", "Jones");
        Customer jd = new Customer("John", "Doe");
        Customer ms = new Customer("Mary", "Smith");
        Customer mw = new Customer("Mike", "Wilson");


        ChainedHashtable ht = new ChainedHashtable();

        ht.put("Jones", jj);
        ht.put("Doe", jd);
        ht.put("Wilson", mw);
        ht.put("Smith", ms);

        ht.printHashtable();

        System.out.println("Retrieve key Wilson " + ht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));

        ht.remove("Wilson");
        ht.remove("Jones");

        ht.printHashtable();

        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
    }
}
