package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

	// construct an empty deque
	public Deque() {

		head = null;
		tail = null;
		size = 0;

	}

	// is the deque empty?
	public boolean isEmpty() {

		return head == null;

	}

	// return the number of items on the deque
	public int size() {

		return size;

	}

	// insert the item at the front
	public void addFirst(Item item) {

		if (item == null) {
			throw new NullPointerException("Can not add null item");
		}

		Node newNode = new Node();
		newNode.item = item;

		Node oldHead = head;
		head = newNode;

		if (size == 0) {

			newNode.next = null;
			tail = newNode;

		} else {
			
			head.next = oldHead;
			oldHead.previous = head;
		}
		size++;


	}

	// insert the item at the end
	public void addLast(Item item) {

		if (item == null) {
			throw new NullPointerException("Can not add null item");
		}

		Node newNode = new Node();
		newNode.item = item;

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

	
		size++;
	}

	// delete and return the item at the front
	public Item removeFirst() {

		if (isEmpty()) {
			throw new NoSuchElementException("Can not remove if list is empty");
		}

		Item item = head.item;
		head = head.next;
		size--;

		if (isEmpty()) {
			tail = null;

		}
		return item;

	}

	// delete and return the item at the end
	public Item removeLast() {

		if (isEmpty()) {
			throw new NoSuchElementException("Can not remove if list is empty");
		}

		Item item = tail.item;

		tail = tail.previous;

		if (tail != null) {
			tail.next = null;
		}

		size--;

		if (size == 0) {
			head = null;
		}

		if (isEmpty()) {
			tail = null;

		}

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
		intergers.addLast(10);
		intergers.addFirst(20);

		for (Integer e : intergers) {
			System.out.println(e);
		}

		System.out.printf("\nTesting Iterator: \n");

		Iterator<Integer> itemIterator = intergers.iterator();

		while (itemIterator.hasNext()) {
			System.out.println(itemIterator.next());
		}

		System.out.printf("\nTesting Remove last\n");

		// intergers.removeFirst();
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