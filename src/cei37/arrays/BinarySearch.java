package cei37.arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int [] nums = {9};
		System.out.println(search(nums, 9));
	}
	
	public static int search(int[] nums, int target) {
        if (nums == null) return -1;
        
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
        	int mid = (right - left)/2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        return -1;
    }
	
	public static int binarySearch(int[] nums, int key) {
		int li = 0;
		int hi = nums.length - 1;
		while(li <= hi) {
			int mid = li + (hi - li) / 2;
			if (nums[mid] == key) {
				return mid;
			} else if (key > nums[mid]) {
				li = mid + 1;
			} else if (key < nums[mid]){
				hi = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static int binarySearchRecursion(int[] nums, int key) {
		return binarySearch(nums, key, 0, nums.length -1);
	}
	
	public static int binarySearch(int[] nums, int key, int li, int hi) {
		if (li > hi) {
			return -1;
		}
		int mid = li + (hi - li) / 2;
		if (nums[mid] == key) {
			return mid;
		} else if (key > nums[mid]) {
			return binarySearch(nums, key,mid + 1, hi);
		} else if (key < nums[mid]) {
			return binarySearch(nums, key,li, mid - 1);
		}
		return -1;
	}
}
