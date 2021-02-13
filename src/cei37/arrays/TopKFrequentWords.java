package cei37.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 692. Top K Frequent Words

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, 
then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrequentWords {

	public static void main(String[] args) {
		TopKFrequentWords tfw = new TopKFrequentWords();
		String[] words = new String[] {
				"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
		};
		int k = 4;

		for (String str : tfw.topKFrequent(words, k)) {
			System.out.println(str);
		}
	}

    public List<String> topKFrequent(String[] words, int k) {
    	List<String> res = new ArrayList<String>();
    	if (words == null || words.length == 0 || k == 0) return res;
    	
    	Map<String, Integer> map = new HashMap<>();
    	for (String str : words) {
    		if (map.containsKey(str)) {
    			map.put(str, map.get(str) + 1);
    		} else {
    			map.put(str, 1);
    		}
    	}

    	Queue<Data> pq = new PriorityQueue<Data>(new Comparator<Data>() {
    		public int compare(Data d1, Data d2) {
    			if (d1.freq == d2.freq) {
    				return d2.word.compareTo(d1.word);
    			} else {
    				return d1.freq - d2.freq;
    			}
    		}
    	});

    	for (Map.Entry<String, Integer> e : map.entrySet()) {
    		pq.offer(new Data(e.getKey(), e.getValue()));
    		if (pq.size() > k) {
    			pq.poll();
    		}
    	}
    	
    	while(!pq.isEmpty()) {
    		res.add(0, pq.poll().word);
    	}
    	return res;
    }
    
    class Data {
    	String word;
    	int freq;
    	public Data(String word, int freq) {
    		this.word = word;
    		this.freq = freq;
    	}
    }
}
