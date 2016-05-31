import java.util.ArrayList;

public class Team {
	private ArrayList<Student> team;
	private String teamName;
	private ArrayList<Double> teamGrade;

	/**
	 * 
	 * initalized the team name and the memembers of the team
	 *
	 * @param teamName
	 * @param members
	 *            -- ArrayList of student members
	 */
	public Team(String teamName) {
		this.teamName = teamName;
		this.team = new ArrayList<Student>();
		this.teamGrade = new ArrayList<Double>();
	}

	public void addTeamMembers(ArrayList<Student> members) {
		for (int i = 0; i < members.size(); i++) {
			this.team.add(members.get(i));
		}
	}

	/**
	 * 
	 * adds a single member to a new team
	 *
	 * @param member
	 */
	public void addTeamMembers(Student member) {
		this.team.add(member);
	}

	/**
	 * 
	 * returns the name of the team
	 *
	 * @return
	 */
	public String getName() {
		return this.teamName;
	}

	/**
	 * 
	 * returns the student members of this team
	 *
	 * @return-- members
	 */
	public ArrayList<Student> getMembers() {
		return this.team;
	}

	/**
	 * 
	 * returns the student at the given index of the array of students on this
	 * team
	 *
	 * @param index
	 * @return
	 */
	public Student getStudent(int index) {
		return this.team.get(index);
	}

	/**
	 * 
	 * addes a team grade to the team
	 *
	 * @param grade
	 */
	public void addTeamGrade(double grade) {
		this.teamGrade.add(grade);
	}

	/**
	 * 
	 * returns a list of grades for the team
	 *
	 * @return
	 */
	public ArrayList<Double> getGrades() {
		return this.teamGrade;
	}

	/**
	 * 
	 * returns the average grade for the team
	 *
	 * @return
	 */
	public double teamAverage() {
		double gradeAverage = 0;
		double totalGrade = 0;
		for (int i = 0; i < this.teamGrade.size(); i++) {
			totalGrade += this.teamGrade.get(i);
		}
		gradeAverage = totalGrade / this.teamGrade.size();
		return gradeAverage;
	}
	// You'll need to add methods, constructors and fields here

}
