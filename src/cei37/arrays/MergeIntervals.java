package cei37.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 

Constraints:

intervals[i][0] <= intervals[i][1]
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Comparator<int[]> comp = new Comparator<int[]>() {
        	@Override
			public int compare(int[] o1, int[] o2) {
        		if (o1[0] > o2[0]) 
        			return 1;
        		if (o1[0] < o2[0]) 
        			return -1;
        		return 0;
			}
        };
        Arrays.sort(intervals, comp);

        List<int[]> res = new ArrayList<>();
        for (int i=0; i<intervals.length; i++) {
        	if (res.isEmpty() || !hasOverlaping(res.get(res.size()-1), intervals[i])) {
        		res.add(intervals[i]);
        	} else {
				res.get(res.size() - 1)[1] = Math.max(intervals[i][1], res.get(res.size() - 1)[1]);
        	}
        }
    	return res.toArray(new int[res.size()][]);
    }
    
    public boolean hasOverlaping(int a[], int b[]) {
    	return a[0] <= b[1] && b[0] <= a[1];
    }
    
	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		int[][] intervals = new int[][] {
			{1,4},
			{2,3},
			{4,6},
		};
		int res[][] = mi.merge(intervals);
		for (int []x: res) {
			for (int y : x) {
				System.out.print(y + ",");
			}
			System.out.println();
		}
	}

}
