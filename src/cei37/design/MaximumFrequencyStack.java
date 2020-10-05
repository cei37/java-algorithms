package cei37.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 *   Maximum Frequency Stack

Implement FreqStack, a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

push(int x), which pushes an integer x onto the stack.
pop(), which removes and returns the most frequent element in the stack.
If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 

Example 1:

Input: 
["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
Output: [null,null,null,null,null,null,null,5,7,5,4]
Explanation:
After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

pop() -> returns 5, as 5 is the most frequent.
The stack becomes [5,7,5,7,4].

pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
The stack becomes [5,7,5,4].

pop() -> returns 5.
The stack becomes [5,7,4].

pop() -> returns 4.
The stack becomes [5,7].
 

Note:

Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
The total number of FreqStack.push calls will not exceed 10000 in a single test case.
The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.
 */
public class MaximumFrequencyStack {

	Map<Integer, Integer> freqMap;
	Map<Integer, Stack<Integer>> setMap;
	int maxFreq = 0;

    public MaximumFrequencyStack() {
    	freqMap = new HashMap<>();
    	setMap = new HashMap<>();
    }
    
    public void push(int x) {
    	int freq = 0;
        if (freqMap.get(x) == null) {
        	freq = 1;
        } else {
        	freq = freqMap.get(x) + 1;
        }
        
        freqMap.put(x, freq);
        
        if (freq > maxFreq) {
        	maxFreq = freq;
        }

		if (setMap.get(freq) == null) {
			Stack<Integer> stack = new Stack<>();
			stack.push(x);
			setMap.put(freq, stack);
		} else {
			setMap.get(freq).push(x);
		}

    }
    
    public int pop() {
        int top = setMap.get(maxFreq).pop();
        
        freqMap.put(top, freqMap.get(top)-1);
        
        if (setMap.get(maxFreq).size() == 0)
        	maxFreq--;
    	return top;
    }

	public static void main(String[] args) {
		MaximumFrequencyStack mfs = new MaximumFrequencyStack();
        // Push elements to the stack 
		mfs.push(4); 
		mfs.push(6); 
		mfs.push(7); 
		mfs.push(6); 
		mfs.push(8); 
		mfs.push(6); 
		mfs.push(6); 
  
        // Pop elements 
        System.out.println(mfs.pop()); 
        System.out.println(mfs.pop()); 
	}
}
