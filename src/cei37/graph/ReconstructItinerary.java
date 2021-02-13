package cei37.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/*
 * 332. Reconstruct Itinerary
Medium

2436

1175

Add to List

Share
Given a list of airline tickets represented by pairs of departure and arrival airports 
[from, to], reconstruct the itinerary in order. All of the tickets belong to a man who 
departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the 
smallest lexical order when read as a single string. For example, the itinerary 
["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
 */
public class ReconstructItinerary {

	public static void main(String[] args) {
		ReconstructItinerary r = new ReconstructItinerary();
		Data data = new Data();
		
		data.addTicket("MUC", "LHR");
		data.addTicket("JFK", "MUC");
		data.addTicket("SFO", "SJC");
		data.addTicket("LHR", "SFO");
		
		/*
		data.addTicket("JFK", "SFO");
		data.addTicket("JFK", "ATL");
		data.addTicket("SFO", "ATL");
		data.addTicket("ATL", "JFK");
		data.addTicket("ATL", "SFO");
		*/
		
		/*
		data.addTicket("JFK", "KUL");
		data.addTicket("JFK", "NRT");
		data.addTicket("NRT", "JFK");
		*/
		
		/*data.addTicket("EZE","AXA");
		data.addTicket("TIA","ANU");
		data.addTicket("ANU","JFK");
		data.addTicket("JFK","ANU");
		data.addTicket("ANU","EZE");
		data.addTicket("TIA","ANU");
		data.addTicket("AXA","TIA");
		data.addTicket("TIA","JFK");
		data.addTicket("ANU","TIA");
		data.addTicket("JFK","TIA");
		*/
		for (String str : r.findItinerary(data.tickets)) {
			System.out.print(str + ",");
		}
		
	}

    public List<String> findItinerary(List<List<String>> tickets) {
    	Map<String, PriorityQueue<String>> g = new HashMap<>();
    	List<String> route = new ArrayList<>();
    	
    	String source;
    	String target;
    	for (List<String> stop : tickets) {
    		source = stop.get(0);
    		target = stop.get(1);
    		
    		if (!g.containsKey(source)) {
    			g.put(source, new PriorityQueue<String>());
    		}
    		g.get(source).offer(target);
    	}
    	
    	dfs(g, route, "JFK");

    	return route;
    }
    
	
    public void dfs(Map<String, PriorityQueue<String>> g, List<String> route, String origin) {
    	PriorityQueue<String> pq = g.get(origin);
    	while(pq != null && !pq.isEmpty()) {
    		dfs(g, route, g.get(origin).poll());
    	}
    	route.add(0,origin);
    }
	
	
	
	
	//this is one solution, I got some help from leetcode
	List<String> result = new ArrayList<>();
	HashMap<String, boolean[]> visited = new HashMap<>();
	int flights = 0;
    public List<String> findItinerary_1(List<List<String>> tickets) {
    	Map<String, LinkedList<String>> g = buildGraph(tickets);
    	List<String> route = new ArrayList<>();
    	
    	for(Map.Entry<String, LinkedList<String>> e : g.entrySet()) {
    		Collections.sort(e.getValue());
    		visited.put(e.getKey(), new boolean[e.getValue().size()]);
    	}
    	this.flights = tickets.size();
    	route.add("JFK");
    	
    	backtracking("JFK", g, route);

    	return result;
    }
    
    private boolean backtracking(String origin, Map<String, LinkedList<String>> g, List<String> route) {

    	if (route.size() == this.flights + 1) {
    		this.result = new ArrayList<String>(route);
    		return true;
    	}
    	
    	if (!g.containsKey(origin) ) {
    		return false;
    	}

    	int i=0;
    	boolean bitmap[] = visited.get(origin);
    	for (String dest : g.get(origin)) {
    		if (!bitmap[i]) {
    			bitmap[i] = true;
	    		route.add(dest);
	    		boolean res = backtracking(dest, g, route);
	    		route.remove(route.size() -1);
	    		bitmap[i] = false;
	    		
	    		if (res) {
	    			return true;
	    		}
    		}
    		i++;
    	}
    	return false;
    }
    

    private Map<String, LinkedList<String>> buildGraph(List<List<String>> tickets) {
    	Map<String, LinkedList<String>> g = new HashMap<String, LinkedList<String>>();
    	
    	for (List<String> list : tickets) {
    		if (!g.containsKey(list.get(0))) {
    			g.put(list.get(0), new LinkedList<String>());
    		}
    		g.get(list.get(0)).add(list.get(1));
    	}
    	
    	return g;
    }
    

    //@@@@@@@@@@@@@@@@@@@@@@@@@
    static class Data {
    	List<List<String>> tickets;
    	public Data(List<List<String>> tickets) {
    		this.tickets = tickets;
    	}
    	public Data() {
    		this.tickets = new ArrayList<List<String>>();
    	}
    	
    	public void addTicket(String s1, String s2) {
    		List<String> list = new ArrayList<>();
    		list.add(s1);
    		list.add(s2);
    		this.tickets.add(list);
    	}
    }
}