package com.andrei.jdkhashmap;

import com.andrei.Customer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainJdkHashMap {
    public static void main(String[] args) {
        Customer jj = new Customer("Jane", "Jones");
        Customer jd = new Customer("John", "Doe");
        Customer ms = new Customer("Mary", "Smith");
        Customer mw = new Customer("Mike", "Wilson");

        Map<String, Customer> hashMap = new HashMap<String, Customer>();

        hashMap.put("Jones", jj);
        hashMap.put("Doe", jd);
        hashMap.put("Smith", ms);

        //print method 1
        Iterator<Customer> iterator = hashMap.values().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("==============");

        //print method 2, java 8
        hashMap.forEach((k, v) ->System.out.println("key = " + k + ", value = " + v));


        System.out.println(hashMap.containsKey("Doe"));

        System.out.println(hashMap.containsValue(jj));

        //replace
        hashMap.put("Doe", mw);
        hashMap.forEach((k, v) ->System.out.println("key = " + k + ", value = " + v));

        hashMap.putIfAbsent("Smith", mw);

        System.out.println(hashMap.get("Smith"));

        System.out.println(hashMap.getOrDefault("someone", jj));


    }
}
