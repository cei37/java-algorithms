package cei37.hard;

import java.util.ArrayList;
import java.util.List;


public class WordBreakII {

	public static void main(String[] args) {
		WordBreakII wb = new WordBreakII();
		
		List<Test> list = new ArrayList<Test>() { {
			add(new Test("aaaaaaa", new ArrayList<String>() {{
				add("aaaa");
				add("aaa");
			}}, true));
			
			add(new Test("cbca", new ArrayList<String>() {{
				add("bc");
				add("ca");
			}}, false));
			
			add(new Test("a", new ArrayList<String>() {{
				add("a");
			}}, true));
			
			add(new Test("leetcode", new ArrayList<String>() {{
				add("leet");
				add("code");
			}}, true));
			
			add(new Test("applepenapple", new ArrayList<String>() {{
				add("apple");
				add("pen");
			}}, true));
			
			add(new Test("catsandog", new ArrayList<String>() {{
				add("cats");
				add("dog");
				add("sand");
				add("and");
				add("cat");
			}}, false));
			
		}};

		for (Test t : list) {
			System.out.println(wb.wordBreak(t.s, t.wordDict) + " expected -- > " + t.expected);
		}
	}
	
    public List<String> wordBreak(String s, List<String> wordDict) {
        return null;
    }

    static class Test {
    	String s;
    	List<String> wordDict;
    	boolean expected;
    	public Test(String s, List<String> wordDict, boolean expected) {
    		this.s = s;
    		this.wordDict = wordDict;
    		this.expected = expected;
    	}
    }
}