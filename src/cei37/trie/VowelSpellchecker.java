package cei37.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 966. Vowel Spellchecker

Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.

For a given query word, the spell checker handles two categories of spelling mistakes:

Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is 
returned with the same case as the case in the wordlist.
Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel 
individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with 
the same case as the match in the wordlist.
Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
In addition, the spell checker operates under the following precedence rules:

When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
When the query matches a word up to capitlization, you should return the first such match in the wordlist.
When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
If the query has no matches in the wordlist, you should return the empty string.
Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].

 

Example 1:

Input: wordlist = ["KiTe","kite","hare","Hare"], 
queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 */
public class VowelSpellchecker {

	public static void main(String[] args) {
		String[] wordlist = new String[] {
			"KiTe","kite","hare","Hare"
		};
		String[] queries = new String[] {
			"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"
		};
		
		VowelSpellchecker vs = new VowelSpellchecker();
		for(String str : vs.spellchecker(wordlist, queries)) {
			System.out.println(str);
		}
	}

    public String[] spellchecker(String[] wordlist, String[] queries) {
	/*
	   1. When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
	   2. When the query matches a word up to capitlization, you should return the first such match in the wordlist.
	   3. When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
	   4. If the query has no matches in the wordlist, you should return the empty string.
	 */
    	if (wordlist == null || wordlist.length == 0) return null;
    	
    	Set<String> original = new HashSet<>();
    	Map<String, String> capitlization = new HashMap<>();
    	Map<String, String> vowel = new HashMap<>();
    	
    	String lower = "";
    	for (String s: wordlist) {
    		original.add(s);
    		lower = s.toLowerCase();
    		capitlization.putIfAbsent(lower, s);
    		vowel.putIfAbsent(lower.replaceAll("[aeiou]", "*") , s);
    	}
    	
    	String[] res = new String[queries.length];
    	int i = 0;
    	for (String q : queries) {
    		if (original.contains(q)) {
    			res[i++] = q;
    			continue;
    		}
    		
    		lower = q.toLowerCase();
    		if (capitlization.containsKey(lower)) {
    			res[i++] = capitlization.get(lower);
    			continue;
    		}
    		
    		lower = lower.replaceAll("[aeiou]", "*");
    		if (vowel.containsKey(lower)) {
    			res[i++] = vowel.get(lower);
    			continue;
    		}
    		res[i++] = "";
    	}
    	
    	return res;
    }
}