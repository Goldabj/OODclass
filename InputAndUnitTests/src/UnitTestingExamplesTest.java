import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class UnitTestingExamplesTest {

	@Test
	public void testFindRectangleArea() {
		assertEquals(-1, UnitTestingExamples.findRectangleArea(-1, 30));
		assertEquals(0, UnitTestingExamples.findRectangleArea(0, 11));
		
	}
	@Test
	public void testComputeMean() {
		assertEquals(0.01, 1000.01 - 1000, 0.000001);
	}

}
