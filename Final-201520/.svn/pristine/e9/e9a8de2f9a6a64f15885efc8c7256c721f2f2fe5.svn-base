/*
 * A linked list class for storing Strings
 */
public class StringLinkedList {

	private class Node {

		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}

		public String data;
		public Node next;

	}

	private Node first;

	public StringLinkedList() {
		first = null;
	}

	/**
	 * Adds a string as the new first element of this list
	 * 
	 * Note - you should not need to modify this function!
	 * 
	 */
	public void addFirst(String newData) {
		Node newNode = new Node(newData, first);
		this.first = newNode;
	}

	/**
	 * Removes the last element of this list Returns the data of the element
	 * that is removed
	 * 
	 * If the list is empty, returns null
	 * 
	 * Note - you should not need to modify this function!
	 * 
	 */
	public String removeLast() {
		// zero element list
		if (first == null)
			return null;

		// one element list
		if (first.next == null) {
			String data = first.data;
			first = null;
			return data;
		}

		// the rest
		Node current = first;
		while (current.next.next != null) {
			current = current.next;
		}
		String data = current.next.data;
		current.next = null;
		return data;
	}

	/**
	 * (PROBLEM 1)
	 * 
	 * Adds a separator node between all the nodes in the list
	 * 
	 * Does not add the separator before the first or after the last
	 * 
	 * For example, for this list and the separator "SEP": "A"->"B"->"C" becomes
	 * "A"->"SEP"->"B"->"SEP"->"C"
	 * 
	 * @param separator
	 *            string to use as separator
	 * 
	 */
	public void addSeparator(String separator) {
		if (this.first == null) {
			return;
		}
		Node current = this.first;
		while (current.next != null) {
			Node seperator = new Node(separator, current.next);
			current.next = seperator;
			current = current.next.next;
		}
	}

	/**
	 * 
	 * (PROBLEM 2)
	 * 
	 * If the current list has aby elements that are left parens and right
	 * parens and removes all elements between the parens and the parens
	 * themselves.
	 * 
	 * You can assume parens will not be nested and all lists are well formed
	 * (that is every left paren has a matching right paren, no right parens
	 * before left parens, etc.)
	 * 
	 * You can assume that the string will never begin with a left paren
	 * 
	 * For example: "A"->"("->"B"->"C"->")"->"D" becomes "A"->"D"
	 * 
	 */
	public void removeBetweenParens() {
		if (this.first == null) {
			return;
		}
		Node current = this.first;
		Node current2 = this.first;
		while (current != null && current2 != null) {
			if (this.first.data == "(") {
				// continue without changing current
			}
			// finds the node before the paren
			else {
				while (current.next != null && current.next.data != "(") {
					current = current.next;
				}
			}
			// finds the paren node
			while (current2.next != null && current2.data != ")") {
				current2 = current2.next;
			}
			if (current.next == null) {
				return;
			}
			// removes the parens and nodes between
			if (current.next.data == "(" && current2.data == ")") {
				current.next = current2.next;
			}
			// contines through the list
			current = current.next;
			current2 = current;
		}

	}

	/**
	 * 
	 * (PROBLEM 3)
	 * 
	 * Returns true if the data in the array is the same as the list, false
	 * otherwise
	 * 
	 * For example the list "A"->"B"->"C" and the array {"A","B","C"} returns
	 * true the list "A"->"B"->"C" and the array {"A","Z","C"} returns false
	 * 
	 * The list and the array might be different lengths. In that case they are
	 * not equal.
	 * 
	 */
	public boolean equalsArray(String[] array) {
		if (this.first == null) {
			if(array.length == 0) {
				return true;
			}
			return false;
		}
		if (array.length == 0) {
			return false;
		}
		Node current = this.first;
		String currentString = array[0];
		int i = 1;
		while (current.next != null && i < array.length) {
			if (current.data.equals(currentString)) {
				current = current.next;
				currentString = array[i];
				i++;
			}else {
				return false;
			}
		}
		if (i == array.length && current.next == null) {
			if(current.data.equals(currentString)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * (PROBLEM 4)
	 * 
	 * Moves N elements from the front to the back of the array
	 * 
	 * For example the list "A"->"B"->"C"->"D" and N=1 becomes
	 * "B"->"C"->"D"->"A" the list "A"->"B"->"C"->"D" and N=2 becomes
	 * "C"->"D"->"A"->"B" the list "A"->"B"->"C"->"D" and N=0 becomes
	 * "A"->"B"->"C"->"D"
	 * 
	 * You can assume that the given N will be strictly less than the length of
	 * the list
	 * 
	 * You can use an additional data structure like an ArrayList if you want,
	 * but the problem is solvable without that.
	 */
	public void moveNToBack(int n) {
		// gets the last node
		Node last = this.first;
		while(last.next != null) {
			last = last.next;
		}
		for(int i = 0; i < n; i++) {
			// makes the last the first
			last.next = this.first;
			last = this.first;
			this.first = this.first.next;
			last.next = null;
			
		}
	}
}
