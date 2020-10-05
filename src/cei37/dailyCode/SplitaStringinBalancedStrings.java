package cei37.dailyCode;

/*
 * 1221. Split a String in Balanced Strings
Balanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.

 

Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
Example 4:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 

Constraints:

1 <= s.length <= 1000
s[i] = 'L' or 'R'

 */
public class SplitaStringinBalancedStrings {

	public static void main(String[] args) {
		SplitaStringinBalancedStrings sp = new SplitaStringinBalancedStrings();
		System.out.println(sp.balancedStringSplit("RLRRLLRLRL"));
		System.out.println(sp.balancedStringSplit("RLLLLRRRLR"));
		System.out.println(sp.balancedStringSplit("LLLLRRRR"));
		System.out.println(sp.balancedStringSplit("RLRRRLLRLL"));

	}

    public int balancedStringSplit(String s) {
        //hold the total of splits
    	int split = 0;
        //counter for R
        int r = 0;
        //counter for L
        int l = 0;
        
        for (int i=0; i<s.length(); i++) {
        	if (s.charAt(i) == 'R') {
        		r++;
        	} else if (s.charAt(i) == 'L') {
        		l++;
        	}
        	if (r == l) {
        		split++;
        		r = 0;
        		l = 0;
        	}
        }

    	return split;
    }
}
