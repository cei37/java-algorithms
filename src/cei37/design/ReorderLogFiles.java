package cei37.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

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

public class ReorderLogFiles {
	
	//this will store the digit logs in the insertion order
	List<String> digitLogs = new ArrayList<>();
	
	//this will store the letter logs in natural oder
	TreeMap<String, TreeSet<String>> letterLogs= new TreeMap<>();
	
    public String[] reorderLogFiles(String[] logs) {
    	separeteLogs(logs);
    	return merge(logs);
    }

    private String[] merge(String[] logs) {
    	String []merge = new String[logs.length];
    	int count = 0;
    	for (Map.Entry<String, TreeSet<String>> en : letterLogs.entrySet()) {
			for (String st: en.getValue()) {
				merge[count] = st + " " + en.getKey();
    			count++;
			}
    	}
    	for (String str : digitLogs) {
    		merge[count] = str;
			count++;
    	}
    	return merge;
    }
    
    private void separeteLogs(String[] logs) {
    	for (String str : logs) {
    		String log[] = str.split(" ");
    		if (isNumber(log)) {
    			digitLogs.add(str);
    		} else {
    			String key = log[0];
    			String value = str.substring(key.length() + 1);
    			if (letterLogs.containsKey(value)) {
    				letterLogs.get(value).add(key);
    			} else {
    				TreeSet tree = new TreeSet();
    				tree.add(key);
    				letterLogs.put(value, tree);
    			}
    		}
    	}
    }

    private boolean isNumber(String[] arr) {
    	return arr[1].matches(".*\\d.*");
    }

	public static void main(String[] args) {
		String[] logs = new String[] {
			"dig1 8 1 5 1",
			"let1 art can",
			"dig2 3 6",
			"let2 own kit dig",
			"let3 art zero"	
		};
		ReorderLogFiles rlf = new ReorderLogFiles();
		for (String str : rlf.reorderLogFiles(logs)) {
			System.out.println(str);
		}
	}
}
