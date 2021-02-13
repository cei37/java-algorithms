package cei37.sliding;

import java.util.Arrays;

/*
 * 76. Minimum Window Substring

########## need to work on this ############


Given two strings s and t, return the minimum window in s which will contain all the characters in t. 
If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum 
window in s.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"
 
Constraints:

1 <= s.length, t.length <= 105
s and t consist of English letters.

Follow up: Could you find an algorithm that runs in O(n) time?
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println(m.minWindow(s, t));
	}

    public String minWindow(String s, String t) {
    	if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
    	
    	int a = 0, b = s.length();
    	int[] tmap = new int[128];
    	int[] smap = new int[128];
    	for (char c : t.toCharArray()) {
    		tmap[c - 'A']++;
    	}

    	int left = -1;
    	int counter = 0;
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		//add to hash map
			smap[c - 'A']++;
			if (left == -1) {
				left = i;
			}
    		
    		//compare
    		if (Arrays.equals(tmap, smap)) {
    			if (b-a < i - left) {
    				a = left;
    				b = i;
    				left = -1;
    			}
    		}
    		
    		//need to reduce
    		if (counter >= t.length() && left == -1 ) {
    			char cc = s.charAt(i - counter);
    			smap[cc - 'A']--;
    		}

    		counter++;
    	}
    	return s.substring(a, b);
    }
}