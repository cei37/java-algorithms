package cei37.string;

/*
58. Length of Last Word
Easy

945

2965

Add to List

Share
Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Example 2:

Input: s = " "
Output: 0
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		LengthOfLastWord le = new LengthOfLastWord();
		
		String[] words = {
			"Hello World",
			"Yeah",
			" ",
			"Hello World OKas  ",
		};

		for (String s : words) {
			System.out.println(le.lengthOfLastWord(s));
		}
	}

    public int lengthOfLastWord(String s) {
    	if (s == null) return 0;
    	
    	String ss = s.trim();
    	
    	if (ss.length() == 0) return 0;
    	
    	String[] arr = ss.split(" ");
    	
    	return arr[arr.length - 1].length();
    }
    
    
}