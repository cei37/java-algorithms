package cei37.stack;

import java.util.Stack;

/*
 * 224. Basic Calculator

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

 */
public class BasicCalculator {

	public static void main(String[] args) {
		BasicCalculator bc = new BasicCalculator();
		
		String ss[] = {
			" (1 + 3) / 2  ", //1
			"14/3*2", //8
			"1-1+1",//1
			"2+3-2*2-3/3",//0
			"3+2*2-4/2",//5
			"3+2*2",//7
			" 3/2 ",//1
			" 3+5 / 2 ",//5
		};
		
		for (String s: ss)
			System.out.println(bc.calculate(s));

	}

	public int calculate(String s) {
		if (s == null || s.trim().length() == 0) return 0;

    	Stack<Integer> nums = new Stack<Integer>();
    	Stack<Character> ops = new Stack<>();
    	
    	int num = 0;
    	char op = '+';
    	
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if (c == ' ' && i != s.length()-1) continue;
    		
    		if (Character.isDigit(c)) {
    			num = num * 10 + c - '0';
    		} 
    		if (!Character.isDigit(c) || i == s.length()-1) {
    			if (op == '*') {
    				nums.push(nums.pop() * num);
    			} else if (op == '/') {
    				nums.push(nums.pop() / num);
    			} else if (op == '-') {
    				nums.push(-num);
    			} else if (op == '+') {
    				nums.push(num);
    			} else if (op == '(') {
    				ops.push(op);
    			}
    			op = c;
    			num = 0;
    		}
    	}
    	num = 0;
		for (Integer n : nums) {
			num += n;
		}
		
		return num;
	}
}
