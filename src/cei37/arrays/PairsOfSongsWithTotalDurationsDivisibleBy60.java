package cei37.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * 1010. Pairs of Songs With Total Durations Divisible by 60

In a list of songs, the i-th song has a duration of time[i] seconds. 

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  
Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 

Note:

1 <= time.length <= 60000
1 <= time[i] <= 500
*/

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

	public static void main(String[] args) {
		int n[] = new int[] {
			30,20,150,100,40
		//  30,20,30 ,40 ,40
		};
		PairsOfSongsWithTotalDurationsDivisibleBy60 p = new PairsOfSongsWithTotalDurationsDivisibleBy60();
		
		System.out.println(p.numPairsDivisibleBy60(n));
	}
	
	
	
	public int numPairsDivisibleBy60(int[] time) {
    	int res = 0;
    	for (int i=0; i<time.length; i++) {
    		time[i] = time[i] % 60;
    	}
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i=0; i<time.length; i++) {
    		int t = time[i];
    		int n = (60 - t) % 60;
    		if (map.containsKey(n)) {
    			res += map.get(n);
    		}
    		map.put(t, map.getOrDefault(t, 0) + 1);
    	}

    	return res;
    }

	//brute force
    public int numPairsDivisibleBy60_1(int[] time) {
    	int num = 0;
    	for (int i=0; i<time.length; i++) {
    		for (int j=i+1; j<time.length; j++) {
        		if ((time[i] + time[j]) % 60 == 0 ) {
        			num++;
        		}
        	}
    	}
    	return num;
    }
}