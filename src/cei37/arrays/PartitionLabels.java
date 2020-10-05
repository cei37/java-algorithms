package cei37.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 763. Partition Labels
A string S of lowercase English letters is given. We want to partition this string into as 
many parts as possible so that each letter appears in at most one part, and return 
a list of integers representing the size of these parts.

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.

 */
public class PartitionLabels {

	public static void main(String[] args) {
		PartitionLabels pl = new PartitionLabels();
		String str = "ababcbacadefegdehijhklij";
		
		for (Integer num : pl.partitionLabels(str)) {
			System.out.println(num);
		}
	}

    public List<Integer> partitionLabels(String s) {
    	List<Integer> result = new ArrayList<>();

    	if (s == null || s.trim().length() == 0) return result;

    	Map<Character, Integer> map = new HashMap<>();
    	for (char c : s.toCharArray()) {
    		int total = map.getOrDefault(c, 0) + 1;
    		map.put(c, total);
    	}

    	Set<Character> set = new HashSet<>();
    	int start = 0;
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if (map.get(c) > 0) {
    			map.put(c, map.get(c) - 1);
    			if (map.get(c) > 0)
    				set.add(c);
    			else
    				set.remove(c);
    		} else {
    			set.remove(c);
    		}

    		if (set.isEmpty()) {
    			result.add(i - start + 1);
    			start = i + 1;
    		}
    	}

    	return result;
    }
}
