package cei37.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTwoFields {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>() {
			{
				add(new Student("Carlos  ", "Artiaga", 20));
				add(new Student("Vicente ", "Villegas", 40));
				add(new Student("Aejandro", "Galvan", 40));
				add(new Student("Aejandro", "Artiaga", 40));
				add(new Student("Aejandro", "Belcomen", 40));
				add(new Student("Alonso  ", "Salazar", 20));
				add(new Student("Bernardo", "Garcia", 20));
				add(new Student("Alex    ", "Gomez  ", 50));
				add(new Student("Esteban ", "Gutierr", 50));
				add(new Student("Francis ", "Garcia", 30));
				add(new Student("Alicia  ", "Garcia", 60));
				add(new Student("Elena   ", "Gutierr", 30));
			}
		};

		//Collections.sort(list, new SortStudentByName());
		//Collections.sort(list, new SortStudentByLastName());
		//Collections.sort(list, (Student s1, Student s2)->s1.getName().compareTo(s2.getName()));
		
		//Comparator<Student> compa = Comparator.comparing(s1 -> s1.getLastName());
		
		Comparator<Student> compa = Comparator.comparing(Student::getName)
				.thenComparing(Student::getLastName);
		
		Collections.sort(list, compa);
	
		
		System.out.println(" ----------------------------------------------------------------");
		for (Student s : list) {
			System.out.println("| " + s.getName() + "\t\t |" + s.getLastName() + "\t\t |");
			System.out.println(" ----------------------------------------------------------------");
		}
	}
}


class SortStudentByLastName implements Comparator<Student> {
	
	@Override
	public int compare(Student s1, Student s2) {

		int comLast = s1.getLastName().compareTo(s2.getLastName());
		
		if (comLast == 0) {
			int comName = s1.getName().compareTo(s2.getName());
			
			if (comName == 0) {
				return s1.getAge() < s2.getAge() ? -1 : 1;
			}
			
			return comName;
		}
		
		return comLast;
	}
}

class SortStudentByName implements Comparator<Student> {
	
	@Override
	public int compare(Student s1, Student s2) {

		int comName = s1.getName().compareTo(s2.getName());
		
		if (comName == 0) {
			int comLastName = s1.getLastName().compareTo(s2.getLastName());
			
			if (comLastName == 0) {
				return s1.getAge() < s2.getAge() ? -1 : 1;
			}
			
			return comLastName;
		}
		
		return comName;
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