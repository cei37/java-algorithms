package cei37.queue;

import java.util.LinkedList;
import java.util.Queue;

/*

346. Moving Average from Data Stream
Easy

773

83

Add to List

Share
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.
 

Example 1:

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 

Constraints:

1 <= size <= 1000
-105 <= val <= 105
At most 104 calls will be made to next.

 */
public class MovingAverageFromDataStream {

	public static void main(String[] args) {
		MovingAverage ma = new MovingAverage(20);
		
		System.out.println(ma.next(23249));System.out.println(ma.next(-17781));System.out.println(ma.next(16086));
		System.out.println(ma.next(29081));System.out.println(ma.next(4686));System.out.println(ma.next(6411));
		System.out.println(ma.next(19428));System.out.println(ma.next(-17740));System.out.println(ma.next(-23564));
		System.out.println(ma.next(-22063));System.out.println(ma.next(-3570));System.out.println(ma.next(15530));
		System.out.println(ma.next(27195));System.out.println(ma.next(12369));System.out.println(ma.next(4861));
		System.out.println(ma.next(-16436));System.out.println(ma.next(20578));System.out.println(ma.next(-30233));
		System.out.println(ma.next(7350));System.out.println(ma.next(-12937));System.out.println(ma.next(-26468));
		System.out.println(ma.next(7350));System.out.println(ma.next(-12937));System.out.println(ma.next(-26468));
	}

	static class MovingAverage {

	    /** Initialize your data structure here. */
		Queue<Integer> queue = null;
		int size;
		double sum;
	    public MovingAverage(int size) {
	        queue = new LinkedList<Integer>();
	        this.size = size;
	    }
	    
	    public double next(int val) {
	    	sum += val;
	    	queue.offer(val);
	    	if (queue.size() <= size) {
	    		return sum / queue.size();
	    	} else {
	    		sum -= queue.poll();
	    	}

	    	return sum / size;
	    }
	}
}
