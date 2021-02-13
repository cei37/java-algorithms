package cei37.string;

/*

1576. Replace All ?'s to Avoid Consecutive Repeating Characters
Easy

149

86

Add to List

Share
Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters into lower case letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.

It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.

Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.

 

Example 1:

Input: s = "?zs"
Output: "azs"
Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
Example 2:

Input: s = "ubv?w"
Output: "ubvaw"
Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".
Example 3:

Input: s = "j?qg??b"
Output: "jaqgacb"
Example 4:

Input: s = "??yw?ipkj?"
Output: "acywaipkja"

 */
public class ReplaceAllQMark {

	public static void main(String[] args) {
		ReplaceAllQMark re = new ReplaceAllQMark();
		String[] data = {
			"?zs",
			"ubv?w",
			"j?qg??b",
			"??yw?ipkj?",
			"?a",
			"??a?",
			"?",
			"???????????????????",
		};

		for (String s : data) {
			System.out.println(re.modifyString(s));
		}
	}

    public String modifyString(String s) {
    	if (s == null || s.length() == 0) return s;
    	
    	char[] data = s.toCharArray();
    	
    	if (data[0] == '?') {
			if (data.length > 1) {
				data[0] = getChar(data[0], data[1]);
			} else {
				data[0] = 'a';
				return new String(data);
			}
		}
    	
    	for (int i=1; i<data.length - 1; i++) {
    		if (data[i] != '?') {
    			continue;
    		}
    		data[i] = getChar(data[i-1], data[i+1]);
    	}
    	
    	if (data[data.length - 1] == '?') {
    		data[data.length - 1] = getChar(data[data.length - 2], ' ');
		}
    	
    	return new String(data);
    }
    
    private char getChar(char c1, char c2) {
    	for (int i=0; i<26; i++) {
    		char c = (char) (i + 'a');
    		if (c1 != c && c2 != c) {
    			return c;
    		}
    	}
    	return '-';
    }
}