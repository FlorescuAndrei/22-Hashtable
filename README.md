# 22-Hashtable
Basic Hashtable, Linear probing strategy, Chaining strategy, JDK Hashtable 

Hashtable
-  Abstract data type  
-  Provide access to data using keys  
-  Keys/Value pairs  
-  Optimize for retrieval (when you know the key)  

For Arrays, index = key , data = value but for Hash tables key doesn’t have to be an integer.   

Hashing  
-  Maps keys of any data type to an integer  
-  Hash function maps key to int  
-  In Java, hash function is Object.hashCode()  
-  Collision occurs when more than one value has the same hashed value     

Hashing function always will be % array.length because must generate an index for the array.  

Load Factor  
-  Tells us how full a hash table is;  
-  items/capacity = size/capacity   
-  Is used to decide when to resize the array backing the hash table  
-  Too low => lots of empty space;   
-  Too high => increase likelihood of collisions  
-  Can play role in time complexity for retrieval O()  

Add to a Hash Table backed by an array  
1.  Provide a key/value pair  
2.  Use a hash function to hash the key to an int value
3.  Store the key/value pair at the hashed key value - this is the index into the array  

If more key will hash to the same integer we have collision.      

Collisions  
There are two common strategy to handle collision, on booth we save the key-value pair not only the value   
1.  Open addressing: if the position is occupied we look for another position in the array.  
One approach to that is **linear probing**:   
-  We increment by 1 the index(one probe) and repeat if still if the position is occupied(more probes).   
- The operations become O(n) because we may have to search entire array for an empty spot.   
- The big problems appear when removing items. We do not want empty spaces because the get method will not work.  
    -  Two solutions:  
    -  We must rehash the keys and shifting items in array O(n);
    -  Leave the array position occupied. Add a deletion field in item object, set it to true when deleted.  
    We occupied more memory and we have a polluted table . Better to rehash the table, keep it clean but depends.   
    
2.  **Chaining:** 
-  Each array position contans a linked list. 
-  With a good hash function and a good load factor this linked list will be short. 
-  Complexity will be between O(1) and O(n) depending on hash function and load factor. 
If k is the maximum length of LinkedList we will have O(1 + k). k is < n (n = number of all elements).  


**Java HashTables**  

Map interface  
–  primary interface for hashtables.  


HashMap class  
-  Implementation of Map interface.
-  Is a hashtable backed by an array of buckets.  
-  Has a Chaining strategy approach .   
A Bucket can be in general an array list or linked list.  
In every bucket we store key/value pairs **not only values** (many key can be hashed to the same array index so at this index we have a bucket with all this different keys and their values).  
To retrieve a value we give the key, will be hashed to index, again we search for the key at this index and we have the value.   
Hash maps store both key and value in the bucket location as a Map.Entry object. Key/value pair = Map.Entry 

LinkedHashMap 
–  Hash table and linked list implementation of Map interface with predictable iteration order.  
-  Is still backed up by an array but they also put all of the entries into a linked list. 

HashTable  
-  Is imilar to HashMap but is tread safe.  
-  Doesn’t allow null key or null values.   


[BACK TO START PAGE](https://github.com/FlorescuAndrei/Start.git)



  
