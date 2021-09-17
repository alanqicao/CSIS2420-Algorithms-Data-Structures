package ceLinked;

/**
 * WordList is a singly-linked list of Strings.
 * It is designed as a practice opportunity to
 * learn how to manipulate linked sturctures.
 * 
 * @author ..........
 */
public class WordList {
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
		
		Node newNode = new Node();
		newNode.item = newItem;
		
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.next = head;
			head =newNode;
		}
		n++;
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
		
		Node node = head;
		int i = 0;
		while(node!=null) {
			if(node.item.equals(item)) {
				return i;
			}
			i++;
			node=node.next;
		}
		return -1; 
	}
	
	/** 
	 * Checks whether the list contains the given item.
	 * 
	 * @param item
	 * @return true if the item is contained in the list; false otherwise.
	 */
	public boolean contains(String item) {	
		Node current= head;
		while(current!=null) {
			if(current.item.equals(item)) {
				return true;
			}
			current=current.next;
		}
		return false; 
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
	
	/* * * * * * * * Test Client * * * * * * */
	public static void main(String[] args) {
		WordList list = new WordList();
		System.out.println("size: " + list.size());

		// Dynamically determine whether the list is empty. If so, print 
		// 'The list is empty.' otherwise print 'The list is not empty.'
		
		System.out.print("TODO 1: ");
		System.out.println(list.isEmpty()? "The list is empty":"The list is not empty.");
		list.append("ant");
		list.append("bat");	
		list.append("cow");
		list.append("dog");
		
		list.prepend("ape");
		System.out.printf("\nTODO 2: prepend 'ape'\nlist: %s\n",list);
		list.prepend("auk");
		System.out.printf("\nTODO 2: prepend 'auk'\nlist: %s\nsize: %d\n",list,list.size());
		
		System.out.printf("\nTODO 3: indexOf\nIndex of dog: %d\nIndex of auk: %d\nIndex of yak: %d\n",list.indexOf("dog"),list.indexOf("auk"),list.indexOf("yak"));
		
		System.out.printf("\nTODO 4: contains");
		System.out.printf(list.contains("cow")? "\n%s is included in the list.\n":"\n%s is not included in the list.\n","cow");
		System.out.printf(list.contains("yak")? "%s is included in the list.\n":"%s is not included in the list.\n","yak");
		
		

		System.out.printf("\nlist: %s\n", list);

		System.out.println("size: " + list.size());
		
	}
	
	

}
