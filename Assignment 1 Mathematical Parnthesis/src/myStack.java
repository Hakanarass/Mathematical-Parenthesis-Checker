import java.util.Iterator;
import java.util.NoSuchElementException;

/* Hakan ARAS, 10 November 2018 */
/* ID: 041701036 */
/* Mathematical Parenthesis Checker */
/* Analyzes parentheses in a mathematical expression given by the user. */
/* I just added toString() method at this part and write a comment each parts. */


public class myStack<Item> implements Iterable<Item> {
	private Item[] a; // array of items
	private int n; // number of elements on stack
	private int CAPACITY = 100;

	public myStack() { //Define a Capacity
		a = (Item[]) new Object[CAPACITY];
		n = 0;
	}

	public boolean isEmpty() {  //Is Empty or Not
		return n == 0;
	}

	public int size() { // How many variable in there
		return n;
	}

	private void resize(int capacity) { //Resize for array
		assert capacity >= n;
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void push(Item item) { //adds item to the top of the stack
		if (n == a.length) {
			resize(2 * a.length); 
		}
		a[n++] = item; // add item
	}

	
	public String toString() { //write to all stack variable top to bottom
	    String tempStr = "";

	    for (int i = n-1; i >= 0; i--)
	        tempStr = tempStr + a[i].toString() + " ";

	    return tempStr;
	}
	
	public Item pop() { // removes and returns the top element from stack
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = a[n - 1];
		a[n - 1] = null; // to avoid loitering
		n--;
		// shrink size of array if necessary
		if (n > 0 && n == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	public Item peek() { 
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return a[n - 1];
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		private int i;

		public ReverseArrayIterator() {
			i = n - 1;
		}

		public boolean hasNext() {
			return i >= 0;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return a[i--];
		}
	}

}
