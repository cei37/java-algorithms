package cei37.design;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 252. Meeting Rooms
 * 
Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
NOTE: input types have been changed on April 15, 2019. Please reset to default code 
definition to get new method signature.

 */
public class MeetingRooms {

	public static void main(String[] args) {
		MeetingRooms mr = new MeetingRooms();
		int[][] intervals = new int[][] {
			{5,  8},
			{6,  8},
		};
		System.out.println(mr.canAttendMeetings(intervals));
	}

    public boolean canAttendMeetings(int[][] intervals) {
       /*Arrays.sort(intervals, new Comparator<int[]>() {
    	   public int compare(int[] a, int[] b) {
    		   return a[0] - b[0];
    	   }
       });*/
    	
       Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

       for (int i=1; i<intervals.length; i++) {
    	   if (hasIntersection(intervals[i-1], intervals[i])) {
    		   return false;
    	   }
       }
       
       return true;
    }
    
    private boolean hasIntersection(int[] a, int b[]) {
    	return a[0] < b[1] && b[0] < a[1];
    }
}
