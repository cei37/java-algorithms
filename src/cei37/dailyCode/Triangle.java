package cei37.dailyCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 120. Triangle
Medium

2287

261

Add to List

Share
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to 
adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is 
the total number of rows in the triangle.
 */
public class Triangle {

	public static void main(String[] args) {
		Triangle t = new Triangle();
		
		/*int[][] mat = new int[][] {
			   {2},
			  {3,4},
			 {6,5,7},
			{4,1,8,3},
		};*/
		
		List<List<Integer>> mat = new ArrayList<List<Integer>>() {
			{
				add(new ArrayList<Integer>() {
					{
						add(2);
					}
				});
				
				add(new ArrayList<Integer>() {
					{
						add(3);
						add(4);
					}
				});
				
				add(new ArrayList<Integer>() {
					{
						add(6);
						add(5);
						add(7);
					}
				});
				
				add(new ArrayList<Integer>() {
					{
						add(4);
						add(1);
						add(8);
						add(3);
					}
				});
			}
		};
		
		System.out.println(t.minimumTotal(mat));

	}

	public int minimumTotal_1(List<List<Integer>> triangle) {
		if (triangle == null || triangle.isEmpty()) return 0;
		
		int size = triangle.size() - 2;

		for (int i = size; i>=0; i--) {
			for (int j=0; j<triangle.get(i).size(); j++) {
				int top = triangle.get(i).get(j);
				int left = triangle.get(i+1).get(j);
				int right = triangle.get(i+1).get(j+1);
				top += Math.min(left, right);
				triangle.get(i).set(j, top);
			}
		}
		
		return triangle.get(0).get(0);
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.isEmpty()) return 0;

		int arr[] = new int[triangle.size() + 1];

		for (int i = triangle.size()-1; i>=0; i--) {
			for (int j=0; j<triangle.get(i).size(); j++) {
				arr[j] = Math.min(arr[j], arr[j + 1]) + triangle.get(i).get(j);
			}
		}
		
		return arr[0];
	}
}
