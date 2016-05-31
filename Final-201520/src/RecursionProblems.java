import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class RecursionProblems {

	/**
	 * (PROBLEM 1)
	 * 
	 * Takes an ArrayList of Ellipse2D objects that are circles. This method
	 * recursively assures that the first circle is the largest in the list, and
	 * so on, making sure that the last circle in the list is the smallest.
	 * 
	 * (HINT: It's easiest to compare circles made as an Ellipse2D by simply
	 * comparing the width or the height of the containing rectangle of the
	 * ellipse.)
	 * 
	 * You may modify the input list
	 *
	 * @param circles
	 * @return true if circle n is bigger than circle n-1; false otherwise
	 */
	public static boolean isShrinkingCircles(ArrayList<Ellipse2D> circles) {
		if (circles.size() == 1) {
			return true;
		}
		if (circles.get(0).getHeight() > circles.get(1).getHeight()) {
			if (circles.get(0).getWidth() > circles.get(1).getHeight()) {
				circles.remove(0);
				return isShrinkingCircles(circles);
			}
		}
		return false;
	}

	/**
	 * (PROBLEM 2)
	 * 
	 * Returns true when each element in larger is equals to the element in the
	 * same position in smaller multiplied by factor. That is, in terms of a
	 * loop: (larger[i] == smaller[i] * factor)
	 * 
	 * This problem must be solved recursively, and if any element in smaller or
	 * larger does not meet the requirement above, return false
	 * 
	 * A recursive helper method may be useful in solving this problem
	 *
	 * @param smaller
	 * @param larger
	 * @param factor
	 * @return true if for all i, larger[i] == smaller[i]*factor; false
	 *         otherwise
	 */
	public static boolean factorTimesGreater(int[] smaller, int[] larger,
			int factor) {
		
		for (int i = 0; i < smaller.length; i++) {
			if(isCurrentFactorTimesGreater(smaller[i], larger[i], factor)) {
				// Nothing. continue testing all the numbers
			}
			else{
				return false;
			}
		}
		//if went through all of the numbers without return false, then it is true
		return true;

	}

	private static boolean isCurrentFactorTimesGreater(int smaller, int larger,
			int factor) {
		if (smaller * factor == larger) {
			return true;
		}
		return false;
	}
}
