import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * creats a console where students can be added students can recive grades on
 * assignments students can be added to created teams
 *
 * @author goldacbj. Created Dec 11, 2014.
 */
public class TeamGradebook {

	private ArrayList<Student> students;
	private ArrayList<Team> teams;

	/**
	 * Constructor - initializes the fields of TeamGradebook
	 * 
	 * You'll want to be sure you initialize students and teams here.
	 */
	public TeamGradebook() {
		this.students = new ArrayList<Student>();
		this.teams = new ArrayList<Team>();
	}

	/**
	 * Adds a student for grade tracking.
	 * 
	 * You can assume the student name is unique. If the student name is
	 * duplicated, feel free to do whatever you want - error, act buggy,
	 * whatever.
	 * 
	 * @param studentName
	 *            name to add
	 * @return "ok" if successful
	 */
	private String handleAddStudent(String studentName) {
		Student student = new Student(studentName);
		students.add(student);
		return "ok";
	}

	/**
	 * Get all student names
	 * 
	 * @return a space separated list of student names
	 */
	private String handleGetNames() {
		String memberNames = "";
		for (int i = 0; i < this.students.size(); i++) {
			memberNames += this.students.get(i).getName();
			if (i < this.students.size() - 1) {
				memberNames += " ";
			}
		}
		return memberNames;
	}

	/**
	 * Adds a team.
	 * 
	 * You can assume the student team name is unique.
	 * 
	 * (for individual assignment): the student names should be students that
	 * have been already added
	 * 
	 * PAIR ASSIGNMENT: implicitly create students if they don't exist
	 * 
	 * @param teamName
	 *            name of new team
	 * @param memberNames
	 *            a list of student names that belong to the team
	 * @return "ok" if success
	 */
	private String handleAddTeam(String teamName, ArrayList<String> memberNames) {
		Team teamx = new Team(teamName);
		this.teams.add(teamx);
		Student studentx = null;
		for (int i = 0; i < memberNames.size(); i++) {
			if (getStudentByName(memberNames.get(i)) != null) {
				studentx = getStudentByName(memberNames.get(i));
			} else {
				studentx = new Student(memberNames.get(i));
				this.students.add(studentx);
			}
			teamx.addTeamMembers(studentx);

		}

		return "ok";
	}

	/**
	 * Returns the student from students with the particular name, null
	 * otherwise (e.g., if the student does not exist).
	 * 
	 * You'll find this method handy when writing addTeam and getAverage.
	 * 
	 * @param name
	 *            the name of the student for whom to search
	 * @return student object with the name or null
	 */
	public Student getStudentByName(String name) {
		for (int i = 0; i < this.students.size(); i++) {
			if (name.equals(this.students.get(i).getName())) {
				return this.students.get(i);
			}
		}

		return null;
	}

	/**
	 * Adds a grade to all the students on the given team.
	 * 
	 * You can assume the team has already been created.
	 * 
	 * @param teamName
	 *            the team to add the grade to
	 * @param grade
	 *            the grade to add
	 * @return "ok" if successful
	 */
	private String handleAddGrade(String teamName, double grade) {
		Team teamx;
		Student studentx;
		for (int i = 0; i < this.teams.size(); i++) {
			if (teamName.equals(this.teams.get(i).getName())) {
				teamx = this.teams.get(i);
				teamx.addTeamGrade(grade);
				for (int j = 0; j < teamx.getMembers().size(); j++) {
					studentx = teamx.getStudent(j);
					studentx.addGrade(grade);
				}
			}
		}
		return "ok";
	}

	/**
	 * Returns the average for a particular student as a string.
	 * 
	 * NOTE the result should be ROUNDED to the nearest whole number Check out
	 * Long.toString and Math.round
	 * 
	 * NOTE if a student has no grades, the student's average should be 0
	 * 
	 * @param studentName
	 *            name of student
	 * @return average grade as string, rounded to nearest whole number
	 */
	private String handleGetAverage(String studentName) {

		Student studentx = getStudentByName(studentName);
		ArrayList<Double> grades = studentx.getGrades();
		if (grades.size() == 0) {
			return "0";
		}
		double averageGrade = 0;
		double totalGrade = 0;
		for (int i = 0; i < grades.size(); i++) {
			totalGrade += grades.get(i);
		}
		averageGrade = totalGrade / grades.size();
		long averageGradeRoudned = Math.round(averageGrade);

		return Long.toString(averageGradeRoudned);
	}

	/**
	 * Returns the team name with the best average on all grades for that team
	 * 
	 * PAIR ASSIGNMENT
	 * 
	 * THIS PART OF THE ASSIGNMENT MAY BE done in pairs with another student. Be
	 * sure to note who you paired with in a comment. You don't have to pair if
	 * you don't want to.
	 * 
	 * NOTE that "best team" is different from the team with the best students.
	 * The average is for the grades FOR THAT TEAM - not including other grades
	 * that students on that team might have.
	 * 
	 * Say, for example, there is a team that had one grade of 100. Then that
	 * TEAM's average should be 100, even if each of the members of the team got
	 * grades with other groups. You'll have to keep track of additional info to
	 * determine each team's average grades.
	 * 
	 * If a team has no grades, it's average should be considered to be 0.
	 * 
	 * If several teams have exactly the same average, any one of them may be
	 * returned as the best group.
	 * 
	 * If no teams exist, you can return an error.
	 * 
	 * @return the name of the team with the best overall average
	 */
	private String handleGetBestTeam() {
		double highestGrade = 0;
		double averageGrade = 0;
		Team teamx;
		Team bestTeam = null;
		if (this.teams.size() == 0) {
			return "No teams";
		}
		for (int i = 0; i < this.teams.size(); i++) {
			teamx = this.teams.get(i);
			averageGrade = teamx.teamAverage();
			if (averageGrade > highestGrade) {
				highestGrade = averageGrade;
				bestTeam = teamx;
			}
		}
		return bestTeam.getName();
	}

	/**
	 * Decodes a command and invokes the right method.
	 * 
	 * THIS METHOD IS WRITTEN FOR YOU - no need to edit
	 * 
	 * You don't have to understand how this function works, and you don't have
	 * to change it. But it's not that hard - feel free to figure it out if you
	 * like.
	 * 
	 * @param command
	 *            The command to decode
	 * @return the results of the command. "ok" if success but no result.
	 */
	public String handleCommand(String command) {
		Scanner input = new Scanner(command);
		String commandType = input.next();

		if (commandType.equals("add-student")) {
			String studentName = input.next();
			input.close();
			return handleAddStudent(studentName);
		}

		if (commandType.equals("get-names")) {
			input.close();
			return handleGetNames();
		}

		if (commandType.equals("add-team")) {
			String teamName = input.next();
			ArrayList<String> memberNames = new ArrayList<String>();
			while (input.hasNext()) {
				memberNames.add(input.next());
			}
			input.close();
			return handleAddTeam(teamName, memberNames);
		}

		if (commandType.equals("add-grade")) {
			String teamName = input.next();
			double grade = input.nextDouble();
			input.close();
			return handleAddGrade(teamName, grade);
		}

		if (commandType.equals("get-average")) {
			String studentName = input.next();
			input.close();
			return handleGetAverage(studentName);
		}

		if (commandType.equals("get-best-team")) {
			input.close();
			return handleGetBestTeam();
		}

		if (commandType.equals("exit")) {
			System.exit(0);
		}

		input.close();
		return "Unknown command " + commandType;
	}

	/**
	 * 
	 * Run the TeamGradebook in console mode (that is, input is to come from the
	 * console).
	 * 
	 * THIS METHOD IS WRITTEN FOR YOU - no need to edit
	 * 
	 * @param args
	 *            Command line arguments (ignored)
	 */
	public static void main(String[] args) {
		TeamGradebook book = new TeamGradebook();
		System.out
				.println("Welcome to Team gradebook.  Enter commands.  Type 'exit' to end.");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String commandLine = scanner.nextLine();
			String result = book.handleCommand(commandLine);
			System.out.println(result);
		}

	}

}
