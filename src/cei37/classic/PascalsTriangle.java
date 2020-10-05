package cei37.classic;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();

		for (List<Integer> l : pt.generate(7)) {
			for (Integer n : l) {
				System.out.print(n + "  ");
			}
			System.out.println();
		}
	}

    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> triangle = new ArrayList<>();
    	List<Integer> row = new ArrayList<>();
    	
    	if (numRows == 0) {
    		return triangle;
    	}
    	
    	row.add(1);
    	triangle.add(row);
    	
    	for (int n=1; n<numRows; n++) {
    		row = new ArrayList<>();
    		row.add(1);
    		for (int i=1; i<triangle.get(n-1).size(); i++) {
    			row.add(triangle.get(n-1).get(i-1) + triangle.get(n-1).get(i));
    		}
    		row.add(1);
    		triangle.add(row);
    	}
    	
    	return triangle;
    }
}
