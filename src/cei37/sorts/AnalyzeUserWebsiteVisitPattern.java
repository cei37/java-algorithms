package cei37.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/*
 * 1152. Analyze User Website Visit Pattern
Medium

102

880

Add to List

Share
We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].

A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  
(The websites in a 3-sequence are not necessarily distinct.)

Find the 3-sequence visited by the largest number of users. If there is more than one solution, return 
the lexicographically smallest such 3-sequence.

 

Example 1:

Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = 
[1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
Output: ["home","about","career"]
Explanation: 
The tuples in this example are:
["joe", 1, "home"]
["joe", 2, "about"]
["joe", 3, "career"]
["james", 4, "home"]
["james", 5, "cart"]
["james", 6, "maps"]
["james", 7, "home"]
["mary", 8, "home"]
["mary", 9, "about"]
["mary", 10, "career"]
The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.

["u1","u1","u1","u2","u2","u2"]
[ 1,   2,   3,   4,   5,   6]
["a", "b", "a", "a", "b", "c"]

Expected: ["a","b","a"]

Note:

3 <= N = username.length = timestamp.length = website.length <= 50
1 <= username[i].length <= 10
0 <= timestamp[i] <= 10^9
1 <= website[i].length <= 10
Both username[i] and website[i] contain only lowercase characters.
It is guaranteed that there is at least one user who visited at least 3 websites.
No user visits two websites at the same time.

 */
public class AnalyzeUserWebsiteVisitPattern {

	public static void main(String[] args) {
		String[] username = new String[] {
			"joe","joe","joe","james","james","james","james","mary","mary","mary"
		};
		String[] website = new String[] {
			"home","about","career","home","cart","maps","home","home","about","career"
		};
		int[] timestamp = new int[] {
			1,2,3,4,5,6,7,8,9,10
		};
		AnalyzeUserWebsiteVisitPattern an = new AnalyzeUserWebsiteVisitPattern();

		for (String s : an.mostVisitedPattern(username, timestamp, website)) {
			System.out.println(s);
		}
	}

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    	List<String> res = new ArrayList<>();
        if (username == null || username.length == 0 || timestamp == null || 
        		timestamp.length == 0 || website == null || website.length == 0) {
        	return res;
        }

        //count the visits by website
        Map<String, Data> map = new HashMap<>();
        for (int i=0; i <website.length; i++) {
        	if (map.containsKey(website[i])) {
        		map.get(website[i]).visits++;
        		map.get(website[i]).time = Math.min(map.get(website[i]).time, timestamp[i]);
        	} else {
        		map.put(website[i], new Data(website[i], timestamp[i]));
        	}
        }
        
        //pq that will hold the 3 most visited web sites
        PriorityQueue<Data> pq = new PriorityQueue<Data>( new Comparator<Data>() {
        	public int compare(Data d1, Data d2) {
        		return d1.visits - d2.visits;
        	}
        });
        
        for (Map.Entry<String, Data> e : map.entrySet()) {
        	pq.offer(e.getValue());
        	if (pq.size() > 3) {
        		pq.poll();
        	}
        }
    	
        //poll from pq to List, then sort by timestamp
        List<Data> list = new ArrayList<Data>();
        while(!pq.isEmpty()) {
        	list.add(pq.poll());
        }
        
        Collections.sort(list, new Comparator<Data>() {
        	public int compare(Data d1, Data d2) {
        		return d1.time - d2.time;
        	}
        });
        
        //add website name to the final list
        for (Data d : list) {
        	res.add(d.website);
        }
        
    	return res;
    }
    
    
    class Data {
    	String website;
    	int visits;
    	int time = Integer.MAX_VALUE;
    	Data(String website, int time) {
    		this.website = website;
    		this.time = time;
    		visits++;
    	}
    }
}