package cei37.java.euleriancycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 332. Reconstruct Itinerary
 * 
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * 
 * Note:
 * 
 * If there are multiple valid itineraries, you should return the itinerary that
 * has the smallest lexical order when read as a single string. For example, the
 * itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. All
 * airports are represented by three capital letters (IATA code). You may assume
 * all tickets form at least one valid itinerary. Example 1:
 * 
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"] Example 2:
 * 
 * Input:
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another possible
 * reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in
 * lexical order.
 * 
 * Approach 2: Hierholzer's Algorithm Eulerian Cycle
 * 
 * In graph theory, an Eulerian trail (or Eulerian path) is a trail in a finite
 * graph that visits every edge exactly once (allowing for revisiting vertices).
 * 
 * In our problem, we are asked to construct an itinerary that uses all the
 * flights (edges), starting from the airport of "JFK". As one can see, the
 * problem is actually a variant of Eulerian path, with a fixed starting point.
 * 
 * Similarly, an Eulerian circuit or Eulerian cycle is an Eulerian trail that
 * starts and ends on the same vertex.
 * 
 * The Eulerian cycle problem has been discussed by Leonhard Euler back in 1736.
 * Ever since, there have been several algorithms proposed to solve the problem.
 * 
 * In 1873, Hierholzer proposed an efficient algorithm to find the Eulerian
 * cycle in linear time (\mathcal{O}(|E|)O(∣E∣)). One could find more details
 * about the Hierholzer's algorithm in this course.
 * 
 * The basic idea of Hierholzer's algorithm is the stepwise construction of the
 * Eulerian cycle by connecting disjunctive circles.
 * 
 * To be more specific, the algorithm consists of two steps:
 * 
 * It starts with a random node and then follows an arbitrary unvisited edge to
 * a neighbor. This step is repeated until one returns to the starting node.
 * This yields a first circle in the graph.
 * 
 * If this circle covers all nodes it is an Eulerian cycle and the algorithm is
 * finished. Otherwise, one chooses another node among the cycles' nodes with
 * unvisited edges and constructs another circle, called subtour.
 * 
 * pic
 * 
 * By connecting all the circles in the above process, we build the Eulerian
 * cycle at the end.
 * 
 * Eulerian Path
 * 
 * To find the Eulerian path, inspired from the original Hierzolher's algorithm,
 * we simply change one condition of loop, rather than stopping at the starting
 * point, we stop at the vertex where we do not have any unvisited edges.
 * 
 * To summarize, the main idea to find the Eulerian path consists of two steps:
 * 
 * Step 1). Starting from any vertex, we keep following the unused edges until
 * we get stuck at certain vertex where we have no more unvisited outgoing
 * edges.
 * 
 * Step 2). We then backtrack to the nearest neighbor vertex in the current path
 * that has unused edges and we repeat the process until all the edges have been
 * used.
 * 
 * The first vertex that we got stuck at would be the end point of our Eulerian
 * path. So if we follow all the stuck points backwards, we could reconstruct
 * the Eulerian path at the end.
 * 
 * Algorithm
 * 
 * Now let us get back to our itinerary reconstruction problem. As we know now,
 * it is a problem of Eulerian path, except that we have a fixed starting point.
 * 
 * More importantly, as stated in the problem, the given input is guaranteed to
 * have a solution. So we have one less issue to consider.
 * 
 * As a result, our final algorithm is a bit simpler than the above Eulerian
 * path algorithm, without the backtracking step.
 * 
 * The essential step is that starting from the fixed starting vertex (airport
 * 'JFK'), we keep following the ordered and unused edges (flights) until we get
 * stuck at certain vertex where we have no more unvisited outgoing edges.
 * 
 * The point that we got stuck would be the last airport that we visit. And then
 * we follow the visited vertex (airport) backwards, we would obtain the final
 * itinerary.
 */

public class ReconstructItinerary {
	// origin -> list of destinations
	HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
	LinkedList<String> result = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReconstructItinerary r = new ReconstructItinerary();
		List<List<String>> tickets = new ArrayList<>();
		List<String> p1 = new ArrayList<String>();
		p1.add("JFK");
		p1.add("SFO");
		tickets.add(p1);
		
		List<String> p2 = new ArrayList<String>();
		p2.add("JFK");
		p2.add("ATL");
		tickets.add(p2);
		
		List<String> p3 = new ArrayList<String>();
		p3.add("SFO");
		p3.add("ATL");
		tickets.add(p3);
		
		List<String> p4 = new ArrayList<String>();
		p4.add("ATL");
		p4.add("JFK");
		tickets.add(p4);

		List<String> p5 = new ArrayList<String>();
		p5.add("ATL");
		p5.add("SFO");
		tickets.add(p5);
		
		System.out.println(r.findItinerary(tickets));
	}

	public List<String> findItinerary(List<List<String>> tickets) {
		// Step 1). build the graph first
		for (List<String> ticket : tickets) {
			String origin = ticket.get(0);
			String dest = ticket.get(1);
			if (this.flightMap.containsKey(origin)) {
				LinkedList<String> destList = this.flightMap.get(origin);
				destList.add(dest);
			} else {
				LinkedList<String> destList = new LinkedList<String>();
				destList.add(dest);
				this.flightMap.put(origin, destList);
			}
		}

		// Step 2). order the destinations
		this.flightMap.forEach((key, value) -> Collections.sort(value));

		this.result = new LinkedList<String>();
		// Step 3). post-order DFS
		this.DFS("JFK");
		return this.result;
	}

	protected void DFS(String origin) {
		// Visit all the outgoing edges first.
		if (this.flightMap.containsKey(origin)) {
			LinkedList<String> destList = this.flightMap.get(origin);
			while (!destList.isEmpty()) {
				// while we visit the edge, we trim it off from graph.
				String dest = destList.pollFirst();
				DFS(dest);
			}
		}
		// add the airport to the head of the itinerary
		this.result.offerFirst(origin);
	}
}
