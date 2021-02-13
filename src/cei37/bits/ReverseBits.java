package cei37.bits;

public class ReverseBits {

	public static void main(String[] args) {
		int[] nums = {
			43261596,
		};
		
		ReverseBits rb = new ReverseBits();
		for (int num : nums) {
			System.out.println(rb.reverseBits(num));
		}
	}

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	String bits = getBits(n);
    	
    	System.out.println(bits);
    	
    	return 0;
    }
    //this is the not the correct solution
    private String getBits(int num) {
    	StringBuilder sb = new StringBuilder();
    	int remainder = 0;
    	int quotient = num;

    	/*
			Divide n by 2, noting the quotient q and the remainder r
			Divide q by 2, noting its quotient and remainder
			Repeat step 2 until we get 0 as the quotient
			Concatenate in reverse order all remainders
    	 */
    	while(quotient != 0) {
    		remainder  = quotient % 2;
    		quotient = quotient / 2;
    		sb.append(remainder);
    	}
    	
    	while(sb.length() < 32) {
    		sb.append("0");
    	}
    	
    	return sb.toString();
    }
}
