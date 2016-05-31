import java.util.ArrayList;

/**
 * 
 * involves varrious methods that invovles working with integers, arrays 
 * and arrayLists
 *
 * @author goldacbj. Created Dec 4, 2014.
 */
public class TwelveProblems {
	/**
	 * 
	 * TODO computes the given point's distance from the origin (0,0)
	 *
	 * @param x
	 * @param y
	 * @return
	 */
	public static double distanceFromOrigin(double x, double y) {
		double distance = Math.sqrt((x * x) + (y * y));
		return distance;
	}

	/**
	 * 
	 * returns true if the given number is a perfect number, if not it returns
	 * false
	 *
	 * @param input
	 * @return
	 */
	public static boolean isPerfect(int input) {
		int dividers = 0;
		for (int i = 1; i <= input - 1; i++) {
			if (input % i == 0) {
				dividers += i;
			}
		}
		if (dividers == input) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * returns true if the last character of a sequence is upper-case, if not it
	 * returns false
	 *
	 * @param String
	 * @return boolean
	 */
	public static boolean endsWithUpperCaseLetter(String input) {
		char lastChar = 'a';
		if (input.length() >= 1) {
			lastChar = input.charAt(input.length() - 1);
		}
		if (Character.isUpperCase(lastChar)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * adds up all of the integers up to the given number, for example
	 * sumofRange(4) = (1+2+3+4) = 10
	 *
	 * @param start
	 * @param end
	 * @return int
	 */
	public static int sumOfRange(int start, int end) {
		int total = 0;
		for (int i = start; i <= end; i++) {
			total += i;
		}
		return total;
	}

	/**
	 * 
	 * returns the first index at which the two given strings are different. if
	 * the two strings are the same, then it returns -1
	 *
	 * @param one
	 *            first String
	 * @param two
	 *            Second String
	 * @return index of difference
	 */
	public static int firstDifference(String one, String two) {
		for (int i = 0; i < one.length(); i++) {
			if (one.charAt(i) != two.charAt(i)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * returns the most common character of the given string
	 *
	 * @param input
	 * 
	 * @return
	 */
	public static char mostCommonCharacter(String input) {
		int counter = 0;
		char topCharacter = 'a';
		char indexedChar = 'b';
		int charTotal = 0;
		for (int i = 0; i < input.length(); i++) {
			indexedChar = input.charAt(i);
			for (int j = 0; j < input.length(); j++) {
				if (indexedChar == input.charAt(j)) {
					counter++;
				}
			}
			if (charTotal < counter) {
				topCharacter = indexedChar;
				charTotal = counter;
			}
			counter = 0;
		}
		return topCharacter;
	}

	/**
	 * 
	 * of a given list of numbers, this function returns the first number that
	 * is divisible by 77. If none of the numbers are divisible by 77, then it
	 * returns -1.
	 *
	 * @param numbers
	 *            list of numbers
	 * @return first number divisible by 77
	 */
	public static int firstDivisbleBy77(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 77 == 0) {
				return numbers[i];
			}
		}
		return -1;
	}

	/**
	 * 
	 * creates a list of integers that are all powers of 2 which starts a 2^0
	 * and goes to to 2^(given exponent). if the power is less than 0, it
	 * returns an empty list.
	 *
	 * @param maxExponent
	 * @return list of powers of two, up to maxExponent
	 */
	public static int[] powersOfTwo(int maxExponent) {
		if (maxExponent >= 0) {
			int[] exponents = new int[maxExponent + 1];
			for (int i = 0; i <= maxExponent; i++) {
				exponents[i] = (int) Math.pow(2, i);
			}
			return exponents;
		}
		return new int[0];
	}

	/**
	 * Given two arrays of integers that are the same length, returns a new
	 * array that contains the pairwise max of the corresponding elements of the
	 * original arrays (i.e. the larger of the two numbers in that slot in the
	 * original arrays)
	 * 
	 * For example: maxArray({2,10},{1,200}) returns {2,200} maxArray({-5, 60,
	 * 7},{-10,400,8}) returns {-5,400,8}
	 * 
	 * @param one
	 *            array of integers
	 * @param two
	 *            array of integers
	 * @return a list of the largest integers at respected indexes
	 */
	public static int[] maxArray(int[] one, int[] two) {
		int[] maxNumbers = new int[one.length];
		for (int i = 0; i < one.length; i++) {
			if (one[i] > two[i]) {
				maxNumbers[i] = one[i];
			} else {
				maxNumbers[i] = two[i];
			}
		}
		return maxNumbers;
	}

	/**
	 * 
	 * Given two arrays, count the number of times the first array occurs in the
	 * second array. You can assume that the first array is shorter than the
	 * second.
	 * 
	 * For example: timesOccur({1,2}, {7,1,2,7,7,7,1,2,7}) returns 2
	 * timesOccur({1,1}, {1,1,1,3} returns 2 (in the 0th and 1st position)
	 * timesOccur({1,2}, {1,3,2,1} returns 0
	 * 
	 * @param shorter
	 *            array of integers that is shorter than longer
	 * @param longer
	 *            array of integers that is longer than shorter
	 * @return counter
	 */
	public static int timesOccur(int[] shorter, int longer[]) {
		int counter = 0;
		for (int i = 0; i < shorter.length - 1; i++) {
			for (int j = 0; j < longer.length - 1; j++) {
				if (shorter[i] == longer[j] && shorter[i + 1] == longer[j + 1]) {
					counter++;
				}
			}

		}
		return counter;
	}

	/**
	 * Given an arraylist of strings, return a new list where anytime the world
	 * "double" appears in the original list it is doubled in the new list.
	 * 
	 * For example: doubleDouble(["foo","double"]) returns
	 * ["foo","double","double"] doubleDouble(["a","double","b","double","c"])
	 * returns ["a","double","double","b","double","double","c"]
	 * 
	 * @param input
	 *            Array list
	 * @return ArrayList
	 * 
	 */
	public static ArrayList<String> doubleDouble(ArrayList<String> input) {
		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i) == "double") {
				output.add("double");
				output.add("double");
			} else {
				output.add(input.get(i));
			}
		}
		return output;
	}

	/**
	 * Given an arraylist of strings, return a new arraylist of strings
	 * containing all the 3 letter strings in the original list
	 * 
	 * For example: threeCharacterStrings(["foo","a","bar"]) returns
	 * ["foo","bar"] threeCharacterStrings(["foo","a","foo", "qq"]) returns
	 * ["foo","foo"] threeCharacterStrings([]) returns []
	 * 
	 * @param strings
	 *            ArrayList of strings
	 * @return ArrayList of only three letter strings
	 */
	public static ArrayList<String> threeCharacterStrings(
			ArrayList<String> strings) {
		ArrayList<String> threeCharacters = new ArrayList<String>();
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).length() == 3) {
				threeCharacters.add(strings.get(i));
			}
		}
		return threeCharacters;
	}
}
