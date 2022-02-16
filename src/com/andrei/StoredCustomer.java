package com.andrei;

import com.andrei.Customer;

//for linear probing and chaining
//we have to store the key and the value in the array for get() method;
//the key is unique but when we hashed it can obtain same number.
public class StoredCustomer {

    public String key;
    public Customer customer;


    public StoredCustomer(String key, Customer customer) {
        this.key = key;
        this.customer = customer;
    }
}
