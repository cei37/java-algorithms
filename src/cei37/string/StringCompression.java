package cei37.string;

/*
 * 443. String Compression
Medium

1107

2967

Add to List

Share
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead be stored in 
the input character array chars. Note that group lengths that are 10 or longer will be 
split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

 
Follow up:
Could you solve it using only O(1) extra space?

 

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
Example 4:

Input: chars = ["a","a","a","b","b","a","a"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note that each group is independent even if two groups have the same character.
 

Constraints:

1 <= chars.length <= 2000
chars[i] is a lower-case English letter, upper-case English letter, digit, or symbol.
 */
public class StringCompression {

	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
		char[][] inputs = new char[][] {
			{'a','a','b','b','c','c','c'},
			{'a'},
			{'a','b','b','b','b','b','b','b','b','b','b','b','b'},
			{'a','a','a','b','b','a','a'},
			{'a','b','c','d','e'},
			{'a','b','c','d','e','e'},
			{'a','b','c','d','e','e','j'},
			{'a','a','a','a','a','b'},
			{'a','a','a','a','b','a'}
		};

		for (char[] ch : inputs) {
			int n = sc.compress(ch);
			for (int i=0; i<n; i++) {
				System.out.print(ch[i]);
			}
			System.out.println("");
		}
	}

    public int compress(char[] chars) {
    	if (chars == null || chars.length == 0) return 0;
    	
    	if (chars.length == 1) return 1;
    	
    	int j = 0;
    	int count = 1;
    	for (int i=1; i<=chars.length; i++) {
    		if (chars.length == i || chars[i] != chars[i-1]) {
    			if (count > 1) {
    				j = addNumberToArr(chars, chars[i-1], count, j);
    			} else {
    				chars[j++] = chars[i-1]; 
    			}
    			count = 0;
    		}
    		count++;
    	}

    	return j;
    }

    public int addNumberToArr(char[] chars, char cc, int count, int j) {
    	String str = String.valueOf(count);
    	chars[j++] = cc;
		for (char c : str.toCharArray()) {
			chars[j++] = c; 
		}
		return j;
    }
    
    public int compress_From_Solution(char[] chars) {
        if(chars.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        
        while(fast < chars.length) {
            int count = 0;
            char cur = chars[fast];
            
            while(fast < chars.length && chars[fast] == cur) {
                fast++;
                count++;
            }
            
            chars[slow++] = cur;
            
            if(count > 1) {
                for(char c : Integer.toString(count).toCharArray()) {
                    chars[slow++] = c;
                }                
            }
        }
        return slow;
    }
}