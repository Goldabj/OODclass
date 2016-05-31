import static org.junit.Assert.*;

import org.junit.Test;


public class RecursionTest {

	@Test
	public void testComputeScore() {
		assertEquals(3, Recursion.findLastWin("WWW"));
		assertEquals(3, Recursion.findLastWin("LLW"));
		assertEquals(3, Recursion.findLastWin("WLWLLLLLL"));
		assertEquals(4, Recursion.findLastWin("LLLW"));
		assertEquals(5, Recursion.findLastWin("WLWLWLLLL"));
		assertEquals(0, Recursion.findLastWin("LLLLLL"));
		assertEquals(0, Recursion.findLastWin(""));
	}

	@Test
	public void testHasHiddenWord() {
		assertTrue(Recursion.hasHiddenWord("abcd", "bd"));
		assertTrue(Recursion.hasHiddenWord("abcd", "ab"));
		assertTrue(Recursion.hasHiddenWord("abcda", "aa"));
		assertTrue(Recursion.hasHiddenWord("abcda", ""));
		assertTrue(Recursion.hasHiddenWord("", ""));
		assertTrue(Recursion.hasHiddenWord("hello", "hello"));
		assertFalse(Recursion.hasHiddenWord("abcd", "abcde"));
		assertFalse(Recursion.hasHiddenWord("abcda", "aaa"));
		assertFalse(Recursion.hasHiddenWord("abcda", "cb"));
		assertFalse(Recursion.hasHiddenWord("", "aa"));
	}

	@Test
	public void testIsPowerOf() {
		assertTrue(Recursion.isPowerOf(2, 2));
		assertTrue(Recursion.isPowerOf(4, 2));
		assertTrue(Recursion.isPowerOf(8, 2));
		assertTrue(Recursion.isPowerOf(16, 2));
		assertTrue(Recursion.isPowerOf(32, 2));
		assertTrue(Recursion.isPowerOf(1024, 2));
		assertTrue(Recursion.isPowerOf(243,3));
		assertTrue(Recursion.isPowerOf(27,3));
		assertFalse(Recursion.isPowerOf(34, 2));
		assertFalse(Recursion.isPowerOf(2024, 2));
		assertFalse(Recursion.isPowerOf(1, 2));
		assertFalse(Recursion.isPowerOf(6,5));
		assertFalse(Recursion.isPowerOf(21, 7));

	}

	@Test
	public void testAlternatingArray() {
		assertTrue(Recursion.alternatingArray(new int[] {1,-2}));
		assertTrue(Recursion.alternatingArray(new int[] {5,-2,7,-100}));
		assertTrue(Recursion.alternatingArray(new int[] {1,-2,3,-6,8,-4}));
		assertFalse(Recursion.alternatingArray(new int[] {1,-2,3,-6,8,4}));
		assertFalse(Recursion.alternatingArray(new int[] {1,2,3,-6,8,-4}));
		assertFalse(Recursion.alternatingArray(new int[] {-2, 1}));
		assertFalse(Recursion.alternatingArray(new int[] {1,-2,3,0,8,-4}));
		assertFalse(Recursion.alternatingArray(new int[] {1,-2,3,-6,0,-4}));
	}

}
