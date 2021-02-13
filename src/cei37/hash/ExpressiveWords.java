package cei37.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
809. Expressive Words
Medium

423

1066

Add to List

Share
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii". 
In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of
applications of the following extension operation: choose a group consisting of characters c, and add 
some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but 
we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension 
like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be 
stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 

 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 

Constraints:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters
 */
public class ExpressiveWords {

	public static void main(String[] args) {
		String s = "heeellooo";
		String words[] = {
			"hello",
			"hi",
			"helo"
		};

		String s2 = "zzzzzyyyyy";
		String words2[] = {
			"zzyy",
			"zy",
			"zyy"
		};
				
		ExpressiveWords ex = new ExpressiveWords();

		System.out.println(ex.expressiveWords(s2, words2));
	}
    
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String word: words) {
            count = count + (isExpressive(S, word) ? 1: 0);
        }
        return count;
    }
    
    private boolean isExpressive(String s, String w) {
        int mS = s.length();
        int nW = w.length();
        int i = 0;
        int j = 0;
        while (i < mS && j < nW) {
            if (s.charAt(i) != w.charAt(j)) {
                return false;
            }
            int countS = 0;
			// count number of consecutive equal characters
            while (i < mS && s.charAt(i) == s.charAt(i-countS)) {
                i++;
                countS++;
            }
            int countW = 0;
			// count number of consecutive equal characters
            while(j < nW && w.charAt(j) == w.charAt(j-countW)) {
                j++;
                countW++;
            }
            if (countS == countW) {
			    // equal number of characters so no need to strech the word
                continue;
            }
            if (countS < countW || countS < 3) {
                // number of characters in cw are more so can't extend
                // since cs > cw and cs < 3 so if we extend word, it has to
                // be minumum of 3 length which S is not so can't extend
                return false;
            }
        }
        return i >= mS && j >= nW;
    }

	/*
	 *
	 //another try, I think I was tired with this problem
    public int expressiveWords(String original, String[] words) {
    	List<Integer> counter = getCounter(original);

    	int total = 0;
    	for (String s : words) {
    		if (isStretchy(original, s, counter)) {
    			total++;
    		}
    	}
    	
    	return total;
    }
    
    private boolean isStretchy(String original, String word, List<Integer> counter) {

    	int i=0; //for word
    	int j=0; //for original
    	int z=0; //for counter
    	while (j < original.length() && i < word.length()) {
    		char c = word.charAt(i);
    		if (c != original.charAt(j)) {
    			return false;
    		}
    		
    		if (z<counter.size() && counter.get(z) >= 3) {
    			int val = counter.get(z);
    			int tem = 1;
    			while(tem < val) {
    	    		if (j < original.length() && c != original.charAt(j)) {
    	    			return false;
    	    		}
    	    		tem++;
    	    		j++;
    			}
    		} else if (z<counter.size() && counter.get(z) > 1) {
    			int val = counter.get(z);
    			int tem = 1;
    			while(tem < val) {
    				if (c != original.charAt(j)) {
    	    			return false;
    	    		}
    	    		tem++;
    	    		j++;
    	    		i++;
    			}
    			
    		}
    		
    		i++;
    		j++;
    		z++;
    	}

    	return original.length() == j && word.length() == i;
    }*/

    private List<Integer> getCounter(String word) {
    	List<Integer> counter = new ArrayList<>();
    	
    	if (word.length() == 0) return counter;
    	
    	int count = 1;
    	for (int i=1; i<word.length(); i++) {
    		if (word.charAt(i - 1) == word.charAt(i)) {
    			count++;
    			continue;
    		}
    		
    		counter.add(count);
    		count = 1;
    	}
    	counter.add(count);

    	return counter;
    }
	
	/*
	//this is my first solution and it is wrong
    public int expressiveWords(String word, String[] words) {
    	Map<Character, Integer> groups = getGroups(word);
    	
    	int total = 0;
    	for (String s : words) {
    		if (isStretchy(word, s, new HashMap(groups))) {
    			total++;
    		}
    	}

    	return total;
    }
    
    private boolean isStretchy(String original, String word, Map<Character, Integer> groups) {

    	int i=0; //for word
    	int j=0; //for original
    	while (j < original.length() && i < word.length()) {
    		char c = word.charAt(i);
    		if (c != original.charAt(j)) {
    			return false;
    		}
    		
    		if (groups.containsKey(c) && groups.get(c) > 0) {
    			while(j + 1 < original.length() && original.charAt(j + 1) == c) {
    				j++;
    			}
    			while(i + 1 < word.length() && word.charAt(i + 1) == c) {
    				i++;
    			}
    			groups.put(c, groups.get(c) - 1);
    		}
    		i++;
    		j++;
    	}

    	return original.length() == j && word.length() == i;
    }
    
    private Map<Character, Integer> getGroups(String s) {
    	Map<Character, Integer> groups = new HashMap<>();
    	
    	int count = 1;
    	char c = ' ';
    	for (int i=1; i<s.length(); i++) {
    		c = s.charAt(i-1);
    		if (s.charAt(i) == c) {
    			count++;
    			continue;
    		}
    		
    		if (count >= 3) {
    			if (!groups.containsKey(c)) {
    				groups.put(c, 0);
    			}
    			groups.put(c, groups.get(c) + 1);
    		}

    		count = 1;
    		
    	}
    	
		if (count >= 3) {
			if (!groups.containsKey(c)) {
				groups.put(c, 0);
			}
			groups.put(c, groups.get(c) + 1);
		}

		return groups;
    }
    */
}