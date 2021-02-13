package cei37.decode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 394. Decode String
Medium

3945

195

Add to List

Share
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets 
is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets
 are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits 
are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 */
public class DecodeString {

	public static void main(String[] args) {
		String[] input = new String[] {
			//"3[a]2[bc]",
			"3[a2[c]]",
			//"2[abc]3[cd]ef",
			//"abc3[cd]xyz"
		};

		for (String s : input) {
			System.out.println(s);
		}
	}

    public String decodeString(String s) {
    	if (s == null || s.length() == 0) return "";
    	StringBuilder result = new StringBuilder();
    	StringBuilder temStr = new StringBuilder();
    	
    	Deque<Data> stack = new ArrayDeque<>();
    	int num = 0;
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if (c - '0' >= 0 && c - '9' <= 9 ) {
    			num = num * 10 + (int)(c - '0');
    		} else if (c == '['){
    			stack.push(new Data(num, temStr.toString()));
    		}  else if (c == ']'){
    			
    		} else {
    			temStr.append(c);
    		}
    	}

    	return result.toString();
    }

    class Data {
    	int num;
    	String value;
    	public Data(int num, String value) {
    		this.value = value;
    		this.num = num;
    	}
    }
}