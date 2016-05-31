import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;


public class HashMapProblemTest {

	@Test
	public void testIncreaseHashmapValues() {
		HashMap<String,Integer> test1 = new HashMap<String,Integer>();
		test1.put("ab", 1);
		test1.put("cd", 10);
		test1.put("xyz", 5);
		HashMapProblem.increaseHashmapValues(test1);
		assertEquals(2, (int) test1.get("ab"));
		assertEquals(11, (int) test1.get("cd"));
		assertEquals(6, (int) test1.get("xyz"));

		HashMap<String,Integer> test2 = new HashMap<String,Integer>();
		test2.put("hello", -1);
		test2.put("goodbye", 0);
		test2.put("xyz", 5);
		HashMapProblem.increaseHashmapValues(test2);
		assertEquals(0, (int) test2.get("hello"));
		assertEquals(1, (int) test2.get("goodbye"));
		assertEquals(6, (int) test2.get("xyz"));

		
	}

}
