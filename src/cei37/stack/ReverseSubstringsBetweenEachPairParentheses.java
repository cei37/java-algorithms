package cei37.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 1190. Reverse Substrings Between Each Pair of Parentheses

You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"

Constraints:

0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.

 */
public class ReverseSubstringsBetweenEachPairParentheses {

	public static void main(String[] args) {
		ReverseSubstringsBetweenEachPairParentheses r = new ReverseSubstringsBetweenEachPairParentheses();
		String[] inputs = new String[] {
			"(abcd)",
			"(u(love)i)",
			"(ed(et(oc))el)",
			"a(bcdefghijkl(mno)p)q"
		};
		for (String s : inputs) {
			System.out.println(r.reverseParentheses(s));
		}
	}

    public String reverseParentheses(String s) {
    	if (s == null || s.length() == 0) return "";
    	Deque<Character> stack = new ArrayDeque<>();
    	
    	for (int i=0; i<s.length(); i++) {
    		if (s.charAt(i) == ')') {
    			StringBuilder sb = new StringBuilder();
    			while(stack.peek() != '(') {
    				sb.append(stack.pop());
    			}
    			stack.pop();
    			for (int j=0; j<sb.length(); j++) {
    				stack.push(sb.charAt(j));
    			}
    		} else {
    			stack.push(s.charAt(i));
    		}
    	}

    	StringBuilder sb = new StringBuilder();
    	while(!stack.isEmpty()) {
    		sb.append(stack.pop());
    	}
    	
        return sb.reverse().toString();
    }
}