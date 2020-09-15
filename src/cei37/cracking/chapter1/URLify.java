package cei37.cracking.chapter1;

public class URLify {

	/**
	 * Write a method  to replace all spaces in a string with '%20': You may assume that the string
	 * has sufficient space at the end to old the additional characters, and that you are given the
	 * "true" length of the string. 
	 * 
	 * Example:
	 * INPUT: 'Mr. John Smith     ', 13
	 * OUTPUT: 'Mr.%20John%20Smith'
	 */
	public static void main(String[] args) {
		URLify u = new URLify();
		String s = "Mr. J ohn Sm ith                    ";
		int trueLength = 15;

		char [] url = s.toCharArray();
		u.urlifyString(url, trueLength);
		for (char c : url) {
			System.out.print(c);
		}
	}
	
	public void urlifyString(char[] url, int trueLength) {
		int spaces = 0;
		for (int i=0; i<trueLength; i++) {
			if (url[i] == ' ') spaces++;
		}
		spaces *= 2;
		
		int total = spaces + trueLength;
		//making sure we are having the correct space to move characters
		if (total > url.length-1) return;
		for (int i=trueLength; i>=0; i--) {
			if (url[i] == ' ') {
				url[total--] = '0';
				url[total--] = '2';
				url[total--] = '%';
			} else {
				url[total--] = url[i];
			}
		}
	}
}