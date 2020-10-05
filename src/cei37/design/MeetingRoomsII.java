package cei37.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 253. Meeting Rooms II
Given an array of meeting time intervals consisting of start and end 
times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
 */
public class MeetingRoomsII {

	public static void main(String[] args) {
		MeetingRoomsII mt = new MeetingRoomsII();
		int[][] intervals = new int[][] {
			{9,10},
			{4, 9},
			{4, 17},
		};
		System.out.println(mt.minMeetingRooms(intervals));
	}
	
    public int minMeetingRooms(int[][] intervals) {
    	
    	if (intervals == null || intervals.length == 0) return 0;
    	
    	Comparator<int[]> comp = new Comparator<int[]>() {
    		public int compare(int a[], int b[]) {
    			return a[0] - b[0];
    		}
    	};
    	Arrays.sort(intervals, comp);
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>() {
    		public int compare(Integer a, Integer b) {
    			return a - b;
    		}
    	});
    	
    	pq.add(intervals[0][1]);
    	
    	for (int i = 1; i<intervals.length; i++) {
    		if (intervals[i][0] >= pq.peek()) {
    			pq.poll();
    		}
    		pq.add(intervals[i][1]);
    	}
    	
    	return pq.size();
    }
    
    public int minMeetingRooms2(int[][] intervals) {
    	Comparator<int[]> comp = new Comparator<int[]>() {
    		public int compare(int a[], int b[]) {
    			return a[0] - b[0];
    		}
    	};
    	List<int[]> list = new ArrayList<>();
    	for (int[] a: intervals) {
    		list.add(a);
    	}

    	if (list.isEmpty()) return 0;
    	
    	Collections.sort(list, comp);
    	
    	int rooms = 1;

    	for (int i=0; i<list.size() - 1; i++) {
    		if (hasIntersection(list.get(i), list.get(i+1))) {
    			rooms++;
    		} 
    		
    		if (list.get(i)[0] >= list.get(i+1)[1]) {
    			rooms--;
    		}
    	}
    	
    	return rooms;
    }
    
    public boolean hasIntersection(int a[], int b[]) {
    	return a[0] < b[1] && b[0] < a[1];
    }
}