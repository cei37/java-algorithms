package cei37.linkedList;

import java.util.PriorityQueue;

/*
  23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 
Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		//Input: lists = [[1,4,5],[1,3,4],[2,6]]
		//Output: [1,1,2,3,4,4,5,6]
		MergeKSortedLists mk = new MergeKSortedLists();

		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(5);
		
		ListNode list2 = new ListNode(2);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		
		ListNode list3 = new ListNode(2);
		list3.next = new ListNode(6);
		
		ListNode[] lists = new ListNode[] {
			list1, list2, list3
		};

		ListNode node = mk.mergeKLists(lists);
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}

	}

	//Priority Queue
	//4 ms
	public ListNode mergeKLists(ListNode[] lists) {
    	if (lists == null || lists.length == 0) return null;
    	PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
    	for (ListNode n : lists) {
    		if (n != null)
    			pq.offer(n);
    	}
    	
    	ListNode head = new ListNode(-1);
    	ListNode current = head;
    	while(!pq.isEmpty()) {
    		ListNode n = pq.poll();
    		current.next = n;
    		if (n.next != null) {
    			pq.offer(n.next);
    		}
    		current = current.next;
    	}
    	return head.next;
    }
	

	//Merge 2 list
	/*
	 * We can achieve the same idea via iteration by assuming that l1 is entirely 
	 * less than l2 and processing the elements one-by-one, inserting elements of 
	 * l2 in the necessary places in l1.
	 * 112 ms
	 */
    public ListNode mergeKLists_1(ListNode[] lists) {
    	if (lists == null || lists.length == 0) return null;
    	ListNode node1 = lists[0];
    	for (int i=1; i<lists.length; i++) {
    		node1 = mergeTwoList(node1, lists[i]);
    	}
    	return node1; 
    }
    
    public ListNode mergeTwoList(ListNode n1, ListNode n2) {
    	ListNode head = new ListNode(-1);
    	ListNode current = head;
    	
    	while(n1 != null && n2 != null) {
    		if (n1.val <= n2.val) {
    			current.next = n1;
    			n1 = n1.next;
    		} else {
    			current.next = n2;
    			n2 = n2.next;
    		}
    		current = current.next;
    	}
    	
    	if (n1 == null) {
    		current.next = n2;
    	} else if (n2 == null) {
    		current.next = n1;
    	}
    	
    	return head.next;
    }

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
