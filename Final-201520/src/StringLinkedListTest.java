import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class StringLinkedListTest {

	StringLinkedList list, list2, empty, onlyOne;	
	
	@Before
	public void setUp() throws Exception {
		list = new StringLinkedList();
		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("a");
		
		list2 = new StringLinkedList();
		list2.addFirst("a");
		list2.addFirst("d");
		list2.addFirst("a");
		list2.addFirst("a");
		list2.addFirst("aaa");
		list2.addFirst("c");
		list2.addFirst("b");
		list2.addFirst("a");
		
		empty = new StringLinkedList();

		onlyOne = new StringLinkedList();
		onlyOne.addFirst("hello");
	}
	

	@Test
	public void NotExamtestListToString() {
		//this code was implemented for you, so this test should pass
		
		assertEquals("[a,b,c]",listToString(list));
		assertEquals("[a,b,c,aaa,a,a,d,a]",listToString(list2));
		assertEquals("[]",listToString(empty));
		assertEquals("[hello]",listToString(onlyOne));

	}

	@Test
	public void testAddSeperator() {
		list.addSeparator("SEP");
		assertEquals("[a,SEP,b,SEP,c]",listToString(list));
		list2.addSeparator(";;;");
		assertEquals("[a,;;;,b,;;;,c,;;;,aaa,;;;,a,;;;,a,;;;,d,;;;,a]",listToString(list2));
		empty.addSeparator("SEP");
		assertEquals("[]",listToString(empty));
		onlyOne.addSeparator("SEP");
		assertEquals("[hello]",listToString(onlyOne));
	}
	
	@Test
	public void testParens() {

		list = new StringLinkedList();
		list.addFirst("c");
		list.addFirst(")");
		list.addFirst("b");
		list.addFirst("(");
		list.addFirst("a");

		// list looks like [a,(,b,),c]
		list.removeBetweenParens();
		assertEquals("[a,c]",listToString(list));
		
		list = new StringLinkedList();
		list.addFirst("c");
		list.addFirst(")");
		list.addFirst("y");
		list.addFirst("x");
		list.addFirst("(");
		list.addFirst("a");

		//list looks like [a,(,x,y,),c]
		list.removeBetweenParens();
		assertEquals("[a,c]",listToString(list));
				
		list = new StringLinkedList();
		list.addFirst("e");
		list.addFirst(")");
		list.addFirst("d");
		list.addFirst("a");
		list.addFirst("a");
		list.addFirst("(");
		list.addFirst("aa");
		list.addFirst(")");
		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("(");
		list.addFirst("a");
		
		// list looks like [a,(,b,c,),aa,(,a,a,d,),e]
		list.removeBetweenParens();
		assertEquals("[a,aa,e]",listToString(list));
		
		list = new StringLinkedList();
		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("a");
		
		//list looks like [a,b,c]
		list.removeBetweenParens();
		assertEquals("[a,b,c]",listToString(list));
		
		list = new StringLinkedList();
		list.addFirst("c");
		list.addFirst(")");
		list.addFirst("(");
		list.addFirst("a");
		
		//list looks like [a,(,),c]
		list.removeBetweenParens();
		assertEquals("[a,c]",listToString(list));
		
		list = new StringLinkedList();
		list.addFirst(")");
		list.addFirst("c");
		list.addFirst("y");
		list.addFirst("x");
		list.addFirst("(");
		list.addFirst("a");
		
		//list looks like [a,(,x,y,c,)]
		list.removeBetweenParens();
		assertEquals("[a]",listToString(list));
				
	}
	
	@Test
	public void testArrayEquals() {
		assertTrue(list.equalsArray(new String[] {"a","b","c"}));
		assertFalse(list.equalsArray(new String[] {"a","z","c"}));
		assertFalse(list.equalsArray(new String[] {"z","b","c"}));
		assertFalse(list.equalsArray(new String[] {"a","b","z"}));
		assertFalse(list.equalsArray(new String[] {"a","b"}));
		assertFalse(list.equalsArray(new String[] {"a","b","c","d"}));
		assertFalse(list.equalsArray(new String[] {}));
		assertTrue(empty.equalsArray(new String[] {}));
		assertFalse(empty.equalsArray(new String[] {"a"}));
		
	}	
	
	@Test
	public void moveNToBack() {
		
		list = new StringLinkedList();
		list.addFirst("d");
		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("a");
		
		list.moveNToBack(1);
		
		assertEquals("[b,c,d,a]",listToString(list));
		
		list = new StringLinkedList();
		list.addFirst("d");
		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("a");
		
		list.moveNToBack(2);
		
		assertEquals("[c,d,a,b]",listToString(list));
		
		list = new StringLinkedList();
		list.addFirst("d");
		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("a");
		
		list.moveNToBack(3);
		
		assertEquals("[d,a,b,c]",listToString(list));
		
		list = new StringLinkedList();
		list.addFirst("d");
		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("a");
		
		list.moveNToBack(0);
		
		assertEquals("[a,b,c,d]",listToString(list));
		
		
	}	

	/**
	 * Handy utility function just for testing.  Do not use in your solution.
	 * 
	 * Turns a list into a string separated by commas
	 * 
	 * @param list
	 * @return stringified version of the list
	 */
	private String listToString(StringLinkedList list) {
		
		String first = list.removeLast();
		if(first == null) return "[]";
		String output = first + "]";
		while(true) {
			String current = list.removeLast();
			if(current == null) {
				return "[" + output;
			} else {
				output = current + "," + output;
			}
		}
	}
}
