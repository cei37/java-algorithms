package cei37.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 150. Evaluate Reverse Polish Notation
Medium

1255

492

Add to List

Share
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate
to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		EvaluateReversePolishNotation eval = new EvaluateReversePolishNotation();
		String[][] tokens = new String[][] {
			{ "2", "1", "+", "3", "*" },
			{ "4", "13", "5", "/", "+" },
			{ "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" },
			{ "4", "3", "-"}
		};

		for (String[] token : tokens) {
			System.out.println(eval.evalRPN(token));
		}
	}

    public int evalRPN(String[] tokens) {
    	if (tokens == null || tokens.length == 0) return 0;
    	Deque<Integer> stack = new ArrayDeque<Integer>();

    	int val1 = 0, val2 = 0;
    	for (String token : tokens) {
    		if (token.equals("*")) {
    			val1 = stack.pop();
    			val2 = stack.pop();
    			stack.push(val1 * val2);
    		} else if (token.equals("/")) {
    			val1 = stack.pop();
    			val2 = stack.pop();
    			stack.push(val2 / val1);
    		} else if (token.equals("+")) {
    			val1 = stack.pop();
    			val2 = stack.pop();
    			stack.push(val1 + val2);
    		} else if (token.equals("-")) {
    			val1 = stack.pop();
    			val2 = stack.pop();
    			stack.push(val2 - val1);
    		} else {
    			stack.push(Integer.valueOf(token));
    		}
    	}
    	
    	return stack.pop();
    }
}