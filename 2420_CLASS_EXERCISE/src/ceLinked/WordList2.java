package ceLinked;

import java.util.Iterator;

/**
 * WordList is a singly-linked list of Strings.
 * It is designed as a practice opportunity to
 * learn how to manipulate linked sturctures.
 * 
 * @author ..........
 */
public class WordList2 implements Iterable <String> {
	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n;     // number of words in the list

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
	public void append(String newItem) {
		// create a new node based on the word provided by the user
		Node newNode = new Node();
		newNode.item = newItem;
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		n++;
	}
	
	/** 
	 * Adds a node containing the new item at the
	 * front of the list.
	 * 
	 * @param newItem
	 */
	public void prepend(String newItem) {		
		// TODO 2
	}
	
	/** 
	 * Returns the index of the first occurrence of the specified item.
	 * If the specified item in not part of the list
	 * the method indexOf returns -1
	 * 
	 * @param item
	 * @return index of the first occurrence of the item; -1 if the word was not found.
	 */
	public int indexOf(String item) {		
		return 0; // TODO 3
	}
	
	/** 
	 * Checks whether the list contains the given item.
	 * 
	 * @param item
	 * @return true if the item is contained in the list; false otherwise.
	 */
	public boolean contains(String item) {	
		return false; // TODO 4
	}
	
	/**
	 * Returns the number of elements in the list
	 * @return the number of elements
	 */
	public int size() {
		return n;
	}
	
	/** 
	 * Determines whether the list is empty or not.
	 * @return true if there are no elements in the list.
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		
		while(current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}
		
		return sb.toString();
	}
	
	@Override
	public Iterator<String> iterator() {
		
		return new WordListIterator();
	}
	
	private class WordListIterator implements Iterator<String>{
		
		
		private Node current = head;
		
		
		@Override
		public boolean hasNext() {
			
		return current != null;
		
		}

		@Override
		public String next() {
			
			String item = current.item;
			current = current.next;
			
			return item;
		}
		
	}
	
	/* * * * * * * * Test Client * * * * * * */
	public static void main(String[] args) {
		WordList2 list = new WordList2();
		System.out.println("size: " + list.size());
		
		// TODO 1
		// Dynamically determine whether the list is empty. If so, print 
		// 'The list is empty.' otherwise print 'The list is not empty.'			
		 
		list.append("ant");
		list.append("bat");
		list.append("cow");
		list.append("dog");
		
		System.out.println("list: " + list);
		System.out.println("ilter");
		
		for(String el: list) {
			System.out.println(el+"..");
		}

	}



}
