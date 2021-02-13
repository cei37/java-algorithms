package cei37.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/*
 * 341. Flatten Nested List Iterator
Medium

1971

758

Add to List

Share
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
             
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

	public static void main(String[] args) {
		List<NestedInteger> list = new ArrayList<>();
		list.add(new MyNestedInteger(1));
		list.add(new MyNestedInteger(2));
		list.add(null);
		list.add(new MyNestedInteger(3));
		list.add(new MyNestedInteger(4));
		
		List<NestedInteger> list1 = new ArrayList<NestedInteger>();
		list1.add(new MyNestedInteger(6));
		list1.add(new MyNestedInteger(7));
		list1.add(new MyNestedInteger(8));
		
		List<NestedInteger> list2 = new ArrayList<NestedInteger>();
		list2.add(new MyNestedInteger(9));
		list2.add(null);
		list2.add(new MyNestedInteger(10));
		
		list1.add(new MyNestedInteger(list2));
		list1.add(null);
		list1.add(new MyNestedInteger(11));
		
		List<NestedInteger> list3 = new ArrayList<NestedInteger>();
		
		List<NestedInteger> list4 = new ArrayList<NestedInteger>();
		list4.add(new MyNestedInteger(12));
		
		list.add(new MyNestedInteger(list1));
		list.add(new MyNestedInteger(list3));
		list.add(new MyNestedInteger(list4));

		 FlattenNestedListIterator i = new FlattenNestedListIterator(list);
		 while (i.hasNext()) {
			 System.out.println(i.next());
		 }

	}

	List<NestedInteger> nestedList;
	Iterator<NestedInteger> it;
	Stack<Iterator<NestedInteger>> stack = new Stack<>();
	
	Integer returnValue = null;

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		this.nestedList = nestedList;
		it = this.nestedList.iterator();
	}

	public boolean myHasNext() {
		if (it.hasNext()) {
			return true;
		} else if (stack.isEmpty()){
			return false;
		}
		it = stack.pop();
		return myHasNext();
	}
	
	@Override
	public boolean hasNext() {
		if (returnValue != null) {
			return true;
		}

		if (!myHasNext()) {
			return false;
		}
		
		NestedInteger e = it.next();
		while(e == null && myHasNext()) {
			e = it.next();
		}
		if (e.isInteger()) {
			returnValue = e.getInteger();
			return true;
		} else {
			List<NestedInteger> l = e.getList();
			if (l.isEmpty()) {
				return hasNext();
			}
			stack.push(it);
			it = l.iterator();
			return hasNext();
		}
	}

	@Override
	public Integer next() {
		if (hasNext()) {
			Integer result = returnValue;
			returnValue = null;
			return result;
		} else {
			throw new NoSuchElementException();
		}
	}

}

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

class MyNestedInteger implements NestedInteger {

	List<NestedInteger> list = null;
	Integer number = null;
	boolean isNumber = false;
	
	public MyNestedInteger(List<NestedInteger> list) {
		this.list = list;
	}
	
	public MyNestedInteger(Integer number) {
		this.isNumber = true;
		this.number = number;
	}
	
	@Override
	public boolean isInteger() {
		return this.isNumber;
	}

	@Override
	public Integer getInteger() {
		if (this.isNumber) {
			return number;
		}
		return null;
	}

	@Override
	public List<NestedInteger> getList() {
		if (this.isNumber) {
			return new ArrayList<NestedInteger>();
		}
		return this.list;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("IsNumber: ").append(isNumber);
		if (isNumber) {
			sb.append("  Value: ").append(number);
		} else {
			for (NestedInteger n : list) {
				sb.append("  Value: ").append(n);
			}
		}
		return sb.toString(); 
	}
}