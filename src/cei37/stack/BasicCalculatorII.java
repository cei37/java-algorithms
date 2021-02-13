package cei37.stack;

import java.util.Stack;

/*
 * 
 * 227. Basic Calculator II

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.

 */
public class BasicCalculatorII {

	public static void main(String[] args) {
		BasicCalculatorII bc = new BasicCalculatorII();
		
		String ss[] = {
			"  3 / 2  ", //1
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
	
	
	//My original implementation, it is a mess, let's try to make a new one
	//with my new improved skill gained
    public int calculate_2(String s) {
    	if (s == null || s.trim().length() == 0) return 0;

    	Stack<Integer> nums = new Stack<Integer>();
    	Stack<Character> op = new Stack<Character>();

    	StringBuffer sb = new StringBuffer();
    	boolean negative = false;
    	
    	for (char c : s.toCharArray()) {
    		if (c == ' ') continue;

    		if (c == '*' || c == '/') {
    			if (negative) {
    				nums.push(-Integer.valueOf(sb.toString()));
    				negative = false;
    			} else {
        			nums.push(Integer.valueOf(sb.toString()));
    			}
    			if (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
    				if (op.peek() == '*') {
    					nums.push(nums.pop() * nums.pop());
    				} else {
    	    			int num1 = nums.pop();
    	    			int num2 = nums.pop();
    	    			nums.push(num2 / num1);
    				}
    				op.pop();
    			}
    			op.push(c);
    			sb = new StringBuffer();
    		} else if (c == '+' || c == '-') {
    			if (negative) {
    				nums.push(-Integer.valueOf(sb.toString()));
    				negative = false;
    			} else {
        			nums.push(Integer.valueOf(sb.toString()));
    			}
    			if (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
    				if (op.peek() == '*') {
    					nums.push(nums.pop() * nums.pop());
    				} else {
    	    			int num1 = nums.pop();
    	    			int num2 = nums.pop();
    	    			nums.push(num2 / num1);
    				}
    				op.pop();
    			}
    			op.push(c);
    			sb = new StringBuffer();
    			if (op.peek() == '-') {
    				negative = true;
    			}
    		} else {
    			sb.append(String.valueOf(c));
    		}
    	}
    	
    	if (sb.length() > 0 ) {
    		if (negative) {
				nums.push(-Integer.valueOf(sb.toString()));
				negative = false;
			} else {
    			nums.push(Integer.valueOf(sb.toString()));
			}
    	}
    	
    	while(!op.isEmpty()) {
    		char o = op.pop();
    		if (o == '*') {
    			nums.push(nums.pop() * nums.pop());
    		} else if (o == '/') {
    			int num1 = nums.pop();
    			int num2 = nums.pop();
    			nums.push(num2 / num1);
    		} else if (o == '+' || o == '-') {
    			nums.push(nums.pop() + nums.pop());
    		}
    	}

    	return nums.peek();
    }
}
