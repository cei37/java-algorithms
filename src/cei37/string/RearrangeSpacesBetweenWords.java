package cei37.string;

import java.util.ArrayList;
import java.util.List;

/*
 * 1592. Rearrange Spaces Between Words

You are given a string text of words that are placed among some number of spaces. Each word consists of 
one or more lowercase English letters and are separated by at least one space. It's guaranteed that text
 contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and 
that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

 

Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the 
words: 9 / (4-1) = 3 spaces.
Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. 
We place this extra space at the end of the string.
Example 3:

Input: text = "hello   world"
Output: "hello   world"
Example 4:

Input: text = "  walks  udp package   into  bar a"
Output: "walks  udp  package  into  bar  a "
Example 5:

Input: text = "a"
Output: "a"
 

Constraints:

1 <= text.length <= 100
text consists of lowercase English letters and ' '.
text contains at least one word.

 */
public class RearrangeSpacesBetweenWords {

	public static void main(String[] args) {
		RearrangeSpacesBetweenWords re = new RearrangeSpacesBetweenWords();
		String[] words = {
			//"     ",
			"      Hello      ",
			" Hello     World! ",
			"  this   is  a sentence   ",
			" practice   makes   perfect",
			"  walks  udp package   into  bar a"
		};

		for (String text : words) {
			System.out.println(re.reorderSpaces(text));
		}
	}

    public String reorderSpaces(String text) {
    	if (text == null || text.length() == 0) return "";

    	List<String> words = new ArrayList<>();
    	int totalSpaces = getNumberOfSpacesAndSplitText(words, text);

    	int mod = 0;
    	int spacesToAdd = 0;
    	
    	if (words.size() - 1 > 0) {
    		mod = totalSpaces % (words.size() - 1);
        	spacesToAdd = totalSpaces / (words.size() - 1);
    	}

    	StringBuilder res = new StringBuilder();
    	for (int i=0; i<words.size() - 1; i++) {
    		res.append(words.get(i));
    		for (int j=0; j<spacesToAdd; j++) {
    			res.append(" ");
    		}
    	}
    	
    	if (words.size() > 0) {
        	res.append(words.get(words.size()-1));
        	if (words.size() == 1) {
        		for (int j=0; j<totalSpaces; j++) {
        			res.append(" ");
        		}
        	}
    	}

    	for (int i=0; i<mod; i++) {
    		res.append(" ");
    	}
    	
    	return res.toString();
    }

    private int getNumberOfSpacesAndSplitText(List<String> words, String text) {
    	int totalSpaces = 0;
    	StringBuilder sb = new StringBuilder();
    	for (char c : text.toCharArray()) {
    		if (c == ' ') {
    			totalSpaces++;
    			if (sb.length() > 0) {
    				words.add(sb.toString());
    				sb = new StringBuilder();
    			}
    		} else {
    			sb.append(c);
    		}
    	}
    	if (sb.length() > 0) {
			words.add(sb.toString());
			sb = new StringBuilder();
		}
    	return totalSpaces;
    }
}