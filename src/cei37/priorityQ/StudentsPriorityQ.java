package cei37.priorityQ;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StudentsPriorityQ {

	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<Student>(new PriorityByAge()) {
			{
				add(new Student("Carlos", "Gutierr", 20));
				add(new Student("Vicente", "Villegas", 40));
				add(new Student("Carlos", "Galvan", 40));
				add(new Student("Esteban", "Salazar", 20));
				add(new Student("Franco", "Garcia", 20));
				add(new Student("Carlos", "Gomez  ", 50));
				add(new Student("Carlos", "Gutierr", 50));
				add(new Student("Francis", "Garcia", 30));
				add(new Student("Carlos", "Garcia", 60));
				add(new Student("Carlos", "Gutierr", 30));
			}
		};
		
		while(!pq.isEmpty()) {
			Student s = pq.poll();
			System.out.println("| " + s.getName() + "\t\t |" + s.getLastName() + "\t\t |" + s.getAge() + "\t\t |");
			System.out.println(" ----------------------------------------------------------------");
		}
	}
}

class PriorityByAge implements Comparator<Student> {
	
	@Override
	public int compare(Student s1, Student s2) {

		return s1.getAge() < s2.getAge() ? -1 : 1;
		
	}
}

class Student {	
	private String name;
	private String lastName;
	private int age;
	
	public Student(String name, String lastName, int age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}