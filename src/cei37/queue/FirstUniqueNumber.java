package cei37.queue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * 1429. First Unique Number

You have a queue of integers, you need to retrieve the first unique integer in the queue.

Implement the FirstUnique class:

FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no 
such integer.
void add(int value) insert value to the queue.
 

Example 1:

Input: 
["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
[[[2,3,5]],[],[5],[],[2],[],[3],[]]
Output: 
[null,2,null,2,null,3,null,-1]
Explanation: 
FirstUnique firstUnique = new FirstUnique([2,3,5]);
firstUnique.showFirstUnique(); // return 2
firstUnique.add(5);            // the queue is now [2,3,5,5]
firstUnique.showFirstUnique(); // return 2
firstUnique.add(2);            // the queue is now [2,3,5,5,2]
firstUnique.showFirstUnique(); // return 3
firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
firstUnique.showFirstUnique(); // return -1
Example 2:

Input: 
["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
[[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
Output: 
[null,-1,null,null,null,null,null,17]
Explanation: 
FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
firstUnique.showFirstUnique(); // return -1
firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
firstUnique.showFirstUnique(); // return 17
Example 3:

Input: 
["FirstUnique","showFirstUnique","add","showFirstUnique"]
[[[809]],[],[809],[]]
Output: 
[null,809,null,-1]
Explanation: 
FirstUnique firstUnique = new FirstUnique([809]);
firstUnique.showFirstUnique(); // return 809
firstUnique.add(809);          // the queue is now [809,809]
firstUnique.showFirstUnique(); // return -1
 

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^8
1 <= value <= 10^8
At most 50000 calls will be made to showFirstUnique and add.

 */
public class FirstUniqueNumber {

	public static void main(String[] args) {
		int[] nums = new int[] {
			2,3,5
		};
		
		FirstUniqueNumber firstUnique = new FirstUniqueNumber(nums);

		firstUnique.showFirstUnique(); // return 2
		firstUnique.add(5);            // the queue is now [2,3,5,5]
		firstUnique.showFirstUnique(); // return 2
		firstUnique.add(2);            // the queue is now [2,3,5,5,2]
		firstUnique.showFirstUnique(); // return 3
		firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
		firstUnique.showFirstUnique(); // return -1

	}
	
	Set<Integer> queue = new LinkedHashSet<Integer>();
	HashMap<Integer, Boolean> unique = new HashMap<>(); 
    public FirstUniqueNumber(int[] nums) {
        for (int n : nums) {
        	add(n);
        }
    }

    public int showFirstUnique() {
    	
    	
        if (!queue.isEmpty()) {
        	int num = queue.iterator().next();
        	System.out.println(num);
        	return num;
        }
        System.out.println(-1);
        return -1;
    }
    
    public void add(int value) {
    	if (unique.containsKey(value) ) {
    		unique.put(value, false);
    		queue.remove(value);
    	} else {
    		queue.add(value);
    		unique.put(value, true);
    	}
    }

	/*
	Queue<Integer> queue = new LinkedList<Integer>();
	HashMap<Integer, Boolean> unique = new HashMap<>(); 
    public FirstUniqueNumber(int[] nums) {
        for (int n : nums) {
        	add(n);
        }
    }

    public int showFirstUnique() {
    	
    	while(!queue.isEmpty() && !unique.get(queue.peek())) {
    		queue.poll();
    	}
    	
        if (!queue.isEmpty()) {
        	System.out.println(queue.peek());
        	return queue.peek();
        }
        System.out.println(-1);
        return -1;
    }
    
    public void add(int value) {
    	if (unique.containsKey(value) ) {
    		unique.put(value, false);
    	} else {
    		queue.offer(value);
    		unique.put(value, true);
    	}
    }
    */
}
