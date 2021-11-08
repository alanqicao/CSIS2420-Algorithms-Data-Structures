package practice3;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Singly-linked list to demonstrate your understanding
 * of linked structures.
 * 
 * @author starter code + Qi Cao
 */
public class Linkstr {
	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n;     // number of items in the list

	/**
	 * Node of LinkedList that stores the item and a
	 * single reference to the next node.
	 */
	private class Node {
		private String item;
		private Node next;
	}
	
	/** 
	 * Adds a node containing the new item at the
	 * end of the list.
	 * 
	 * @param newItem
	 */
	public void append(final String newItem) {
		final Node newNode = new Node();
		newNode.item = newItem;

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		n++;
	}

	/**
	 * Returns the first <code>k</code> element from this list in the order specified in the list. <br/>
	 * If the list has less than <code>k</code> elements or <code>k</code> is not positive, 
	 * an IllegalArgumentException should be thrown.<br/>
	 * 
	 * Example: <br/>
	 * If the list includes the elements "A" "B" "C" "D" "E" <br/>
	 * firstK(3) should return "A" "B" "C" <br/>
	 * firstK(1) should return "A" <br/>
	 * 
	 * @param k number of elements returned
	 * @return first <code>k</code> element from this list
	 * @throws IllegalArgumentException if <code>k</code> is greater than the size 
	 *         of the list or <code>k</code> isn't positive
	 */
	@SuppressWarnings("unlikely-arg-type")
	public Iterable<String> firstK(final int k) {
		
		Queue<String> s = new Queue<>();
		
		if(k > n && k >= 0) {
			throw new IllegalArgumentException("can not be greater than the size of the list");
		}
	
		
	Node current = head;
	
	for(int i = 0; i < k; i++) {
		
		String item = current.item;
		current = current.next;
		 s.equals(item);
		
	}
	
		
		return s; 
		
	}
	
	
	
	public Iterable<String> everyOther(){
		
		Queue<String> queue = new Queue<>();	
		Node current = head;
		
		while (current != null) { //skip current
			queue.enqueue(current.item);			
			if(current.next!=null) {
				current = current.next;
				current = current.next;
			}			
		}
		return queue;
	}

	/**
	 * count the number of word that start with lower case
	 * @return number of words
	 */
	public int lowerCaseWordCount() {
		int count = 0;
		
		Node current = head;		
		while (current != null) { 			
			if(Character.isLowerCase(current.item.charAt(0))) {
				count++;
				current = current.next;
			}					
		}		
		return count; 
	}
	
	/**
	 * Determine whether the first element of the list is a string 
	 * That has a single letter
	 * @return
	 */
	public boolean singleLetterFirstElement() {
		
		return false;
	}
	
	/**
	 * Returns the number of elements in the list
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return n;
	}

	/**
	 * Determines whether the list is empty or not.
	 * 
	 * @return true if there are no elements in the list.
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		Node current = head;

		while (current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}

		return sb.toString();
	}

	/* = = = = = = = = = Test Client = = = = = = = = = */

	// The main method can be used for your own testing.
	// If you write enough JUnit tests to thoroughly test your code that way, that's fine, too.
	public static void main(String[] args) {

		Linkstr list = new Linkstr();
		list.append("aA");
//		list.append("B");
//		list.append("C");
//		list.append("D");
		StdOut.println("cities: " + list);
		System.out.println("cities: "+"["+list+"]");
		//System.out.println("everOther:"+"["+list.everyOther());
		System.out.println("lower case word count: "+list.lowerCaseWordCount());
		
	}

}
