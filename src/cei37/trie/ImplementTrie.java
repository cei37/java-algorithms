package cei37.trie;

/*
 * 208. Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
public class ImplementTrie {

	public static void main(String[] args) {
		ImplementTrie trie = new ImplementTrie();

		System.out.println("Insert -- apple");
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("apples"));   // returns false
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		System.out.println("Insert -- app");
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true

	}
	

	TrieNode trie;
    /** Initialize your data structure here. */
    public ImplementTrie() {
        trie = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = trie;
        if (word != null && word.length() > 0) {
        	for (int i=0; i<word.length(); i++) {
        		char ch = word.charAt(i);
        		if (node.containsKey(ch)) {
        			node = node.get(ch);
        		} else {
        			node.put(ch, new TrieNode());
        			node = node.get(ch);
        		}
        	}
        	node.setEnd();
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode node = trie;
    	if (word != null && word.length() > 0) {
    		for (int i=0; i<word.length(); i++) {
    			char ch = word.charAt(i);
    			if (node.containsKey(ch)) {
    				node = node.get(ch);
    			} else {
    				return false;
    			}
    		}
    		return node.isEnd();
    	}
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	if (prefix != null && prefix.length() > 0) {
    		TrieNode node = trie;
    		for (int i=0; i<prefix.length(); i++) {
    			char ch = prefix.charAt(i);
    			if (node.containsKey(ch)) {
    				node = node.get(ch);
    			} else {
    				return false;
    			}
    		}
    	}
        return true;
    }
    
	class TrieNode {
		private TrieNode[] links;
		private boolean end;
		private final int SIZE = 26;
		
		public TrieNode() {
			links = new TrieNode[SIZE];
		}
		
		public boolean containsKey(char ch) {
			return links[ch-'a'] != null;
		}
		
		public TrieNode get(char ch) {
			return links[ch-'a'];
		}
		
		public void put(char ch, TrieNode node) {
			links[ch-'a'] = node;
		}
		
		public void setEnd() {
			end = true;
		}
		
		public boolean isEnd() {
			return end;
		}
	}
}
