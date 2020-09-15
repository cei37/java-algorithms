package cei37.myLinkedList;

public class LinkedList<T> {
	
	Node<T> head;
	int size = 0;
	
	public LinkedList() { }
	
	public void addNode(Node<T> data) {
		if (head == null) {
			head = data;
		} else {
			data.next = head;
			head = data;
		}
		size++;
	}
	
	public void display() {
		Node<T> current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("");
	}
	
	public int size() {
		return size;
	}
	
	public boolean delete() {
		if (head != null) {
			head = head.next;
			size--;
			return true;
		}
		return false;
	}
	
	
	public Node<T> search(T value) {
		Node<T> current = head;
		while(current != null) {
			if (current.data == value ) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public boolean insertNode(Node<T> data, int index) {
		if (index == 0) {
			addNode(data);
			return true;
		} else if (index < size) {
			Node<T> current = head;
			int i = 1;
			while(index != i) {
				current = current.next;
				i++;
			}
			
			Node<T> tem = current.next;
			current.next = data;
			data.next = tem;
			size++;

			return true;
		}
		return false;
	}
	
	public boolean deleteAt(int index) {
		if (index > size) return false;
		
		Node<T> current = head;
		if (index == 0) {
			delete();
			return true;
		}
		
		for (int i=1; i < index; i++) 
			current = current.next;
		
		if (current.next != null && current.next.next!=null)
			current.next = current.next.next;
		else
			current.next = null;

		size--;
		return true;
	}
	
	public void rotate() {
		Node<T> current = head;
		Node<T> previous = null;
		Node<T> next = null;
		while(current!=null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addNode(new Node<Integer>(5));
		list.addNode(new Node<Integer>(6));
		list.addNode(new Node<Integer>(7));
		list.addNode(new Node<Integer>(8));
		list.addNode(new Node<Integer>(9));
		
		list.display();
		System.out.println("After a search...");
		System.out.println(list.search(7));
		
		
		System.out.println("After a delete...");
		System.out.println(list.delete());
		list.display();
		
		System.out.println("After an insert...");
		list.insertNode(new Node<Integer>(3), 0);
		list.insertNode(new Node<Integer>(4), 1);
		list.insertNode(new Node<Integer>(13), 4);
		list.display();
		
		System.out.println("After deteleAt...");
		list.deleteAt(5);
		list.display();
		
		System.out.println("After rotate...");
		list.rotate();
		list.display();
		
	}
}

class Node<T> {
	T data;
	Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
	public String toString() {
		return String.valueOf(data);
	}
}