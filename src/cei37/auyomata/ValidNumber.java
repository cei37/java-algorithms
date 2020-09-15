package cei37.auyomata;

import java.util.HashSet;
import java.util.Set;

/*
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false



System.out.println(vn.isNumber("0") +  "=> true");
System.out.println(vn.isNumber(" 0.1 ") +  " => true");
System.out.println(vn.isNumber("abc") +  " => false");
System.out.println(vn.isNumber("1 a") +  " => false");
System.out.println(vn.isNumber("2e10") +  " => true");
System.out.println(vn.isNumber(" -90e3) +  "   " => true");
System.out.println(vn.isNumber(" 1e") +  " => false");
System.out.println(vn.isNumber("e3") +  " => false");
System.out.println(vn.isNumber(" 6e-1") +  " => true");
System.out.println(vn.isNumber(" 99e2.5 ") +  " => false");
System.out.println(vn.isNumber("53.5e93") +  " => true");
System.out.println(vn.isNumber(" --6 ") +  " => false");
System.out.println(vn.isNumber("-+3") +  " => false");
System.out.println(vn.isNumber("95a54e53") +  " => false");

Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one. 
However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."

 */
public class ValidNumber {

	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		
		System.out.println(vn.isNumber("2323") + "|true\t2323");
		System.out.println(vn.isNumber("0") +  "|true\t0 =>\ttrue");
		System.out.println(vn.isNumber(" 0.1 ") +  "|true\t0.1  => true");
		System.out.println(vn.isNumber("abc") +  "|false\tabc => false");
		System.out.println(vn.isNumber("1 a") +  "|false\t1 a => false");
		System.out.println(vn.isNumber("2e10") +  "|true\t2e10 => true");
		System.out.println(vn.isNumber(" -90e3   ") + "|true\t-90e3    => true");
		System.out.println(vn.isNumber(" 1e") +  "|false\t1e => false");
		System.out.println(vn.isNumber("e3") +  "|false\te3 => false");
		System.out.println(vn.isNumber(" 6e-1") +  "|true\t6e-1 => true");
		System.out.println(vn.isNumber(" 99e2.5 ") +  "|false\t99e2.5  => false");
		System.out.println(vn.isNumber("53.5e93") +  "|true\t53.5e93 => true");
		System.out.println(vn.isNumber(" --6 ") +  "|false\t--6  => false");
		System.out.println(vn.isNumber("-+3") +  "|false\t-+3 => false");
		System.out.println(vn.isNumber("95a54e53") +  "|false\t95a54e53 => false");
		System.out.println(vn.isNumber("3.") +  "|true\t3. => true");
		System.out.println(vn.isNumber(".") +  "|false\t. => false"); 
		System.out.println(vn.isNumber(".20") +  "|true\t.20 => true");
		
		System.out.println("=================================");
		System.out.println(vn.isNumber("-.") +  "|false\t-. => false");
		System.out.println(vn.isNumber("46.e3") +  "|true\t46.e3 => true");
		System.out.println(vn.isNumber("46.e-3") +  "|true\t46.e-3 => true");
		System.out.println(vn.isNumber(".e1") +  "|false\t.e1 => false");
		System.out.println(vn.isNumber("1e.66") +  "|false\t1e.66 => false");
		System.out.println(vn.isNumber(".2e81") +  "|true\t.2e81 => true");
		
		
	}
	
    public boolean isNumber(String s) {
    	/*
    	 * This is an implementation using a Finite-state machine
    	 */
    	int[][] machine = {
    	  //{-, D, e, .},
    		{4, 1, 8, 5},
    		{8, 1, 6, 2},
    		{8, 2, 6, 8},
    		{8, 3, 8, 8},
    		{8, 1, 8, 5},
    		{8, 2, 8, 8},
    		{7, 3, 8, 8},
    		{8, 3, 8, 8},
    		{8, 8, 8, 8}
    	};
    	
    	if (s != null) {
    		char [] c = s.trim().toCharArray();
    		//we are starting with state 0
    		int state = 0;
    		
        	for (int i=0; i<c.length; i++) {
        		int input = getInput(c[i]);
        		if (input < 0) {
        			return false;
        		}
        		state = machine[state][input];
        		if (state == 8) return false;
        	}
        	if (state == 1 || state ==2 || state ==3) return true;
    	}
    	return false;
    }

    //convenience method to return the representation
    //of each input.
    private int getInput(char c) {
    	if (c == '+' || c == '-') return 0;
    	if (Character.isDigit(c)) return 1;
    	if (c == 'e') return 2;
    	if (c == '.') return 3;
    	return -1;
    }
}