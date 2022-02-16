package com.andrei.linearprobing;

import com.andrei.Customer;
import com.andrei.StoredCustomer;

//handle collision using linear probing approach
public class LinearProbingHashtable {

    private StoredCustomer[] hashtable;

    public LinearProbingHashtable(){

        hashtable = new StoredCustomer[10];
    }

    public void put(String key, Customer customer){
        int hashedKey = hashKey(key);

        if(occupied(hashedKey)){

            //we loop around to find an empty position and we need a stop point
            int stopindex = hashedKey;

            //wrapping
            if(hashedKey == hashtable.length -1){
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            //till here we have set the very first probe position
            //now at each loop iteration we set the next probe position and take care of the wrapping
            while (occupied(hashedKey) && hashedKey != stopindex){

                //increment and wrap hashed key at the beginning of the array if the end is reached:  9%10 = 9; 10%10
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }
        //if there are no free position
        if(occupied(hashedKey)){
            System.out.println("Sorry, there is already an employee at position " + hashedKey);
        }else{
            hashtable[hashedKey] = new StoredCustomer(key, customer);
        }

    }

    public Customer get(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }
        return hashtable[hashedKey].customer;

    }

    public Customer remove(String key){
        int hashedKey = findKey(key);
        if (hashedKey == -1){
            return null;
        }

        Customer customer = hashtable[hashedKey].customer;

        hashtable[hashedKey] = null;

        //rehashing the table. If empty spots remain the get method will not work.
        StoredCustomer[] oldHashtable = hashtable;
        hashtable = new StoredCustomer[oldHashtable.length];

        for(int i = 0; i< oldHashtable.length; i++){
            if(oldHashtable[i] != null){
                put(oldHashtable[i].key, oldHashtable[i].customer);
            }
        }
        return customer;
    }

    //hashing function
    private int hashKey(String key){
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index){
        return hashtable[index] != null;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key == key) {
            return hashedKey;
        } else {

            int stopindex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (hashedKey != stopindex && hashtable[hashedKey] != null && (!hashtable[hashedKey].key.equals(key))) {

                hashedKey = (hashedKey + 1) % hashtable.length;
            }

            if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
                return hashedKey;
            }else {

                return -1;
            }
        }


    }


    public void printHashtable(){
        for(int i = 0; i < hashtable.length; i++){

            if(hashtable[i] == null){
                System.out.println("empty");
            }else {
                System.out.println("Position " + i + ": " + hashtable[i].customer);
            }

        }
    }


}
