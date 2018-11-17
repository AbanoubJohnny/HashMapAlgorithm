
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmap;

import java.util.Arrays;


/**
 *
 * @author Abanoub Johnny
 */
public class HashMap<k extends String , v> {
    
    private HashMapItem<k , v>[] data;
    private final int size;

    public HashMap(int size) {
        this.size = size;
        this.data = new HashMapItem[size];
    }    
    
    //inserton method
    public boolean put(k key,v value){
    
        HashMapItem<k , v> item = new HashMapItem(key,value);
        int keyHash = calculateKeyHash(key);
        if(data[keyHash]==null){
            data[keyHash] = item;
        }
        else{
            int anotherKeyHash = searchForAnotherPosition(keyHash);
            if (anotherKeyHash==-1) 
                return false;
            data[anotherKeyHash] = item;
        }
        return true;
    }
    
    public int searchForAnotherPosition(int keyHashCalulated){
        int result = -1;
        for(int i=0 ; i<size ; i++){
            try{int keyHash = (keyHashCalulated+i)%(size);
            if(data[keyHash]==null){
                result = keyHash;
                break;
            }
            }
            catch(Exception e){
                System.out.println("error"+keyHashCalulated+i%(size-1));
            }
        }
        return result;
    }
    
    //inserton method
    
    
    
    
    //getValue method
    public v getValue(k key){
        int keyHash = calculateKeyHash(key);
        HashMapItem<k , v> resultItem = data[keyHash];
        if(resultItem==null||!resultItem.key.equals(key)){
             int anotherKeyHash = searchForItemInAnotherPosition(keyHash,key);
            if (anotherKeyHash==-1) return null;
            resultItem = data[anotherKeyHash];
        }
        return resultItem.value;
    }
    
  
    //getValue method 
   
    
    public void printMap(){
        System.out.println("----------------------------");
        for(int i=0 ; i<size ; i++){
            HashMapItem item = data[i];
            if(item!=null) System.out.println(item.toString());
        }
        System.out.println("----------------------------");
    }
    
    
    //removeItem method 
    
    public boolean remove(k key){
          int anotherKeyHash,keyHash = calculateKeyHash(key);
        HashMapItem<k , v> resultItem = data[keyHash];
        boolean isNotInPlace = resultItem==null||!resultItem.key.equals(key);
        if(isNotInPlace){
            keyHash = searchForItemInAnotherPosition(keyHash,key);
            if (keyHash==-1) return false;
        }
        data[keyHash] = null;
        if(isNotInPlace){
            rehashData();
        }
        return true;
    }
    
    public int calculateKeyHash(k key) {
        int i, l = key.length();
        long hash = 0;
        for (i = 0; i < l; i++) {
            hash += Character.getNumericValue(key.charAt(i));
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
       
        return (int)(Math.abs(hash) % size);
    }
    
     public int searchForItemInAnotherPosition(int keyHashCalulated, String itemKey){
         int result = -1;
        for(int i=1 ; i<size ; i++){
            int keyHash = (keyHashCalulated+i)%(size);
            if(data[keyHash]!=null&&data[keyHash].key.equals(itemKey)){
                result = keyHash;
                break;
            }
        }
        return result;
    }

    private void rehashData() {
        HashMapItem<k , v>[] rehashData = Arrays.copyOf(data,size);
        this.data = new HashMapItem[size];
        for(HashMapItem<k , v> item:rehashData){
            if(item!=null)
            put(item.key,item.value);
        }
    }
}
