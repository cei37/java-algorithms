package cei37.dailyCode;

/*
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

 */
public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		int arr1[] = new int[] {1, 1};
		int arr2[] = new int[] {1, 1};
		
		System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(arr1, arr2));
		
	}

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int l1 = nums1 != null ? nums1.length : 0;
    	int l2 = nums2 != null ? nums2.length : 0;
    	
    	int c1 = 0;
    	int c2 = 0;
    	int i = 0;
    	
    	int targetIndex = (l1 + l2)/2;
    	boolean isEven = (l1 + l2) % 2 == 0;
    	
    	int temp1 = 0;
    	int temp2 = 0;

    	while ((c1 != l1 || c2 != l2) && i <= targetIndex ) {
    		if (c1 < l1 && c2 < l2) {
	    		if (nums1[c1] < nums2[c2]) {
	    			temp1 = temp2;
	    			temp2 = nums1[c1];
	    			c1++;
	    			i++;
	    		} else if (nums2[c2] <= nums1[c1]) {
	    			temp1 = temp2;
	    			temp2 = nums2[c2];
	    			c2++;
	    			i++;
	    		}
    		} else if (c1 < l1) {
    			temp1 = temp2;
    			temp2 = nums1[c1];
    			c1++;
    			i++;
    		} else if (c2 < l2) {
    			temp1 = temp2;
    			temp2 = nums2[c2];
    			c2++;
    			i++;
    		}

        	if (i == targetIndex + 1 && isEven) {
        		return ((double)temp1 + (double)temp2) / 2; 
        	} else if (i == targetIndex + 1){
        		return temp2;
        	}
    	}

    	return 0d;
    }
    
    /*
	//This solution make use of a temporal array to merge them before
	//getting the median
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int []arr = mergeSortedArrays(nums1, nums2);

    	boolean isEven = arr.length % 2 == 0;
    	
    	if (isEven) {
    		int n = arr.length/2;
    		return ((double)arr[n] + (double)arr[n - 1]) / 2; 
    	} else {
    		return arr[arr.length/2];
    	}
    }
    
    public int[] mergeSortedArrays(int[] nums1, int[] nums2) {
    	int l1 = nums1 != null ? nums1.length : 0;
    	int l2 = nums2 != null ? nums2.length : 0;

    	if (l1 == 0) return nums2;
    	if (l2 == 0) return nums1;
    	
    	int c1 = 0;
    	int c2 = 0;
    	int i = 0;

    	int[] result = new int[l1 + l2];
    	while (c1 != l1 || c2 != l2) {
    		if (c1 < l1 && c2 < l2) {
	    		if (nums1[c1] < nums2[c2]) {
	    			result[i] = nums1[c1];
	    			c1++;
	    			i++;
	    		} else if (nums2[c2] < nums1[c1]) {
	    			result[i] = nums2[c2];
	    			c2++;
	    			i++;
	    		} else {
	    			result[i] = nums1[c1];
	    			i++;
	    			result[i] = nums2[c2];
	    			c1++;
	    			c2++;
	    			i++;
	    		}
    		} else if (c1 < l1) {
    			result[i] = nums1[c1];
    			c1++;
    			i++;
    		} else if (c2 < l2) {
    			result[i] = nums2[c2];
    			c2++;
    			i++;
    		}
    	}

    	return result;
    }
     */
}
