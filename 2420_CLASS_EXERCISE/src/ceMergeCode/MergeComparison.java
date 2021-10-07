package ceMergeCode;

import java.util.Arrays;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeComparison {

	public static void main(String[] args) {
		
		double Billion = 1_000_000_000.0;
		Integer[] numbers = getRandomNumbers(50_000);
		Integer[] numbers2 = Arrays.copyOf(numbers, numbers.length);
		
		long startTime = System.nanoTime();
		MergeSlow.sort(numbers);
		double endTime = (System.nanoTime() - startTime) / Billion;
		StdOut.printf("Time to sort numbers (Merge Slow): %.4fs", endTime);
		
		System.out.println();
		startTime = System.nanoTime();
		Merge.sort(numbers2);	
		endTime = (System.nanoTime() - startTime) / Billion;
		StdOut.printf("Time to sort numbers (Merge): %.4fs", endTime);
		
	}
	
	/**
	 * Genereate an array of the spcified size and fills it
	 * with random 7-digt number
	 * @param size of the array
	 * @return array of random number
	 */
	private static Integer[] getRandomNumbers(int size) {
		
		Integer[] array = new Integer[size];
		
		for(int i = 0; i<size;i++) {
			
			array[i]=StdRandom.uniform(1_000_000,10_000_000);
		}
		return array;
	}
	
	/**
	 * Genereate an Iterable of the spcified size and fills it
	 * with random 7-digt number
	 * @param size of the array
	 * @return Iterable of random number
	 */
	private static Iterable<Integer> getRandomNumbers2(int size) {
		
		Queue<Integer> array = new Queue<>();
		
		for(int i = 0; i<size; i++) {
			
			array.enqueue(StdRandom.uniform(1_000_000,10_000_000));
			
		}
		
		
		
		return array;
		
	}

}
