package cei37.design;

import java.util.ArrayList;
import java.util.List;

/*
 * Find Median from Data Stream

Solution
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class MedianFinder {

    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
    	list.add(binarySearch(num), num);
    }
    
    public int binarySearch(int num) {
    	int low = 0;
    	int high = list.size()-1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int numList = list.get(mid);
            if (numList < num) {
                low = mid + 1;
            } else if (numList > num) {
                high = mid - 1;
            } else if (numList == num) {
                return mid;
            }
        }
        return low;
    }
    
    public double findMedian() {
    	int size = list.size();
    	//odd
    	if (size % 2 == 1) {
    		return list.get(size/2);
    	} else { //even
    		return (double)(list.get(size/2)+list.get(size/2-1))/2;
    	}
    }

	public static void main(String[] args) {
		MedianFinder md = new MedianFinder();
		md.addNum(1);
		md.addNum(2);
		System.out.println(md.findMedian());
		md.addNum(3);
		System.out.println(md.findMedian());
	}
}
