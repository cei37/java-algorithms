package cei37.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 269. Alien Dictionary

There is a new alien language that uses the English alphabet. However, the 
order among letters are unknown to you.

You are given a list of strings words from the dictionary, where words are 
sorted lexicographically by the rules of this new language.

Derive the order of letters in this language, and return it. If the given 
input is invalid, return "". If there are multiple valid solutions, return any of them.


Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.

w  r  t
w  r  f
e  r
e  t  t
r  f  t  t

 */
public class AlienDictionary {

	public static void main(String[] args) {
		AlienDictionary alien = new AlienDictionary();
		String[] words = new String[] {
			"wrt","wrf","er","ett","rftt"
		};

		System.out.println(alien.alienOrder(words));
	}
	
    public String alienOrder(String[] words) {
    	if (words == null || words.length == 0) return "";
    	Map<Character, List<Character>> graph = new HashMap<>();

    	
    	return "";
    }


}