package cei37.sliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 438. Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p 
will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */
public class FindAllAnagrams {

	public static void main(String[] args) {
		FindAllAnagrams faa = new FindAllAnagrams();
		String s = "abab";
		String p = "ab";
		for (int i : faa.findAnagrams(s, p)) {
			System.out.println(i);
		}
	}

    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> res = new ArrayList<>();
    	if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;
    	
    	Map<Character, Integer> smap = new HashMap<>();
    	Map<Character, Integer> pmap = new HashMap<>();
    	for (char c: p.toCharArray()) {
    		if (pmap.containsKey(c)) {
    			pmap.put(c, pmap.get(c) + 1);
    		} else {
    			pmap.put(c, 1);
    		}
    	}
        
    	int counter = 0;
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if (smap.containsKey(c)) {
    			smap.put(c, smap.get(c) + 1);
    		} else {
    			smap.put(c, 1);
    		}
    		
    		if (counter >= p.length()) {
    			char cc = s.charAt(i - counter);
    			if (smap.get(cc) > 1) {
    				smap.put(cc, smap.get(cc) - 1);
    			} else {
    				smap.remove(cc);
    			}
    			counter--;
    		}
    		
    		if (smap.equals(pmap)) {
    			res.add(i - counter);
    		}
    		counter++;
    	}
    	
    	return res;
    }
}