package cei37.sorts;

public class Merge {

	public static void main(String[] args) {
		int[] nums = {10,3,-1,4,5,5,7,11,1, 15, 8, 9, 0};
		Merge.mergeSort(nums);
		for (int i: nums) {
			System.out.println(i);
		}
	}
	
	public static void mergeSort(int[] a) {
		int aux[] = new int[a.length];
		sort(a, aux, 0, a.length -1);
	}
	
	private static void sort(int a[], int aux[], int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	private static void merge(int a[], int aux[], int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (aux[j] < aux[i]) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}

}
