package cei37.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 973. K Closest Points to Origin

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

 */
public class KClosestPointstoOrigin {

	public static void main(String[] args) {
		KClosestPointstoOrigin kc = new KClosestPointstoOrigin();
		int points[][] = new int[][] {
			{-5, 4},
			{-6, -5},
			{4, 6},
		};
		int k = 2;
		
		for (int[] row : kc.kClosest(points, k)) {
			System.out.println(row[0] + " , " + row[1]);
		}

	}

    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

	/*
    public int[][] kClosest(int[][] points, int K) {
    	if (points == null || points.length == 0 || K > points.length) 
    		return new int[0][0];
    	
    	List<Data> list = new ArrayList<Data>();

    	for (int point[] : points) {
    		int dist = point[0]*point[0] + point[1]*point[1];
    		list.add(new Data(point[0], point[1], dist));
    	}
    	
    	Collections.sort(list, new Comparator<Data>() {
			public int compare(Data o1, Data o2) {
				return o1.dist - o2.dist;
			}
    	});
    
    	int [][] res = new int[K][2];
    	
    	for (int i=0; i<K; i++) {
    		res[i][0] = list.get(i).x;
    		res[i][1] = list.get(i).y;
    	}
    	
    	return res;
    }
    
    class Data {
    	int x;
    	int y;
    	int dist;
    	public Data(int x, int y, int dist) {
    		this.x = x;
    		this.y = y;
    		this.dist = dist;
    	}
    }
    */
}
