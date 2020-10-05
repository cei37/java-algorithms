package cei37.design;


import java.util.Map;
import java.util.TreeMap;

/*
 * 
 * 937. Reorder Data in Log Files
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 

Constraints:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.

 */

public class ReorderLogFiles2 {

	TreeMap<String, String> tree= new TreeMap<>();
	
    public String[] reorderLogFiles(String[] logs) {
    	int i = 0;
    	for (String log : logs) {
    		String[] ar =  log.split(" ", 2);
    		
    		if (Character.isDigit(ar[1].charAt(0))) {
    			//digit-log
    			tree.put("1 " + (char)i + " ", log);
    			i++;
    		} else {
    			//letter-log
    			tree.put("0 " + ar[1] + " " + ar[0], log);
    		}
    	}

    	i = 0;
    	for (Map.Entry<String, String>  en: tree.entrySet()) {
    		logs[i++] = en.getValue();
    	}
    	
    	return logs;
    }

	public static void main(String[] args) {
		String[] logs = new String[] {
			"dig1 8 1 5 1",
			"let1 art can",
			"dig2 3 6",
			"let2 own kit dig",
			"let3 art zero"	
		};
		
		String[] logs2 = new String[] {
			"a1 9 2 3 1",
			"g1 act car",
			"zo4 4 7",
			"ab1 off key dog",
			"a8 act zoo",
			"6 82"
		};
		
		String[] logs3 = new String[] {
			"1 n u", 
			"r 527", 
			"j 893", 
			"6 14", 
			"6 82"
		};

		ReorderLogFiles2 rlf = new ReorderLogFiles2();
		for (String str : rlf.reorderLogFiles(logs3)) {
			System.out.println(str);
		}
	}
}