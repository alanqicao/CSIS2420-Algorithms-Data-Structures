package ceQuick;

import java.util.Arrays;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compares the performance of the following algorithms quick sort and selection
 * sort
 * 
 * @author Qi Cao
 *
 */

public class SortComparison {

	public static void main(String[] args) {

		double Billion = 1_000_000_000.0;
		int counter = 1000;

		StdOut.printf("    n   | Selection | Quick\n");
		StdOut.printf(" ------ | --------- | ---------");

		while (counter <= 256000) {

			Integer[] numbers = getRandomNumberArray(counter, 7);
			Integer[] numbers2 = Arrays.copyOf(numbers, numbers.length);

			long startTime = System.nanoTime();
			Selection.sort(numbers);
			double endTime = (System.nanoTime() - startTime) / Billion;

			long startTime2 = System.nanoTime();
			Quick.sort(numbers2);
			double endTime2 = (System.nanoTime() - startTime2) / Billion;

			StdOut.printf("\n %6d | %8.4fs | %.4fs", counter, endTime, endTime2);

			counter = counter * 2;

		}

	}

	/**
	 * Genereate an array of the spcified size and fills it with random n-digt
	 * number
	 * 
	 * @param size of the array
	 * @param n    number of digits of each random number
	 * @return array of random number
	 * @throws illegalArgumentException if N is less then 1 and greater than 10
	 */
	private static Integer[] getRandomNumberArray(int size, int n) {

		if (n < 1 | n > 10) {
			throw new IllegalArgumentException("Can't creat integers with the specified number of digits");
		}

		Integer[] array = new Integer[size];

		for (int i = 0; i < size; i++) {

			array[i] = StdRandom.uniform((int) Math.pow(10, n - 1), (int) Math.pow(10, n));
		}
		return array;
	}

}
