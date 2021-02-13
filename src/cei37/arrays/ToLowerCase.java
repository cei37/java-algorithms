package cei37.arrays;

/*
 * 709. To Lower Case

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
 */
public class ToLowerCase {

	public static void main(String[] args) {
		ToLowerCase tlc = new ToLowerCase();
		System.out.println(tlc.toLowerCase("Hello"));
	}

    public String toLowerCase(String str) {
    	if (str == null || str.trim().length() == 0) return "";
    	StringBuilder sb = new StringBuilder();
    	for (int i=0; i<str.length(); i++) {
    		char c = str.charAt(i);
    		if (c >= 'A' && c <= 'Z')
    			sb.append((char)(c + 32));
    		else 
    			sb.append(c);
    	}
    	return sb.toString();
    }
}