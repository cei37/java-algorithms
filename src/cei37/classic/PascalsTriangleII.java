package cei37.classic;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	public static void main(String[] args) {
		PascalsTriangleII pt = new PascalsTriangleII();

		pt.getRow(3).stream().forEach(a -> 
			System.out.print(a + "  ")
		);
	}

    public List<Integer> getRow(int rowIndex) {
    	List<Integer> row = new ArrayList<>();
    	
    	row.add(1);

    	if (rowIndex == 0) {
    		return row;
    	}
    	
    	for (int n=1; n<=rowIndex; n++) {
    		List<Integer> prevRow = row;
    		row = new ArrayList<>();
    		row.add(1);
    		for (int i=1; i<prevRow.size(); i++) {
    			row.add(prevRow.get(i-1) + prevRow.get(i));
    		}
    		row.add(1);
    	}
    	
    	return row;
    }
}
