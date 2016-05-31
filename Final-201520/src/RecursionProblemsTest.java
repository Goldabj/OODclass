import static org.junit.Assert.*;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class RecursionProblemsTest {
	ArrayList<Ellipse2D> list1;
	ArrayList<Ellipse2D> list2;
	ArrayList<Ellipse2D> list3;
	ArrayList<Ellipse2D> list4;
	ArrayList<Ellipse2D> list5;
	ArrayList<Ellipse2D> list6;
	ArrayList<Ellipse2D> list7;

	@Before
	public void setUp() throws Exception {
		list1 = new ArrayList<Ellipse2D>();
		for(int i = 100; i >= 0; i--) {
			list1.add(new Ellipse2D.Double(0, 0, i, i));
		}
		list2 = new ArrayList<Ellipse2D>();
		for(int i = 0; i < 100; i++) {
			list2.add(new Ellipse2D.Double(0, 0, i, i));
		}
		list3 = new ArrayList<Ellipse2D>();
		for(int i = 10000; i >= 0; i -= 5) {
			list3.add(new Ellipse2D.Double(0, 0, i, i));
		}
		list4 = new ArrayList<Ellipse2D>();
		for(int i = 10000; i >= 0; i -= 5) {
			list4.add(new Ellipse2D.Double(0, 0, i, i));
		}
		list4.add(new Ellipse2D.Double(0, 0, 10, 10));
		list5 = new ArrayList<Ellipse2D>();
		for(int i = 10000; i >= 0; i -= 5) {
			list5.add(new Ellipse2D.Double(0, 0, i, i));
		}
		list5.add(0, new Ellipse2D.Double(0, 0, 1, 1));
		list6 = new ArrayList<Ellipse2D>();
		for(int i = 10000; i >= 0; i -= 5) {
			list6.add(new Ellipse2D.Double(0, 0, i, i));
		}
		list6.add(list6.size()/2, new Ellipse2D.Double(0, 0, 10000, 10000));
		list7 = new ArrayList<Ellipse2D>();
		for(int i = 10000; i >= 0; i -= 5) {
			list7.add(new Ellipse2D.Double(0, 0, i, i));
		}
		list7.add(list7.size()/2, new Ellipse2D.Double(0, 0, 1, 1));
	}

	@Test
	public void testIsShrinkingCircles() {
		assertTrue(RecursionProblems.isShrinkingCircles(list1));
		assertFalse(RecursionProblems.isShrinkingCircles(list2));
		assertTrue(RecursionProblems.isShrinkingCircles(list3));
		assertFalse(RecursionProblems.isShrinkingCircles(list4));
		assertFalse(RecursionProblems.isShrinkingCircles(list5));
		assertFalse(RecursionProblems.isShrinkingCircles(list6));
		assertFalse(RecursionProblems.isShrinkingCircles(list7));
	}
	
	@Test
	public void testFactorTimesGreater() {
		int[] a = new int[50];
		int[] b = new int[50];
		int[] c = new int[50];
		int[] d = new int[50];
		
		for(int i = 0; i < 50; i++) {
			a[i] = i;
			b[i] = i * 5;
			c[i] = i * 5 * 7;
			d[i] = i * 14;
		}
		
		assertTrue(RecursionProblems.factorTimesGreater(a, b, 5));
		assertTrue(RecursionProblems.factorTimesGreater(b, c, 7));
		assertTrue(RecursionProblems.factorTimesGreater(a, c, 35));
		assertTrue(RecursionProblems.factorTimesGreater(a, d, 14));
		assertFalse(RecursionProblems.factorTimesGreater(a, b, 4));
		assertFalse(RecursionProblems.factorTimesGreater(a, c, 34));
		assertFalse(RecursionProblems.factorTimesGreater(b, c, 5));
		
		int[] e = new int[100];
		int[] f = new int[100];
		int[] g = new int[100];
		
		for(int i = 0; i < 100; i++) {
			e[i] = 1;
			f[i] = 9;
			g[i] = 0;
		}
		assertTrue(RecursionProblems.factorTimesGreater(e, f, 9));
		assertTrue(RecursionProblems.factorTimesGreater(e, g, 0));
		assertTrue(RecursionProblems.factorTimesGreater(f, g, 0));
		f[50] = f[50] + 1;
		assertFalse(RecursionProblems.factorTimesGreater(e, f, 9));
		f[50] = f[50] - 1;
		f[0] = f[0] + 6;
		assertFalse(RecursionProblems.factorTimesGreater(e, f, 9));
		f[0] = f[0] - 6;
		f[99] = 0;
		assertFalse(RecursionProblems.factorTimesGreater(e, f, 9));
		g[88] = 8;
		assertFalse(RecursionProblems.factorTimesGreater(e, g, 0));
		assertFalse(RecursionProblems.factorTimesGreater(f, g, 0));
		
	}

}
