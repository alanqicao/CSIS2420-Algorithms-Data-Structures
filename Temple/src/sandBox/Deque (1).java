package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * List-like class that allows us to add and delete items
 * from both the front and back of the list.
 * 
 * @author Chi Cao
 * @author Danny Dwyer
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

	private int size; // size of the stack
	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null

	/**
	 * Node of LinkedList that stores the item and a Reference to the next node and
	 * previous node.
	 */
	private class Node {

		private Item item;
		private Node next;
		private Node previous;

	}

	/**
	 * Creates an empty Deque
	 */
	public Deque() {

		head = null;
		tail = null;
		size = 0;

	}

	/**
	 * Determines if the Deque is empty.
	 * 
	 * @return True if the deque is empty, false otherwise.
	 */
	public boolean isEmpty() {

		// is the deque empty?
		return size <= 0;

	}

	/**
	 * Return the number of items on the deque.
	 * 
	 * @return The number of items in the data structure.
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserts item at the front of the Deque.
	 * 
	 * @param item The item being inserted.
	 */
	public void addFirst(Item item) {

		//Throw exception
		if (item == null) {
			throw new NullPointerException("Can not add null item");
		}

		//Create new node
		Node newNode = new Node();
		newNode.item = item;

		//set head to new node
		Node oldHead = head;
		head = newNode;

		if (size == 0) {
			newNode.next = null;
			tail = newNode;
		} else {		
			head.next = oldHead;
			oldHead.previous = head;
		}
		
		//increment size
		size++;

	}

	/**
	 * Appends item at the end of this Deque.
	 * 
	 * @param item Item being appended.
	 */
	public void addLast(Item item) {

		//Throw exception
		if (item == null) {
			throw new NullPointerException("Can not add null item");
		}

		//Create new node
		Node newNode = new Node();
		newNode.item = item;

		//Add node
		if (size == 0) {
			newNode.next = null;
			head = newNode;
			tail = newNode;
		} else {
			Node oldTail = tail;
			tail = newNode;
			oldTail.next = tail;
			tail.previous = oldTail;
		}

		//Increment size
		size++;
	}

	/**
	 * Deletes and returns the item at the front of the Deque.
	 * 
	 * @return The item at the front of this deque.
	 */
	public Item removeFirst() {

		//Throw exception
		if (isEmpty()) {
			throw new NoSuchElementException("Can not remove if list is empty");
		}

		//Remove head and decrement size
		Item item = head.item;
		head = head.next;
		size--;

		if (isEmpty()) {
			tail = null;
		}
		return item;

	}

	// delete and return the item at the end
	/**
	 * Delete and return item at the end of this Deque.
	 * 
	 * @return The item at the end of this deque.
	 */
	public Item removeLast() {

		//Throw exception if deque is empty
		if (isEmpty()) {
			throw new NoSuchElementException("Can not remove if list is empty");
		}

		//Remove node
		Item item = tail.item;
		tail = tail.previous;

		if (tail != null) {
			tail.next = null;
		}

		//decrement size
		size--;

		//set head and tail to null if this deque is empty
		if (this.isEmpty()) {
			head = null;
			tail = null;
		}

		//return item
		return item;
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new itemIterator();

	}
	
	private class itemIterator implements Iterator<Item> {

		private Node current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {

			//If deque is empty throw exception
			if (isEmpty()) {
				throw new NoSuchElementException("Items are empty");
			}

			Item item = current.item;
			current = current.next;
			return item;
		}

	}

	// unit testing
	public static void main(String[] args) {

		System.out.printf("Testing add last add fist \n");
		Deque<Integer> intergers = new Deque<>();

		// intergers.addFirst(5);
		intergers.addLast(2);
		intergers.addFirst(1);
		intergers.addFirst(3);
		intergers.addFirst(4);

		for (Integer e : intergers) {
			System.out.println(e);
		}

		System.out.printf("\nTesting Iterator: \n");

		Iterator<Integer> itemIterator = intergers.iterator();

		while (itemIterator.hasNext()) {
			System.out.println(itemIterator.next());
		}

		System.out.printf("\nTesting Remove last\n");

		intergers.removeFirst();
		intergers.removeLast();

		for (Integer e : intergers) {
			System.out.println(e);
		}

		Iterator<Integer> itemIterator2 = intergers.iterator();
		System.out.println("\niterator: ");
		while (itemIterator2.hasNext()) {
			System.out.println(itemIterator2.next());
		}

	}

}