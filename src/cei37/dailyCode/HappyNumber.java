package cei37.dailyCode;

import java.util.HashSet;
import java.util.Set;

/*
 *
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until 
the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not 
include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
1exp2 + 9ex2 = 82
8exp2 + 2exp2 = 68
6exp2 + 8exp2 = 100
1exp2 + 0exp2 + 02 = 1

examples of happy numbers
//1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68
 */
public class HappyNumber {

	
	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		
		int [] num = {1, 7, 10, 13, 19, 23, 28, 31, 32, 2};
		
		for (Integer i: num) {
			System.out.println(hn.isHappy(i));
			System.out.println("-------------------");
		}

	}

    public boolean isHappy(int n) {
    	Set<Integer> set = new HashSet<Integer>();
        int num = n;
        while(set.add(num)) {
            if (num == 1) return true;
            char[] c = String.valueOf(num).toString().toCharArray();
            num = 0;
            for (int i=0; i<c.length; i++) {
            	int d = Integer.valueOf(String.valueOf(c[i]));
                num += d*d;
            }
        }
        return false;
    }
}
