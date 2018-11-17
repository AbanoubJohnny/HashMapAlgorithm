/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmap;

/**
 *
 * @author Abanoub Johnny
 */
public class HashMapItem <k , v>{
    
    k key;
    v value;
    
    public HashMapItem(k key,v value){
        this.key = key;
        this.value = value; 
    }

    public k getKey() {
        return key;
    }

    public v getValue() {
        return value;
    }
    
    @Override
    public String toString(){
        return key+"->"+value;
    }
    
}
