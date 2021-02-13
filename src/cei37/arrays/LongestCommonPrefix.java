package cei37.arrays;

/*
 * 14. Longest Common Prefix
Easy

3196

2006

Add to List

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[][] strs = new String[][] {
			{ "a" },
			{ "a", "a" },
			{ "ab", "a" },
			{ "ab", "ac" },
			{ "a", "ac" },
			{ "", "" },
			{ "", "a" },
			{ "a", "" },
			{ "" },
			{"dog","racecar","car"},
			{"flower","flow","flight"}
		};
		
		for (String[] s : strs) {
			System.out.println(lcp.longestCommonPrefix(s) + " --");
		}
	}

    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) return "";
    	if (strs.length == 1) return strs[0];
    	
    	int p=0;
    	boolean simmilar = true;
    	while(simmilar) {
    		for (int i=1; i<strs.length; i++) {
    			if (p < strs[i].length() && p < strs[i-1].length()) {
	    			if (strs[i-1].charAt(p) != strs[i].charAt(p)) {
	    				simmilar = false;
	    				return strs[0].substring(0,p);
	    			}
    			} else {
    				return strs[0].substring(0,p);
    			}
    		}
    		p++;
    	}
    	return strs[0].substring(0,p);
    }
    
    public String longestCommonPrefix_1(String[] strs) {
    	if (strs == null || strs.length == 0) return "";
    	if (strs.length == 1) return strs[0];
    	StringBuffer sb = new StringBuffer();
    	
    	int p=0;
    	boolean simmilar = true;
    	while(simmilar) {
    		for (int i=1; i<strs.length; i++) {
    			if (p < strs[i].length() && p < strs[i-1].length()) {
	    			if (strs[i-1].charAt(p) != strs[i].charAt(p)) {
	    				simmilar = false;
	    				return sb.toString();
	    			}
    			} else {
    				return sb.toString();
    			}
    		}
    		if (simmilar) {
    			sb.append(strs[0].charAt(p));
    		}
    		p++;
    	}
    	return sb.toString();
    }
}
