package cei37.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * 554. Brick Wall

There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. 
The bricks have the same height but different width. You want to draw a vertical line from the 
top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the 
width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need 
to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line 
will obviously cross no bricks.

Example:

Input: [[1,2,2,1],
        [3,1,2],
        [1,3,2],
        [2,4],
        [3,1,2],
        [1,3,1,1]]

Output: 2

Explanation: 

Note:

The width sum of bricks in different rows are the same and won't exceed INT_MAX.
The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 */
public class BrickWall {

	public static void main(String[] args) {
		BrickWall bw = new BrickWall();
		List<List<Integer>> wall = new ArrayList<List<Integer>>() { {
			add(new ArrayList<Integer>() {{
				add(1);
				add(2);
				add(2);
				add(1);
			}});
			add(new ArrayList<Integer>() {{
				add(3);
				add(1);
				add(2);
			}});
			add(new ArrayList<Integer>() {{
				add(1);
				add(3);
				add(2);
			}});
			add(new ArrayList<Integer>() {{
				add(2);
				add(4);
			}});
			add(new ArrayList<Integer>() {{
				add(3);
				add(1);
				add(2);
			}});
			add(new ArrayList<Integer>() {{
				add(1);
				add(3);
				add(1);
				add(1);
			}});
		} };

		System.out.println(bw.leastBricks(wall));
	}
	
    public int leastBricks(List<List<Integer>> wall) {
    	if (wall == null || wall.size() == 0) return 0;
    	
    	Map<Integer, Integer> hash = new HashMap<>();
    	for (int i=0; i<wall.size(); i++) {
    		int sum = 0;
    		for (int j=0; j<wall.get(i).size()-1; j++) {
    			sum += wall.get(i).get(j);
    			hash.put(sum, hash.getOrDefault(sum, 0) + 1);
    		}
    	}
    	
    	int max = 0;
    	for (Map.Entry<Integer, Integer> e : hash.entrySet()) {
    		max = Math.max(max, e.getValue());
    	}

    	return wall.size() - max;
    }
}
