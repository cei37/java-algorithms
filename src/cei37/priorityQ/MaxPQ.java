package cei37.priorityQ;

/*
 * In computer science, a priority queue is an abstract data type which is 
 * like a regular queue or stack data structure, but where additionally 
 * each element has a "priority" associated with it. In a priority queue, 
 * an element with high priority is served before an element with low priority. 
 * If two elements have the same priority, they are served according to their 
 * order in the queue.

	While priority queues are often implemented with heaps, they are conceptually 
	distinct from heaps. A priority queue is an abstract concept like "a list" or "a map"; 
	just as a list can be implemented with a linked list or an array, a priority queue 
	can be implemented with a heap or a variety of other methods such as an unordered array.
 */
public class MaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N;
	
	public MaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity+1];
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public void insert(Key key) {
		pq[++N] = key;
		swim(N);
	}
	
	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N+1] = null;
		return max;
	}
	
	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			exch(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while(2*k <= N) {
			int j = 2*k;
			if (j < N && less(j, j+1)) {
				j++;
			}
			if (!less(k,j)) {
				break;
			}
			exch(k,j);
			k = j;
		}
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	public static void main(String[] args) {
		MaxPQ<Integer> pq = new MaxPQ<Integer>(10);
		pq.insert(10);
		pq.insert(5);
		pq.insert(4);
		pq.insert(8);
		pq.insert(15);
		pq.insert(3);
		
		
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
	}

}
