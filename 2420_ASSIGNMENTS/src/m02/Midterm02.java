package m02;


import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Midterm02 coding challenges.
 * 
 * 
 * @author Qi Cao
 */
public class Midterm02 {
	
	/**
	 * Main methods create 50,000 random 8-digit numbers.
	 * It has symbol table include string words array associated from smallest random number array.
	 * Print out all the keys and values inside symbol table
	 * Print out random word from words array and it's value;
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] numbers;
		String[] words = {"as", "at", "be", "do", "go", "hi", "in", "is", "it", "my" };

		numbers = getRandomNumbers(50000);
		
		Quick.sort(numbers);	
		
		RedBlackBST <String,Integer> st = new RedBlackBST<>();		
		for(int i = 0; i < words.length-1;i++) {
			st.put(words[i], numbers[i]);
		}
		
		StdOut.println("All keys and values: ");
		for(String key: st.keys()) {
			StdOut.println(key+" "+st.get(key));		
		}
		
		int randomIndexNumber =StdRandom.uniform(0,words.length);
		String randomWord = words[randomIndexNumber];
		
		StdOut.println("\nRandom word: "+ randomWord);				
		StdOut.printf("Number of keys that are smaller than %s: %d",randomWord,st.rank(randomWord));

		/*
		 * Challenge 2:
		 * ============
		 * A) Which of the symbol tables did you select?
		 * I choose Red Black BST 
		 * 
		 * B) Provide two specific reasons why is it best suited for the challenges.
		 * Because the put and get only take O(log) N time in worst case, and loop all the keys
		 * only take O(log n+ m) time so it is really fast
		 */
	}

	/**
	 * Returns an array of n uniformly random 8-digit numbers.
	 * 
	 * @param n number of elements in the array
	 * @return Type Integer array of random numbers
	 */
	private static Integer[] getRandomNumbers(int n) {
		
		Integer[] array = new Integer[n];	
		int counter = 0;
		
		while(counter < n) {			
			Integer randomNumber = StdRandom.uniform((int) Math.pow(10, 7), (int) Math.pow(10, 8));			
			if( randomNumber % 2 != 0) {
				array[counter]=randomNumber;
				counter++;
			}
		}		
		return array;
	}
	
}
