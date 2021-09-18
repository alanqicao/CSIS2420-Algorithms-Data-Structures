package a02;

import java.util.Iterator;

/**
 * A randomized queue is similar to a stack or queue, except
 * that the item removed is chosen uniformly at random from
 * items in the data structure.
 * 
 * @author Danny
 * @author Chi
 *
 * @param <Item>
 */
public class RandomizedQueue_Danny<Item> implements Iterable<Item> {
	
	/**
	 * Private inner class that is a node for RandomizedQueue.
	 * 
	 * @author Danny
	 * @author Chi
	 *
	 */
	private class Node {
		
		//Pointer to next node.
		Node next;
		
		//Data stored in node.
		Item data;
		
		/**
		 * Constructor for Node.
		 * 
		 * @param d The data the node stores.
		 */
		Node(Item d){
			this.data = d;
		}
	}

	//Integer that represents the size of the randomized queue.
	private int size;
	
	//Variable that points to the head of the queue.
	private Node head;
	
	//Variable that points to the tail of the queue.
	//TODO: This may never actually be used since this queue doesn't
	//      dequeue the tail, instead it dequeues a random node.
	private Node tail;
	
	/**   
	 * Constructs an empty randomized queue.
	 */
	public RandomizedQueue_Danny() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	   
	/**
	 * Returns if the queue is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	/**
	 * Returns the number of items on the queue.
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Add item to queue.
	 * 
	 * @param item
	 * @throws NullPointerException
	 */
	public void enqueue(Item item) throws NullPointerException {
		
		//Catch null item.
		if(item == null) throw new java.lang.NullPointerException("Null item cannot be equeued.");
		
		//create new node
		Node newNode = new Node(item);
		
		//set the new node's next to the head node
		newNode.next = tail;
		
		//if the queue was empty, set tail to new node
		if(this.size == 0) head = newNode;
		
		//Set head to new node
		tail = newNode;
		
		//increment size counter
		this.size++;
	}
	
	/**
	 * Delete and return a random item from the queue.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
    public Item dequeue() throws java.util.NoSuchElementException{
    	
    	//Throw exception if RandomizedQueue is empty.
    	if(this.size == 0) throw new java.util.NoSuchElementException("RandomizedQueue is empty.");
    	
    	//Generate random number
    	int randomIndex = (int) (Math.random() * (this.size - 0));
    	
    	//Gets the index left of the random number
    	int indexLeftOfNode = randomIndex - 1;
    	
    	//Node that is the node returned
    	Node returnedNode;
    	
    	//Case if index = 0 (nothing to the left, so we just delete node and move head to the right
    	if(randomIndex == 0) {
    		returnedNode = head;
    		head = head.next;
    		returnedNode.next =null;
    		return returnedNode.data;
    	}
    	
    	Node current = head;
    	for(int i = 0; i < indexLeftOfNode; i++) {
    		current = current.next;
    	}
    	//Get data to return 
    	returnedNode = current.next;
    	
    	//Delete the node and set next pointers to returned.next
    	current.next = returnedNode.next;
    	returnedNode.next = null;
    	
    	//decrement size
    	this.size--;
    	
    	//Return data.
    	return returnedNode.data;
    }
    
    /**
     * Returns a random item from the queue.
     * 
     * @return
     * @throws java.util.NoSuchElementException
     */
    public Item sample() {
    	
    	//Throw exception if RandomizedQueue is empty.
    	if(this.size == 0) throw new java.util.NoSuchElementException("RandomizedQueue is empty.");

    	//Generate random number
    	int randomIndex = (int) (Math.random() * (this.size - 0));
    	
    	//Loop through the data structure until that random index is reached, and return that value.
    	Node current = head;
    	for(int i = 0; i < randomIndex; i++) {
    		current = current.next;
    	} return current.data;
    }
    
    /**
     * Returns an independent iterator over items in random order.
     * 
     * @return
     */
	public Iterator<Item> iterator()  {
		return new CustomIterator<>(this);
	}
	//Used: https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/
	//for learning how to program an Iterator.
	private class CustomIterator<Item> implements Iterator<Item> {
	    RandomizedQueue_Danny<Item>.Node current;
		
	    // constructor
	    CustomIterator(RandomizedQueue_Danny<Item> rq) {
	        current = rq.tail;
	    }
	      
	    // Checks if the next element exists
	    public boolean hasNext() {
			return current != null;
	    }
	      
	    // moves the cursor/iterator to next element
	    public Item next() {
	    	Item data = current.data;
	    	current = current.next;
	    	return data;
	    }
	      
	    // Used to remove an element. Implement only if needed
	    public void remove() {
	       throw new UnsupportedOperationException("Unsupported Operation");
	    }
	}
	
	public static void main(String[] args) {
		//TODO: Unit testing.
		RandomizedQueue_Danny<String> rq = new RandomizedQueue_Danny<String>();
		
		//add items to rq
		rq.enqueue("ant");
		rq.enqueue("bat");
		rq.enqueue("cat");
		rq.enqueue("dog");
		
		for(String s : rq) {
			System.out.println(s);
		}
		
		//get random item from Random queue
		//System.out.println(rq.dequeue());
	}
}
