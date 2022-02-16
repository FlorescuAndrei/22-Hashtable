package com.andrei.simple;

import com.andrei.Customer;

public class SimpleHashtable {

    private Customer[] hashtable;

    public SimpleHashtable(){

        hashtable = new Customer[10];
    }

    public void put(String key, Customer customer){
        int hashedKey = hashKey(key);

        //doesn't handle collision
        if(hashtable[hashedKey] != null){
            System.out.println("Sorry, there is already an employee at position " + hashedKey);
        }else{
            hashtable[hashedKey] = customer;
        }

    }

    public Customer get(String key){
        int hashedKey = hashKey(key);

        return hashtable[hashedKey];
    }
    //hashing function
    private int hashKey(String key){
        return key.length() % hashtable.length;
    }

    public void printHashtable(){
        for(int i = 0; i < hashtable.length; i++){
            System.out.println(hashtable[i]);
        }
    }


}
