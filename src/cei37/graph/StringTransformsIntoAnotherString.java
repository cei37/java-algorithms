package cei37.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 1153. String Transforms Into Another String
Hard

515

186

Add to List

Share
Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.

Return true if and only if you can transform str1 into str2.

 

Example 1:

Input: str1 = "aabcc", str2 = "ccdee"
Output: true
Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
Example 2:

Input: str1 = "leetcode", str2 = "codeleet"
Output: false
Explanation: There is no way to transform str1 to str2.
 

Constraints:

1 <= str1.length == str2.length <= 104
str1 and str2 contain only lowercase English letters.

Model the problem as a graph problem. Add an edge from one character to another if you need to convert between them.
What if one character needs to be converted into more than one character?
There would be no solution. Thus, every node can have at most one outgoing edge.
How to process a linked list?
How to process a cycle?
What if there is a character with no outgoing edge? You can use it to break all cycles!
 */




//Solution
/*
One character can be mapped to another character, therefore, size of distinct elements in
HashMap is less than or equal to 26. However, size of the distinct elements of HashMap
cannot be equal to 26, because if it equals to 26, there will be cycle.
ab -> ba, if the size of the alphabet is 2,
a -> b, b -> a
a -> b
bb -> ba
b -> a
aa -> ba
*/
public class StringTransformsIntoAnotherString {

	public static void main(String[] args) {
		//String str1 = "aabcc", str2 = "ccdee";
		//String str1 = "leetcode", str2 = "codeleet";
		String str2 = "bcdefghijklmnopqrstuvwxyza";
		            // ||||||||||||||||||||||||||
		String str1 = "abcdefghijklmnopqrstuvwxyz";
		
		//"abcdefghijklmnopqrstuvwxyz"
		//"bcadefghijklmnopqrstuvwxzz"
		
		StringTransformsIntoAnotherString s = new StringTransformsIntoAnotherString();
		System.out.println(s.canConvert(str1, str2));
	}

    public boolean canConvert(String str1, String str2) {
    	if (str1.length() != str2.length()) return false;
    	if (str1.equalsIgnoreCase(str2)) return true;
    	
    	Map<Character, Character> map1 = new HashMap<>();
    	Set<Character> set = new HashSet<>();
    	for (int i=0; i<str1.length(); i++) {
    		char c1 = str1.charAt(i);
    		char c2 = str2.charAt(i);
    		
    		if (map1.containsKey(c1) && map1.get(c1) != c2) {
    			return false;
    		}

    		map1.put(c1, c2);
    		//this is only used to keep track of total unique character in str2
    		//if at the end we have 26, we return false
    		set.add(c2);
    	}
    	
    	return set.size() != 26;
    }
}