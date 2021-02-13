package cei37.iterator;

import java.util.NoSuchElementException;

public class MyIterator {

	public static void main(String[] args) {
		int[][] v1 = new int[][] {
			{},
			{},
			{},
			{},
			{},
			{ 1,2,3,4,5},
			{ 6,7,8},
			{},
			{},
			{},
			{ 9,10},
			{ 11},
			{},
			{},
			{},
			{ 12,13},
			{},
			{},
			{14,15},
			{},
			{},
		};
		
		int[][] v2 = new int[][] {
			{},
			{},
			{},
			{},
			{},
		};

		int[][] v3 = new int[][] {
			{1,2},
			{3},
			{4},
		};
		
		Vector2D obj = new Vector2D(v3);
		while(obj.hasNext()) {
			System.out.println(obj.next());
		}
	}
}


class Vector2D {
    int[][] v;
    int row = 0;
    int col = 0;
    public Vector2D(int[][] v) {
        this.v = v;
        row = 0;
        col = 0;
    }
    
    public int next() {
    	if (!hasNext()) throw new NoSuchElementException();
    	return v[row][col++];
    }
    
    public boolean hasNext() {

        while (row < v.length && col + 1 > v[row].length) {
        	row++;
        	col = 0;
        }
        
        if (row >= v.length ) {
        	return false;
        }
        
    	return true;
    }
}