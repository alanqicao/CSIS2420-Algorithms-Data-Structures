package a02;

import java.util.Iterator;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * A randomized queue is similar to a stack or queue, except
 * that the item removed is chosen uniformly at random from
 * items in the data structure.
 * 
 * @author Danny
 * @author Chi
 *
 * @param <Item> Object being stored in the data structure.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

	//Array to store the items in.
	private Item[] arrayItems;
	
	//Integer that tells us how many items there are
	private int length;

	/**
	 * Construct an empty randomized queue.
	 */
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		
		// create new array with any size
		arrayItems = (Item[]) new Object[2];
		
		// set length to 0
		length = 0;

	}

	/**
	 * Determines if the queue is empty.
	 * 
	 * @return True if array is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Return the number of items on the queue.
	 * 
	 * @return The total items on the queue.
	 */
	public int size() {
		return length;
	}

	/**
	 * add the item
	 * 
	 * @param item
	 */
	public void enqueue(Item item) {
		// check if argument is null
		if (item == null) {
			throw new NullPointerException("Item can not be null");
		}

		//determine if array needs to be resized
		if (length == arrayItems.length) {
			resize(arrayItems.length * 2);
		}

		//add item to back of array
		arrayItems[length] = item;

		//increment length
		length++;
	}

	/**
	 * Resizes an array.
	 * 
	 * @param An integer that is the size needed to resize array.
	 */
	@SuppressWarnings("unchecked")
	private void resize(int n) {

		//create new array
		Object[] newArray = new Object[n];

		//iterate through old array and copy it to new array
		for (int i = 0; i < length; i++) {
			newArray[i] = arrayItems[i];
		}
		
		this.arrayItems = (Item[]) newArray;
	}

	/**
	 * Delete and return a random item from the data structure.
	 * 
	 * @return A randomly selected item from the data structure.
	 */
	public Item dequeue() {

		if (this.isEmpty()) {
			throw new NoSuchElementException("RandomizedQueue is empty");
		}

		//shuffle the array
		StdRandom.shuffle(this.arrayItems);
		
		//set the returned item to the last item in the now shuffled array
		//(this makes it completely random what is returned).
		Item item = (Item) arrayItems[--this.length];

		//Set the last item to null (delete it).
		arrayItems[this.length] = null;

		//decrement the length
		//--length;

		//resize if necessary
		if ( arrayItems.length > 0 && length < arrayItems.length / 4 ) {
			resize(length / 2);
		}

		//Return the item
		return item;

	}

	/**
	 * Returns (but does not delete) a random item from the data structure.
	 * 
	 * @return A random item from the data structure.
	 */
	public Item sample() {
		
		//Determine if this array is empty
		if(this.isEmpty()) {
			throw new NoSuchElementException("RandominzeQueue is empty");
		}
		
		//get random number between zero and length
		int randomNumber = StdRandom.uniform(0, length);
		
		//return the value of the random index
		return arrayItems[randomNumber];
	}

	/**
	 * Returns an independent iterator over items in random order
	 * 
	 * @return An iterator of the data structure.
	 */
	public Iterator<Item> iterator(){
		return new CustomIterator();	   
	}
	
	//Private class that creates an iterator for this class.
	private class CustomIterator implements Iterator<Item> {
		
		private int index; //current member we are pointing to 
		private int[] pointers;// shuffled indexes
		
		private CustomIterator() {
			pointers = StdRandom.permutation(length);
			index = -1;
		}
		
		public boolean hasNext() {
			return index < pointers.length - 1;
		}
		
		public Item next() {
			if (index >= pointers.length - 1)
				throw new NoSuchElementException();

			return (Item) arrayItems[pointers[++index]];
		}
		
		
	    // Used to remove an element. Implement only if needed
	    public void remove() {
	       throw new UnsupportedOperationException("Unsupported Operation");
	    }
	} 
	   
	/**
	 * Unit testing.
	 * 
	 * @param [NOT USED]
	 */
	public static void main(String[] args) {
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		
		//add items to rq
		rq.enqueue("ant");
		rq.enqueue("bat");
		rq.enqueue("cat");
		rq.enqueue("dog");
		rq.dequeue();
		rq.dequeue();
		rq.dequeue();
		rq.dequeue();
		for(String s : rq) {		
			  System.out.println(s);
		}
		System.out.println(rq.isEmpty());
		System.out.println(rq.length);
		System.out.println(rq.size());
		
		
		
	}
}