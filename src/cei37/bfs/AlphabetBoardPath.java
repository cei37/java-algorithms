package cei37.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 1138. Alphabet Board Path
Medium

365

95

Add to List

Share
On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].

Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.



We may make the following moves:

'U' moves our position up one row, if the position exists on the board;
'D' moves our position down one row, if the position exists on the board;
'L' moves our position left one column, if the position exists on the board;
'R' moves our position right one column, if the position exists on the board;
'!' adds the character board[r][c] at our current position (r, c) to the answer.
(Here, the only positions that exist on the board are positions with letters on them.)

Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
 */
public class AlphabetBoardPath {

	public static void main(String[] args) {
		//AlphabetBoardPath.MySolution a = new AlphabetBoardPath().new MySolution();
		AlphabetBoardPath.OtherSolution a = new AlphabetBoardPath().new OtherSolution();
		System.out.println(a.alphabetBoardPath("leet"));
		System.out.println(a.alphabetBoardPath("code"));
		System.out.println(a.alphabetBoardPath("vicente"));
	}

	class MySolution {
		char[][] board = {
			{'a', 'b', 'c', 'd', 'e'},
			{'f', 'g', 'h', 'i', 'j'},
			{'k', 'l', 'm', 'n', 'o'},
			{'p', 'q', 'r', 's', 't'},
			{'u', 'v', 'w', 'x', 'y'},
			{'z'},
		};
	    public String alphabetBoardPath(String target) {
	    	StringBuilder sb = new StringBuilder();
	    	Node node = new Node(board[0][0], null, ' ', 0, 0);
	    	for (int i=0; i<target.length(); i++) {
	    		char c = target.charAt(i);
	    		Node res = getPath(c, node);
	    		sb.append(res.toString().trim());
	    		node = new Node(board[res.row][res.col], null, ' ', res.row, res.col);
	    	}
	
	    	return sb.toString();
	    }
	    
	    public Node getPath(char target, Node start) {
	    	boolean[][] visited = {
	    		new boolean[5],
	    		new boolean[5],
	    		new boolean[5],
	    		new boolean[5],
	    		new boolean[5],
	    		new boolean[1],
	    	};
	
	    	Queue<Node> q = new LinkedList<>();
	    	q.add(start);
	
	    	int[][] moves = {
	    		{-1, 0, 0}, //row top
	    		{1, 0, 1}, //row down
	    		{0, -1, 2}, //col left
	    		{0, 1, 3}, //col right 
	    	};
	
	    	int newCol = 0;
	    	int newRow = 0;
	    	while(!q.isEmpty()) {
	    		Node node = q.poll();
	    		if (node.value == target) {
	    			return node;
	    		}
	    		visited[node.row][node.col] = true;
	    		for (int[] move : moves) {
	    			newRow = node.row + move[0];
	    			newCol = node.col + move[1];
	    			if (newRow >=0 && newRow < board.length && newCol >= 0 && 
	    				newCol < board[newRow].length &&
	    				!visited[newRow][newCol]) {
	    				
	    				char m = ' ';
	    				if (node.row == newRow) {
	    					//there was a change in the column
	    					m = newCol > node.col ? 'R' : 'L';
	    				} else {
	    					//there was a change in the row
	    					m = newRow > node.row ? 'D' : 'U';
	    				}
	    				q.offer(new Node(board[newRow][newCol], node, m, newRow, newCol));
	    			}
	    		}
	    	}
	    	return null;
	    }
	    
	    class Node {
	    	char value;
	    	int row;
	    	int col;
	    	Node prev;
	    	char move;
	    	
	    	public Node(char value, Node prev, char move, int row, int col) {
	    		this.value = value;
	    		this.prev = prev;
	    		this.move = move;
	    		this.row = row;
	    		this.col = col;
	    	}
	    	
	    	public String toString() {
	    		StringBuilder sb = new StringBuilder();
	    		sb.append('!');
	    		Node p = this;;
	    		while(p != null) {
	    			sb.append(p.move);
	    			p = p.prev;
	    		}
	    		return sb.reverse().toString();
	    	}
	    }
	}
	//other solutio and better
	class OtherSolution {
	    public String alphabetBoardPath(String target) {
	        StringBuilder sb = new StringBuilder();
	        int pos = 0;
	        
	        for (char c : target.toCharArray()) {
	            int cpos = c - 'a';

	            if (cpos != pos) {
	                int x = pos % 5 - cpos % 5;
	                int y = pos / 5 - cpos / 5;

	                while (x > 0) {
	                    x--;
	                    sb.append('L');
	                }
	                
	                while (y > 0) {
	                    y--;
	                    sb.append('U');
	                }
	                
	                while (x < 0) {
	                    x++;
	                    sb.append('R');
	                }
	                
	                while (y < 0) {
	                    y++;
	                    sb.append('D');
	                }                
	            }
	            
	            sb.append('!');
	            pos = cpos;
	        }
	        
	        return sb.toString();
	    }
	}
}