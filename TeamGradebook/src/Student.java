import java.util.ArrayList;

public class Student {
	private String name;
	private ArrayList<Double> grades;

	// TODO: You'll probably need to have some more fields here

	/**
	 * makes a new student object
	 * 
	 * @param newName
	 *            the name of the student
	 */
	public Student(String newName) {
		this.name = newName;
		this.grades = new ArrayList<>();
	}

	/**
	 * gets the name of the student
	 * 
	 * @return the name of the student
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * adds a grade to the student
	 *
	 * @param grade
	 */
	public void addGrade(double grade) {
		this.grades.add(grade);
	}

	/**
	 * 
	 * returns the grades of a student
	 *
	 * @return
	 */
	public ArrayList<Double> getGrades() {
		return this.grades;
	}

	// TODO: You'll need to add some new methods here
}
