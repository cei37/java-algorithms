package cei37.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 451. Sort Characters By Frequency

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

 */
public class SortCharactersByFrequency {

	public static void main(String[] args) {
		
		String[] words = new String[] {
			"tree",
			"cccaaa",
			"Aabb"
		};
		
		SortCharactersByFrequency sc = new SortCharactersByFrequency();
		for (String s : words)
			System.out.println(sc.frequencySort(s));
	}

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Data> list = new ArrayList<Data>();
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
        	list.add(new Data(e.getKey(), e.getValue()));
        }
        
        Collections.sort(list, new Comparator<Data>() {
			public int compare(Data o1, Data o2) {
				return o2.num - o1.num;
			}
        });
        
        StringBuilder sb = new StringBuilder();
        for (Data d : list) {
        	for (int i=0; i<d.num; i++) {
        		sb.append(d.c);
        	}
        }
        
    	return sb.toString();
    }
    
    class Data {
    	char c;
    	int num;
    	public Data(char c, int num) {
    		this.c = c;
    		this.num = num;
    	}
    }
}
