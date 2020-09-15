package cei37.dailyCode;

/*
 * Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single 
space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string 
should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 
 
 */
public class ReverseWordsinaString {

	public static void main(String[] args) {
		ReverseWordsinaString re = new ReverseWordsinaString();
		String s = "the sky is blue";
		System.out.println(re.reverseWords(s));
	}

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
    	
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
        	int j=i;
        	while(i > 0 && s.charAt(i) != ' ') i--;
        	sb.append(s.substring(i, j+1)).append(" ");
        	i--;
        }
        
    	return sb.toString().trim();
    }
}
