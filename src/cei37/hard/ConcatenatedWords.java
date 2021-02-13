package cei37.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 472. Concatenated Words

Given a list of words (without duplicates), please write a program that returns all concatenated 
words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter
 words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.

 */
public class ConcatenatedWords {

	public static void main(String[] args) {
		ConcatenatedWords c = new ConcatenatedWords();
		String[] words = new String[] {
			"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"
		};

		for (String s : c.findAllConcatenatedWordsInADict(words)) {
			System.out.println(s);
		}
	}

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
    	Set<String> set = new HashSet<>();
    	List<String> res = new ArrayList<>();
    	for (String w : words) {
    		set.add(w);
    	}
    	
    	for (String w : words) {
    		if (dfs2(set, w)) {
    			res.add(w);
    		}
    	}
    	
    	return res;
    }
	
    private boolean dfs2(Set<String> words, String word) {
    	if (word == null || word.length() <= 0) return false;
    	
    	int len = word.length();

    	for (int i = 1; i<len; i++) {
    		String sub = word.substring(i);
    		if (words.contains(word.substring(0, i)) && (words.contains(sub) || dfs2(words, sub))) {
    			return true;
    		}
    	}
    	return false;
    }
	
    public List<String> findAllConcatenatedWordsInADict_1(String[] words) {
    	Set<String> set = new HashSet<>();
    	List<String> res = new ArrayList<>();
    	for (String w : words) {
    		set.add(w);
    	}
    	
    	for (String w : words) {
    		if (dfs(set, w, 0)) {
    			res.add(w);
    		}
    	}
    	
    	return res;
    }
    
    private boolean dfs(Set<String> words, String word, int start) {
    	if (start != 0 && words.contains(word.substring(start))) {
    		return true;
    	}

    	for (int i= start + 1; i<word.length(); i++) {
    		String sub = word.substring(start, i);
    		if (words.contains(sub)) {
    			words.add(word.substring(0, i));
    			if (dfs(words, word, i)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
}