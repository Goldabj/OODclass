import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a set of recursion examples covered in class
 * 
 * @author wilkin
 *
 */
public class RecursionExamples {

	/**
	 * The main method simply calls each of the example recursive
	 * functions
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Remove each of the comments to call each method
		
		// #1 --
		//simpleCounter(7);
		
		
		// #2 --
		//int result = rightTriangleArea(5);
		//System.out.println("The area of a triangle of width 5 is: " + result + "\n");
		
		// #3 --
		//int result2 = recursiveFactorial(6);
		//System.out.println("6! is: " + result2 + "\n");
		
		// #4 --
		//int result3 = letterCount("The answer for this one is 3", 'e');
		//System.out.println("There are " + result3 + " e's in the string.");
		
		// #5 --
		//Integer[] localArray = {1, 88, 55, 900, 750, 4012, 8265, 952, 28404};
		//ArrayList<Integer> localList = new ArrayList<Integer>(Arrays.asList(localArray));
		//int result4 = findMax(localList);
		//System.out.println("The largest element in the array is: " + result4);

		// #6 --
		//String anagrams = findAnagrams("", "arts");
		//System.out.println("The anagrams for the word \"arts\" are:\n" + anagrams);
	}
	
	/**
	 * This simple method recursively prints out the numbers 1 to the counter
	 * 
	 * @param counter
	 */
	public static void simpleCounter(int counter) {
		if(counter == 0)
			return;
		else {
			//TODO Try the simpleCounter recursive call AFTER the print statement as well...
			simpleCounter(counter - 1);
			System.out.println(""+counter);
	        return;
		}
	}
	
	/**
	 * Computes a "pixel-like" area of a triangle given an input
	 * width.  A triangle with inputWidth of 4 represents a right 
	 * triangle that is 4 pixels high, 4 pixels wide.  The "area" 
	 * is the precise number of pixels that it takes to render 
	 * the triangle.
	 * 
	 * @param inputWidth - the value of the triangle's width and height
	 * @return - the number of pixels it would take to render the 
	 *           triangle that is inputWidth pixels wide
	 */
	public static int rightTriangleArea(int inputWidth) {
		return 0;
	}
	
	/**
	 * Recursively calculates the factorial of the given input.
	 * 
	 * @param curVal
	 * @return curVal!
	 */
	public static int recursiveFactorial(int curVal) {
		return 0;
	}
	
	/**
	 * Given a string "input" and character "c", this method recursively
	 * calculates the number of times the character appears in the string.
	 * 
	 * @param input - the string to count characters
	 * @param c - the character to count in the string
	 * @return the number of times the character appears in the string
	 */
	public static int letterCount(String input, char c) {
		if(input.isEmpty()) {
			return 0;
		}
		char firstChar = input.charAt(0);
		String rest = input.substring(1);
		if(c == firstChar) {
			return 1 + letterCount(rest, c);
		} else {
			return letterCount(rest, c);
		}
	}
	
	/**
	 * This method returns the largest integer in the array list
	 * 
	 * @param listOfInts - an array list that contains integers
	 * @return - the largest integer in teh list
	 */
	public static int findMax(ArrayList<Integer> listOfInts) {
		return 0;
	}
	
	/**
	 * This method returns all anagrams of a given word.  In other words,
	 * this method returns a string with every permutation possible by
	 * mixing the letters of the string.
	 * 
	 * @param prefix - The portion of the word that splits the string
	 * @param word - The word to find all anagrams for.
	 * @return a string containing all anagrams for the given word.
	 */
	public static String findAnagrams(String prefix, String word) {
		if(word.length() <= 1)
			return (prefix + word + "\n");
		else {
			String localStr = "";
			for(int i = 0; i < word.length(); i++) {
				String cur = word.substring(i, i + 1);
		        String before = word.substring(0, i); // letters before cur
		        String after = word.substring(i + 1); // letters after cur
		        localStr += findAnagrams(prefix + cur, before + after);
		    }
			return localStr;
		}  
	}

}
