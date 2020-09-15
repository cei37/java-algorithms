package cei37.dailyCode;

import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(-2);
		System.out.println(obj);
		obj.push(0);
		System.out.println(obj);
		obj.push(-1);
		System.out.println(obj);
		obj.getMin();
		System.out.println(obj);
		obj.top();
		System.out.println(obj);
		obj.pop();
		System.out.println(obj);

		
		System.out.println(obj.getMin());
	}

	
	class Element {
        int value;
        int min;
        
        Element(int x, int min) {
            this.value = x;
            this.min = min;
        }
        
        public String toString() {
        	return "[" + value + "<min " + min + ">]";
        }
    }
    
    Stack<Element> stack = null;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Element>();
    }
    
    public void push(int x) {
        Element ele = null;
        if (stack.empty()) {
            ele = new Element(x, x);
            stack.push(ele);
            return;
        }
        int currentMin = stack.peek().min;
        if (x <= currentMin) 
            ele = new Element(x, x);
        else
            ele = new Element(x, currentMin);
        stack.push(ele);
    }
    
    public void pop() {
    	stack.pop();   
    }
    
    public int top() {
    	return stack.peek().value;
    }
    
    public int getMin() {
    	return stack.peek().min;
    }
    
    public String toString() {
    	return stack.toString();
    }
}
