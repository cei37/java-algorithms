package cei37.string;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 767. Reorganize String

Given a string S, check if the letters can be rearranged so that two characters 
that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

krktktkwkrkzkakpkqk
krkrktktkakpkqkwkzk

aaabcae
abacaea

S will consist of lowercase letters and have length in range [1, 500].
 */
public class ReorganizeString {

	public static void main(String[] args) {
		ReorganizeString re = new ReorganizeString();
		String s = "abcaa";
		//String s = "aaabcae";
		//String s = "aab";
		//String s = "aaab";
		//String s = "kkkkzrkatkwpkkkktrq";
		System.out.println(re.reorganizeString(s));
	}

	/*
	 * My second solution after seeing some examples
	 */
	public String reorganizeString(String s) {
    	if (s == null || s.length() == 0) return "";
    	
    	//create array for character counter
    	int arr[] = new int[26];
    	for (int i=0; i<s.length(); i++) {
    		arr[s.charAt(i) - 'a']++;
    	}


    	Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

    	for (int i=0; i<arr.length; i++) {
    		if (arr[i] != 0) {
    			pq.offer(new int[] { i, arr[i] });
    		}
    	}
    	
    	if (pq.peek()[1] > (s.length() + 1) / 2) {
    		return "";
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	int[] tem = new int[] {-1, -1};
    	while(!pq.isEmpty()) {
    		int cur[] = pq.poll();
    		if (tem[1] > 0) {
    			pq.offer(tem);
    		}
    		if (cur[1] > 0) {
    			sb.append((char)(cur[0] + 'a'));
    			cur[1]--;
    		}
    		tem = cur;
    	}
    	
    	if (tem[1] > 0) {
    		return "";
    	}
    	
    	return sb.toString();
    }

	/*
	 * This is my solution
	 */
    public String reorganizeString_1(String s) {
    	if (s == null || s.length() == 0) return "";
    	
    	//create array for character counter
    	int arr[] = new int[26];
    	for (int i=0; i<s.length(); i++) {
    		arr[s.charAt(i) - 'a']++;
    	}


    	Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    	for (int i=0; i<arr.length; i++) {
    		if (arr[i] != 0) {
    			pq.offer(new int[] { i, arr[i] });
    		}
    	}
    	
    	if (pq.peek()[1] > (s.length() + 1) / 2) {
    		return "";
    	}
    	
    	StringBuilder sb = new StringBuilder();

    	while(!pq.isEmpty()) {

    		int eleA[] = pq.poll();
    		char c = (char)(eleA[0] + 'a');
    		if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
    			return "";
    		}
    		sb.append(c);
    		eleA[1]--;
    		
    		int eleB[] = new int[] {0, 0};
    		if (!pq.isEmpty()) {
        		eleB = pq.poll();
        		c = (char)(eleB[0] + 'a');
        		if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
        			return "";
        		}
        		sb.append(c);
        		eleB[1]--;
    		}
    		
    		if (eleA[1] > 0) {
    			pq.offer(eleA);
    		}

    		if (eleB[1] > 0) {
    			pq.offer(eleB);
    		}
    	}
    	
    	return sb.toString();
    }
}
