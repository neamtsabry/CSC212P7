package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

import edu.smith.cs.csc212.p7.errors.BadIndexError;
import edu.smith.cs.csc212.p7.errors.EmptyListError;

public class DoublyLinkedList<T> implements P6List<T> {
	private Node<T> start;
	private Node<T> end;
	public Node<T> lastNode;

	/**
	 * A doubly-linked list starts empty.
	 */
	public DoublyLinkedList() {
		this.start = null;
		this.end = null;
	}

	/*
	 * This will take O(1) time because all we need to do is 
	 * access the first item and delete it.
	 */
	@Override
	public T removeFront() {
		checkNotEmpty();
		T removed = start.value;
		start = start.after;
		if (start != null) {
			start.before = null;
		}
		return removed;
	}
	
	/*
	 * same as removeFront, O(1)
	 */
	@Override
	public T removeBack() {
		// see if the list is empty
		checkNotEmpty();
		
		// if there is one item in the list
		// just remove the first item
		if (this.size() == 1) {
			T removed = start.value;
			start = null;
			return removed;
		} else {
			// otherwise remove the end
			T removed = end.value;
			end = end.before;
			
			// make sure the end is not null
			if(end!=null) {
				end.after = null;
			}
			return removed;
		}
	}
	
	/*
	 * This will take O(n) time because we need to access
	 * every time in the list with the for loop. If we think 
	 * about the number of items in the list as n, and if this
	 * is the worst case scenario (that the index we want to
	 * remove is at the end), we will have O(n).
	 */
	@Override
	public T removeIndex(int index) {
		// check if list is empty
		checkNotEmpty();

		// if removing the first item
		if (index == 0) {
			return this.removeFront();
		}

		// if removing last item
		if (index == this.size()) {
			return this.removeBack();
		}
		
		// have a counter that starts at 0
		int at = 0;

		// go through all items in the list until you find 
		// the desired index
		for (Node<T> current = start; current != null; current = current.after) {
			if (at == (index - 1)) {
				T removed = current.after.value;
				current.after = current.after.after;
				return removed;
			}
			at++;
		}
		
		// if you get here that means the index does not exist
		// so throw this error
		throw new BadIndexError();
	}
	
	/*
	 * O(1), we're just adding to the front
	 */
	@Override
	public void addFront(T item) {
		Node<T> second = start;
		this.start = new Node<T>(item);
		start.after = second;
		start.before = null;
		if (second != null) {
			second.before = start;
		} else {
			end = start;
		}
	}

	/*
	 * same as addFront, O(1)
	 */
	@Override
	public void addBack(T item) {
		// make a new node
		Node<T> newNode = new Node<T>(item);
		
		// if list is empty
		if(this.end == null) {
			// just add item to front
			addFront(item);
		}
		else {
			// otherwise, make sure the end and 
			// the new node are pointing to the right things
			
			// new node should be at the end so it 
			// would be pointing to null right after it 
			// and pointing back to the now previous end
			newNode.after = null;
			newNode.before = this.end;
			
			// and our end would be pointing at the new node
			this.end.after = newNode;
			
			// now the new node is the end
			this.end = newNode;
		}
	}
	
	/*
	 * O(n), we're going through all items in the list 
	 * in worst case scenario
	 */
	@Override
	public void addIndex(T item, int index) {
		// if the list is empty
		if (this.isEmpty() || (index == 0)) {
			addFront(item);
		}

		// if adding to the back
		if (index == (this.size() - 1)) {
			addBack(item);
		}

		// if adding somewhere in the middle
		else {
			// have a counter
			int at = 0;

			// go through nodes
			for (Node<T> current = start; current != null; current = current.after) {
				if (at == (index - 1)) {
					// make a new node
					Node<T> c = new Node<>(item);
					
					// make sure we have the right pointers
					c.after = current.after;
					
					// c points at null and the current
					c.before = current;
					
					// current should be pointing at c 
					current.after.before = c;
					
					// c should be current now
					current.after = c;
					
				}
				at++;
			}
		}
	}
	
	// For unit tests, List<T> supports equals, but P6List<T> does not.
    public List<T> copyToList() {
            ArrayList<T> output = new ArrayList<T>();
            for (Node<T> n = this.start; n != null; n = n.after) {
                    output.add(n.value);
            }
            return output;
    }
    
    // If you treat your DoublyLinkedList<T> like a queue with pop() as removeFront(), you are destroying the lists.
    // This may also be helpful for unit-testing.
    public DoublyLinkedList<T> copy() {
            DoublyLinkedList<T> output = new DoublyLinkedList<T>();
            for (Node<T> n = this.start; n != null; n = n.after) {
                    output.addBack(n.value);
            }
            return output;
    }
	
	/*
	 * O(1)
	 */
	@Override
	public T getFront() {
		return start.value;
	}
	
	/*
	 * O(1)
	 */
	@Override
	public T getBack() {
		return end.value;
	}
	
	/*
	 * Going through all items, O(n)
	 */
	@Override
	public T getIndex(int index) {
		checkNotEmpty();

		int at = 0;

		for (Node<T> current = start; current != null; current = current.after) {
			if (at == (index)) {
				T found = current.value;
				return found;
			}
			at++;
		}
		throw new BadIndexError();
	}

	/*
	 * Here, we're going to go through all items
	 * O(n)
	 */
	@Override
	public int size() {
		int index = 0;
		for (Node<T> current = start; current != null; current = current.after) {
			index++;
		}
		return index;
	}

	/*
	 * O(1)
	 */
	@Override
	public boolean isEmpty() {
		return start == null;
	}
	
	/*
	 * O(1)
	 */
	private void checkNotEmpty() {
		if (this.isEmpty()) {
			throw new EmptyListError();
		}
	}

	/**
	 * The node on any linked list should not be exposed. Static means we don't need
	 * a "this" of DoublyLinkedList to make a node.
	 * 
	 * @param <T> the type of the values stored.
	 */
	private static class Node<T> {
		/**
		 * What node comes before me?
		 */
		public Node<T> before;
		/**
		 * What node comes after me?
		 */
		public Node<T> after;
		/**
		 * What value is stored in this node?
		 */
		public T value;
		/**
		 * Create a node with no friends.
		 * 
		 * @param value - the value to put in it.
		 */
		public Node(T value) {
			this.value = value;
			this.before = null;
			this.after = null;
		}
	}
}
