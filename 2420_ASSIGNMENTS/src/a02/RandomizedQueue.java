/**
 * 
 */
package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Qi Cao
 *
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] arrayItems;
	private int length;

	/**
	 * construct an empty randomized queue
	 */
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		// create new array with any size
		arrayItems = (Item[]) new Object[2];
		// set length to 0
		length = 0;

	}

	/**
	 * is the queue empty?
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		// return if array is empty
		return length == 0;
	}

	/**
	 * return the number of items on the queue
	 * 
	 * @return
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
		// check
		if (item == null) {

			throw new NullPointerException("Item can not be null");
		}

		if (length >= arrayItems.length) {

			resize(arrayItems.length * 2);
		}

		arrayItems[length] = item;

		length++;
	}

	/**
	 * resize a array
	 * 
	 * @param a integer that is the size need to resize array
	 */
	@SuppressWarnings("unchecked")
	private void resize(int n) {

		Object[] newArray = new Object[n];

		for (int i = 0; i < length; i++) {
			newArray[i] = arrayItems[i];
			arrayItems = (Item[]) newArray;
		}
	}

	/**
	 * delete and return a random item
	 * 
	 * @return
	 */
	public Item dequeue() {

		if (length <= 0) {
			throw new NoSuchElementException("RandomizedQueue is empty");
		}

		// StdRandom.shuffle(array, 0, length) why can not use this?

		int randomNumber = StdRandom.uniform(0, length);

		
		Item item = (Item) arrayItems[randomNumber];

		arrayItems[randomNumber] = arrayItems[length];

		arrayItems[length] = null;

		--length;

		if (length > 0 && length < length / 4) {
			resize(length / 2);
		}

		return item;

	}

	/**
	 * return (but do not delete) a random item
	 * 
	 * @return
	 */
	public Item sample() {
		if(length == 0) {
			throw new NoSuchElementException("RandominzeQueue is empty");
		}
		int randomNumber = StdRandom.uniform(0, length);

		
		Item item = (Item) arrayItems[randomNumber];

		return item;
	}

	/**
	    * return an independent iterator over items in random order
	    */
	   public Iterator<Item> iterator(){
		   
		return null;
		   
	   }
	   
	   
	   

	/**
	 * unit testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}
}