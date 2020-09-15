package cei37.dailyCode;

public class PalindromeII {

	public static void main(String[] args) {
		PalindromeII p = new PalindromeII();
		//System.out.println(p.validPalindrome("anitalavaladtina"));
		//System.out.println(p.validPalindrome("deeee"));
		System.out.println(p.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
	}

    public boolean validPalindrome(String s) {
    	char c[] = s.toCharArray();
    	boolean b = true, a = true;
    	int temI = 0, temJ = 0;
        for (int i=0, j=c.length-1; i<j; i++, j--) {
        	if (c[i]!=c[j]) {
        		if (b && c[i+1]==c[j] && temI==0) {
        			temI = i;
        			temI = j;
        			i++;
        			b = false;
        		} else if (b && c[i]==c[j-1]) {
        			j--;
        			b = false;
        		} else {
        			if (temI > 0 && a) {
        				i = temI;
        				j = temJ;
        				b=true;
        				a = false;
        			} else {
        				return false;
        			}
        		}
        	}
        }
    	return true;
    }
}
