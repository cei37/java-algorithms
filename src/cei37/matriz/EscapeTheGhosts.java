package cei37.matriz;

/*
 * 789. Escape The Ghosts
Medium

214

362

Add to List

Share
You are playing a simplified PAC-MAN game on an infinite 2-D grid. You start at the point [0, 0], and you are given a destination point target = [xtarget, ytarget], which you are trying to get to. There are several ghosts on the map with their starting positions given as an array ghosts, where ghosts[i] = [xi, yi] represents the starting position of the ith ghost. All inputs are integral coordinates.

Each turn, you and all the ghosts may independently choose to either move 1 unit in any of the four cardinal directions: north, east, south, or west or stay still. All actions happen simultaneously.

You escape if and only if you can reach the target before any ghost reaches you. If you reach any square (including the target) at the same time as a ghost, it does not count as an escape.

Return true if it is possible to escape, otherwise return false.

 

Example 1:

Input: ghosts = [[1,0],[0,3]], target = [0,1]
Output: true
Explanation: You can reach the destination (0, 1) after 1 turn, while the ghosts located at (1, 0) and (0, 3) cannot catch up with you.
Example 2:

Input: ghosts = [[1,0]], target = [2,0]
Output: false
Explanation: You need to reach the destination (2, 0), but the ghost at (1, 0) lies between you and the destination.
Example 3:

Input: ghosts = [[2,0]], target = [1,0]
Output: false
Explanation: The ghost can reach the target at the same time as you.
Example 4:

Input: ghosts = [[5,0],[-10,-2],[0,-5],[-2,-2],[-7,1]], target = [7,7]
Output: false
Example 5:

Input: ghosts = [[-1,0],[0,1],[-1,0],[0,1],[-1,0]], target = [0,0]
Output: true
 

Constraints:

1 <= ghosts.length <= 100
ghosts[i].length == 2
-104 <= xi, yi <= 104
There can be multiple ghosts in the same location.
target.length == 2
-104 <= xtarget, ytarget <= 104

 */
public class EscapeTheGhosts {

	public static void main(String[] args) {
		EscapeTheGhosts es = new EscapeTheGhosts();
		int[][] ghosts = {
			{1,0},
			//{0,3}
		};
		int[] target = {2 ,0};

		System.out.println(es.escapeGhosts(ghosts, target));

	}

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
    	int cur = getDistance(new int[] {0,0}, target);
    	
    	for (int[] ghost : ghosts) {
    		if (getDistance(ghost, target) <= cur) {
    			return false;
    		}
    	}

    	return true;
    }
    
    private int getDistance(int[] p1, int[] p2) {
    	return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}