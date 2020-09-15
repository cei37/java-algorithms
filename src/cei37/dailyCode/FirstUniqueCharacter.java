package cei37.dailyCode;

import java.util.HashMap;
import java.util.Map;

/*
 *  First Unique Character in a String
Solution
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

 */
public class FirstUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstUniqueCharacter fuc = new FirstUniqueCharacter();
		String s = "leetcode";
		System.out.println(fuc.firstUniqChar(s));
	}
	
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] c = s.toCharArray();
        for (int i=0; i<c.length; i++) {
            if (map.get(c[i])!=null) {
                map.put(c[i], map.get(c[i]) + 1);
            } else {
                map.put(c[i], 1);
            }
        }
        
        for (int i=0; i<c.length; i++) {
            if (map.get(c[i])!=null && map.get(c[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

}
