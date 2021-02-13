package cei37.string;

/*
 * 8. String to Integer (atoi)
Medium

24

58

Add to List

Share
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 

Example 1:

Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-231, 231 - 1], the final result is 42.
Example 2:

Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.
Example 3:

Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
Example 4:

Input: s = "words and 987"
Output: 0
Explanation:
Step 1: "words and 987" (no characters read because there is no leading whitespace)
         ^
Step 2: "words and 987" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "words and 987" (reading stops immediately because there is a non-digit 'w')
         ^
The parsed integer is 0 because no digits were read.
Since 0 is in the range [-231, 231 - 1], the final result is 0.
Example 5:

Input: s = "-91283472332"
Output: -2147483648
Explanation:
Step 1: "-91283472332" (no characters read because there is no leading whitespace)
         ^
Step 2: "-91283472332" ('-' is read, so the result should be negative)
          ^
Step 3: "-91283472332" ("91283472332" is read in)
                     ^
The parsed integer is -91283472332.
Since -91283472332 is less than the lower bound of the range [-231, 231 - 1], the final result is clamped to -231 = -2147483648.
 

Constraints:

0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

 */
public class StringToIntegerATOI {

	public static void main(String[] args) {
		StringToIntegerATOI s = new StringToIntegerATOI();
		String[] inputs = {
			/*"42",
			"       -42",
			"4193 with words",
			"words and 987",
			"-91283472332",
			"    s232",
			"    s 232",
			"    s 232",
			"  -232 s",
			"  -  232 s",
			"  +  232 s",
			"  +  233",
			"+233",
			"0035",
			"3.14",
			"+3.15",
			"-3.15",
			".315",
			"  -0012a42",
			"00000-42a1234",*/
			"9223372036854775808"
		};
		//System.out.println(Integer.MIN_VALUE);
		for (String in : inputs) {
			System.out.println(s.myAtoi(in));
		}
	}

    public int myAtoi(String str) {
    	if (str == null || str.length() == 0) return 0;
    	
    	//hold the final result
    	long sum = 0;
    	boolean negative = false;
    	int pos = 0;
    	
    	while(pos < str.length() && str.charAt(pos) == ' ') {
    		pos++;
    	}

    	if (pos <str.length() && (str.charAt(pos) == '-' || str.charAt(pos) == '+')) {
    		negative = str.charAt(pos) == '-';
    		pos++;
    	}

    	for (int i=pos; i < str.length(); i++) {
    		char c= str.charAt(i);

    		if (c == ' ' || c == '.') {
    			return resturnNumber(sum, negative);
    		}

    		if (c - '0' >= 0 && c - '0' <= 9) {
    			sum = 10 * sum + (c - '0');
    			if (sum >= Integer.MAX_VALUE || sum <= Integer.MIN_VALUE) {
    				return resturnNumber(sum, negative);
    			}
    		} else {
    			return resturnNumber(sum, negative);
    		}
    	}

    	return resturnNumber(sum, negative);
    }
    
    public int resturnNumber(long num, boolean negative) {
    	if (negative) {
    		num = -num;
		}
    	if (num >= Integer.MAX_VALUE) {
    		return Integer.MAX_VALUE;
    	}
    	if (num <= Integer.MIN_VALUE) {
    		return Integer.MIN_VALUE;
    	}
    	return (int)num;
    }
}