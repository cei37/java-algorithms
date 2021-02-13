package cei37.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 127. Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest 
transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {

	public static void main(String[] args) {
		WordLadder w = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>() {{
			add("hot");
			add("dot");
			add("dog");
			add("lot");
			add("log");
			add("cog");
		}};
		System.out.println(w.ladderLength(beginWord, endWord, wordList));
	}

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	if (beginWord == null || beginWord.length() == 0 || endWord == null ||
    			endWord.length() == 0 || wordList == null || wordList.size() == 0) {
    		return 0;
    	}
    	Map<String, List<String>> graph = new HashMap<>();
    	for (String word : wordList) {
    		for (String trans : transformWord(word)) {
    			if (!graph.containsKey(trans)) {
    				graph.put(trans, new ArrayList<String>());
    			}
    			graph.get(trans).add(word);
    		}
    	}
    	
    	Deque<Pair<String, Integer>> q = new ArrayDeque<Pair<String, Integer>>();
    	Set<String> visited = new HashSet<>();
    	q.offer(new Pair<String, Integer>(beginWord, 1));
    	
    	while (!q.isEmpty()) {
    		Pair<String, Integer> curr = q.poll();
    		if (curr.key.equals(endWord)) {
    			return curr.value;
    		}
    		List<String> trans = transformWord(curr.key);
    		for (String word : trans) {
    			if (graph.containsKey(word) && !visited.contains(word)) {
    				for (String realWord : graph.get(word)) {
    					visited.add(word);
        				q.offer(new Pair<String, Integer>(realWord, curr.value + 1));
    				}
    			}
    		}
    	}

    	return 0;
    }
    
    public List<String> transformWord(String s) {
    	List<String> t = new ArrayList<String>();
    	for (int i=0; i<s.length(); i++) {
    		char[] arr = s.toCharArray();
    		arr[i] = '*';
    		t.add(new String(arr));
    	}
    	return t;
    }
    
    class Pair<T, S> {
    	T key;
    	S value;
    	Pair(T key, S value) {
    		this.key = key;
    		this.value = value;
    	}
    	
    	public String toString() {
    		return key + " -- " + value;
    	}
    }
}