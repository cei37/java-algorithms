package cei37.string;

/*
 * 415. Add Strings

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {

	public static void main(String[] args) {
		AddStrings ad = new AddStrings();
		String num1 = "3000";
		String num2 = "8125";
		
		System.out.println(ad.addStrings(num1, num2));
	}

    public String addStrings(String num1, String num2) {
    	if (num1 == null) return num2;
    	if (num2 == null) return num1;
    	
    	StringBuilder sb = new StringBuilder();
    	int l1 = num1.length() - 1;
    	int l2 = num2.length() - 1;
    	int carry = 0;
    	while(l1 >= 0 || l2 >= 0) {
    		int n1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
    		int n2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
    		int value = (n1 + n2 + carry) % 10;
    		carry = (n1 + n2 + carry) / 10;
    		sb.append(value);
    		l1--;
    		l2--;
    	}
    	if (carry != 0) {
    		sb.append(carry);
    	}
    	return sb.reverse().toString();
    }
}
