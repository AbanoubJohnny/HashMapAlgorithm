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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashMap<String, String> map = new HashMap<>(5); 
        map.put("vishal", "gehan"); 
        map.put("sachin", "Amgad"); 
        map.put("vaibhav", "Aly"); 
        map.put("vaibha", "Hussien"); 
        System.out.println(map.getValue("vaibhav"));
        System.out.println(map.getValue("vaibha"));
        map.printMap();
        map.remove("vishal");
        map.printMap();
        
        
    }
    
}