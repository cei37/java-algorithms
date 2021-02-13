package cei37.minimax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
843. Guess the Word
Hard

720

742

Add to List

Share
This problem is an interactive problem new to the LeetCode platform.

We are given a word list of unique words, each word is 6 letters long, and one word in this list is chosen as secret.

You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from the original list with 6 lowercase letters.

This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.

For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or less calls to master.guess and at least one of these guesses was the secret, you pass the testcase.

Besides the example test case below, there will be 5 additional test cases, each with 100 words in the word list.  The letters of each word in those testcases were chosen independently at random from 'a' to 'z', such that every word in the given word lists is unique.

Example 1:
Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]

Explanation:

master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.

We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
Note:  Any solutions that attempt to circumvent the judge will result in disqualification.
 */
public class GuessTheWord {

	public static void main(String[] args) {
		
    	char[][] board = {
    		{'a', 'b', 'c', 'd', 'e'},
    		{'f', 'g', 'h', 'i', 'j'},
    		{'k', 'l', 'm', 'n', 'o'},
    		{'p', 'q', 'r', 's', 't'},
    		{'u', 'v', 'w', 'x', 'y'},
    		{'z'},
    	};
    	
    	for (int i=0; i<board.length; i++) {
    		for (int j=0; j<board[i].length; j++) {
        		System.out.print(board[i][j] + ",");
        	}
    		System.out.println();
    	}
    	System.exit(0);
		//String[] wordList = { "acckzz", "ccbazz", "eiowzz", "abcczz" };
		
		//GuessTheWord.Solution1 g1 = new GuessTheWord().new Solution1();
		//g1.findSecretWord(wordList, null);
		
		//GuessTheWord.Solution2 g2 = new GuessTheWord().new Solution2();
		//g2.findSecretWord(wordList, guess);
		
		//need to take a look to
		//https://leetcode.com/problems/guess-the-word/discuss/133862/Random-Guess-and-Minimax-Guess-with-Comparison
		
		int N = 1000;
		int average = 0;
		for (int i=0; i<N; i++) {
			GuessTheWord.Guess guess= new GuessTheWord().new Guess(100);
			GuessTheWord.MySolution my = new GuessTheWord().new MySolution(); //average 6
			//GuessTheWord.Solution1 my = new GuessTheWord().new Solution1(); //average 5-6
			System.out.println("=================");
			guess.pickUpWord();
			//System.out.println(guess.pickUpWord());
			my.findSecretWord(guess.words, guess);
			if (my.tries > 10) {
				System.out.println("--" + my.tries + "--");
			} else {
				System.out.println(my.tries);
			}
			average += my.tries;
		}
		System.out.println("Average: " + (average / N));
	}
	
	class MySolution {
		int tries;
	    public void findSecretWord(String[] wordlist, Master master) {
	        int guess = 0;
	        int row = 0;
	        while(guess != 6) {
	        	//using Random the use case is not passed, need to use Math.random
	            row = (int)(Math.random()*wordlist.length); //ran.nextInt(wordlist.length);
	            guess = master.guess(wordlist[row]);
	            tries++;
	            if (guess == 6) return;

	            List<String> wordlist2 = new ArrayList<>();
	            for (String word : wordlist) {
	                if (match(wordlist[row], word) == guess) {
	                    wordlist2.add(word);
	                }
	            }
	            wordlist =  wordlist2.toArray(new String[0]);
	        }
	    }

	    public int match(String s1, String s2) {
	        int count = 0;
	        for (int i=0; i<s1.length(); i++) {
	            if (s1.charAt(i) == s2.charAt(i)) {
	                count++;
	            }
	        }
	        return count;
	    }
	}
	
	class MySolution2 {
		int tries;
	    public void findSecretWord(String[] wordlist, Master master) {
	    	int guess = 0;
	    	Random ran = new Random();
	    	int row = 0;
	    	String w = "";
	    	while(guess != 6) {
	    		row = ran.nextInt(wordlist.length);
	    		guess = master.guess(wordlist[row]);
	    		w = wordlist[row];
	    		
	    		List<String> wordlist2 = new ArrayList<>();
	    		for (String word : wordlist) {
	    			if (match(wordlist[row], word) == guess) {
	    				wordlist2.add(word);
	    			}
	    		}
	    		wordlist =  wordlist2.toArray(new String[0]);
	    		tries++;
	    	}

	    	if (guess == 6) {
    			System.out.println("Found.." + w);
    			return;
    		}
	    }
	    
	    public int match(String s1, String s2) {
			int count = 0;
			for (int i=0; i<s1.length(); i++) {
				if (s1.charAt(i) == s2.charAt(i)) {
					count++;
				}
			}
			return count;
	    }
	}

	class MySolution1 {
		int tries;
	    public void findSecretWord(String[] wordlist, Master master) {
	    	//Arrays.sort(wordlist);
	    	int[][] matriz = buildMatriz(wordlist);
	    	
	    	int row = 0;
	    	int guess = 0;
	    	for (String word : wordlist)  {
	    		if (word == null) {
	    			continue;
	    		}
	    		guess = master.guess(word);
	    		tries++;
	    		if (guess == 6) {
	    			System.out.println("Found..");
	    			return;
	    		} else if (guess == 0) {
	    			wordlist[row] = null;
	    			for (int i=0; i<matriz.length; i++) {
	    				if (matriz[row][i] > 0) {
	    					wordlist[i] = null;
	    				}
	    			}
	    		} /*else {
	    			for (int i=0; i<matriz.length; i++) {
	    				if (matriz[row][i] < guess) {
	    					wordlist[i] = null;
	    				}
	    			}
	    		}*/
	    	}
	    }
	    
	    private int[][] buildMatriz(String[] wordlist) {
	    	int[][] matriz = new int[wordlist.length][wordlist.length];
	    	for (int row=0; row<wordlist.length; row++) {
	    		for (int col=row; col<wordlist.length; col++) {
	    			int matches = 0;
	    			for (int i=0; i<6; i++) {
	    				if (wordlist[row].charAt(i) == wordlist[col].charAt(i)) {
	    					matches++;
	    				}
	    			}
	    			matriz[row][col] = matches;
	    		}
	    	}
	    	return matriz;
	    }
	}

	class Solutio4 {
		//Minimax
	    public void findSecretWord(String[] wordlist, Master master) {
	        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
	            HashMap<String, Integer> count = new HashMap<>();
	            for (String w1 : wordlist)
	                for (String w2 : wordlist)
	                    if (match(w1, w2) == 0)
	                        count.put(w1, count.getOrDefault(w1 , 0) + 1);
	            String guess = "";
	            int min0 = 100;
	            for (String w : wordlist)
	                if (count.getOrDefault(w, 0) < min0) {
	                    guess = w;
	                    min0 = count.getOrDefault(w, 0);
	                }
	            x = master.guess(guess);
	            List<String> wordlist2 = new ArrayList<String>();
	            for (String w : wordlist)
	                if (match(guess, w) == x)
	                    wordlist2.add(w);
	            wordlist = wordlist2.toArray(new String[0]);
	        }
	    }

		//Guess a Random Word
	    public void findSecretWord_1(String[] wordlist, Master master) {
	        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
	            String guess = wordlist[new Random().nextInt(wordlist.length)];
	            x = master.guess(guess);
	            List<String> wordlist2 = new ArrayList<>();
	            for (String w : wordlist)
	                if (match(guess, w) == x)
	                    wordlist2.add(w);
	            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
	        }
	    }

	    public int match(String a, String b) {
	        int matches = 0;
	        for (int i = 0; i < a.length(); ++i)
	            if (a.charAt(i) == b.charAt(i))
	                matches ++;
	        return matches;
	    }
	}

	class Solution3 {
		/*
		 * GOOD COMMENT
		 * This solution won't work though. I think everyone arrives to this solution in
		 * the beginning where countMatches != Master.guess. But it doesn't work all the
		 * time, simply sometine rand() is lucky enough to guess all 4 test cases
		 * properly.
		 */
		/*
		 * I will try to explain this question in a better way than the author did. Here
		 * We are given with a wordlist, which contains a secret word. Ex: wordlist =
		 * <abcmno, demfab, gmhipq, jkldef, limnpq, opqabc> and secret word is limnpq
		 * Now there is a function guess(String guessWord) supplied by Leetcode backend
		 * which returns the number of matches with the secret word. And remember,
		 * guessWord is always a word from the supplied wordList Eg: guess(demfab) means
		 * demfab will be compared with secret word (limnpq). so compare(d,l)=0,
		 * compare(e,i)=0, compare(m,m)=1, compare(f,n)=0, compare(a,p)=0,
		 * compare(b,q)=0. So comparing demfab(it could be any random string from the
		 * wordlist) with the secret word returns total match = 1 position that matched.
		 * Now if guess() is supplied with secret word itself, all characters will
		 * match(here 6). So the idea is to eliminate some number of strings from word
		 * list after each loop until we find 100% match where we can guess the word. If
		 * we run the loop less that 10 times and find the answer, we are good. If not
		 * the test fails. So we have to reduce the search space by eliminating some of
		 * the words from wordlist.
		 */
		public void findSecretWord(String[] wordlist, Master master) {
			Random random = new Random();
			// First we will have a list constructed from wordlist to keep the original list
			// of words/ original search space given to us
			List<String> currentSearchSpace = new ArrayList<>();
			for (String s : wordlist)
				currentSearchSpace.add(s);
			// Now we have to try to guess the word with in 10 attempts. If not we quit
			int maxTrials = 10;
			int trial = 1;
			while (trial <= maxTrials) {
				// First we try to randomly pick an index in the wordlist and check if that
				// string is the correct word
				// This random number could be anything from 0 till size-1
				int currentPickIndex = random.nextInt(currentSearchSpace.size());
				String currentPickedWord = currentSearchSpace.get(currentPickIndex);
				// Check if the guessed word is the secret one by getting number of matches
				// returned from guess()
				int numMatches = master.guess(currentPickedWord);
				// If we get 6 matches it is all done, as this is the secret word which we
				// guessed
				if (numMatches == 6)
					return;
				// If not, we create a new search space with all the words with which the
				// currentPickedWord has same
				// number of matches numMatches. That means the new search space will include
				// atleast the secret word
				// along with (may be) some extra words from the list. But definitely the search
				// space would be smaller
				// than the original list provided.
				List<String> newSearchSpace = new ArrayList<>();
				for (String s : currentSearchSpace) {
					if (countMatches(currentPickedWord, s) == numMatches)
						newSearchSpace.add(s);
				}
				// Now assign the newSearchSpace to the currentSearchSpace
				currentSearchSpace = new ArrayList(newSearchSpace);
				trial++;
			}
			// If we cannot guess the word in 10 attempts, this test fails.

		}

		public int countMatches(String word1, String word2) {
			int count = 0;
			for (int i = 0; i < 6; i++) {
				if (word1.charAt(i) == word2.charAt(i))
					count++;
			}
			return count;
		}
	}

	class Solution2 {
		/*
		 * The problem to start with a random word is not deterministic. If the list of words 
			is longer than 100, probably will fail more.
			Could be expensive, but an alternative is sort first the list. In this case, 
			there is a relation between two continuous words. This is my solution:
		 */
		public void findSecretWord(String[] wordlist, Master master) {
			Arrays.sort(wordlist);
			Map<String, Integer> badWords = new HashMap();
			for (String word : wordlist) {
				if (validateWord(word, badWords)) {
					int score = master.guess(word);
					if (score == 6) {
						return;
					}
					badWords.put(word, score);
				}
			}
		}

		private boolean validateWord(String candidate, Map<String, Integer> badWords) {
			int similarity = 0;
			Integer score = 0;
			for (String w : badWords.keySet()) {
				similarity = similarity(w, candidate);
				score = badWords.get(w);
				if ((score == 0 && similarity > 0) || similarity < score) {
					return false;
				}
			}
			return true;
		}

		public int similarity(String s1, String s2) {
			int count = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == s2.charAt(i)) {
					count++;
				}
			}
			return count;
		}
	}

	class Solution1 {
		/*
		Approach #1: Minimax with Heuristic [Accepted]
		Intuition
		
		We can guess that having less words in the word list is generally better. If the data is random, we can reason this is often the case.
		
		Now let's use the strategy of making the guess that minimizes the maximum possible size of the resulting word list. If we started with NN words in our word list, we can iterate through all possibilities for what the secret could be.
		
		Algorithm
		
		Store H[i][j] as the number of matches of wordlist[i] and wordlist[j]. For each guess that hasn't been guessed before, do a minimax as described above, taking the guess that gives us the smallest group that might occur.
		
		 */
		int[][] H;
		int tries = 0;
		public void findSecretWord(String[] wordlist, Master master) {
			int N = wordlist.length;
			H = new int[N][N];
			for (int i = 0; i < N; ++i) {
				for (int j = i; j < N; ++j) {
					int match = 0;
					for (int k = 0; k < 6; ++k) {
						if (wordlist[i].charAt(k) == wordlist[j].charAt(k)) {
							match++;
						}
					}
					H[i][j] = H[j][i] = match;
				}
			}
	
			List<Integer> possible = new ArrayList();
			List<Integer> path = new ArrayList();
			for (int i = 0; i < N; ++i) {
				possible.add(i);
			}
	
			while (!possible.isEmpty()) {
				int guess = solve(possible, path);
				int matches = master.guess(wordlist[guess]);
				tries++;
				if (matches == wordlist[0].length()) {
					return;
				}
				List<Integer> possible2 = new ArrayList();
				for (Integer j : possible) {
					if (H[guess][j] == matches) {
						possible2.add(j);
					}
				}
				possible = possible2;
				path.add(guess);
			}
	
		}
	
		public int solve(List<Integer> possible, List<Integer> path) {
			if (possible.size() <= 2) {
				return possible.get(0);
			}
			List<Integer> ansgrp = possible;
			int ansguess = -1;
	
			for (int guess = 0; guess < H.length; ++guess) {
				if (!path.contains(guess)) {
					ArrayList<Integer>[] groups = new ArrayList[7];
					for (int i = 0; i < 7; ++i) {
						groups[i] = new ArrayList<Integer>();
					}
					for (Integer j : possible) {
						if (j != guess) {
							groups[H[guess][j]].add(j);
						}
					}
	
					ArrayList<Integer> maxgroup = groups[0];
					for (int i = 0; i < 7; ++i) {
						if (groups[i].size() > maxgroup.size()) {
							maxgroup = groups[i];
						}
					}
	
					if (maxgroup.size() < ansgrp.size()) {
						ansgrp = maxgroup;
						ansguess = guess;
					}
				}
			}
	
			return ansguess;
		}
	}

	interface Master {
		public int guess(String word);
	}
	
	class Guess implements Master {
		String word;
		int SIZE = 100;
		String[] words = new String[SIZE];

		public Guess(int N) {
			SIZE = N;
			words = new String[SIZE];
			generateWords();
		}
		public Guess() {
			generateWords();
		}
		
		public void generateWords() {
			Random ran = new Random();
			StringBuilder sb = new StringBuilder();
			
			for (int j=0; j<SIZE; j++) {
				for (int i=0; i<6; i++) {
					sb.append((char)(ran.nextInt(26) + 'a'));
				}
				words[j] = sb.toString();
				sb = new StringBuilder();
			}
		}

		public String pickUpWord() {
			Random ran = new Random();
			word = words[ran.nextInt(SIZE)];
			return word;
		}

		public int guess(String word) {
			int count = 0;
			
			for (int i=0; i<word.length(); i++) {
				if (this.word.charAt(i) == word.charAt(i)) {
					count++;
				}
			}
			
			return count;
		}
	}
}