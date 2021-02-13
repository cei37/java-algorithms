package cei37.hash;

/*
690. Employee Importance
Easy

877

815

Add to List

Share
You are given a data structure of employee information, which includes the employee's unique id, their importance value and their direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all their subordinates.

Example 1:

Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 

Note:

One employee has at most one direct leader and may have several subordinates.
The maximum number of employees won't exceed 2000.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, 5, new ArrayList<Integer>() {{
			add(2);
			add(3);
		}}));
		
		list.add(new Employee(2, 3, new ArrayList<Integer>() {{   }}));
		
		list.add(new Employee(3, 3, new ArrayList<Integer>() {{	  }}));
		
		
		EmployeeImportance em = new EmployeeImportance();
		
		System.out.println(em.getImportance(list, 1));
	}

    public int getImportance(List<Employee> employees, int id) {
    	Map<Integer, Employee> g = new HashMap<>();
    	
    	for (Employee em : employees) {
    		g.put(em.id, em);
    	}
    	
    	return getImportance(0, g, id);
    }
    
    private int getImportance(int total, Map<Integer, Employee> g, int id) {
    	
    	Employee em = g.get(id);
    	
    	if (em == null) {
    		return total;
    	}
    	total = em.importance;
    	for (int newId : em.subordinates) {
    		total += getImportance(total, g, newId);
    	}

    	return total;
    }
    
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
        
        public Employee(int id, int importance, List<Integer> subordinates) {
        	this.id = id;
        	this.importance = importance;
        	this.subordinates = subordinates;
        }
    };
}