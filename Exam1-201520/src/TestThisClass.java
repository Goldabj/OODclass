import java.awt.Point;


/**
 * A single method class that needs to be tested. The JUnit test 
 * file should be named TestThisClassTest.java.
 *
 */
public class TestThisClass {

	/**
	 * This is a method that takes a number of hours and an hourly rate
	 * and calculates the charges based on a charge plan as follows:
	 * 		1) For the first hour you pay full price
	 * 		2) The rate for 2-3 hours is the hourly rate at a 10% discount
	 * 		   rounded to the nearest whole dollar amount
	 *      3) The rate for 4 hours is the hourly rate at a 12% discount
	 *         rounded to the nearest whole dollar amount
	 *      4) Anything above 4 hours is the hourly rate at a 15% discount
	 *         rounded to the nearest whole dollar amount
	 * 
	 * @param time - number of hours
	 * @param rate - the hourly rate in whole dollar amounts
	 * @return  the total charge for the number of hours given any possible
	 *          discounts
	 */
	public static int getPrice(int time, int rate) {
		// TODO: build Unit tests that test this function appropriately
		//
		// For full credit, your tests must contain at least 4 asserts
		// that test *different* cases (e.g. boundary cases, etc.)
		// However, your tests do not need to be exhaustive.
		//
		// Your test should use the JUnit framework and be in its own file
		// TestThisClassTest.java.
		
		if(time < 2) {
			return time * rate;
		} else if (time < 4) {
			return Math.round((time * rate)*0.9f);
		} else if (time == 4) {
			return Math.round((time * rate)*0.88f);
		} else {
			return Math.round((time * rate)*0.85f);
		}
	}
	
}
