package cei37.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.List;

/*
 * 1086. High Five

Given a list of scores of different students, return the average score of each student's 
top five scores in the order of each student's id.

Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  
The average score is calculated using integer division.

 

Example 1:

Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation: 
The average of the student with id = 1 is 87.
The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 

Note:

1 <= items.length <= 1000
items[i].length == 2
The IDs of the students is between 1 to 1000
The score of the students is between 1 to 100
For each student, there are at least 5 scores

 */
public class HighFive {

	public static void main(String[] args) {
		HighFive hf = new HighFive();

		int[][] items = new int[][] {
			{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}
		};
		
		int[][] list = hf.highFive(items);
		for (int[] student : list) {
			System.out.println(student[0] + " --> " + student[1]);
		}
		
	}

	@SuppressWarnings("serial")
	public int[][] highFive(int[][] items) {
    	if (items == null || items.length == 0) return new int[0][0];
    	
    	Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
    	
    	for (int student[] : items) {
    		if (map.get(student[0]) != null) {
    			map.get(student[0]).add(student[1]);
    			if (map.get(student[0]).size() > 5) {
    				map.get(student[0]).poll();
    			}
    		} else {
    			map.put(student[0], new PriorityQueue<Integer>() {{
    				add(student[1]);
    			}});
    		}
    	}
    	
    	int[][] result = new int[map.size()][2];
    	
    	int i = 0;
    	for (Map.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()) {
    		result[i][0] = e.getKey();
    		int max = 0;
    		int j = 0;
    		while(j < 5 && !e.getValue().isEmpty()) {
    			max += e.getValue().poll();
    			j++;
    		}
    		result[i][1] = (int)max/5;
    		i++;
    	}
    	
    	return result;
    }
	
    public int[][] highFiveComparator(int[][] items) {
    	if (items == null || items.length == 0) return new int[0][0];
    	
    	Comparator<int[]> comp = new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				} else {
					return o1[0] - o2[0];
				}
			}
    	};
    	Arrays.sort(items, comp);
    	
    	List<int[]> list = new ArrayList<int[]>();
    	
    	int sum = 0, count = 0;
    	for (int i=0; i<items.length; i++) {
    		sum += items[i][1];
    		count++;
    		
    		if (count == 5) {
    			list.add(new int[] { items[i][0], sum/5 });
    			count = 0;
    			sum = 0;
    			while(i + 1 < items.length && items[i][0] == items[i + 1][0] ) {
    				i++;
    			}
    		}
    	}
    	
    	return list.stream().toArray(int[][] ::new);
    }
}
