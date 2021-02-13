package cei37.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
1048. Longest String Chain
Medium

1420

95

Add to List

Share
Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chain is "a","ba","bda","bdca".
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of English lowercase letters.
 */
public class LongestStringChain {

	public static void main(String[] args) {
		//LongestStringChain.MySolution my = new LongestStringChain().new MySolution();
		LongestStringChain.SomeOneelseSolution my = new LongestStringChain().new SomeOneelseSolution();

		String[] words1 = { "a","b","ba","bca","bda","bdca" };
		String[] words2 = { "xbc","pcxbcf","xb","cxbc","pcxbc" };
		String[] words3 = { "bdca","bda","ca","dca","a" };
		String[] words4 = { "xbc","pcxbcf","xb","cxbc","pcxbc" };

		System.out.println(my.longestStrChain(words1));
		System.out.println(my.longestStrChain(words2));
		System.out.println(my.longestStrChain(words3));
		System.out.println(my.longestStrChain(words4));
	}

	class MySolution {
	    public int longestStrChain(String[] words) {
	    	if (words == null || words.length == 0) return 0;
	    	//Arrays.sort(words, (a, b) -> a.length() - b.length());
	    	int max = 0;
	    	for (int i=0; i<words.length; i++) {
	    		for (int j=0; j<words.length; j++) {
	    			if (isPredecesor(words[j], words[i])) {
		    			max = Math.max(max, Math.max(words[i].length(),words[j].length()));
	    				//max = Math.max(max, words[j].length());
	    				//max = Math.max(max, words[i].length());
		    		}
	    		}
	    	}

	    	return max;
	    }
	    
	    
	    private boolean isPredecesor(String s1, String s2) {
	    	if(s2.length() - s1.length() != 1) return false;
	    	int match = 0;
	    	for (int i=0, j=0; i<s1.length() &&  j<s2.length(); j++) {
	    		if (s1.charAt(i) == s2.charAt(j)) {
	    			match++;
	    			i++;
	    		}
	    	}
	    	
	    	return match == s1.length();
	    }
	}
	
	class SomeOneelseSolution {
		//recursion 
		//need to study more this approach
		int maxLength = 0;
		public int longestStrChain(String[] words) {
		    Set<String> set = new HashSet<>();
		    for(String s : words){
		        set.add(s);
		    }
		    for(int i = words.length - 1; i >= 0; i--){
		        String word = words[i];
		        recursiveSearch(set, word, 0);
		    }
		    return maxLength;
		}

		private void recursiveSearch(Set<String> set, String word, int count){
		    if(!set.contains(word)){
		        return;
		    }
		    maxLength = Math.max(maxLength, count + 1);
		    for(int j = 0; j < word.length(); j++){
		        String subString = word.substring(0, j) + word.substring(j + 1);
		        recursiveSearch(set, subString, count + 1);
		    }
		}
	}
}