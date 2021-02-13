package cei37.hash;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {

	public static void main(String[] args) {
		VerifyingAnAlienDictionary v = new VerifyingAnAlienDictionary();
		String[] words = new String[] {
				"apple","app"
		};
		String order = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(v.isAlienSorted(words, order));

	}

    public boolean isAlienSorted(String[] words, String order) {
    	if (words == null || words.length == 0) return true;
    	int[] arr = new int[26];
    	for (int i=0; i<order.length(); i++) {
    		arr[order.charAt(i) - 'a'] = i;
    	}

    	for (int i=1; i<words.length; i++) {
    		boolean flag = true;
    		for (int col = 0; col < Math.min(words[i-1].length(), words[i].length()); col++) {
    			if (words[i-1].charAt(col) != words[i].charAt(col)) {
    				if (arr[words[i-1].charAt(col) - 'a'] > arr[words[i].charAt(col) - 'a']) {
    					return false;
    				} else {
    					flag = false;
    					break;
    				}
    			}
    		}
            if (words[i-1].length() > words[i].length() && flag) {
				return false;
			}
    	}
    	return true;
    }

    public boolean isAlienSorted_1(String[] words, String order) {
    	if (words == null || words.length == 0) return true;
    	Map<Character, Integer> map = new HashMap<>();
    	for (int i=0; i<order.length(); i++) {
    		map.put(order.charAt(i), i);
    	}

    	for (int i=1; i<words.length; i++) {
    		boolean flag = true;
    		for (int col = 0; col < Math.min(words[i-1].length(), words[i].length()); col++) {
    			if (words[i-1].charAt(col) != words[i].charAt(col)) {
    				if (map.get(words[i-1].charAt(col)) > map.get(words[i].charAt(col))) {
    					return false;
    				} else {
    					flag = false;
    					break;
    				}
    			}
    		}
            if (words[i-1].length() > words[i].length() && flag) {
				return false;
			}
    	}
    	return true;
    }
}
