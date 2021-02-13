package cei37.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Figure out whether the given words can form a circular chain. Assume that a single word can never form a chain.

Two words can be chained together if the first word’s last letter is equal to the second word’s first letter.
 We are given a list of words and we need to figure out if all the words can be chained together or not. 
 Let’s assume that all the words are lower case.

Consider the following words:

eve
eat
ripe
tear
These words can form the following chain:

eve
eat
ripe
tear

https://www.educative.io/courses/coderust-hacking-the-coding-interview/k27X
 */
public class WordChaining {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>() {{
			add("123");
			add("345");
			add("567");
			add("789");
			add("903");
			
		}};
		WordChaining wc = new WordChaining();
		System.out.println(wc.isCircularChain(list));
	}
	boolean res = false;
	public boolean isCircularChain(List<String> list) {
		if (list == null || list.isEmpty()) return false;
		Map<Character, List<String>> g = new HashMap<>();

		list.forEach( e -> {
			char c = e.charAt(0);
			if (!g.containsKey(c)) {
				g.put(c, new ArrayList<String>());
			}
			g.get(c).add(e);
		});
		Set<String> visited = new HashSet<String>();
		dfs(g, visited, list.get(0), list.get(0), list.size());

		return res;
	}
	
	public void dfs(Map<Character, List<String>> g, Set<String> visited, String node, String first, int size) {
		char c = node.charAt(node.length()-1);
		if (g.containsKey(c)) {
			visited.add(node);
			if (visited.size() == size) {
				char ch1 = first.charAt(0);
				char ch2 = node.charAt(node.length()-1);
				if (ch1 == ch2) {
					res = true;
				}
			}
			for (String n : g.get(c)) {
				if (!visited.contains(n)) {
					dfs(g, visited, n, first, size);
				}
			}
		}
	}
}