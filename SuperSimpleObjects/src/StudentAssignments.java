import java.util.ArrayList;


public class StudentAssignments {
	private String name; 
	private ArrayList<String> gradeArray = new ArrayList<String>();
	
	/**
	 * 
	 * constructs student with default name.
	 *
	 */
	public StudentAssignments() {
		this.name = "Studenty McStudenton";
	}
	
	/**
	 * 
	 * contsturts student with given name
	 *
	 * @param name -- name of student
	 */
	public StudentAssignments(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * makes a list of assignments, and the grades the student recived
	 * on these assignments
	 *
	 * @param assignment -- name of assignment
	 * @param grade -- grade of that assignment
	 * @return
	 */
	public void addAssignment(String assignment, double grade) {
		this.gradeArray.add(assignment + " - " + grade);
	}
	
	/**
	 * 
	 * prints the students name and the grades that the student has
	 * recived on all of his asssignments
	 *
	 */
	public void printGradeReport() {
		System.out.println(this.name + ": " + this.gradeArray);
	}
}
