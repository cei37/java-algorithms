package cei37.dailyCode;

import java.util.Stack;

/*
 Backspace String Compare
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {

	public static void main(String[] args) {
		BackspaceStringCompare b = new BackspaceStringCompare();
		/*System.out.println(b.backspaceCompare("ab#c", "ad#c"));
		System.out.println(b.backspaceCompare("ab##", "c#d#"));
		System.out.println(b.backspaceCompare("a##c", "#a#c"));
		System.out.println(b.backspaceCompare("a#c", "b"));*/
		System.out.println(b.backspaceCompare("y#fo##f", "y#f#o##f"));
	}
	
    public boolean backspaceCompare(String S, String T) {
    	Stack<Character> s1 = flatString(S);
    	Stack<Character> s2 = flatString(T);
    	
    	while(!s1.isEmpty() || !s2.isEmpty()) {
    		if (s1.isEmpty() || s2.isEmpty() || s1.pop() != s2.pop())
    			return false;
    	}
    	return true;
    }
    
    public Stack<Character> flatString(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0; i<c.length; i++) {
            if (c[i]=='#') {
            	if (!stack.isEmpty())
            		stack.pop();
            }
            else {
                stack.push(c[i]);
            }
        }
        return stack;
    }
}