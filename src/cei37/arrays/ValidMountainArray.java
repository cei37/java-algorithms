package cei37.arrays;

public class ValidMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidMountainArray v = new ValidMountainArray();
		System.out.println(v.validMountainArray(new int[]{9,8,7,6,5,4,3,2,1,0}));
	}

	public boolean validMountainArray(int[] A) {
        if (A.length >= 3) {
            int min = A[0];
            int max = 0;
            int i=0;
            boolean b = false;
            for (i=1; i<A.length; i++) {
                if (A[i]>min) {
                    min = A[i];
                    b=true;
                } else if (A[i]==min) {
                    return false;
                } else {
                    max = A[i-1];
                    break;
                }
            }
            if (b) {
	            b=false;
	            while(i < A.length) {
	                if (A[i] < max) {
	                    max = A[i];
	                } else if (A[i] >= max) {
	                    return false;
	                }
	                i++;
	                b = true;
	            }
	            if (b)
	            	return true;
            }
        }
        return false;
    }
	
}
