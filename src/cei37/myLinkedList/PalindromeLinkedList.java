package cei37.myLinkedList;

import java.util.Stack;

/*
 * Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		PalindromeLinkedList p = new PalindromeLinkedList();
		LinkedList<Integer> list = new LinkedList();
		list.addNode(new Node<Integer>(1));
		list.addNode(new Node<Integer>(1));
		//list.addNode(new Node<Integer>(5));
		//list.addNode(new Node<Integer>(2));
		//list.addNode(new Node<Integer>(1));
		
		System.out.println(p.isPalindrome(list.head));
	}

    public boolean isPalindrome(Node<Integer> head) {
        Stack<Integer> stack = new Stack<>();
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        
        //if the list is empty, let's assume it is a palindrome
        if (head == null) return true;
        boolean odd = false;
        while(slow != null) {
        	if (fast == null) {
        		//if the list is odd, let's remove the first element from the stack,
        		//it is the element in the middle of the list.
        		if (odd) {
        			stack.pop();
        			odd = false;
        		}
        		//we have reach the end, let's start comparing each half
        		if (stack.pop() != slow.data) {
        			return false;
        		}
        		slow = slow.next;
        	} else {
        		//we are going to iterate the list in a normal way till reach the end
        		//using the fast pointer and slow pointer to the middle
        		stack.add(slow.data);
        		slow = slow.next;
        		if (fast.next != null)
        			fast = fast.next.next;
        		else {
        			fast = null;
        			odd = true;
        		}
        	}
        }
        if (odd) {
			stack.pop();
		}
    	return stack.isEmpty();
    }
}
