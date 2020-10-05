package cei37.arrays;

/*
 * 541. Reverse String II

Given a string and an integer k, you need to reverse the first k characters for every 2k 
characters counting from the start of the string. If there are less than k characters left, 
reverse all of them. If there are less than 2k but greater than or equal to k characters, 
then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

 */
public class ReverseStringII {

	public static void main(String[] args) {
		ReverseStringII rs = new ReverseStringII();
		//String s = "krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc";
		String s = "1234567890asew";
		int k = 2;
		System.out.println(rs.reverseStr(s, k));
	}

    public String reverseStr(String s, int k) {
    	
    	if (s == null || s.length() == 0) return "";
    	
    	char[] ch = s.toCharArray();
    	for (int start = 0; start<ch.length; start += 2 * k) {
    		int l = start;
    		int r = Math.min(start + k - 1, ch.length - 1);
    		reverseChar(ch, l, r);
    	}

    	return new String(ch);
    }
    
    public void reverseChar(char[] ch, int l, int r) {
    	while(l<r) {
    		char c = ch[l];
    		ch[l++] = ch[r];
    		ch[r--] = c;
    	}
    }
}
