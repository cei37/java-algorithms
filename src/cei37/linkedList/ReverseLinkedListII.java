package cei37.linkedList;

/*
 * 92. Reverse Linked List II
Medium

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {

	public static void main(String[] args) {
		ListNode node = new ListNode(3);
		node.next = new ListNode(5);
		//node.next.next = new ListNode(3);
		//node.next.next.next = new ListNode(4);
		//node.next.next.next.next = new ListNode(5);
		
		ReverseLinkedListII r = new ReverseLinkedListII();
		
		ListNode n = node;
		while(n != null) {
			System.out.println(n.val);
			n = n.next;
		}
		System.out.println("------------");
		ListNode res = r.reverseBetween(node, 1, 2);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (head == null) return null;
    	if (m == n) return head;
    	int mm = 1;
    	ListNode current = head;
    	ListNode prev = null;
    	
    	while(current != null && mm != m) {
    		prev = current;
    		current = current.next;
    		mm++;
    	}
    	
    	if (prev == null) {
    		return reverse(current, n, m);
    	} else {
    		prev.next = reverse(current, n, m);
    	}
    	return head;
    }
    
    public ListNode reverse(ListNode node, int n, int m) {
    	ListNode curr = node;
    	ListNode prev = null;
    	ListNode tail = null;
    	boolean b = true;
    	while(curr != null && b) {
    		if (m == n) {
    			b = false;
    		}
    		ListNode tem = curr.next;
    		curr.next = prev;
    		if (tail == null && prev != null) {
    			tail = prev;
    		}
    		prev = curr;
    		curr = tem;
    		m++;
    	}
    	if (tail != null)
    		tail.next = curr;
    	return prev;
    }
    
	static public class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}