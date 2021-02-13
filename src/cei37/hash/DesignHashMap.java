package cei37.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
706. Design HashMap
Easy

1265

141

Add to List

Share
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.

 */
public class DesignHashMap {

	public static void main(String[] args) {
		DesignHashMap.MyHashMap hashMap = new DesignHashMap().new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);
		hashMap.put(3, 3);
		hashMap.put(4, 4);
		System.out.println(hashMap.get(1));
		System.out.println(hashMap.get(3));
		hashMap.put(2, 5);
		System.out.println(hashMap.get(2)); 
		hashMap.remove(2);
		System.out.println(hashMap.get(2));
		hashMap.remove(4);
		System.out.println(hashMap.get(4));
	}

	class MyHashMap {

	    /** Initialize your data structure here. */
		int key_generator = 3001;
		List<Bucket<Integer, Integer>> map = new ArrayList<>();
	    public MyHashMap() {
	        for (int i=0; i<key_generator; i++) {
	        	map.add(new Bucket<Integer, Integer>());
	        }
	    }
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	    	map.get(key % key_generator).add(key, value);
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        Pair<Integer,Integer> p = map.get(key % key_generator).get(key);
	        if (p == null) {
	        	return -1;
	        }
	    	return p.value;
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	    	map.get(key % key_generator).remove(key);
	    }
	}
	
	class Bucket<A,B> {
		LinkedList<Pair<A, B>> list = new LinkedList<>();
		public void add(A key, B value) {
			for (Pair<A, B> p : list) {
				if (p.key.equals(key)) {
					p.value = value;
					return;
				}
			}
			list.add(new Pair<A, B>(key, value));
		}
		
		public Pair<A,B> get(A key) {
			for (Pair<A, B> p : list) {
				if (p.key.equals(key)) {
					return p;
				}
			}
			return null;
		}

		public void remove(A key) {
			for (Pair<A, B> p : list) {
				if (p.key.equals(key)) {
					list.remove(p);
					return;
				}
			}
		}
	}
	
	class Pair<A,B> {
		A key;
		B value;
		
		Pair(A key, B value) {
			this.key = key;
			this.value = value;
		}
	}
}