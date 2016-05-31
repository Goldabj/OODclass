package sll;

import java.util.NoSuchElementException;

/**
 * This class provides a basic implementation of a singly linked list. It's
 * motivated by the implementation in Big Java, 5e, ch. 16.1.
 * 
 * @author Brendan Goldacker on 2/10/15
 * @param <T>
 *            The type of elements in the list
 */
public class LinkedList<T> implements List<T>, Iterable<T> {

	private ListNode<T> first;
	// Note that in addition to a head (first) pointer
	// this list contains a last pointer. Be sure to
	// BOTH first and last up to date in all your code.
	private ListNode<T> last;

	/**
	 * Constructs a new, empty linked list.
	 */
	public LinkedList() {
		this.first = null;
		this.last = null;
	}

	@Override
	public String toString() {
		if (this.first == null) {
			return "[]";
		}
		String result = "[";
		ListNode<T> current = this.first;
		while (current != this.last) {
			result += (current.getElement() + ", ");
			current = current.getNext();
		}
		return result + current.getElement() + "]";
	}

	@Override
	public boolean add(T x) {
		if (this.first == null) {
			this.first = new ListNode<T>(x, null);
			this.last = this.first;
		} else {
			ListNode<T> newX = new ListNode<T>(x, null);
			this.last.setNext(newX);
			this.last = newX;
		}

		return true;
	}

	@Override
	public int size() {
		if (this.first == null) {
			return 0;
		}
		ListNode<T> current = this.first;
		int count = 0;
		while (current != this.last) {
			count++;
			current = current.getNext();
		}
		return count + 1;
	}

	@Override
	public void add(int i, T x) throws IndexOutOfBoundsException {
		if (i < 0 || i > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		if (i == 0) {
			if (this.size() == 0) {
				this.add(x);
				return;
			}
			ListNode<T> newX = new ListNode<T>(x, this.first);
			this.first = newX;
			return;
		}
		if (i == this.size()) {
			this.add(x);
			return;
		}
		ListNode<T> current = this.first;
		int count = 1;
		while (count < i) {
			current = current.getNext();
			count++;
		}
		ListNode<T> newX = new ListNode<>(x, current.getNext());
		current.setNext(newX);
	}

	@Override
	public boolean contains(T x) {
		if (this.size() == 0) {
			return false;
		}
		ListNode<T> current = this.first;
		while (current != this.last) {
			if (current.getElement().equals(x)) {
				return true;
			}
			current = current.getNext();
		}
		if (this.last.getElement().equals(x)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(T x) {
		if (this.size() == 0) {
			return false;
		}
		if (this.first.getElement().equals(x)) {
			ListNode<T> temp = this.first.getNext();
			this.first.setNext(null);
			this.first = temp;
			return true;
		}
		ListNode<T> current = this.first;
		while (current.getNext() != null) {
			if (current.getNext().getElement().equals(x)) {
				current.setNext(current.getNext().getNext());
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (this.size() == 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			return this.first.getElement();
		}
		if (index == this.size() - 1) {
			return this.last.getElement();
		}
		if (index < 0 || index > this.size() - 1) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<T> current = this.first;
		int count = 0;
		while (count < index) {
			count++;
			current = current.getNext();
		}
		return current.getElement();
	}

	@Override
	public int indexOf(T x) {
		if (this.size() == 0) {
			return -1;
		}
		ListNode<T> current = this.first;
		int count = 0;
		while (current.getNext() != null) {
			if (current.getElement().equals(x)) {
				return count;
			}
			count++;
			current = current.getNext();
		}
		return -1;
	}

	@Override
	public T set(int index, T element) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.size() - 1) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			T firstElement = this.first.getElement();
			this.first.setElement(element);
			return firstElement;
		}
		if (index == this.size() - 1) {
			T firstElement = this.last.getElement();
			this.last.setElement(element);
			return firstElement;
		}
		ListNode<T> current = this.first;
		int count = 0;
		while (count < index) {
			count++;
			current = current.getNext();
		}
		T firstElement = current.getElement();
		current.setElement(element);
		return firstElement;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	/**
	 * This is an iterator over this list.
	 * 
	 * @author TODO <YOUR_NAME> on <DATE>.
	 */
	private class LinkedListIterator implements Iterator<T> {

		private ListNode<T> current, previous;

		private LinkedListIterator() {
			this.current = null;
			this.previous = null;
		}

		@Override
		public boolean hasNext() {
			if (this.current == null) {
				if (first != null) {
					return true;
				}
				return false;
			}
			if (this.current.getNext() != null) {
				return true;
			}
			return false;
		}

		@Override
		public T next() throws NoSuchElementException {
			if (size() == 0) {
				throw new NoSuchElementException();
			}
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			if (this.current == null) {
				this.current = first;
				return this.current.getElement();
			}
			this.previous = this.current;
			this.current = this.current.getNext();
			return this.current.getElement();
		}

		@Override
		public void remove() {
			if (this.current == null) {
				throw new IllegalStateException();
			}
			if (!LinkedList.this.contains(this.current.getElement())) {
				throw new IllegalStateException();
			}
			LinkedList.this.remove(this.current.getElement());
			this.current = this.previous;

		}
	}

}
