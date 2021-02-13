package cei37.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MyFirst {

	public static void main(String[] args) {
		List<City> cities = getCities();
		
		MyFirst sh = new MyFirst();
		
		System.out.println(sh.getShortest(cities, "A", "K"));
		System.out.println(sh.getPath("A", "K"));
	}

	
	public List<String> getPath(String source, String target) {
		List<String> path = new ArrayList<>();
		
		Pair t = distance.get(target);
		path.add(target);
		while(t != null) {
			path.add(t.prev);
			t = distance.get(t.prev);
		}
		Collections.reverse(path);
		return path;
	}
	
	Map<String, Pair> distance = new HashMap<>();
	public int getShortest(List<City> cities, String source, String target) {
		Map<String, List<City>> g = buildGraph(cities);
		Set<String> visited = new HashSet<>();
		
		Queue<String> q = new LinkedList<>();
		q.offer(source);

		while(!q.isEmpty()) {
			String current = q.poll();
			List<City> children = g.get(current);
			visited.add(current);
			if (children == null) {
				continue;
			}
			for(City city : children) {
				if (visited.contains(city.name)) {
					continue;
				}
				if (distance.get(city.name) != null) {
					int dist = distance.get(current).distance + city.distance;
					if (dist <= distance.get(city.name).distance) {
						distance.put(city.name, new Pair(dist, current));
					}
				} else {
					if (distance.get(current) != null) {
						int prev = distance.get(current).distance;
						distance.put(city.name, new Pair(prev + city.distance, current));
					} else {
						distance.put(city.name, new Pair(city.distance, current));
					}
				}
				q.offer(city.name);
			}
		}	

		return distance.get(target).distance;
	}

	private Map<String, List<City>> buildGraph(List<City> cities) {
		Map<String, List<City>> graph = new HashMap<>();
		for (City c : cities) {
			graph.put(c.name, c.neighbors);
		}

		return graph;
	}

	static class Pair {
		int distance;
		String prev;
		public Pair(int distance, String prev) {
			this.distance = distance;
			this.prev = prev;
		}
		
		public String toString() {
			return "[" + distance + "] --> " + prev;
		}
	}

	static class City {
		String name;
		int distance;
		List<City> neighbors;
		
		public City(String name, int distance, List<City> neighbors) {
			this.name = name;
			this.distance = distance;
			this.neighbors = neighbors;
		}
	}

	public static List<City> getCities() {
		List<City> cities = new ArrayList<City>();
		//A
		City a = new City("A", 0, new ArrayList<City>() {{
			add(new City("B", 3, null));
			add(new City("C", 1, null));
			add(new City("D", 2, null));
		}});

		//B
		City b = new City("B", 0, new ArrayList<City>() {{
			add(new City("A", 3, null));
			add(new City("C", 1, null));
			add(new City("G", 7, null));
		}});
		
		//C
		City c = new City("C", 0, new ArrayList<City>() {{
			add(new City("A", 1, null));
			add(new City("B", 1, null));
			add(new City("D", 2, null));
			add(new City("E", 4, null));
			add(new City("F", 5, null));
			add(new City("G", 6, null));
		}});
		
		//D
		City d = new City("D", 0, new ArrayList<City>() {{
			add(new City("A", 2, null));
			add(new City("C", 2, null));
			add(new City("E", 3, null));
		}});
		
		//E
		City e = new City("E", 0, new ArrayList<City>() {{
			add(new City("D", 3, null));
			add(new City("C", 4, null));
			add(new City("F", 4, null));
			add(new City("I", 8, null));
			add(new City("H", 9, null));
		}});
		
		//F
		City f = new City("F", 0, new ArrayList<City>() {{
			add(new City("C", 5, null));
			add(new City("G", 3, null));
			add(new City("J", 7, null));
			add(new City("I", 1, null));
			add(new City("E", 4, null));
		}});
		
		//G
		City g = new City("G", 0, new ArrayList<City>() {{
			add(new City("B", 7, null));
			add(new City("C", 6, null));
			add(new City("F", 3, null));
			add(new City("J", 5, null));
		}});
		
		//H
		City h = new City("H", 0, new ArrayList<City>() {{
			add(new City("E", 9, null));
			add(new City("I", 1, null));
			add(new City("K", 2, null));
		}});
		
		//I
		City i = new City("I", 0, new ArrayList<City>() {{
			add(new City("E", 8, null));
			add(new City("F", 1, null));
			add(new City("J", 3, null));
			add(new City("K", 3, null));
			add(new City("H", 1, null));
		}});
		
		//J
		City j = new City("J", 0, new ArrayList<City>() {{
			add(new City("G", 5, null));
			add(new City("F", 7, null));
			add(new City("I", 3, null));
			add(new City("K", 2, null));
		}});

		//K
		City k = new City("K", 0, new ArrayList<City>() {{
			add(new City("H", 2, null));
			add(new City("I", 3, null));
			add(new City("J", 2, null));
		}});
		
		cities.add(a);
		cities.add(b);
		cities.add(c);
		cities.add(d);
		cities.add(e);
		cities.add(f);
		cities.add(g);
		cities.add(h);
		cities.add(i);
		cities.add(j);
		cities.add(k);
		
		return cities;
	}
}