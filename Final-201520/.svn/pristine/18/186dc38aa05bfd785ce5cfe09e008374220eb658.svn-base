import java.util.ArrayList;
import java.util.HashMap;

/**
 * A single HashMap problem worth 5 points
 * 
 * @author wilkin
 *
 */
public class HashMapProblem {
	
	
	/**
	 * Using an ArrayList of Strings, we want to track the letter count for
	 * every word.  To do this, we will map an integer (the letter count) to
	 * an array list of words for each of the respective letter counts.
	 * 
	 * For Example:
	 * Given the ArrayList: ["Hello", "there", "how", "are", "you", 
	 *                       "doing", "I". "am", "fantastic"]
	 * The HashMap would contain:
	 * 		{(1, ["I"]), (2, ["am"]), (3, ["how", "are", "you"]), 
	 *       (5, ["Hello", "there", "doing"]), (9, ["fantastic"])}
	 * 
	 * You may assume that all the words in the ArrayList are unique, that is
	 * a particular word only appears in the list once.
	 * 
	 * @param words an ArrayList of individual words as Strings
	 * @return a HashMap that maps word letter count to an ArrayList of words which
	 *         contain that many letters
	 */
	public static HashMap<Integer, ArrayList<String>> letterCountToWords(ArrayList<String> words) {
		HashMap<Integer, ArrayList<String>> letterCount = new HashMap<>();
		for(int i = 0; i < words.size(); i++) {
			String currentWord = words.get(i);
			int currentWordLength = currentWord.length();
			if(letterCount.containsKey(currentWordLength)) {
				ArrayList<String> temp = letterCount.get(currentWordLength);
				temp.add(currentWord);
				letterCount.replace(currentWordLength, temp);
			}
			else {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(currentWord);
				letterCount.put(currentWordLength, temp);
			}
		}
		return letterCount;
	}
}
