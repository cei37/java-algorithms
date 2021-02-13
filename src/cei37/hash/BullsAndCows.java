package cei37.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/*
 * 299. Bulls and Cows

You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your 
friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but 
are located in the wrong position. Specifically, the non-bull digits in the guess that 
could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your 
friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number 
of cows. Note that both secret and guess may contain duplicate digits.

 

Example 1:

Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"
Example 2:

Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
Example 3:

Input: secret = "1", guess = "0"
Output: "0A0B"
Example 4:

Input: secret = "1", guess = "1"
Output: "1A0B"
 

Constraints:

1 <= secret.length, guess.length <= 1000
secret.length == guess.length
secret and guess consist of digits only.

 */
public class BullsAndCows {

	public static void main(String[] args) {
		BullsAndCows bc = new BullsAndCows();
		String[][] data = new String[][] {
			{"11", "10", "1A0B"},
			{"1122", "2211", "0A4B"},
			{"1807", "7810", "1A3B"},
			{"1123", "0111", "1A1B"},
			{"1", "0", "0A0B"},
			{"1", "1", "1A0B"},
		};
		
		for (String[] str : data) {
			String res = bc.getHint(str[0], str[1]);
			System.out.println("Secret: " + str[0] + "\t\tGuess: " + str[1] + "\t\tRes: " + res + "\t\tExp: " + str[2] + "\t\tOK?: " + res.equals(str[2]));
		}
	}
	
    public String getHint(String secret, String guess) {
    	if (secret == null || secret.length() == 0 || guess == null ||
    			guess.length() == 0 || guess.length() != secret.length()) {
    		return "";
    	}

    	int bulls = 0;
    	int cows = 0;
    	int[] counter = new int[10];
    	
    	for (int i=0; i<secret.length(); i++) {
    		if (secret.charAt(i) == guess.charAt(i)) {
    			bulls++;
    		} else {
    			counter[secret.charAt(i) - '0']++;
    		}
    	}
    	
    	for (int i=0; i<guess.length(); i++) {
    		int pos = guess.charAt(i) - '0';
    		if (secret.charAt(i) != guess.charAt(i) && counter[pos] > 0) {
    			cows++;
    			counter[pos]--;
    		}
    	}

    	StringBuilder res = new StringBuilder();
    	res.append(bulls).append("A").append(cows).append("B");

    	return res.toString();
    }
}
