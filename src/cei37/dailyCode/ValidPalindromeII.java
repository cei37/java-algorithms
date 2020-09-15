package cei37.dailyCode;

/*
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

 */
public class ValidPalindromeII {

	public static void main(String[] args) {
		String str = "anitalavalatina";
		//String str = "gju";
		ValidPalindromeII vp = new ValidPalindromeII();
		
		System.out.println(vp.validPalindrome(str));

	}

	public boolean validPalindrome(String s) {
		char arr[] = s.toCharArray();
		for (int i=0, j=arr.length -1; j>=i; i++, j--) {
			if (arr[i] != arr[j]) {
				boolean valid = validPal(arr, i, j, i);
				if (valid) 
					return true;
				else 
					return validPal(arr, i, j, j);
				
			}
		}
    	return true;
    }

	public boolean validPal(char []arr, int ii, int jj, int remove) {
		for (int i=ii, j=jj; j>i; i++, j--) {
			if (i == remove) i++;
			if (j == remove) j--;
			if (arr[i] != arr[j]) return false;
		}
		return true;
	}
}
