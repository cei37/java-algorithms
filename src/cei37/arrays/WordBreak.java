package cei37.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
public class WordBreak {

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		
		List<Test> list = new ArrayList<Test>() { {
			add(new Test("aaaaaaa", new ArrayList<String>() {{
				add("aaaa");
				add("aaa");
			}}, true));
			
			add(new Test("cbca", new ArrayList<String>() {{
				add("bc");
				add("ca");
			}}, false));
			
			add(new Test("a", new ArrayList<String>() {{
				add("a");
			}}, true));
			
			add(new Test("leetcode", new ArrayList<String>() {{
				add("leet");
				add("code");
			}}, true));
			
			add(new Test("applepenapple", new ArrayList<String>() {{
				add("apple");
				add("pen");
			}}, true));
			
			add(new Test("catsandog", new ArrayList<String>() {{
				add("cats");
				add("dog");
				add("sand");
				add("and");
				add("cat");
			}}, false));
			
		}};

		for (Test t : list) {
			System.out.println(wb.wordBreak(t.s, t.wordDict) + " expected -- > " + t.expected);
		}
	}
	
	//Approach 2: DFS or recursion with memoization
	public boolean wordBreak(String s, List<String> wordDict) {
    	if (s == null || s.length() == 0 || wordDict.size() == 0) return false;
    	Set<String> set = new HashSet<>(wordDict);
    	return dfs(s, set, 0, new Boolean[s.length() + 1]);
    }
    
    public boolean dfs(String word, Set<String> set, int start, Boolean[] memo) {
    	if (word.length() == start) return true;

    	if (memo[start] != null) {
    		return memo[start];
    	}
    	
    	int len = word.length();
    	for (int i = 1 + start; i < len + 1; i++) {
    		String sub = word.substring(start, i);
    		if (set.contains(sub) && dfs(word, set, i, memo)) {
    			return memo[start] = true;
    		}
    	}
    	return memo[start] = false;
    }
    

	//Approach 1: Brute Force
	/*
    public boolean wordBreak(String s, List<String> wordDict) {
    	if (s == null || s.length() == 0 || wordDict.size() == 0) return false;
    	Set<String> set = new HashSet<>(wordDict);
    	return dfs(s, set, 0);
    }
    
    public boolean dfs(String word, Set<String> set, int start) {
    	if (word.length() == start) return true;

    	int len = word.length();
    	for (int i = 1 + start; i < len + 1; i++) {
    		String sub = word.substring(start, i);
    		if (set.contains(sub) && dfs(word, set, i)) {
    			return true;
    		}
    	}
    	return false;
    }*/
    
    static class Test {
    	String s;
    	List<String> wordDict;
    	boolean expected;
    	public Test(String s, List<String> wordDict, boolean expected) {
    		this.s = s;
    		this.wordDict = wordDict;
    		this.expected = expected;
    	}
    }
}