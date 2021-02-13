package cei37.priorityQ;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 1491. Average Salary Excluding the Minimum and Maximum Salary
Easy

215

46

Add to List

Share
Given an array of unique integers salary where salary[i] is the salary of the employee i.

Return the average salary of employees excluding the minimum and maximum salary.

 

Example 1:

Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500
Example 2:

Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000)/1= 2000
Example 3:

Input: salary = [6000,5000,4000,3000,2000,1000]
Output: 3500.00000
Example 4:

Input: salary = [8000,9000,2000,3000,6000,1000]
Output: 4750.00000
 */
public class AverageSalaryExcludingRheMinimumAndMaximumSalary {

	public static void main(String[] args) {
		AverageSalaryExcludingRheMinimumAndMaximumSalary av = new AverageSalaryExcludingRheMinimumAndMaximumSalary();
		int[][] salary = new int[][] {
			{4000,3000,1000,2000},
			{1000,2000,3000},
			{6000,5000,4000,3000,2000,1000},
			{8000,9000,2000,3000,6000,1000}
		};

		for (int[] arr : salary) {
			System.out.println(av.average(arr));
		}
	}

    public double average(int[] salary) {
    	if (salary == null || salary.length <=2) {
    		return 0;
    	}
    	
    	double sum = 0;
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	for (int num : salary) {
    		min = Math.min(min, num);
    		max = Math.max(max, num);
    		sum += num;
    	}

    	return (sum - max - min) / (salary.length - 2);
    }

    public double average_1(int[] salary) {
    	if (salary == null || salary.length <=2) {
    		return 0;
    	}
    	
    	double average = 0;
    	Queue<Integer> pq = new PriorityQueue<>();
    	
    	for (int num : salary) {
    		pq.offer(num);
    	}
    	
    	int total = pq.size() - 2;
    	//let's remove the first element from queue (smallest)
    	pq.poll();
    	while(!pq.isEmpty() && pq.size() > 1) {
    		average += pq.poll();
    	}

    	return average/total;
    }
}
