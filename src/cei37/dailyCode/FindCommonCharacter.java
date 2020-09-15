package cei37.dailyCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacter {
/*
	1002. Find Common Characters
	Given an array A of strings made only from lowercase letters, 
	return a list of all characters that show up in all strings within 
	the list (including duplicates).  For example, if a character occurs 
	3 times in all strings but not 4 times, you need to include that 
	character three times in the final answer.

	You may return the answer in any order.
*/			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] A = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
		//String[] A = {"bella","label","roller"};
		
		FindCommonCharacter fcc = new FindCommonCharacter();
		System.out.println(fcc.commonChars(A));
	}
	
    public List<String> commonChars(String[] A) {
        int[][] mat = new int[A.length][26];
        for (int i=0; i<A.length; i++) {
        	char[] arr = A[i].toCharArray();
        	for (char c : arr) {
        		mat[i][c-'a']++;
        	}
        }
        List<String> result = new ArrayList<String>();
        for (int i=0; i<26; i++) {
        	int min = Integer.MAX_VALUE;
        	for (int j=0; j<A.length; j++) {
        		if (mat[j][i] == 0) {
        			min = 0;
        			break;
        		}
        		min = Math.min(mat[j][i], min);
        	}
        	if (min > 0) {
        		for (int x=0; x<min; x++) {
        			result.add(String.valueOf((char)(i + 'a')));
        		}
        	}
        }
        return result;
    }

}
