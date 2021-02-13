package cei37.string;

/*
 * 38. Count and Say


Share
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), 
which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of
 groups so that each group is a contiguous section all of the same character. 
 Then for each group, say the number of characters, then say the character. To
  convert the saying into a digit string, replace the counts with a number 
  and concatenate every saying.

For example, the saying and conversion for digit string "3322251":


Given a positive integer n, return the nth term of the count-and-say sequence.

 

Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 

Constraints:

1 <= n <= 30
 */
public class CountAndSay {

	public static void main(String[] args) {
		CountAndSay say = new CountAndSay();
		System.out.println(say.countAndSay(10));

	}

    public String countAndSay(int n) {
        String res = "1";
        for (int i=1; i < n; i++) {
            res = say(res);
        }
        return res;
    }
    
    public String say(String str) {
        if (str == null || str.equals("")) return "";
        
        StringBuilder sb = new StringBuilder();
        char temC = str.charAt(0);
        int count = 1;
        char c = str.charAt(0);
        for (int i=1; i<str.length(); i++) {
            c = str.charAt(i);
            if (c == temC) {
                count++;
            } else {
                sb.append(count).append(temC);
                count = 1;
                temC = c;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }

}
