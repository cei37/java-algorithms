package cei37.dailyCode;

import java.util.Stack;

/*
 * 402. Remove K Digits

Given a non-negative integer num represented as a string, remove k digits from the 
number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {

	public static void main(String[] args) {
		RemoveKDigits rkd = new RemoveKDigits();
		String num = "1234567890";
		int k = 9;
		System.out.println(rkd.removeKdigits(num, k));
	}

    public String removeKdigits(String num, int k) {
    	Stack<Character> stack = new Stack<>();
    	
    	if (num == null || num.trim().length() == 0 || k == 0) {
    		return num;
    	}
    	
    	if (num.trim().length() == k) {
    		return "0";
    	}
    	
    	for (int i=0; i < num.length(); i++) {
    		while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
    			stack.pop();
    			k--;
    		}
    		stack.push(num.charAt(i));
    	}
    	
    	while(k > 0) {
    		if (!stack.isEmpty()) {
    			stack.pop();
    		}
    		k--;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	boolean leftZero = true;
    	for (Character c : stack) {
    		if (leftZero && c == '0' ) continue;
    		leftZero = false;
    		sb.append(c);
    	}
    	
    	if (sb.length() == 0) {
    		return "0";
    	}
    	return sb.toString();
    }
}
