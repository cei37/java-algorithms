package cei37.dailyCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * 582. Kill Process

Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. 
This is just like a tree structure. Only one process has PPID that is 0, which means this 
process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains 
PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list 
of PIDs of processes that will be killed in the end. You should assume that when a process 
is killed, all its children processes will be killed. No order is required for the final answer.

Example 1:
Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
Note:
The given kill id is guaranteed to be one of the given PIDs.
n >= 1.


 */
public class KillProcess {

	public static void main(String[] args) {
		KillProcess kp = new KillProcess();
		List<Integer> pid = new ArrayList<Integer>() {
			{
				add(1);
				add(3);
				add(10);
				add(5);
			}
		};
		
		List<Integer> ppid = new ArrayList<Integer>() {
			{
				add(3);
				add(0);
				add(5);
				add(3);
			}
		};
		
		int kill = 5;
		
		for (int i : kp.killProcess(pid, ppid, kill)) {
			System.out.println(i);
		}
	}

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i=0; i<pid.size(); i++) {
            if (map.get(ppid.get(i))==null) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(pid.get(i));
                map.put(ppid.get(i), list);
            } else {
                map.get(ppid.get(i)).add(pid.get(i));
            }
        }
        
        List<Integer> pidToKill = new ArrayList<>();
        killProcess(map, kill, pidToKill);
        
        return pidToKill;
    }
    
    public void killProcess(Map<Integer, List<Integer>> map, int kill, List<Integer> result) {
        
        List<Integer> toBeKilled = map.get(kill);
        //map.remove(kill);
        result.add(kill);
        
        if (toBeKilled != null && toBeKilled.size() > 0) {
            for (Integer toKill : toBeKilled) {
                killProcess(map, toKill, result);
            }
        }
    }
}
