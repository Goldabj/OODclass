import java.util.HashMap;
import java.util.Set;


public class HashMapProblem {

	/* This function takes a HashMap of Strings to integers.  It increases the value of
	 * each integer by one.
	 * 
	 * For example:
	 * 
	 * {ab=1, xyz=5, cd=10} becomes {ab=2, xyz=6, cd=11}
	 * 
	 */
	public static void increaseHashmapValues(HashMap<String,Integer> input) {
		Set<String> keySet = input.keySet();
		for(String key : keySet) {
			int initialValue = input.get(key);
			input.replace(key, initialValue + 1);
		}
	}
}
