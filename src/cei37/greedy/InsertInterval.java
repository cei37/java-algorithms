package cei37.greedy;

import java.util.ArrayList;
import java.util.List;

/*
 * 57. Insert Interval
Medium

2296

222

Add to List

Share
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
Example 3:

Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]
Example 4:

Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]
Example 5:

Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= intervals[i][0] <= intervals[i][1] <= 105
intervals is sorted by intervals[i][0] in ascending order.
newInterval.length == 2
0 <= newInterval[0] <= newInterval[1] <= 105

1, 2, 3, 4, 5, 6, 7
7, 6, 3, 4, 5, 2, 1
7, 6, 5, 4, 3, 1, 2
 
k2

 */
public class InsertInterval {

	public static void main(String[] args) {
		InsertInterval in = new InsertInterval();
		int[][] intervals = new int[][] {
			{3, 5},
			{12, 15},
		};
		int[] newInterval = new int[] {
			6,6
		};
		
		for (int[] res : in.insert(intervals, newInterval)) {
			System.out.println(res[0] + ", " + res[1]);
		}
	}

    public int[][] insert(int[][] intervals, int[] newInterval) {
    	if (intervals == null || intervals.length == 0) return new int[][] { newInterval };
    	List<int[]> res = new ArrayList<>();
    	int addNewInterval = newInterval[1] < intervals[0][0] ? 0 : 1;
    	if (addNewInterval == 0) {
    		res.add(newInterval);
    	} else {
    		res.add(intervals[0]);
    	}

    	boolean mergedNewIn = false;
    	for (int i=addNewInterval; i<intervals.length; i++) {
    		int[] tem = res.get(res.size()-1);

    		//here we are checking intersections for the new interval
    		if (!mergedNewIn && isIntersection(tem, newInterval)) {
				res.remove(res.size()-1);
				res.add(getIntersection(tem, newInterval));
				tem = res.get(res.size()-1);
				mergedNewIn = true;
    		}

        	if (!mergedNewIn && newInterval[0] > tem[1] && newInterval[1] < intervals[i][0]) {
        		res.add(newInterval);
        		mergedNewIn = true;
        	}

    		//here we are checking intersections for intervals
    		insertInterval(res, tem, intervals[i]);
    	}

    	//just in case the new interval was not added to the result list
    	if (!mergedNewIn) {
    		insertInterval(res, res.get(res.size()-1), newInterval);
    	}

    	int[][] out = new int[res.size()][];
    	for (int i=0; i<res.size(); i++) {
    		out[i] = res.get(i);
    	}
    	return out;
    }
    
    public boolean isIntersection(int[] a, int[] b) {
    	return a[1] >= b[0];
    }
    
    public int[] getIntersection(int[] a, int[] b) {
    	return new int[] { Math.min(a[0], b[0]), Math.max(a[1], b[1]) };
    }
    
    public void insertInterval(List<int[]> res, int tem[], int[] interval) {
		if (isIntersection(tem, interval)) {
			res.remove(res.size()-1);
			res.add(getIntersection(tem, interval));
		} else {
			res.add(interval);
		}
    }
}