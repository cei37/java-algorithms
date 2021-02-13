package cei37.arrays;

/*
 * Rotational Cipher
One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain 
amount. Rotating a character means replacing it with another character that is a certain 
number of steps away in normal alphabetic or numerical order.
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is 
"Cheud-726?". Every alphabetic character is replaced with the character 3 letters 
higher (wrapping around from Z to A), and every numeric character replaced with the 
character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric 
characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.
Signature
string rotationalCipher(string input, int rotationFactor)
Input
1 <= |input| <= 1,000,000
0 <= rotationFactor <= 1,000,000
Output
Return the result of rotating input a number of times equal to rotationFactor.
Example 1
input = Zebra-493?
rotationFactor = 3
output = Cheud-726?
Example 2
input = abcdefghijklmNOPQRSTUVWXYZ0123456789
rotationFactor = 39
output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 */
public class RotationalCipher {

	// Add any helper functions you may need here

	String rotationalCipher(String input, int rotationFactor) {
		if (input == null || input.length() == 0) return "";
		
		char[] arr = input.toCharArray();
		
		int a = (int)'a';
		int z = (int)'z';
		int A = (int)'A';
		int Z = (int)'Z';
		int n0 = (int)'0';
		int n9 = (int)'9';
		
		for (int i=0; i<arr.length; i++) {
			int c = (int)arr[i];
			
			//a..z
			if (c >= a && c <= z ) {
				arr[i] = rotate((int)c, a, z, rotationFactor);
				continue;
			}

			//A..Z
			if (c >= A && c <= Z) {
				arr[i] = rotate((int)c, A, Z, rotationFactor);
				continue;
			}

			//0..9
			if (c >= n0 && c<=n9) {
				arr[i] = rotate((int)c, n0, n9, rotationFactor);
				continue;
			}
		}
		
		return new String(arr);
	}
	
	public char rotate(int c, int start, int end, int rotationFactor) {
		int rotator = rotationFactor%(end - start + 1);
		c += rotator;
		if (c > end) {
			c = c - end + start - 1;
		}
		return (char)c;
	}

	
	
	
	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(String expected, String output) {
		boolean result = (expected.equals(output));
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printString(expected);
			System.out.print(" Your output: ");
			printString(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printString(String str) {
		System.out.print("[\"" + str + "\"]");
	}

	public void run() {
		String input_1 = "All-convoYs-9-be:Alert1.";
		int rotationFactor_1 = 4;
		String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
		String output_1 = rotationalCipher(input_1, rotationFactor_1);
		check(expected_1, output_1);

		String input_2 = "abcdZXYzxy-999.@";
		int rotationFactor_2 = 200;
		String expected_2 = "stuvRPQrpq-999.@";
		String output_2 = rotationalCipher(input_2, rotationFactor_2);
		check(expected_2, output_2);

		
		String input_3 = "Zebra-493?";
		int rotationFactor_3 = 3;
		String expected_3 = "Cheud-726?";
		String output_3 = rotationalCipher(input_3, rotationFactor_3);
		check(expected_3, output_3);

		String input_4 = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
		int rotationFactor_4 = 39;
		String expected_4 = "nopqrstuvwxyzABCDEFGHIJKLM9012345678";
		String output_4 = rotationalCipher(input_4, rotationFactor_4);
		check(expected_4, output_4);
		
		String input_5 = "4";
		int rotationFactor_5 = 11;
		String expected_5 = "5";
		String output_5 = rotationalCipher(input_5, rotationFactor_5);
		check(expected_5, output_5);

	}

	public static void main(String[] args) {
		new RotationalCipher().run();
	}
}
