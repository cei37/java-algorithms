package cei37.matriz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 957. Prison Cells After N Days

There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, 
else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described 
above.)

 

Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]
 

Note:

cells.length == 8
cells[i] is in {0, 1}
1 <= N <= 10^9
 */
public class PrisonCellsAfterNDays {

	public static void main(String[] args) {
		PrisonCellsAfterNDays pc = new PrisonCellsAfterNDays();
		int days = 1000000000;
		int[] cells = new int[] {
			1,0,0,1,0,0,1,0
		};
		
		for (int i : pc.prisonAfterNDays(cells, days)) {
			System.out.print(i + "  ");
		}
	}

	/*
	 * Output: [0,0,1,1,1,1,1,0]
	 */
	public int[] prisonAfterNDays(int[] cells, int N) {
    	
    	if (cells == null || cells.length == 0) return new int[0];

    	Map<String, Integer> map = new HashMap<>();
		int loop = 0;
		
    	for (int i=N; i>0; i--) {
        	int[] day = new int[cells.length];
        	map.put(Arrays.toString(cells), loop++);
    		for (int j=1; j<cells.length-1; j++) {
    			day[j] = cells[j-1] == cells[j+1] ? 1 : 0;
    		}
    		cells = day;
    		if (map.containsKey(Arrays.toString(cells))) {
    			i %= loop - map.get(Arrays.toString(cells));
        	}
    	}

    	return cells;
    }

	public int[] prisonAfterNDays3(int[] cells, int N) {

		Map<String, Integer> map = new HashMap<>();
		int circle = 0;
		while (N-- > 0) {
			int[] next = new int[8];
			map.put(Arrays.toString(cells), circle++);
			for (int i = 1; i < 7; i++)
				next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
			cells = next;
			if (map.containsKey(Arrays.toString(cells)))
				N %= circle - map.get(Arrays.toString(cells));
		}

		return cells;
	}

    public int[] prisonAfterNDays2(int[] cells, int N) {
    	
    	if (cells == null || cells.length == 0) return new int[0];
    	
    	for (int i=0; i<N; i++) {
    		int left = 0;
			int center = 0;
			int right = 0;
    		for (int j=1; j<cells.length; j++) {
    			center = cells[j];
    			if (j + 1 <cells.length) {
    				right = cells[j+1];
    				cells[j] = left == right ? 1 : 0;
    			} else {
    				right = 0;
    				cells[j] = 0;
    			}
    			left = center;
    		}
    	}

    	return cells;
    }
}
