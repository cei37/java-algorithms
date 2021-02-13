package cei37.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
 * 347. Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.

 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		TopKFrequentElements top = new TopKFrequentElements();
		int nums[] = new int[] {
			1
		};
		int k = 2;
		
		for (int i : top.topKFrequent(nums, k))
			System.out.println(i);

	}

    public int[] topKFrequent(int[] nums, int k) {
    	
    	if (nums == null || nums.length == 0 || k == 0 || k > nums.length) return new int[0];
    	
    	int res[] = new int[k];
    	
    	Map<Integer, Integer> map = new HashMap<>();

    	for (int num : nums) {
    		map.put(num, map.getOrDefault(num, 1) + 1);
    	}

    	PriorityQueue<Data> pq = new PriorityQueue<Data>(new Comparator<Data>() {
			public int compare(Data o1, Data o2) {
				return o1.value - o2.value;
			}    		
    	});

    	for (Map.Entry<Integer, Integer> e : map.entrySet()) {
    		pq.offer(new Data(e.getKey(), e.getValue()));
    		
    		if (pq.size() > k) {
    			pq.poll();
    		}
    	}
    	
    	for (int i=k-1; i>=0; i--) {
    		res[i] = pq.poll().key;
    	}
    	
    	return res;
    }
    
    class Data {
    	int key;
    	int value;
    	public Data(int key, int value) {
    		this.key = key;
    		this.value = value;
    	}
    }
    
}
