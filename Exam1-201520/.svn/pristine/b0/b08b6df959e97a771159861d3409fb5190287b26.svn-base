import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class SmallProblemsTest {

	@Test
	public void testIBeforeE() {
		assertTrue(SmallProblems.iBeforeE("ie"));
		assertTrue(SmallProblems.iBeforeE("IE"));
		assertTrue(SmallProblems.iBeforeE("Ie"));
		assertTrue(SmallProblems.iBeforeE("iE"));
		assertTrue(SmallProblems.iBeforeE("skies"));
		assertTrue(SmallProblems.iBeforeE(""));
		assertFalse(SmallProblems.iBeforeE("eie"));
		assertFalse(SmallProblems.iBeforeE("receive"));
		assertFalse(SmallProblems.iBeforeE("meet"));
	}

	@Test
	public void testClosestPowerOf2() {
		assertEquals(0, SmallProblems.closestPowerOf2(1));
		assertEquals(1, SmallProblems.closestPowerOf2(2));
		assertEquals(2, SmallProblems.closestPowerOf2(3));
		assertEquals(2, SmallProblems.closestPowerOf2(4));
		assertEquals(2, SmallProblems.closestPowerOf2(5));
		assertEquals(3, SmallProblems.closestPowerOf2(7));
		assertEquals(3, SmallProblems.closestPowerOf2(8));
		assertEquals(3, SmallProblems.closestPowerOf2(9));
		
		for(int i = 0; i < 100; i++) {
			long val = Math.round((Math.random() * Integer.MAX_VALUE));
			long res = Math.round(Math.log10(val) / Math.log10(2));
			if(val - Math.pow(2, res-1) < Math.pow(2, res) - val)
				res = res - 1;
			assertEquals(res, SmallProblems.closestPowerOf2(val));
		}
	}
	
	@Test
	public void testNumberOfXX() {
		assertEquals(0, SmallProblems.numberOfXX(""));
		assertEquals(0, SmallProblems.numberOfXX("X"));
		assertEquals(1, SmallProblems.numberOfXX("XX"));
		assertEquals(2, SmallProblems.numberOfXX("XXX"));
		assertEquals(6, SmallProblems.numberOfXX("XXXXXXoXX"));
		assertEquals(0, SmallProblems.numberOfXX("XoXoXxXo"));
		assertEquals(4, SmallProblems.numberOfXX("abcXXXcbaXXoXX"));
		assertEquals(1, SmallProblems.numberOfXX("XXabcfd"));
		assertEquals(1, SmallProblems.numberOfXX("abcrtXX"));
		assertEquals(3, SmallProblems.numberOfXX("abcXXjhgXXpoiXpoiXXytr"));
	}
	
	@Test
	public void testcountDownX() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(1); test.add(2);
		assertEquals("[1, 0, 2, 1, 0]", SmallProblems.countDownX(test).toString());
		test = new ArrayList<Integer>();
		test.add(1); test.add(2);test.add(3); test.add(5);
		assertEquals("[1, 0, 2, 1, 0, 3, 2, 1, 0, 5, 4, 3, 2, 1, 0]", SmallProblems.countDownX(test).toString());
		test = new ArrayList<Integer>();
		test.add(1); test.add(0); test.add(1); test.add(0);
		assertEquals("[1, 0, 0, 1, 0, 0]", SmallProblems.countDownX(test).toString());
		test = new ArrayList<Integer>();
		assertEquals("[]", SmallProblems.countDownX(test).toString());
		test = new ArrayList<Integer>();
		test.add(0); test.add(0); test.add(0); test.add(0);
		assertEquals("[0, 0, 0, 0]", SmallProblems.countDownX(test).toString());
		test = new ArrayList<Integer>();
		test.add(4); test.add(0); test.add(0); test.add(9);
		assertEquals("[4, 3, 2, 1, 0, 0, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", SmallProblems.countDownX(test).toString());
		test = new ArrayList<Integer>();
		test.add(11); test.add(0); test.add(1); test.add(0);
		assertEquals("[11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0, 1, 0, 0]", SmallProblems.countDownX(test).toString());
	}
	
	@Test
	public void testStrLengths() {
		String[] test1 = {"hello", "123", "w", "poll"};
		String[] test2 = {"bye", "thwifwer", "how", "1234", "d", "f"};
		int[] res1 = {5, 3, 1, 4, 3, 8, 3, 4, 1, 1};
		
		String[] test3 = {"", "", ""};
		int[] res2 = {5, 3, 1, 4, 0, 0, 0};
		int[] res3 = {0, 0, 0, 3, 8, 3, 4, 1, 1};
		
		String[] test4 = {};
		int[] res4 = {0, 0, 0};
		int[] res5 = {0, 0, 0};
		int[] res6 = {5, 3, 1, 4};
		int[] res7 = {5, 3, 1, 4};
		
		assertArrayEquals(res1, SmallProblems.strLengths(test1, test2));
		assertArrayEquals(res2, SmallProblems.strLengths(test1, test3));
		assertArrayEquals(res3, SmallProblems.strLengths(test3, test2));
		assertArrayEquals(res4, SmallProblems.strLengths(test3, test4));
		assertArrayEquals(res5, SmallProblems.strLengths(test4, test3));
		assertArrayEquals(res6, SmallProblems.strLengths(test1, test4));
		assertArrayEquals(res7, SmallProblems.strLengths(test4, test1));
	}
	
	@Test
	public void testSwapper() {
		int[] test1 = {1, 2, 3, 4, 5, 6};
		int[] perm1 = {1, 2, 3, 4, 5, 6};
		
		int[] res1 = {2, 1, 4, 3, 6, 5};
		
		int[] test2 = {111, 432, 7465, 999};
		int[] perm2 = {111, 432, 7465, 999};
		
		int[] res2 = {432, 111, 999, 7465};
		
		int[] test3 = {};
		int[] perm3 = {};
		int[] res3 = {};
		
		int[] test4 = {99, 234};
		int[] perm4 = {99, 234};
		
		int[] res4 = {234, 99};
		
		assertArrayEquals(res1, SmallProblems.swapper(test1));
		assertArrayEquals(test1, perm1);
		
		assertArrayEquals(res2, SmallProblems.swapper(test2));
		assertArrayEquals(test2, perm2);
		
		assertArrayEquals(res3, SmallProblems.swapper(test3));
		assertArrayEquals(test3, perm3);
		
		assertArrayEquals(res4, SmallProblems.swapper(test4));
		assertArrayEquals(test4, perm4);
	}
	
	@Test
	public void testEquilibrium() {
		int[] test1 = {2, 1, 4, 999, 1, 4, 2};
		assertEquals(3, SmallProblems.equilibrium(test1));
		
		int[] test2 = {17, 8, 8, 9};
		assertEquals(1, SmallProblems.equilibrium(test2));
		
		int[] test3 = {};
		assertEquals(-1, SmallProblems.equilibrium(test3));
		
		int[] test4 = {11, 17, 28, 4, 5, 7, 4, 2, 6};
		assertEquals(2, SmallProblems.equilibrium(test4));
		
		int[] test5 = {0, 0, 0, 0, 0, 9, 0};
		assertEquals(5, SmallProblems.equilibrium(test5));
	}
}
