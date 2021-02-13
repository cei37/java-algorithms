package cei37.string;

import java.util.ArrayList;
import java.util.List;

/*
 * 68. Text Justification

Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth 
characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a 
line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last 
line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a",
"computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth

 */
public class TextJustification {

	public static void main(String[] args) {
		TextJustification t = new TextJustification();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		//String[] words = {"What","must","be","acknowledgment","shall","be"};
		//String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
		//String[] words = {"enough","to","explains","to", "yeah", "ok", "assssh", "sure"};
		int maxWidth = 16;
		
		for (String str : t.fullJustify(words, maxWidth)) {
			System.out.println(str);
		}
	}
    
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> res = new ArrayList<>();
    	int init = 0;
    	int charCounter = 0;
    	int wordCounter = 0;
    	int i=0;
    	while(i < words.length) {
    		if (words[i].length() + charCounter + wordCounter - 1 < maxWidth) {
    			charCounter += words[i].length();
    			wordCounter++;

    			//this is to handled the last line in the array
    			if (words.length - 1 == i) {
    				makeLine(words, maxWidth, charCounter, wordCounter, res, init, i);
    			}
    		} else {
    			//this is called each time that we can form a line < maxWidth, but with the max with line
    			makeLine(words, maxWidth, charCounter, wordCounter, res, init, i - 1);
    			charCounter = 0;
    			wordCounter = 0;
    			init = i;
    			continue;
    		}
    		i++;
    	}
    	
        return res;
    }
    
    private void makeLine(String[] words, int maxWidth, int charCounter, int wordCounter, List<String> res, int init, int end) {
    	StringBuilder sb = new StringBuilder();

    	//this is a single word
    	if (init == end && end < words.length - 1) {
    		sb.append(words[init]);
    		fillWithSpaces(sb, maxWidth);
    		res.add(sb.toString());
    	} else if (end == words.length - 1) {
    		//this is the last line
    		for (int i=init; i<end; i++) {
    			sb.append(words[i]).append(" ");
    		}
    		sb.append(words[end]);
    		fillWithSpaces(sb, maxWidth);
    		res.add(sb.toString());
    	} else {
    		wordCounter--;
	    	int extraSpaces = maxWidth - (charCounter + wordCounter);
	    	int mod = 0;
	    	int newSpace = 0;
	    	if (wordCounter > 0) {
	    		mod = extraSpaces % wordCounter;
	    		newSpace = extraSpaces / wordCounter;
	    	}
	    	
	    	for (int i=init; i<end; i++) {
	    		sb.append(words[i]);
	    		
	    		//this is the default space
	    		sb.append(" ");
	
	    		//this is the remained spaced dived between all words
	    		for (int j=0; j<newSpace; j++) {
	    			sb.append(" ");
	    		}
	
	    		//this is the mod
	    		if (mod > 0) {
	    			sb.append(" ");
	    			mod--;
	    		}
	    	}
	    	//let's add the last word from the counter
	    	sb.append(words[end]);

	    	//let's add the created word to the res
	    	res.add(sb.toString());
    	}
    }
    
    private void fillWithSpaces(StringBuilder sb, int maxWidth) {
		while(sb.length() < maxWidth) {
			sb.append(" ");
		}
    }
}
