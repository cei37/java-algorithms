package cei37.number;

/*
 * 7. Reverse Integer
Easy

4290

6621

Add to List

Share
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 */
public class ReverseInteger {

	public static void main(String[] args) {
		int[] nums = {
			123,
			-123,
			120,
			0,
			1534236469
		};
		
		ReverseInteger re = new ReverseInteger();
		for (int n : nums)  {
			System.out.println(re.reverse(n));
		}
	}

    public int reverse(int x) {
    	//int sign = x < 0 ? -1 : 1;
    	int res = 0;
    	int mod = 0;
    	long sum = 0;
    	
    	while(x != 0) {
    		sum = sum * 10 + mod;
    		mod = x % 10;
    		x = x / 10;
    	}
    	sum = sum * 10 + mod;
    	if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
			return 0;
		}
    	
    	return (int)sum;
    }
}