package cei37.java;

import java.util.*;

public class BasicLinkedHashMap {

    public static void main(String a[]) 
    { 
        LinkedHashMap<String, String> lhm =  new LinkedHashMap<String, String>() {
        	protected boolean removeEldestEntry(Map.Entry<String, String> el) {
        		System.out.println(">>>>>");
        		return size() > 5;
        	}
        }; 
        lhm.put("a", "a");
        lhm.put("b", "b");
        lhm.put("one", "one"); 
        lhm.put("two", "two");
        lhm.put("c", "c");
        lhm.put("four", "four");
        lhm.put("d", "d");
  
        // It prints the elements in same order  
        // as they were inserted     
        System.out.println(lhm); 
  
        System.out.println("Getting value for key 'one': " + lhm.get("one")); 
        System.out.println("Size of the map: " + lhm.size()); 
        System.out.println("Is map empty? " + lhm.isEmpty()); 
        System.out.println("Contains key 'two'? "+   lhm.containsKey("two")); 
        System.out.println("Contains value 'practice.geeks" +"forgeeks.org'? "+ lhm.containsValue("practice"+  ".geeksforgeeks.org")); 
        System.out.println("delete element 'one': " +  lhm.remove("one")); 
        System.out.println(lhm); 
        
        System.out.println("------------------");
        for(Map.Entry<String, String>  e:  lhm.entrySet()) {
        	System.out.println(e.getKey());
        }
        System.out.println("------------------");
        System.out.println(lhm.get("d")); 
        System.out.println(lhm.get("a")); 
        System.out.println(lhm.get("two"));
        
        System.out.println("------------------");
        for(Map.Entry<String, String>  e:  lhm.entrySet()) {
        	System.out.println(e.getKey());
        }
    }

}
