package cei37.linkedList;

import java.util.HashMap;
import java.util.Map;


public class LinkedListCycleII {

	public static void main(String[] args) {
		/*ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next = new ListNode(7);
		node.next.next.next.next.next.next.next = new ListNode(8);
		node.next.next.next.next.next.next.next.next = new ListNode(9);
		node.next.next.next.next.next.next.next.next.next = new ListNode(10);
		node.next.next.next.next.next.next.next.next.next.next = node.next;*/
		
		ListNode node = new ListNode(3);
		node.next = new ListNode(2);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(-4);
		node.next.next.next.next = node.next;
		
		LinkedListCycleII l = new LinkedListCycleII();
		System.out.println(l.detectCycle(node));

	}

    private ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
    

    public ListNode detectCycle_2(ListNode head) {
    	if (head == null) return null;
    	
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while(slow != null && fast != null && slow != fast) {
    		slow = slow.next;
    		if (fast.next != null)
    			fast = fast.next.next;
    		else 
    			fast = fast.next;
    	}
    	if (slow == fast) return slow;
    	
    	return null;
    }
    
    public ListNode detectCycle_1(ListNode head) {
    	Map<ListNode, Integer> hash = new HashMap<>();
    	int i=0;
    	while(head != null) {
    		if (hash.containsKey(head)) {
    			return head;
    		}
    		hash.put(head, i++);
    		head = head.next;
    	}
        return null;
    }
    
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
		
		public String toString() {
			return String.valueOf(val);
		}
	}
}