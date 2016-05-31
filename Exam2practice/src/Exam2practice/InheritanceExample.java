package Exam2practice;

/**
 * Demonstrates method overriding.
 * 
 * @author Curt Clifton.
 */
public class InheritanceExample {
	class One {
		public void alpha() {
			System.out.print("A");
			this.beta();
		}

		public void beta() {
			System.out.println("B");
		}
	}

	class Two extends One {
		public void beta() {
			System.out.println("C");
		}

		public void gamma() {
			System.out.println("D");
		}
	}

	/**
	 * Runs the example.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		new InheritanceExample().run();
	}

	private void run() {
		One p = new One();
		One q = new Two();
		Two r = new Two();

		// p.gamma(); // compile error
		// q.gamma(); // compile error
		r.gamma();

		p.beta();
		q.beta();
		r.beta();

		p.alpha();
		q.alpha();
		r.alpha();

	}

}
