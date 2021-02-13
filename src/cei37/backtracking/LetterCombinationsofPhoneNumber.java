package cei37.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 17. Letter Combinations of a Phone Number
Medium

4778

458

Add to List

Share
Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 
1 does not map to any letters.


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsofPhoneNumber {

	public static void main(String[] args) {
		String digits = "232";
		LetterCombinationsofPhoneNumber lc = new LetterCombinationsofPhoneNumber();
		
		for (String str : lc.letterCombinations(digits)) {
			System.out.println(str);
		}
	}

	List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
    	if (digits == null || digits.length() == 0) return res;
    	
    	Map<String, String> map = new HashMap<>();
    	pupulateMap(map);
    	backTrack("", digits, map);
        return res;
    }
    
    public void backTrack(String combination, String digits, Map<String, String> phone) {
    	if (digits.length() == 0) {
    		res.add(combination);
    	} else {
    		String digit = digits.substring(0,1);
    		String letters = phone.get(digit);
    		for (int i=0; i<letters.length(); i++) {
    			String letter = phone.get(digit).substring(i, i + 1);
    			backTrack(combination + letter, digits.substring(1), phone);
    		}
    	}
    }
    
    public void pupulateMap(Map<String, String> map) {
    	map.put("0", " ");
    	map.put("1", " ");
    	map.put("2", "abc");
    	map.put("3", "def");
    	map.put("4", "ghi");
    	map.put("5", "jkl");
    	map.put("6", "mno");
    	map.put("7", "pqrs");
    	map.put("8", "tuv");
    	map.put("9", "wxyz");
    }
}
