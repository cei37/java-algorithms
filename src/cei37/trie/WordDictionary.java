package cei37.trie;

/*
 * 211. Design Add and Search Words Data Structure

Design a data structure that supports adding new words and finding if a string matches any 
previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or 
false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.

 */
public class WordDictionary {

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		//System.out.println(wordDictionary.search("pad")); // return False
		//System.out.println(wordDictionary.search("bad")); // return True
		//System.out.println(wordDictionary.search("mad")); // return True
		//System.out.println(wordDictionary.search("dad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b..")); // return True
		System.out.println(wordDictionary.search("b.d")); // return True
		System.out.println(wordDictionary.search("..a")); // return True
	}

	
	
	TrieNode trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word != null && word.length() > 0) {
        	TrieNode node = trie;
        	for (int i=0; i<word.length(); i++) {
        		char ch = word.charAt(i);
        		if (node.get(ch) != null) {
        			node = node.get(ch);
        		} else {
        			node.put(ch, new TrieNode());
        			node = node.get(ch);
        		}
        	}
        	node.setEnd();
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	if (word != null && word.length() > 0) {
    		TrieNode node = trie;
    		return search(word, 0, node);
    	}
    	return false;
    }
    
    private boolean search(String word, int idx, TrieNode node) {
    	
    	if (idx == word.length() ) return node.isEnd();

    	char ch = word.charAt(idx);
    	if (ch != '.') {
			return (node.get(ch) != null && search(word, idx + 1, node.get(ch)));
    	} else {
	    	for (TrieNode link : node.getLinks()) {
	    		if (link != null && search(word, idx + 1, link)) {
	    			return true;
	    		}
	    	}
    	}
		return false;
    }
    
    class TrieNode {
    	private TrieNode[] links;
    	private boolean end;
    	public  int SIZE = 26;

    	public TrieNode() {
    		links = new TrieNode[26];
    	}
    	
    	public void put(char ch, TrieNode node) {
    		links[ch - 'a'] = node;
    	}

    	public TrieNode get(char ch) {
    		return links[ch - 'a'];
    	}
    	
    	
    	public void setEnd() {
    		end = true;
    	}
    	
    	public boolean isEnd() {
    		return end;
    	}
    	
    	public TrieNode[] getLinks() {
    		return links;
    	}
    }
    
    /*

	Map<Integer,List<String>> map;
    public WordDictionary() {
        map = new HashMap<>();
        
    }
    
    public void addWord(String word) {
        if(!map.containsKey(word.length())){
            List<String> list = new ArrayList<>();
            list.add(word);
            map.put(word.length(), list);
        } else {
            map.get(word.length()).add(word);
        }
    }
    
    
    public boolean search(String word) {
        int index = word.length();
        if (!map.containsKey(index)){
            return false;
        }
        
        List<String> list = map.get(index);
        for (String listStr : list){
            if(isSame(listStr,word)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isSame(String listStr, String word){
        for (int i = 0; i < listStr.length(); i++){
            if (word.charAt(i) != '.' && listStr.charAt(i) != word.charAt(i)){
                return false;
            }
        }
        return true;
    }


     */
}
