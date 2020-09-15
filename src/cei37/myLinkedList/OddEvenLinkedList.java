package cei37.myLinkedList;

/*
 *   Odd Even Linked List
Solution
Given a singly linked list, group all odd nodes together followed by the even nodes. 
Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity 
and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

Constraints:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
The length of the linked list is between [0, 10^4].
 */

public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddEvenLinkedList oe = new OddEvenLinkedList();
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.addNode(new Node<Integer>(7));
		list.addNode(new Node<Integer>(4));
		list.addNode(new Node<Integer>(6));
		list.addNode(new Node<Integer>(5));
		list.addNode(new Node<Integer>(3));
		list.addNode(new Node<Integer>(1));
		list.addNode(new Node<Integer>(2));

		Node<Integer> node = oe.oddEvenList2(list.head);
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

    public Node<Integer> oddEvenList(Node<Integer> head) {
    	//this is to handle the worst case scenario
    	if (head == null) return null;
    	
    	Node<Integer> odd = head; //this is the node to return back
    	Node<Integer> even = head.next; //this is the node that should be connected to the odd temNode
    	
    	Node<Integer> temOdd = odd;
    	Node<Integer> temEven = even;
    	
    	boolean isOdd = true;
    	if (head.next != null) {
    		head = head.next.next;
    	}
    	
    	while(head != null && temOdd != null && temEven != null) {
    		if (isOdd) {
    			temOdd.next = head;
    			temOdd = temOdd.next;
    			isOdd = false;
    		} else {
    			temEven.next = head;
    			temEven = temEven.next;
    			isOdd = true;
    		}
    		head = head.next;
    	}
    	if (temEven != null)
    		temEven.next = null; //this will handle the odd case infinity loop
    	temOdd.next = even;
    	return odd;
    }
    
    public Node<Integer> oddEvenList2(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
