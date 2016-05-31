import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author wilkin
 *
 */
public class HashMapProblemTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLetterCountToWords() {
		ArrayList<String> words = new ArrayList<String>();
		String s = "This is a test to see how well the functions written";
		String s2 = "All these words are uniquely small except supererogatory";
		String[] a = s.trim().split(" ");
		String[] a2 = s2.trim().split(" ");
		for(String w : a)
			words.add(w);
		for(String w : a2)
			words.add(w);
		
		HashMap<Integer, ArrayList<String>> test = HashMapProblem.letterCountToWords(words);
		
		testEqualsUnordered(new String[] {"supererogatory"},test.get(14));
		testEqualsUnordered(new String[] {"This","test","well"},test.get(4));
		testEqualsUnordered(new String[] {"to","is"},test.get(2));
		testEqualsUnordered(new String[] {"a"},test.get(1));
		testEqualsUnordered(new String[] {"these","small","words"},test.get(5));
		assertEquals(null, test.get(15));
	}
	
	private static void testEqualsUnordered(String[] expected, ArrayList<String> yourValue) {
		ArrayList<String> expectedList = new ArrayList<String>();
		ArrayList<String> copyOfYourList = new ArrayList<String>(yourValue);
		for(String s : expected) {
			expectedList.add(s);
		}
		Collections.sort(expectedList);
		Collections.sort(copyOfYourList); //sort in case you added items in a different order
		assertEquals(expectedList, copyOfYourList);
		
	}

}
