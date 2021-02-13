package cei37.arrays;

/*
 * 5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),

 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring lp = new LongestPalindromicSubstring();
		String[] arr = new String[] {
			"babad", //"bab"
			"cbbd", //bb
			"a", //a
			"ac" //a
		};
		
		for (String s : arr) {
			System.out.println(lp.longestPalindrome(s));
		}
	}
/*
	public String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}*/

	int start = 0;
	int end = 0;
    public String longestPalindrome(String s) {
    	start = 0;
    	end = 0;
    	if (s == null || s.length() == 0) return "";
    	
    	for (int i=0; i<s.length(); i++) {
    		findPalindrom(s, i, i);
    		findPalindrom(s, i, i + 1);
    	}
    	
    	return s.substring(start, end + 1);
    }
    
    public void findPalindrom(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			if (end - start < r - l) {
				start = l;
				end = r;
			}
			l--;
			r++;
		}
    }
}
