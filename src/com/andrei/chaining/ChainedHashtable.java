package com.andrei.chaining;

import com.andrei.Customer;
import com.andrei.StoredCustomer;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {

    private LinkedList<StoredCustomer>[] hashtable;

    public ChainedHashtable(){
        hashtable = new LinkedList[10];
        for(int i = 0; i< hashtable.length; i++){
            hashtable[i] = new LinkedList<>();
        }
    }

    public void put(String key, Customer customer){
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredCustomer(key, customer));
    }

    public Customer get(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredCustomer> iterator = hashtable[hashedKey].listIterator();
        StoredCustomer customer = null;
        while(iterator.hasNext()) {
            customer = iterator.next();
            if (customer.key.equals(key)) {
                return customer.customer;
            }
        }
      return null;
    }

    public Customer remove(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredCustomer> iterator = hashtable[hashedKey].listIterator();
        StoredCustomer customer = null;

        while(iterator.hasNext()) {
            customer = iterator.next();

            if (customer.key.equals(key)) {
              break;
            }
        }

        if(customer == null && !customer.key.equals(key)){
            return null;
        }else {
            hashtable[hashedKey].remove(customer);
            return customer.customer;
        }
    }

    private int hashKey(String key){

        return key.length() % hashtable.length;
    }

    public void printHashtable(){
        for(int i = 0; i < hashtable.length; i++){
            if(hashtable[i].isEmpty()){
                System.out.println(i + " is empty");
            }else{
                System.out.println(i);
                ListIterator<StoredCustomer> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()){
                    System.out.println("\t" + iterator.next().customer);
                }
            }

        }
    }
}
