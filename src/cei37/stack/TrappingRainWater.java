package cei37.stack;

import java.util.Stack;

/*
 * 
 * 42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 
6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

 */
public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater trw = new TrappingRainWater();
		
		int[] height = new int[] {
			2, 0 , 2
		};
		
		System.out.println(trw.trap(height));
	}

    public int trap(int[] height) {
    	
    	if (height == null || height.length == 0) return 0;
    	
    	Stack<Integer> stack = new Stack<>();
    	int res = 0;
    	
    	for (int i = 0; i<height.length; i++) {
			while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
				int cur = stack.pop();
				if (!stack.isEmpty()) {
					res += (i - stack.peek() - 1) * (Math.min(height[stack.peek()], height[i]) - height[cur]);
				}
			}
			stack.push(i);
    	}
    	
    	return res;
    }
}
