package cei37.design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
 * 
 * 1094. Car Pooling
You are driving a vehicle that has capacity empty seats initially available for passengers.  
The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains 
information about the i-th trip: the number of passengers that must be picked up, and the l
ocations to pick them up and drop them off.  The locations are given as the number of 
kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for 
all the given trips. 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true

Constraints:

trips.length <= 1000
trips[i].length == 3
1 <= trips[i][0] <= 100
0 <= trips[i][1] < trips[i][2] <= 1000
1 <= capacity <= 100000

 */
public class CarPooling {

	public static void main(String[] args) {
		CarPooling cp = new CarPooling();
		/*int[][] trips = new int[][] {
			{3, 2, 7 },
			{8, 3, 9 },
			{3, 7, 9 },
		};*/
		
		int[][] trips = new int[][] {
			{2, 1, 5 },
			{3, 5, 7 },
		};
		int capacity = 3;
		
		System.out.println(cp.carPooling(trips, capacity));
	}
	
    public boolean carPooling(int[][] trips, int capacity) {
    	Map<Integer, Integer> map = new TreeMap<>();
    	
    	for (int[] trip : trips) {
    		int start = map.getOrDefault(trip[1], 0) + trip[0];
    		map.put(trip[1], start);
    		
    		int end = map.getOrDefault(trip[2], 0) - trip[0];
    		map.put(trip[2], end);
    	}

    	int pass = 0;
    	for (Map.Entry<Integer, Integer> en : map.entrySet()) {
    		pass += en.getValue();
    		if (pass > capacity) return false;
    	}
    	
    	return true;
    }
}
