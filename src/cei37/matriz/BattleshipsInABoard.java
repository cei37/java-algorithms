package cei37.matriz;

/*
419. Battleships in a Board
Medium

886

570

Add to List

Share
Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

 */
public class BattleshipsInABoard {

	public static void main(String[] args) {
		char[][] board = {
			{ 'X', '.', '.', 'X' },
			{ '.', '.', '.', 'X' },
			{ 'X', '.', '.', '.' },
			{ '.', 'X', '.', 'X' },
		};
		
		BattleshipsInABoard ba = new BattleshipsInABoard();
		System.out.println(ba.countBattleships(board));
	}

	
	//this is my solution
    public int countBattleships(char[][] board) {
    	int count = 0;
    	for (int i=0; i<board.length; i++) {
    		for (int j=0; j<board[i].length; j++) {
    			if (board[i][j] == 'X') {
    				count++;
    				discoverShip(board, i, j);
    			}
    		}
    	}
    	return count;
    }
    
    private void discoverShip(char[][] board, int row, int col) {
    	int[][] points = { 
    		{1, 0},
    		{0, 1},
    		{-1, 0},
    		{0, -1},
    	};
    	int rl = board.length;
    	int cl = board[0].length;
    	if (row < rl && row >= 0 && col < cl && col >=0 && board[row][col] == 'X') {
    		board[row][col] = '.';
    		for (int[] point : points) {
    			discoverShip(board, row + point[0], col + point[1]);
    		}
    	}
    }
    
    //this is someone else solutions
    public int countBattleships_1(char[][] board) {
        int result = 0;
        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[row].length; col++) {
                if(board[row][col] != 'X') {
                    continue;
                }
                if(col > 0 && board[row][col-1] == 'X') {
                    continue;
                }
                if(row > 0 && board[row-1][col] == 'X') {
                    continue;
                }
                result++;
            }
        }
        return result;
    }
}