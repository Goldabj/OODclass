import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TwelveProblemsTest {

	@Test
	public void testDistanceFromOrigin() {
		assertEquals(1, TwelveProblems.distanceFromOrigin(-1, 0),.001);
		assertEquals(108.894, TwelveProblems.distanceFromOrigin(77, 77),.001);
		assertEquals(5, TwelveProblems.distanceFromOrigin(-3, -4),.001);
		assertEquals(11.1803, TwelveProblems.distanceFromOrigin(5, -10),.001);
	}

	@Test
	public void testIsPerfect() {
		assertTrue(TwelveProblems.isPerfect(6));
		assertTrue(TwelveProblems.isPerfect(28));
		assertTrue(TwelveProblems.isPerfect(496));
		assertTrue(TwelveProblems.isPerfect(8128));
		assertTrue(TwelveProblems.isPerfect(33550336));
		assertFalse(TwelveProblems.isPerfect(7));
		assertFalse(TwelveProblems.isPerfect(99));
		assertFalse(TwelveProblems.isPerfect(10000));
	}

	@Test
	public void testEndsWithUpperCaseLetter() {
		assertTrue(TwelveProblems.endsWithUpperCaseLetter("doG"));
		assertFalse(TwelveProblems.endsWithUpperCaseLetter("dog"));
		assertTrue(TwelveProblems.endsWithUpperCaseLetter("HELLO"));
		assertFalse(TwelveProblems.endsWithUpperCaseLetter("hello"));
		assertFalse(TwelveProblems.endsWithUpperCaseLetter(""));

	}

	@Test
	public void testSumOfRange() {
		assertEquals(6, TwelveProblems.sumOfRange(1,3));
		assertEquals(14, TwelveProblems.sumOfRange(2,5));
		assertEquals(21, TwelveProblems.sumOfRange(10,11));
		assertEquals(3, TwelveProblems.sumOfRange(3,3));
		assertEquals(0, TwelveProblems.sumOfRange(100,1));
	}

	@Test
	public void testFirstDifference() {
		assertEquals(1,TwelveProblems.firstDifference("abc", "axy"));
		assertEquals(2,TwelveProblems.firstDifference("abx", "aby"));
		assertEquals(0,TwelveProblems.firstDifference("foo", "bar"));
		assertEquals(-1,TwelveProblems.firstDifference("foo", "foo"));
		assertEquals(-1,TwelveProblems.firstDifference("", ""));
	}

	@Test
	public void testMostCommonCharacter() {
		assertEquals('a', TwelveProblems.mostCommonCharacter("aaab"));
		assertEquals('a', TwelveProblems.mostCommonCharacter("bbaaa"));
		assertEquals('c', TwelveProblems.mostCommonCharacter("abcbcdc"));
		assertEquals('a', TwelveProblems.mostCommonCharacter("a"));
		assertEquals('l', TwelveProblems.mostCommonCharacter("hello"));
	}

	@Test
	public void testFirstDivisbleBy77() {
		int[] a = {88,24,154,77};
		int[] b = {5929, 280};
		int[] c = {1,2,3,4};
		int[] d = {};
		assertEquals(154, TwelveProblems.firstDivisbleBy77(a));
		assertEquals(5929, TwelveProblems.firstDivisbleBy77(b));
		assertEquals(-1, TwelveProblems.firstDivisbleBy77(c));
		assertEquals(-1, TwelveProblems.firstDivisbleBy77(d));
	}

	@Test
	public void testPowersOfTwo() {
		int[] a = {1,2,4,8};
		int[] b = {1, 2, 4, 8, 16, 32, 64, 128};
		int[] c = {1};
		int[] d = {};
		assertArrayEquals(a, TwelveProblems.powersOfTwo(3));
		assertArrayEquals(b, TwelveProblems.powersOfTwo(7));
		assertArrayEquals(c, TwelveProblems.powersOfTwo(0));
		assertArrayEquals(d, TwelveProblems.powersOfTwo(-200));
	}

	@Test
	public void testMaxArray() {
		int[] a = {1,2,3};
		int[] b = {4,5,6};
		int[] c = {7,1,6};
		int[] d = {7,5,6};
		
		assertArrayEquals(b, TwelveProblems.maxArray(a, b));
		assertArrayEquals(d, TwelveProblems.maxArray(b, c));
	}

	@Test
	public void testTimesOccur() {
		int[] a = {7,1,1,7,7,1,1};
		int[] b =  {1,1};
		int[] c = {1,1,1,3};
		int[] d = {1, 3, 4, 1, 2, 1};
		assertEquals(2, TwelveProblems.timesOccur(b, a));
		assertEquals(2, TwelveProblems.timesOccur(b, c));
		assertEquals(0, TwelveProblems.timesOccur(b, d));
	}

	private ArrayList<String> toAL(String[] array) {
		ArrayList<String> output = new ArrayList<String>();
		for(String s : array) {
			output.add(s);
		}
		return output;
	}
	
	@Test
	public void testDoubleDouble() {
		String[] a = {"foo", "double"};
		String[] aSolution = {"foo", "double", "double"};
		String[] b = {"double","foo","double","bar"};
		String[] bSolution = {"double","double","foo","double","double","bar"};
		String[] c = {};
		String[] d = {"foo","bar"};
		assertEquals(toAL(aSolution), TwelveProblems.doubleDouble(toAL(a)));
		assertEquals(toAL(bSolution), TwelveProblems.doubleDouble(toAL(b)));
		assertEquals(toAL(c), TwelveProblems.doubleDouble(toAL(c)));
		assertEquals(toAL(d), TwelveProblems.doubleDouble(toAL(d)));
	}

	@Test
	public void testThreeCharacterStrings() {
		String[] a = {"doublea","a","foo","ab","zzzz","bar"};
		String[] b = {"foo","bar"};
		String[] c = {};
		
		assertEquals(toAL(b), TwelveProblems.threeCharacterStrings(toAL(a)));
		assertEquals(toAL(b), TwelveProblems.threeCharacterStrings(toAL(b)));
		assertEquals(toAL(c), TwelveProblems.threeCharacterStrings(toAL(c)));
	}

}
