package cei37.linkedList;

import java.util.HashMap;
import java.util.Map;

/*
 * 138. Copy List with Random Pointer
Medium

4046

734

Add to List

Share
A linked list is given such that each node contains an additional random pointer which 
could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented 
as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null 
if it does not point to any node.
 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
Example 4:

Input: head = []
Output: []
Explanation: Given linked list is empty (null pointer), so return null.
 

Constraints:

-10000 <= Node.val <= 10000
Node.random is null or pointing to a node in the linked list.
The number of nodes will not exceed 1000.

 */
public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		Node node7 = new Node(7);
		Node node13 = new Node(13);
		Node node11 = new Node(11);
		Node node10 = new Node(10);
		Node node1 = new Node(1);
		
		node7.next = node13;
		
		node13.next = node11;
		node13.random = node7;
		
		node11.next = node10;
		node11.random = node1;
		
		node10.next = node1;
		node10.random = node11;
		
		node1.random = node7;
		
		print(node7);
		CopyListWithRandomPointer c = new CopyListWithRandomPointer();
		
		System.out.println("##############");
		print(c.copyRandomList(node7));

	}

    public Node copyRandomList(Node head) {
    	if (head == null) return null;
    	Map<Node, Node> m = new HashMap<>();
    	Node oldNode = head;
    	
    	Node newNode = new Node(oldNode.val);
    	m.put(oldNode, newNode);
    	while(oldNode != null) {
    		newNode.random = clonedNode(oldNode.random, m);
    		newNode.next = clonedNode(oldNode.next, m);
    		
    		newNode = newNode.next;
    		oldNode = oldNode.next;
    	}

        return m.get(head);
    }
    
	public Node clonedNode(Node node, Map<Node, Node> map) {
		if (node != null) {
			if (map.containsKey(node)) {
				return map.get(node);
			} else {
				map.put(node, new Node(node.val));
				return map.get(node);
			}
		}
		return null;
	}
    
    public static void print(Node node) {
    	StringBuffer sb = new StringBuffer();
    	while(node != null) {
    		String adress = node.toString().replaceAll("cei37\\.linkedList\\.CopyListWithRandomPointer\\$Node\\@", "");
    		sb.append(node.val).append("[").append(adress).append("]").append(" --> ");
    		if (node.random != null) {
    			adress = node.random.toString().replaceAll("cei37\\.linkedList\\.CopyListWithRandomPointer\\$Node\\@", "");
    			sb.append(node.random.val).append("[").append(adress).append("]");
    		}
    		sb.append("\n");
    		node = node.next;
    	}
    	System.out.println(sb);
    }

	static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
}
